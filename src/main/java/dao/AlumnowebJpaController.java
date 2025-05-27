/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import dto.Alumnoweb;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author bazal
 */
public class AlumnowebJpaController implements Serializable {

    public AlumnowebJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public AlumnowebJpaController() {

    }

    public void create(Alumnoweb alumnoweb) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alumnoweb);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Alumnoweb alumnoweb) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            alumnoweb = em.merge(alumnoweb);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = alumnoweb.getCodiEstdWeb();
                if (findAlumnoweb(id) == null) {
                    throw new NonexistentEntityException("The alumnoweb with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alumnoweb alumnoweb;
            try {
                alumnoweb = em.getReference(Alumnoweb.class, id);
                alumnoweb.getCodiEstdWeb();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alumnoweb with id " + id + " no longer exists.", enfe);
            }
            em.remove(alumnoweb);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Alumnoweb> findAlumnowebEntities() {
        return findAlumnowebEntities(true, -1, -1);
    }

    public List<Alumnoweb> findAlumnowebEntities(int maxResults, int firstResult) {
        return findAlumnowebEntities(false, maxResults, firstResult);
    }

    private List<Alumnoweb> findAlumnowebEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Alumnoweb.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Alumnoweb findAlumnoweb(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Alumnoweb.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlumnowebCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Alumnoweb> rt = cq.from(Alumnoweb.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public String hashPassword(String plainPassword) {
        // Genera un salt y hashea la contraseña
        // El número 12 es el factor de costo (rounds), puedes ajustarlo según necesites
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
    }

    // Método adicional para verificar contraseñas
    public boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    public int validarUsuario(String dni, String plainPassword) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            // Buscar usuario por DNI
            Query query = em.createNamedQuery("Alumnoweb.findByNdniEstdWeb");
            query.setParameter("ndniEstdWeb", dni);
            List<Alumnoweb> usuarios = query.getResultList();

            if (usuarios.isEmpty()) {
                return 0; // Usuario no encontrado
            }

            Alumnoweb usuario = usuarios.get(0);
            String hashedPassword = usuario.getPassEstd();

            // Verificar la contraseña usando BCrypt
            if (verifyPassword(plainPassword, hashedPassword)) {
                return 1; // Usuario y contraseña válidos
            } else {
                return -1; // Contraseña incorrecta
            }
        } catch (Exception e) {
            return 0;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}

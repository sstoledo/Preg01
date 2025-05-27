/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author bazal
 */
@Entity
@Table(name = "alumnoweb")
@NamedQueries({
        @NamedQuery(name = "Alumnoweb.findAll", query = "SELECT a FROM Alumnoweb a"),
        @NamedQuery(name = "Alumnoweb.findByCodiEstdWeb", query = "SELECT a FROM Alumnoweb a WHERE a.codiEstdWeb = :codiEstdWeb"),
        @NamedQuery(name = "Alumnoweb.findByNdniEstdWeb", query = "SELECT a FROM Alumnoweb a WHERE a.ndniEstdWeb = :ndniEstdWeb"),
        @NamedQuery(name = "Alumnoweb.findByAppaEstdWeb", query = "SELECT a FROM Alumnoweb a WHERE a.appaEstdWeb = :appaEstdWeb"),
        @NamedQuery(name = "Alumnoweb.findByApmaEstdWeb", query = "SELECT a FROM Alumnoweb a WHERE a.apmaEstdWeb = :apmaEstdWeb"),
        @NamedQuery(name = "Alumnoweb.findByNombEstdWeb", query = "SELECT a FROM Alumnoweb a WHERE a.nombEstdWeb = :nombEstdWeb"),
        @NamedQuery(name = "Alumnoweb.findByFechNaciEstdWeb", query = "SELECT a FROM Alumnoweb a WHERE a.fechNaciEstdWeb = :fechNaciEstdWeb"),
        @NamedQuery(name = "Alumnoweb.findByLogiEstd", query = "SELECT a FROM Alumnoweb a WHERE a.logiEstd = :logiEstd"),
        @NamedQuery(name = "Alumnoweb.validar", query = "SELECT a FROM Alumnoweb a WHERE a.ndniEstdWeb = :ndniEstdWeb AND a.passEstd = :passEstd"),
        @NamedQuery(name = "Alumnoweb.findByPassEstd", query = "SELECT a FROM Alumnoweb a WHERE a.passEstd = :passEstd") })
public class Alumnoweb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codiEstdWeb")
    private Integer codiEstdWeb;
    @Column(name = "ndniEstdWeb")
    private String ndniEstdWeb;
    @Column(name = "appaEstdWeb")
    private String appaEstdWeb;
    @Column(name = "apmaEstdWeb")
    private String apmaEstdWeb;
    @Column(name = "nombEstdWeb")
    private String nombEstdWeb;
    @Column(name = "fechNaciEstdWeb")
    @Temporal(TemporalType.DATE)
    private Date fechNaciEstdWeb;
    @Column(name = "logiEstd")
    private String logiEstd;
    @Column(name = "passEstd")
    private String passEstd;

    public Alumnoweb() {
    }

    public Alumnoweb(Integer codiEstdWeb) {
        this.codiEstdWeb = codiEstdWeb;
    }

    public Integer getCodiEstdWeb() {
        return codiEstdWeb;
    }

    public void setCodiEstdWeb(Integer codiEstdWeb) {
        this.codiEstdWeb = codiEstdWeb;
    }

    public String getNdniEstdWeb() {
        return ndniEstdWeb;
    }

    public void setNdniEstdWeb(String ndniEstdWeb) {
        this.ndniEstdWeb = ndniEstdWeb;
    }

    public String getAppaEstdWeb() {
        return appaEstdWeb;
    }

    public void setAppaEstdWeb(String appaEstdWeb) {
        this.appaEstdWeb = appaEstdWeb;
    }

    public String getApmaEstdWeb() {
        return apmaEstdWeb;
    }

    public void setApmaEstdWeb(String apmaEstdWeb) {
        this.apmaEstdWeb = apmaEstdWeb;
    }

    public String getNombEstdWeb() {
        return nombEstdWeb;
    }

    public void setNombEstdWeb(String nombEstdWeb) {
        this.nombEstdWeb = nombEstdWeb;
    }

    public Date getFechNaciEstdWeb() {
        return fechNaciEstdWeb;
    }

    public void setFechNaciEstdWeb(Date fechNaciEstdWeb) {
        this.fechNaciEstdWeb = fechNaciEstdWeb;
    }

    public String getLogiEstd() {
        return logiEstd;
    }

    public void setLogiEstd(String logiEstd) {
        this.logiEstd = logiEstd;
    }

    public String getPassEstd() {
        return passEstd;
    }

    public void setPassEstd(String passEstd) {
        this.passEstd = passEstd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiEstdWeb != null ? codiEstdWeb.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumnoweb)) {
            return false;
        }
        Alumnoweb other = (Alumnoweb) object;
        if ((this.codiEstdWeb == null && other.codiEstdWeb != null)
                || (this.codiEstdWeb != null && !this.codiEstdWeb.equals(other.codiEstdWeb))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Alumnoweb[ codiEstdWeb=" + codiEstdWeb + " ]";
    }

}

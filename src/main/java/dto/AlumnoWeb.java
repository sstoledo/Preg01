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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "AlumnoWeb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlumnoWeb.findAll", query = "SELECT a FROM AlumnoWeb a"),
    @NamedQuery(name = "AlumnoWeb.findByCodiEstdWeb", query = "SELECT a FROM AlumnoWeb a WHERE a.codiEstdWeb = :codiEstdWeb"),
    @NamedQuery(name = "AlumnoWeb.findByNdniEstdWeb", query = "SELECT a FROM AlumnoWeb a WHERE a.ndniEstdWeb = :ndniEstdWeb"),
    @NamedQuery(name = "AlumnoWeb.findByAppaEstdWeb", query = "SELECT a FROM AlumnoWeb a WHERE a.appaEstdWeb = :appaEstdWeb"),
    @NamedQuery(name = "AlumnoWeb.findByApmaEstdWeb", query = "SELECT a FROM AlumnoWeb a WHERE a.apmaEstdWeb = :apmaEstdWeb"),
    @NamedQuery(name = "AlumnoWeb.findByNombEstdWeb", query = "SELECT a FROM AlumnoWeb a WHERE a.nombEstdWeb = :nombEstdWeb"),
    @NamedQuery(name = "AlumnoWeb.findByFechNaciEstdWeb", query = "SELECT a FROM AlumnoWeb a WHERE a.fechNaciEstdWeb = :fechNaciEstdWeb"),
    @NamedQuery(name = "AlumnoWeb.findByLogiEstd", query = "SELECT a FROM AlumnoWeb a WHERE a.logiEstd = :logiEstd"),
    @NamedQuery(name = "AlumnoWeb.findByPassEstd", query = "SELECT a FROM AlumnoWeb a WHERE a.passEstd = :passEstd")})
public class AlumnoWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codiEstdWeb")
    private Integer codiEstdWeb;
    @Size(max = 50)
    @Column(name = "ndniEstdWeb")
    private String ndniEstdWeb;
    @Size(max = 50)
    @Column(name = "appaEstdWeb")
    private String appaEstdWeb;
    @Size(max = 50)
    @Column(name = "apmaEstdWeb")
    private String apmaEstdWeb;
    @Size(max = 50)
    @Column(name = "nombEstdWeb")
    private String nombEstdWeb;
    @Column(name = "fechNaciEstdWeb")
    @Temporal(TemporalType.DATE)
    private Date fechNaciEstdWeb;
    @Size(max = 100)
    @Column(name = "logiEstd")
    private String logiEstd;
    @Size(max = 500)
    @Column(name = "passEstd")
    private String passEstd;

    public AlumnoWeb() {
    }

    public AlumnoWeb(Integer codiEstdWeb) {
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
        if (!(object instanceof AlumnoWeb)) {
            return false;
        }
        AlumnoWeb other = (AlumnoWeb) object;
        if ((this.codiEstdWeb == null && other.codiEstdWeb != null) || (this.codiEstdWeb != null && !this.codiEstdWeb.equals(other.codiEstdWeb))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.AlumnoWeb[ codiEstdWeb=" + codiEstdWeb + " ]";
    }

}

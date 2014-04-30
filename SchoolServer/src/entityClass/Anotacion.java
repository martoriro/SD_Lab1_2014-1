/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entityClass;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Joel
 */
@Entity
@Table(name = "ANOTACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anotacion.findAll", query = "SELECT a FROM Anotacion a"),
    @NamedQuery(name = "Anotacion.findByIdAnotacion", query = "SELECT a FROM Anotacion a WHERE a.idAnotacion = :idAnotacion"),
    @NamedQuery(name = "Anotacion.findByFecha", query = "SELECT a FROM Anotacion a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Anotacion.findByRutProfesor", query = "SELECT a FROM Anotacion a WHERE a.rutProfesor = :rutProfesor"),
    @NamedQuery(name = "Anotacion.findByTipoAnotacion", query = "SELECT a FROM Anotacion a WHERE a.tipoAnotacion = :tipoAnotacion"),
    @NamedQuery(name = "Anotacion.findByRutAlumno", query = "SELECT a FROM Anotacion a WHERE a.rutAlumno = :rutAlumno"),
    @NamedQuery(name = "Anotacion.findByRutAlumnoAndAnotacion", query = "SELECT a FROM Anotacion a WHERE a.rutAlumno = :rutAlumno and a.tipoAnotacion = :tipoAnotacion")})
public class Anotacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ANOTACION")
    private Integer idAnotacion;
    @Lob
    @Column(name = "CONTENIDO")
    private String contenido;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "RUT_PROFESOR")
    private String rutProfesor;
    @Column(name = "TIPO_ANOTACION")
    private String tipoAnotacion;
    @Column(name = "RUT_ALUMNO")
    private String rutAlumno;

    public Anotacion() {
    }

    public Anotacion(Integer idAnotacion) {
        this.idAnotacion = idAnotacion;
    }

    public Integer getIdAnotacion() {
        return idAnotacion;
    }

    public void setIdAnotacion(Integer idAnotacion) {
        this.idAnotacion = idAnotacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRutProfesor() {
        return rutProfesor;
    }

    public void setRutProfesor(String rutProfesor) {
        this.rutProfesor = rutProfesor;
    }

    public String getTipoAnotacion() {
        return tipoAnotacion;
    }

    public void setTipoAnotacion(String tipoAnotacion) {
        this.tipoAnotacion = tipoAnotacion;
    }

    public String getRutAlumno() {
        return rutAlumno;
    }

    public void setRutAlumno(String rutAlumno) {
        this.rutAlumno = rutAlumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnotacion != null ? idAnotacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Anotacion)) {
            return false;
        }
        Anotacion other = (Anotacion) object;
        if ((this.idAnotacion == null && other.idAnotacion != null) || (this.idAnotacion != null && !this.idAnotacion.equals(other.idAnotacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClass.Anotacion[ idAnotacion=" + idAnotacion + " ]";
    }
    
}

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
@Table(name = "PRUEBA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prueba.findAll", query = "SELECT p FROM Prueba p"),
    @NamedQuery(name = "Prueba.findByIdPrueba", query = "SELECT p FROM Prueba p WHERE p.idPrueba = :idPrueba"),
    @NamedQuery(name = "Prueba.findByIdAsignatura", query = "SELECT p FROM Prueba p WHERE p.idAsignatura = :idAsignatura"),
    @NamedQuery(name = "Prueba.findByRut", query = "SELECT p FROM Prueba p WHERE p.rut = :rut"),
    @NamedQuery(name = "Prueba.findByNota", query = "SELECT p FROM Prueba p WHERE p.nota = :nota"),
    @NamedQuery(name = "Prueba.findByFecha", query = "SELECT p FROM Prueba p WHERE p.fecha = :fecha"),
    @NamedQuery(name = "Prueba.findByRutIdAsignatura", query = "SELECT p FROM Prueba p WHERE p.rut = :rut and p.idAsignatura = :idAsignatura"),
    @NamedQuery(name = "Prueba.findByIdAsignaturaFecha", query = "SELECT p FROM Prueba p WHERE p.idAsignatura = :idAsignatura and p.fecha = :fecha")
})
public class Prueba implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PRUEBA")
    private Integer idPrueba;
    @Column(name = "ID_ASIGNATURA")
    private Integer idAsignatura;
    @Column(name = "RUT")
    private String rut;
    @Column(name = "NOTA")
    private Float nota;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Prueba() {
    }

    public Prueba(Integer idPrueba) {
        this.idPrueba = idPrueba;
    }

    public Integer getIdPrueba() {
        return idPrueba;
    }

    public void setIdPrueba(Integer idPrueba) {
        this.idPrueba = idPrueba;
    }

    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrueba != null ? idPrueba.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prueba)) {
            return false;
        }
        Prueba other = (Prueba) object;
        if ((this.idPrueba == null && other.idPrueba != null) || (this.idPrueba != null && !this.idPrueba.equals(other.idPrueba))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClass.Prueba[ idPrueba=" + idPrueba + " ]";
    }
    
}

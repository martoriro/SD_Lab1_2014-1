/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entityClasses;

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
 * @author Martín
 */
@Entity
@Table(name = "PRUEBA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prueba.findAll", query = "SELECT p FROM Prueba p"),
    @NamedQuery(name = "Prueba.findByIdPrueba", query = "SELECT p FROM Prueba p WHERE p.idPrueba = :idPrueba"),
    @NamedQuery(name = "Prueba.findByIdAsignatura", query = "SELECT p FROM Prueba p WHERE p.idAsignatura = :idAsignatura"),
    @NamedQuery(name = "Prueba.findByRut", query = "SELECT p FROM Prueba p WHERE p.rut = :rut"),
    @NamedQuery(name = "Prueba.findByRutAndIdAsignatura", query = "SELECT p FROM Prueba p WHERE p.rut = :rut and p.idAsignatura = :idAsignatura"),
    @NamedQuery(name = "Prueba.findByNota", query = "SELECT p FROM Prueba p WHERE p.nota = :nota"),
    @NamedQuery(name = "Prueba.findByFecha", query = "SELECT p FROM Prueba p WHERE p.fecha = :fecha")})
public class Prueba implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PRUEBA")
    private Integer idPrueba;
    @Basic(optional = false)
    @Column(name = "ID_ASIGNATURA")
    private int idAsignatura;
    @Basic(optional = false)
    @Column(name = "RUT")
    private String rut;
    @Column(name = "NOTA")
    private Integer nota;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public Prueba() {
    }

    public Prueba(Integer idPrueba) {
        this.idPrueba = idPrueba;
    }

    public Prueba(Integer idPrueba, int idAsignatura, String rut, Date fecha) {
        this.idPrueba = idPrueba;
        this.idAsignatura = idAsignatura;
        this.rut = rut;
        this.fecha = fecha;
    }

    public Integer getIdPrueba() {
        return idPrueba;
    }

    public void setIdPrueba(Integer idPrueba) {
        this.idPrueba = idPrueba;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
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
        return "Entities.Prueba[ idPrueba=" + idPrueba + " ]";
    }
    
}

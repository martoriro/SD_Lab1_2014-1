/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entityClass;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Joel
 */
@Entity
@Table(name = "USUARIO_ASIGNATURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioAsignatura.findAll", query = "SELECT u FROM UsuarioAsignatura u"),
    @NamedQuery(name = "UsuarioAsignatura.findByIdUsuarioAsignatura", query = "SELECT u FROM UsuarioAsignatura u WHERE u.idUsuarioAsignatura = :idUsuarioAsignatura"),
    @NamedQuery(name = "UsuarioAsignatura.findByIdAsignatura", query = "SELECT u FROM UsuarioAsignatura u WHERE u.idAsignatura = :idAsignatura"),
    @NamedQuery(name = "UsuarioAsignatura.findByRut", query = "SELECT u FROM UsuarioAsignatura u WHERE u.rut = :rut")})
public class UsuarioAsignatura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO_ASIGNATURA")
    private Integer idUsuarioAsignatura;
    @Column(name = "ID_ASIGNATURA")
    private Integer idAsignatura;
    @Column(name = "RUT")
    private String rut;

    public UsuarioAsignatura() {
    }

    public UsuarioAsignatura(Integer idUsuarioAsignatura) {
        this.idUsuarioAsignatura = idUsuarioAsignatura;
    }

    public Integer getIdUsuarioAsignatura() {
        return idUsuarioAsignatura;
    }

    public void setIdUsuarioAsignatura(Integer idUsuarioAsignatura) {
        this.idUsuarioAsignatura = idUsuarioAsignatura;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioAsignatura != null ? idUsuarioAsignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioAsignatura)) {
            return false;
        }
        UsuarioAsignatura other = (UsuarioAsignatura) object;
        if ((this.idUsuarioAsignatura == null && other.idUsuarioAsignatura != null) || (this.idUsuarioAsignatura != null && !this.idUsuarioAsignatura.equals(other.idUsuarioAsignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityClass.UsuarioAsignatura[ idUsuarioAsignatura=" + idUsuarioAsignatura + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entityClasses;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Martín
 */
@Entity
@Table(name = "ASISTENCIA_ASIGNATURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsistenciaAsignatura.findAll", query = "SELECT a FROM AsistenciaAsignatura a"),
    @NamedQuery(name = "AsistenciaAsignatura.findByIdAsistencia", query = "SELECT a FROM AsistenciaAsignatura a WHERE a.asistenciaAsignaturaPK.idAsistencia = :idAsistencia"),
    @NamedQuery(name = "AsistenciaAsignatura.findByIdAsignatura", query = "SELECT a FROM AsistenciaAsignatura a WHERE a.asistenciaAsignaturaPK.idAsignatura = :idAsignatura")})
public class AsistenciaAsignatura implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsistenciaAsignaturaPK asistenciaAsignaturaPK;

    public AsistenciaAsignatura() {
    }

    public AsistenciaAsignatura(AsistenciaAsignaturaPK asistenciaAsignaturaPK) {
        this.asistenciaAsignaturaPK = asistenciaAsignaturaPK;
    }

    public AsistenciaAsignatura(int idAsistencia, int idAsignatura) {
        this.asistenciaAsignaturaPK = new AsistenciaAsignaturaPK(idAsistencia, idAsignatura);
    }

    public AsistenciaAsignaturaPK getAsistenciaAsignaturaPK() {
        return asistenciaAsignaturaPK;
    }

    public void setAsistenciaAsignaturaPK(AsistenciaAsignaturaPK asistenciaAsignaturaPK) {
        this.asistenciaAsignaturaPK = asistenciaAsignaturaPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asistenciaAsignaturaPK != null ? asistenciaAsignaturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaAsignatura)) {
            return false;
        }
        AsistenciaAsignatura other = (AsistenciaAsignatura) object;
        if ((this.asistenciaAsignaturaPK == null && other.asistenciaAsignaturaPK != null) || (this.asistenciaAsignaturaPK != null && !this.asistenciaAsignaturaPK.equals(other.asistenciaAsignaturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.AsistenciaAsignatura[ asistenciaAsignaturaPK=" + asistenciaAsignaturaPK + " ]";
    }
    
}

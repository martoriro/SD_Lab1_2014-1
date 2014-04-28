/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entityClasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Martín
 */
@Embeddable
public class AsistenciaAsignaturaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ASISTENCIA")
    private int idAsistencia;
    @Basic(optional = false)
    @Column(name = "ID_ASIGNATURA")
    private int idAsignatura;

    public AsistenciaAsignaturaPK() {
    }

    public AsistenciaAsignaturaPK(int idAsistencia, int idAsignatura) {
        this.idAsistencia = idAsistencia;
        this.idAsignatura = idAsignatura;
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAsistencia;
        hash += (int) idAsignatura;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaAsignaturaPK)) {
            return false;
        }
        AsistenciaAsignaturaPK other = (AsistenciaAsignaturaPK) object;
        if (this.idAsistencia != other.idAsistencia) {
            return false;
        }
        if (this.idAsignatura != other.idAsignatura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.AsistenciaAsignaturaPK[ idAsistencia=" + idAsistencia + ", idAsignatura=" + idAsignatura + " ]";
    }
    
}

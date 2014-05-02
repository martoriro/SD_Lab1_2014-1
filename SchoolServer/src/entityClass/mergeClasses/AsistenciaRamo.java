/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entityClass.mergeClasses;

import java.sql.Date;
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
 * @author Martín
 */
@Entity
//@JoinTable(name="ASISTENCIA_RAMO");
public class AsistenciaRamo {
    int rut;
    int estado;
    int id_asignatura;
    Date fecha;
    
    public AsistenciaRamo(){
        rut = 0;
    }
    
    public void setRut(int rutE){
        rut = rutE;
    }
    public void setEstado(int estadoE){
        estado = estadoE;
    }
    public void setId(int idE){
        id_asignatura = idE;
    }
    public void setFecha(Date fechaE){
        fecha = fechaE;
    }
}
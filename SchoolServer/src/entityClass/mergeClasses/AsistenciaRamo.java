/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entityClass.mergeClasses;

import entityClass.*;
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
 * @author Martín
 */
//@Entity
//@JoinTable(name="ASISTENCIA_RAMO");
public class AsistenciaRamo {
    String rut;
    int estado;
    int id_asignatura;
    Date fecha;
    
    public AsistenciaRamo(String rutE, int idAsignatura, Date fechaE, int estadoE){
        rut = rutE;
        id_asignatura = idAsignatura;
        fecha = fechaE;
        estado = estadoE;
    }

    public String getRut(){
        return rut;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public int getEstado(){
        return estado;
    }
    
    public int getAsignatura(){
        return id_asignatura;
    }
    
    public void showAsistencia(){
        System.out.println("Rut: "+rut+" ID Asignatura: "+id_asignatura+" Fecha: "+fecha+" Asistio?: "+estado);
    }
}
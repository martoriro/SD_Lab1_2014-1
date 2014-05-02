/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entityClass.mergeClasses;

import java.sql.Date;

/**
 *
 * @author Martín
 */
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

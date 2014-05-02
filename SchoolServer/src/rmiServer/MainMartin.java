/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiServer;

import entityClass.*;
import static entityClass.Usuario_.edad;
import entityClass.mergeClasses.*;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sessionBeans.*;
//import sessionBeans.*;

/**
 *
 * @author Gustavo Salvo Lara
 */
public class MainMartin {
    static private RmiConnection connection = new RmiConnection();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, Exception {
        System.out.println("ADMINISTRADOR: CRUD USUARIOS");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SchoolServerPU");
        AsistenciaJpaController asistencia = new AsistenciaJpaController(factory);
        
        List<AsistenciaRamo> asistencias = asistencia.findAsistenciaPorDia("176032502", java.sql.Date.valueOf("2014-04-30"));
        //System.out.println(asistencias.);
        
        //Usuario nuevoUsuario = new Usuario("17409487g", "123", "Joel", 23, "alumno", "Avalos", "Pincheira");
        //Usuario nUser2 = new Usuario("176032502", "123", "M", 23, "profesor", "Gonzalez", "Sotomayor");
        //usuarioController.create(nuevoUsuario); //Comentado para no meter al mismo wn
        //usuarioController.create(nUser2); //Comentado para no meter al mismo wn
        //Eliminar usuario
        //usuarioController.destroy("17409487k");
        System.out.println("FIN");
       }
}

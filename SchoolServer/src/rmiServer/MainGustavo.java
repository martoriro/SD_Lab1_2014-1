/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiServer;

import entityClass.Usuario;
import static entityClass.Usuario_.edad;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sessionBeans.PruebaJpaController;
import sessionBeans.UsuarioJpaController;
//import sessionBeans.*;

/**
 *
 * @author Gustavo Salvo Lara
 */
public class MainGustavo {
    static private RmiConnection connection = new RmiConnection();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, Exception {
        System.out.println("Promedio: Gustavo ramo matemática");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SchoolServerPU");
        PruebaJpaController pruebaController = new PruebaJpaController(factory);
        System.out.println(pruebaController.sacaPromedioRamo("177402168",1));
        System.out.println("Promedio: Gustavo ramo matemática");
        System.out.println(pruebaController.promedioGeneralAlumno("177402168"));
    }
}

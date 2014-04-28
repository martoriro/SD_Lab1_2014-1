/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiServer;

import entityClasses.Asignatura;
import java.rmi.RemoteException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sessionBeans.*;

/**
 *
 * @author Gustavo Salvo Lara
 */
public class Main {
    static private RmiConnection connection = new RmiConnection();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        Asignatura calculo = new Asignatura();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SchoolServerPU");
        AsignaturaJpaController calculoController = new AsignaturaJpaController(factory);
        calculo.setNombre("Calculo");
        calculo.setRut("17032");
        calculoController.create(calculo);
       }
}

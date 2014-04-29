/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiServer;

import entityClasses.Asignatura;
import entityClasses.Prueba;
import java.rmi.RemoteException;
import java.util.List;
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
        /*
        Asignatura calculo = new Asignatura();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SchoolServerPU");
        AsignaturaJpaController calculoController = new AsignaturaJpaController(factory);
        calculo.setNombre("calculo");
        calculo.setRut("17032");
        calculoController.create(calculo);
        */
        
        //Funcionalidad ver notas del alumno
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SchoolServerPU");
        PruebaJpaController notasController = new PruebaJpaController(factory);
        
        List<Prueba> pruebas;
        pruebas = notasController.showNotes("17409487k");
        for (int i = 0; i < pruebas.size(); i++) {
            System.out.println("Id asignatura: " + pruebas.get(i).getIdAsignatura() + ", Nota: " + pruebas.get(i).getNota());
        }
        
       }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiServer;

import entityClasses.Anotacion;
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
        System.out.println("FUNCIONALIDAD QUE MUESTRA TODAS LAS NOTAS");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SchoolServerPU");
        PruebaJpaController notasController = new PruebaJpaController(factory);
        
        List<Prueba> pruebas;
        pruebas = notasController.showNotes("17409487k");
        for (int i = 0; i < pruebas.size(); i++) {
            System.out.println("Id asignatura: " + pruebas.get(i).getIdAsignatura() + ", Nota: " + pruebas.get(i).getNota());
        }
        
        //Funcionalidad Notas del alumno por asignatura
        System.out.println("FUNCIONALIDAD QUE FILTRA POR ALUMNO Y ASIGNATURA");
        System.out.println("CASO RAMO 2 Y NOTAS");
        List<Prueba> PruebasAsignaturas;
        PruebasAsignaturas = notasController.showNotesForAsignature("17409487k", 2);
        for (int i = 0; i < PruebasAsignaturas.size(); i++) {
            System.out.println("Id asignatura: " + PruebasAsignaturas.get(i).getIdAsignatura() + ", Nota: " + PruebasAsignaturas.get(i).getNota());
        }
        System.out.println("CASO RAMO 4 Y NOTAS");
        PruebasAsignaturas = notasController.showNotesForAsignature("17409487k", 4);
        for (int i = 0; i < PruebasAsignaturas.size(); i++) {
            System.out.println("Id asignatura: " + PruebasAsignaturas.get(i).getIdAsignatura() + ", Nota: " + PruebasAsignaturas.get(i).getNota());
        }
        
        //Funcionalidad que permite al usuario aluimno ver sus anotaciones
         //Funcionalidad que permite al usuario aluimno ver sus anotaciones
        System.out.println("FUNCIONALIDAD QUE PERMITE AL ALUMNO VER SUS ANOTACIONES");
        AnotacionJpaController anotacionesController = new AnotacionJpaController(factory);
        
        List<Anotacion> anotaciones;
        anotaciones = anotacionesController.showAnotations("17409487k");
        for (int i = 0; i < anotaciones.size(); i++) {
            System.out.println("Id anotacion: " + anotaciones.get(i).getIdAnotacion()+ ", Contenido: " + anotaciones.get(i).getContenido());
        }
       }
}

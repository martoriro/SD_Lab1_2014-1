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
       
        System.out.println("ADMINISTRADOR: CRUD USUARIOS");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SchoolServerPU");
        UsuarioJpaController usuarioController = new UsuarioJpaController(factory);
        
        Usuario nuevoUsuario = new Usuario("17409487g", "123", "Joel", 23, "alumno", "Avalos", "Pincheira");
        //usuarioController.create(nuevoUsuario); //Comentado para no meter al mismo wn
        //Eliminar usuario
        //usuarioController.destroy("17409487k");
        
        //Editar usuario
        nuevoUsuario.setNombre("JoelEditado");
        //usuarioController.edit(nuevoUsuario); //Comentado para no editar  a cada rato
       
        //Funcionalidad ver notas del alumno
        System.out.println("FUNCIONALIDAD QUE MUESTRA TODAS LAS NOTAS");
        /*EntityManagerFactory factory = Persistence.createEntityManagerFactory("SchoolServerPU");
        PruebaJpaController pruebasController = new PruebaJpaController(factory);
        
        List<Prueba> pruebas;
        pruebas = pruebasController.showNotes("17409487k");
        for (int i = 0; i < pruebas.size(); i++) {
            System.out.println("Id asignatura: " + pruebas.get(i).getIdAsignatura() + ", Nota: " + pruebas.get(i).getNota());
        }
        
        //Funcionalidad Notas del alumno por asignatura
        System.out.println("FUNCIONALIDAD QUE FILTRA POR ALUMNO Y ASIGNATURA");
        System.out.println("CASO RAMO 2 Y NOTAS");
        List<Prueba> PruebasAsignaturas;
        PruebasAsignaturas = pruebasController.showNotesForAsignature("17409487k", 2);
        for (int i = 0; i < PruebasAsignaturas.size(); i++) {
            System.out.println("Id asignatura: " + PruebasAsignaturas.get(i).getIdAsignatura() + ", Nota: " + PruebasAsignaturas.get(i).getNota());
        }
        System.out.println("CASO RAMO 4 Y NOTAS");
        PruebasAsignaturas = pruebasController.showNotesForAsignature("17409487k", 4);
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
        
        //Funcionalidad para agregar notas de los alumnos
        System.out.println("FUNCIONALIDAD QUE PERMITE INSETAR NOTAS DE LOS ALUMNOS");
        
        Prueba nuevaPrueba = new Prueba(Integer.SIZE, 2, "17409487k", null);
        nuevaPrueba.setNota(33);
        //pruebasController.create(nuevaPrueba);
        */
        System.out.println("FIN");
       }
}

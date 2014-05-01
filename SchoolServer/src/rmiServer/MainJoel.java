/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiServer;

import encriptador.MD5;
import entityClass.Anotacion;
import entityClass.Asignatura;
import entityClass.Asistencia;
import entityClass.Mensaje;
import entityClass.Prueba;
import entityClass.Usuario;
import static entityClass.Usuario_.edad;
import java.rmi.RemoteException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sessionBeans.AnotacionJpaController;
import sessionBeans.AsignaturaJpaController;
import sessionBeans.AsistenciaJpaController;
import sessionBeans.MensajeJpaController;
import sessionBeans.PruebaJpaController;
import sessionBeans.UsuarioJpaController;
import sun.util.calendar.BaseCalendar;
//import sessionBeans.*;

/**
 *
 * @author Gustavo Salvo Lara
 */
public class MainJoel {
    static private RmiConnection connection = new RmiConnection();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, Exception {
       
        System.out.println("FUNCIONALIDAD QUE ECRIPTA EN MD5");
        String password = "123";
        String passwordEncriptada;
        MD5 instancia = new MD5();
        passwordEncriptada = instancia.encriptar(password);
        System.out.println("PASSWORD ENCRIPTADA ES: " + passwordEncriptada);
        
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
       
        System.out.println("BUSCAR POR RUT Y MUESTRA DATOS");
        List<Usuario> usuarios;
        usuarios = usuarioController.buscarUsuario("17409487k");
        
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println("Rut: " + usuarios.get(i).getRut() + ", Nombre: " + usuarios.get(i).getNombre());
        }
        
        System.out.println("Ver mis anotaciones");
        AnotacionJpaController anotacionController = new AnotacionJpaController(factory);
        List<Anotacion> anotaciones;
        anotaciones = anotacionController.buscarAnotaciones("17409487k");
        
        for (int i = 0; i < anotaciones.size(); i++) {
            System.out.println("Rut: " + anotaciones.get(i).getRutAlumno()+ ", Contenido: " + anotaciones.get(i).getContenido());
        }
        //Funcionalidad ver notas del alumno
        System.out.println("FUNCIONALIDAD QUE MUESTRA TODAS LAS NOTAS");
        
        PruebaJpaController pruebaController = new PruebaJpaController(factory);
        List<Prueba> notas;
        notas = pruebaController.todasNotas("177402168");
        
        for (int i = 0; i < notas.size(); i++) {
            System.out.println("Rut: " + notas.get(i).getRut() + ", Ramo: " + notas.get(i).getIdAsignatura() + ", Nota: " + notas.get(i).getNota());
        }
        
        System.out.println("fUNCIONALIDAD QUE PERMITE VER LOS MENSAJES DEL ADMINISTRADOR");
        MensajeJpaController mensajeController = new MensajeJpaController(factory);
        List<Mensaje> mensajeRecibido;
        mensajeRecibido = mensajeController.mensajeEspecifico("apoderado");
        
        for (int i = 0; i < mensajeRecibido.size(); i++) {
            System.out.println("Asunto: " + mensajeRecibido.get(i).getAsunto()+ ", Contenido: " + mensajeRecibido.get(i).getContenido()+ ", Fecha: " + mensajeRecibido.get(i).getFecha());
        }
        
        System.out.println("FUNCIONALIDAD QUE PERMITE OBTENER LAS NOTAS DE UNA ASIGNATURA");
        List<Prueba> listaNotasAsignatura;
        listaNotasAsignatura = pruebaController.notasPorAsignatura("177402168", 2);
        
        for (int i = 0; i < listaNotasAsignatura.size(); i++) {
            System.out.println("Rut: " + listaNotasAsignatura.get(i).getRut()+ ", Asignatura: " + listaNotasAsignatura.get(i).getIdAsignatura()+ ", Nota: " + listaNotasAsignatura.get(i).getNota());
        }
        
        System.out.println("FUNCIONALIDAD PROFESOR REGISTRA ASISTENCIA");
        AsistenciaJpaController asistenciaController = new AsistenciaJpaController(factory);
        Asistencia nuevaAsistencia;
        nuevaAsistencia = new Asistencia(null, 0);
        nuevaAsistencia.setIdAsignatura(2);
        nuevaAsistencia.setRut("177402168");
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        
        nuevaAsistencia.setFecha(cal.getTime());
        
        //asistenciaController.create(nuevaAsistencia); //Comentada para no agregar la misma asistencia a cada rato
        
        System.out.println("FUNCIONALIDAD APODERADO VE ASISTENCIA DE SU HIJO");
        List<Asistencia> asistenciaHijo;
        asistenciaHijo = asistenciaController.asistenciaAlumnoApoderado("17409487k");
        
        for (int i = 0; i < asistenciaHijo.size(); i++) {
            System.out.println("Rut: " + asistenciaHijo.get(i).getRut()+ ", Asignatura: " + asistenciaHijo.get(i).getIdAsignatura()+ ", Estado: " + asistenciaHijo.get(i).getEstado());
        }
        
        
        System.out.println("FUNCIONALIDAD COMO ADMINISTRADOR QUIERO HACER CRUD DE RAMOS");
        
        AsignaturaJpaController asignaturaController = new AsignaturaJpaController(factory);
        
        System.out.println("CRATE");
        
        Asignatura nuevaAsignatura = new Asignatura(null, "artes"); 
        //asignaturaController.create(nuevaAsignatura); //Comentado para no crear varias veces la misma asignatura
        
        System.out.println("READ");
        List<Asignatura> listaAsignaturas;
        listaAsignaturas = asignaturaController.listaAsignaturas();
        
        for (int i = 0; i < listaAsignaturas.size(); i++) {
            System.out.println("ID: " + listaAsignaturas.get(i).getIdAsignatura()+ ", Nombre: " + listaAsignaturas.get(i).getNombre());
        }
        
        System.out.println("UPDATE");
        nuevaAsignatura.setNombre("artesEditado");
        nuevaAsignatura.setIdAsignatura(5);
        //asignaturaController.edit(nuevaAsignatura);  //Comentado para editar cuando ya no exista
        
        for (int i = 0; i < listaAsignaturas.size(); i++) {
            System.out.println("ID: " + listaAsignaturas.get(i).getIdAsignatura()+ ", Nombre: " + listaAsignaturas.get(i).getNombre());
        }
        
        System.out.println("DELETE");
        
        //asignaturaController.destroy(6);  //Comentado para no eliminar el elemento no existente
        
        for (int i = 0; i < listaAsignaturas.size(); i++) {
            System.out.println("ID: " + listaAsignaturas.get(i).getIdAsignatura()+ ", Nombre: " + listaAsignaturas.get(i).getNombre());
        }
        
        System.out.println("FUNCIONALIDAD PARA CREAR MENSAJES");
        Mensaje nuevoMensajeAdministrador = new Mensaje(null);
        nuevoMensajeAdministrador.setAsunto("Correos electronicos");
        nuevoMensajeAdministrador.setContenido("Solicito a los apoderados enviar su correo electronico a pepe@hotmail.com");
        nuevoMensajeAdministrador.setTipo("apoderado");
        nuevoMensajeAdministrador.setFecha(cal.getTime());
        
        //mensajeController.create(nuevoMensajeAdministrador); //Comento para no agregar a cada rato el mismo mensaje
        
        System.out.println("FIN");
       }
}

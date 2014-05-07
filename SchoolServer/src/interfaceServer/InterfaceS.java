/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceServer;

import entityClass.Anotacion;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gustavo Salvo Lara
 */
public interface InterfaceS extends Remote{
    public String userLogin (String user, String pass) throws RemoteException;
    public String[] verAsignaturas(String rut) throws RemoteException;
    public String nombreApellido(String rut) throws RemoteException;
    public String[] verNotas(String rut, String nombre) throws RemoteException;
    public float calculaPromedioAsignatura(String asignatura, String rut) throws RemoteException;
    public String[][] asignaturaPromedioAlumno(String rut) throws RemoteException;
    public float promedioGeneralAlumno(String rut) throws RemoteException;
    public String[] filtraAnotaciones(String rut,String tipo)throws RemoteException;
    public String[] anotacionesTodas(String rut) throws RemoteException;
    public String[] miAnotacion(int idAnotacion) throws RemoteException;
    public String[] leerMensaje(int id) throws RemoteException;
    public String[] listarMensajes(String tipo) throws RemoteException;
    public String tipoUsuario(String rut) throws RemoteException;
    public String[] obtenerHijos(String rutApoderado) throws RemoteException;
    public String obtenerProfesor(String materia) throws Exception;
    public String[] promedios(String asignatura) throws Exception;
    public String[] alumnosAsignatura(String asignatura) throws RemoteException;
    public void crearAnotacion(String contenido, String rutProfesor, String tipo, String rutAlumno) throws RemoteException;
    public String[] todosAlumnos() throws RemoteException;
    public void crearMensaje(String asunto, String contenido, String tipo) throws RemoteException;
    public String[] profesores() throws RemoteException;
}

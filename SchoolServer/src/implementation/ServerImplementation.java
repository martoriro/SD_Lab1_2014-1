/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import entityClass.Anotacion;
import entityClass.Asignatura;
import entityClass.Prueba;
import entityClass.Usuario;
import entityClass.UsuarioAsignatura;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sessionBeans.*;

/**
 *
 * @author Gustavo Salvo Lara
 */
public class ServerImplementation extends UnicastRemoteObject implements interfaceServer.InterfaceS {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("SchoolServerPU");
    UsuarioJpaController userFunction = new UsuarioJpaController(factory);
    AnotacionJpaController anotacionController = new AnotacionJpaController(factory);
    AsignaturaJpaController asignaturaController = new AsignaturaJpaController(factory);
    AsistenciaJpaController asistenciaController = new AsistenciaJpaController(factory);
    MensajeJpaController mensajeController = new MensajeJpaController(factory);
    PruebaJpaController pruebaController = new PruebaJpaController(factory);
    UsuarioAsignaturaJpaController usuarioAsignaturaController = new UsuarioAsignaturaJpaController(factory);
    
    
        
    public ServerImplementation() throws RemoteException{
        
    }

    @Override
    public String userLogin(String user, String pass) throws RemoteException {
        String resp = null;
        try {
            resp = userFunction.login(user, pass);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ServerImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }
    
    //Funciones de profesores
    public String[] verAsignaturas(String rut) throws RemoteException{
        
        List<UsuarioAsignatura> listatest;
        List<Asignatura> AsignaturaName;

        listatest = usuarioAsignaturaController.AsignaturasRut(rut);
        
        String listaProbando[] = new String[listatest.size()];
        
        for (int i = 0; i < listatest.size(); i++) {
            AsignaturaName = asignaturaController.nombreAsignatura(listatest.get(i).getIdAsignatura());
            //System.out.println("ID: " + listatest.get(i).getIdAsignatura());
            //System.out.println("Nombre: " + AsignaturaName.get(0).getNombre());
            listaProbando[i] = AsignaturaName.get(0).getNombre(); 
        }
        return listaProbando;
    }
    
    public String nombreApellido(String rut) throws RemoteException{
        String nombreApellido = "";
        String nombre = null;
        String apellidoPat = null;
        String apellidoMat = null;
        List<Usuario> usuarioPorRut;
        usuarioPorRut = userFunction.buscarUsuario(rut);
        nombre = usuarioPorRut.get(0).getNombre();
        apellidoPat = usuarioPorRut.get(0).getApellidoPat();
        apellidoMat = usuarioPorRut.get(0).getApellidoMat();
        nombreApellido = nombre + " " + apellidoPat + " " + apellidoMat;

        return nombreApellido;
    }
    
    public String[] verNotas(String rut, String nombre) throws RemoteException{
        List<Asignatura> Asignaturas;
        Asignaturas = asignaturaController.idAsignatura(nombre);
        List<Prueba> listaPruebas;
        listaPruebas = pruebaController.notasPorAsignatura(rut, Asignaturas.get(0).getIdAsignatura());
        
        String listaPruebasNotas[] = new String[listaPruebas.size()];
        for (int i = 0; i < listaPruebas.size(); i++) {
            //AsignaturaName = asignaturaController.nombreAsignatura(listatest.get(i).getIdAsignatura());
            
            listaPruebasNotas[i] = listaPruebas.get(i).getFecha() + "." + listaPruebas.get(i).getNota(); 
        }
        return listaPruebasNotas;
    }

}

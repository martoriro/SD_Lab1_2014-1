/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import encriptador.MD5;
import entityClass.Anotacion;
import entityClass.Asignatura;
import entityClass.Mensaje;
import entityClass.Prueba;
import entityClass.Usuario;
import entityClass.UsuarioAsignatura;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sessionBeans.*;
import sessionBeans.exceptions.NonexistentEntityException;

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

    public ServerImplementation() throws RemoteException {
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

    public String tipoUsuario(String rut) {
        Usuario user = userFunction.buscarUsuario(rut).get(0);
        return user.getTipo();
    }

    public String[] leerMensaje(int id) {
        String mensaje[] = new String[3];
        Mensaje msg = mensajeController.findMensaje(id);
        mensaje[0] = msg.getFecha() + "";
        mensaje[1] = msg.getAsunto();
        mensaje[2] = msg.getContenido();
        return mensaje;
    }

    public String[] listarMensajes(String tipo) {
        List<Mensaje> mensaje = mensajeController.mensajeEspecifico(tipo);
        String idMensajes[] = new String[mensaje.size()];
        for (int i = 0; i < idMensajes.length; i++) {
            idMensajes[i] = mensaje.get(i).getIdMensaje() + "";
        }
        return idMensajes;
    }

    public String[] miAnotacion(int idAnotacion) throws RemoteException {
        List<Anotacion> anotaciones = anotacionController.miAnotacion(idAnotacion);
        String resultado[] = new String[4];
        resultado[0] = anotaciones.get(0).getFecha() + "";
        resultado[1] = nombreApellido(anotaciones.get(0).getRutProfesor() + "");
        resultado[2] = anotaciones.get(0).getContenido();
        resultado[3] = anotaciones.get(0).getTipoAnotacion() + "";
        return resultado;
    }

    public String[] filtraAnotaciones(String rut, String tipo) {
        List<Anotacion> anotaciones = anotacionController.filtrarAnotaciones(rut, tipo);
        int cant = anotaciones.size();
        String anotacionesFiltradas[] = new String[cant];
        for (int i = 0; i < cant; i++) {
            anotacionesFiltradas[i] = anotaciones.get(i).getIdAnotacion() + "";
        }
        return anotacionesFiltradas;
    }

    public String[] anotacionesTodas(String rut) {
        List<Anotacion> anotaciones = anotacionController.buscarAnotaciones(rut);
        int cant = anotaciones.size();
        String anotacionesFiltradas[] = new String[cant];
        for (int i = 0; i < cant; i++) {
            anotacionesFiltradas[i] = anotaciones.get(i).getIdAnotacion() + "";
        }
        return anotacionesFiltradas;
    }

    public float promedioGeneralAlumno(String rut) {
        String[][] promAsig = asignaturaPromedioAlumno(rut);
        float sum = 0;
        for (int i = 0; i < promAsig[0].length; i++) {
            sum += Float.parseFloat(promAsig[1][i]);
        }
        float prom = sum / promAsig[0].length;
        return Float.parseFloat(Math.round(prom * Math.pow(10, 1)) / Math.pow(10, 1) + "");
    }

    public String[][] asignaturaPromedioAlumno(String rut) {
        List<UsuarioAsignatura> asignaturas = usuarioAsignaturaController.AsignaturasRut(rut);
        int cantAsignaturas = asignaturas.size();
        String asigProm[][] = new String[2][cantAsignaturas];
        for (int i = 0; i < cantAsignaturas; i++) {
            asigProm[0][i] = (asignaturaController.nombreAsignatura(asignaturas.get(i).getIdAsignatura()).get(0).getNombre());

            asigProm[1][i] = (pruebaController.sacaPromedioRamo(rut, asignaturas.get(i).getIdAsignatura()) + "");

        }
        return asigProm;

    }

    public float calculaPromedioAsignatura(String asignatura, String rut) {
        int idAsignatura = Integer.parseInt(asignaturaController.idAsignatura(asignatura).get(0).getIdAsignatura() + "");
        return pruebaController.sacaPromedioRamo(rut, idAsignatura);
    }

    public String[] verAsignaturas(String rut) throws RemoteException {

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

    public String nombreApellido(String rut) throws RemoteException {
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

    public String[] verNotas(String rut, String nombre) throws RemoteException {
        List<Asignatura> Asignaturas;
        Asignaturas = asignaturaController.idAsignatura(nombre);
        List<Prueba> listaPruebas;
        listaPruebas = pruebaController.notasPorAsignatura(rut, Asignaturas.get(0).getIdAsignatura());

        String listaPruebasNotas[] = new String[listaPruebas.size()];
        for (int i = 0; i < listaPruebas.size(); i++) {
            //AsignaturaName = asignaturaController.nombreAsignatura(listatest.get(i).getIdAsignatura());

            listaPruebasNotas[i] = listaPruebas.get(i).getFecha() + "/" + listaPruebas.get(i).getNota();
        }
        return listaPruebasNotas;
    }

    public String[] obtenerHijos(String rutApoderado) throws RemoteException {
        List<Usuario> listaHijos;
        listaHijos = userFunction.buscarHijos(rutApoderado);
        String hijos[] = new String[listaHijos.size()];

        for (int i = 0; i < listaHijos.size(); i++) {
            //AsignaturaName = asignaturaController.nombreAsignatura(listatest.get(i).getIdAsignatura());

            hijos[i] = listaHijos.get(i).getRut() + "," + listaHijos.get(i).getNombre() + " " + listaHijos.get(i).getApellidoPat() + " " + listaHijos.get(i).getApellidoMat();
        }
        return hijos;
    }

    public String obtenerProfesor(String materia) throws Exception {
        List<Asignatura> listaAsignaturas;
        listaAsignaturas = asignaturaController.idAsignatura(materia);
        int idAsignatura;
        idAsignatura = listaAsignaturas.get(0).getIdAsignatura();
        String rut;
        String nombre = "";
        List<UsuarioAsignatura> listaUsuariosAsignaturas;
        listaUsuariosAsignaturas = usuarioAsignaturaController.AsignaturasID(idAsignatura);
        //Ahora obtengo los profesores
        List<Usuario> listaProfesores;
        listaProfesores = userFunction.buscarProfesor();

        for (int i = 0; i < listaProfesores.size(); i++) {
            rut = listaProfesores.get(i).getRut();
            for (int j = 0; j < listaUsuariosAsignaturas.size(); j++) {
                if (rut.equals(listaUsuariosAsignaturas.get(j).getRut())) {
                    nombre = listaProfesores.get(i).getNombre() + " " + listaProfesores.get(i).getApellidoPat() + " " + listaProfesores.get(i).getApellidoMat();
                } else {
                    //nada
                }
            }
        }

        return nombre;
    }

    public String[] promedios(String asignatura) throws Exception {
        List<Asignatura> listaAsignatura;
        listaAsignatura = asignaturaController.idAsignatura(asignatura);
        int idAsignatura2 = 0;
        idAsignatura2 = listaAsignatura.get(0).getIdAsignatura();

        List<UsuarioAsignatura> listaAlumnosProfesores;
        listaAlumnosProfesores = usuarioAsignaturaController.AsignaturasID(idAsignatura2);

        List<Usuario> listaUsuarios;
        Usuario usuarioAgregar = new Usuario();
        int cantidadAlumnos = 0;

        for (int i = 0; i < listaAlumnosProfesores.size(); i++) {

            listaUsuarios = userFunction.buscarUsuario(listaAlumnosProfesores.get(i).getRut());
            //System.out.println(listaUsuarios.get(0).getRut());

            if (listaUsuarios.get(0).getTipo().equals("profesor")) {
                System.out.println("hola soy profe");
                //listaAlumnosProfesores.remove(listaUsuarios.get(0));
            } else {
                cantidadAlumnos++;
            }
        }
        String listaAlumnos[] = new String[cantidadAlumnos];
        int aux = 0;

        for (int i = 0; i < listaAlumnosProfesores.size(); i++) {

            listaUsuarios = userFunction.buscarUsuario(listaAlumnosProfesores.get(i).getRut());
            //System.out.println(listaUsuarios.get(0).getRut());

            if (listaUsuarios.get(0).getTipo().equals("profesor")) {
            } else {
                listaAlumnos[aux] = listaUsuarios.get(0).getRut();
                aux++;
            }
        }

        String resultado;
        String resultadofinal[] = new String[cantidadAlumnos];

        for (int i = 0; i < listaAlumnos.length; i++) {
            resultado = listaAlumnos[i] + "," + pruebaController.sacaPromedioRamoJoel(listaAlumnos[i], idAsignatura2);
            resultadofinal[i] = resultado;
        }

        return resultadofinal;
    }

    public String[] alumnosAsignatura(String asignatura) throws RemoteException {

        List<Asignatura> listaAsignatura;
        listaAsignatura = asignaturaController.idAsignatura(asignatura);
        int idAsignatura2 = 0;
        idAsignatura2 = listaAsignatura.get(0).getIdAsignatura();

        List<UsuarioAsignatura> listaAlumnosProfesores;
        listaAlumnosProfesores = usuarioAsignaturaController.AsignaturasID(idAsignatura2);

        List<Usuario> listaUsuarios;
        Usuario usuarioAgregar = new Usuario();
        int cantidadAlumnos = 0;

        for (int i = 0; i < listaAlumnosProfesores.size(); i++) {

            listaUsuarios = userFunction.buscarUsuario(listaAlumnosProfesores.get(i).getRut());
            //System.out.println(listaUsuarios.get(0).getRut());

            if (listaUsuarios.get(0).getTipo().equals("profesor")) {
                //listaAlumnosProfesores.remove(listaUsuarios.get(0));
            } else {
                cantidadAlumnos++;
            }
        }
        String listaAlumnos[] = new String[cantidadAlumnos];
        int aux = 0;

        for (int i = 0; i < listaAlumnosProfesores.size(); i++) {

            listaUsuarios = userFunction.buscarUsuario(listaAlumnosProfesores.get(i).getRut());

            if (listaUsuarios.get(0).getTipo().equals("profesor")) {
            } else {
                listaAlumnos[aux] = listaUsuarios.get(0).getRut() + "," + listaUsuarios.get(0).getNombre();
                aux++;
            }
        }
        return listaAlumnos;
    }

    public void crearAnotacion(String contenido, String rutProfesor, String tipo, String rutAlumno) throws RemoteException {
        Date fecha = new Date();

        Anotacion nuevaAnotacion = new Anotacion();
        nuevaAnotacion.setContenido(contenido);
        nuevaAnotacion.setFecha(fecha);
        nuevaAnotacion.setRutProfesor(rutProfesor);
        nuevaAnotacion.setTipoAnotacion(tipo);
        nuevaAnotacion.setRutAlumno(rutAlumno);

        anotacionController.create(nuevaAnotacion);
    }

    public String[] todosAlumnos() throws RemoteException {
        List<Usuario> listaAlumnos;
        String resultado;
        listaAlumnos = userFunction.buscarAlumnos();
        String listaAlumnos2[] = new String[listaAlumnos.size()];
        for (int i = 0; i < listaAlumnos2.length; i++) {
            listaAlumnos2[i] = listaAlumnos.get(i).getRut() + "," + listaAlumnos.get(i).getNombre() + " " + listaAlumnos.get(i).getApellidoPat() + " " + listaAlumnos.get(i).getApellidoMat();
        }
        return listaAlumnos2;
    }

    public void crearMensaje(String asunto, String contenido, String tipo) throws RemoteException {
        Date fecha = new Date();

        Mensaje nuevoMensaje;
        nuevoMensaje = new Mensaje();
        nuevoMensaje.setAsunto(asunto);
        nuevoMensaje.setContenido(contenido);
        nuevoMensaje.setTipo(tipo);
        nuevoMensaje.setFecha(fecha);

        mensajeController.create(nuevoMensaje);
    }

    public boolean crearAsignatura(String nombre) throws RemoteException {
        Asignatura nuevaAsignatura;
        nuevaAsignatura = new Asignatura();
        nuevaAsignatura.setNombre(nombre);

        try {
            asignaturaController.create(nuevaAsignatura);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String[] profesores() throws RemoteException {
        List<Usuario> listaProfesores;
        listaProfesores = userFunction.buscarProfesor();
        String profesores[] = new String[listaProfesores.size()];

        for (int i = 0; i < listaProfesores.size(); i++) {
            profesores[i] = listaProfesores.get(i).getRut() + "," + listaProfesores.get(i).getNombre() + " " + listaProfesores.get(i).getApellidoPat() + " " + listaProfesores.get(i).getApellidoMat();
        }

        return profesores;
    }

    public String[] alumnos() throws RemoteException {
        List<Usuario> listaAlumnos;
        listaAlumnos = userFunction.buscarAlumnos();
        String alumnos[] = new String[listaAlumnos.size()];

        for (int i = 0; i < listaAlumnos.size(); i++) {
            alumnos[i] = listaAlumnos.get(i).getRut() + "," + listaAlumnos.get(i).getNombre() + " " + listaAlumnos.get(i).getApellidoPat() + " " + listaAlumnos.get(i).getApellidoMat();
        }

        return alumnos;
    }

    public String[] asignaturas() throws RemoteException {
        List<Asignatura> listaAsignaturas;
        listaAsignaturas = asignaturaController.listaAsignaturas();
        String asignaturas[] = new String[listaAsignaturas.size()];

        for (int i = 0; i < listaAsignaturas.size(); i++) {
            asignaturas[i] = listaAsignaturas.get(i).getNombre();
        }

        return asignaturas;
    }

    public boolean profesorMateria(String rutProfesor, String materia) throws RemoteException {
        List<Asignatura> asignaturaBuscada;
        asignaturaBuscada = asignaturaController.idAsignatura(materia);
        int idAsignatura = asignaturaBuscada.get(0).getIdAsignatura();

        UsuarioAsignatura nuevoUsuarioAsignatura = new UsuarioAsignatura();
        nuevoUsuarioAsignatura.setIdAsignatura(idAsignatura);
        nuevoUsuarioAsignatura.setRut(rutProfesor);

        List<UsuarioAsignatura> revision;
        revision = usuarioAsignaturaController.buscarRegistro(rutProfesor, idAsignatura);

        if (revision.size() == 0) {
            usuarioAsignaturaController.create(nuevoUsuarioAsignatura);
            return true;
        } else {
            //No se puede crear
            return false;
        }

    }

    public boolean alumnoMateria(String rutAlumno, String materia) throws RemoteException {
        List<Asignatura> asignaturaBuscada;
        asignaturaBuscada = asignaturaController.idAsignatura(materia);
        int idAsignatura = asignaturaBuscada.get(0).getIdAsignatura();

        UsuarioAsignatura nuevoUsuarioAsignatura = new UsuarioAsignatura();
        nuevoUsuarioAsignatura.setIdAsignatura(idAsignatura);
        nuevoUsuarioAsignatura.setRut(rutAlumno);

        List<UsuarioAsignatura> revision;
        revision = usuarioAsignaturaController.buscarRegistro(rutAlumno, idAsignatura);

        if (revision.size() == 0) {
            usuarioAsignaturaController.create(nuevoUsuarioAsignatura);
            return true;
        } else {
            //No se puede crear
            return false;
        }
    }

    public boolean validarRut(String rut) throws RemoteException{

        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }
    
    public String[] alumnosSinApoderado(){
        List<Usuario> sinApoderados;
        sinApoderados = userFunction.sinApoderados();
        String alumnosSinApoderado[] = new String[sinApoderados.size()];
        
        for(int i = 0; i < alumnosSinApoderado.length; i++){
            alumnosSinApoderado[i] = sinApoderados.get(i).getRut();
        }
        
        return alumnosSinApoderado;
    }
    
    

//Funcionalidades del administrador
    public boolean nuevoUsuario(String rut, String password, String nombre, int edad, String tipo, String apellidoPat, String apellidoMat, String rutApoderado) throws Exception {
        
        String password2 = password;
        String passwordEncriptada;
        MD5 instancia = new MD5();
        passwordEncriptada = instancia.encriptar(password2);
        
        Usuario nuevoUsuario = new Usuario(rut, passwordEncriptada, nombre, edad, tipo, apellidoPat, apellidoMat);
        nuevoUsuario.setRutApoderado(rutApoderado);
        
        List<Usuario> usuarioBuscado;
        usuarioBuscado = userFunction.buscarUsuario(rut);
        
        if(usuarioBuscado.size() == 0){
            userFunction.create(nuevoUsuario);
            return true;
        }
        else{
            return false;
            
        }
        
    }
    
    public void modificarPassword(String rut, String newPassword){
        List<Usuario> usuarioBuscado;
        usuarioBuscado = userFunction.buscarUsuario(rut);
    }

    public void eliminarUsuario(String rut) throws NonexistentEntityException {
        List<Usuario> listaUsuario;
        listaUsuario = userFunction.buscarUsuario(rut);
        userFunction.destroy(listaUsuario.get(0).getRut());
    }
}

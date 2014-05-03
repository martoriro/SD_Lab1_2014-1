/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceServer;

import entityClass.Anotacion;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Gustavo Salvo Lara
 */
public interface InterfaceS extends Remote{
    public String userLogin (String user, String pass) throws RemoteException;
    public String[] verAsignaturas(String rut) throws RemoteException;
    public String nombreApellido(String rut) throws RemoteException;
    
}

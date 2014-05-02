/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import entityClass.Anotacion;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Gustavo Salvo Lara
 */
public class ServerImplementation extends UnicastRemoteObject implements interfaceServer.InterfaceS {
    public ServerImplementation() throws RemoteException{
        
    }

    @Override
    public boolean userLogin(String user, String pass) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Anotacion> filtrarAnotaciones(String rut, String tipo) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

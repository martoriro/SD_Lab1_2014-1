/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Gustavo Salvo Lara
 */
public interface InterfaceS extends Remote{
    public boolean userLogin (String user, String pass) throws RemoteException;
}
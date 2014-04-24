/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import interfaceServer.InterfaceS;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Gustavo Salvo Lara
 */
public class ServerFunctions extends UnicastRemoteObject implements InterfaceS {

    public ServerFunctions() throws RemoteException{
        super();
    }

    @Override
    public boolean userLogin(String user, String pass) throws RemoteException {
        if(user.equals("juanito") && pass.equals("1234")){
            return true;
        }else{
            return false;
        }
    }
    
}

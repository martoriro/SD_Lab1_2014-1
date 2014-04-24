/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiServer;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo Salvo Lara
 */
public class RmiConnection {
    private static Registry registry;
    
    public Registry getRegistry() throws RemoteException{
        startRegistry(1098);
        return registry;
    }
    private static void startRegistry (int puerto) throws RemoteException{
        try{
            registry = LocateRegistry.getRegistry(puerto);
            registry.list();
        }catch(RemoteException e){
            registry = LocateRegistry.createRegistry(puerto);
            registry.list();
        }
    }
    public boolean stop() throws RemoteException{
        try{
            registry.unbind("IMP");
            return true;
        }catch(NotBoundException ex){
            Logger.getLogger(RmiConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }catch(AccessException ex){
             Logger.getLogger(RmiConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
}

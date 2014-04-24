/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiClient;

import interfaceServer.InterfaceS;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Gustavo Salvo Lara
 */
public class RmiConnection {
    private static Registry registry;
    private static InterfaceS server;
    
    public boolean rmiRegistry() throws RemoteException{
        try{
            //Se inicia rmiregistry para el registro de objetos
            java.security.AllPermission permission = new java.security.AllPermission();
            System.setProperty("java.security.policy", "rmi.policy");
            //Se indica la dirección y el puerto
            startRegistry("127.0.0.1",1098);
            server = (InterfaceS)registry.lookup("IMP");
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    private static void startRegistry(String host, int puerto){
        try{
            registry = LocateRegistry.getRegistry(host, puerto);
            registry.list();
        }catch(RemoteException e){
            e.printStackTrace();
        }
    }
    public InterfaceS getServer(){
        return server;
    }
    
}

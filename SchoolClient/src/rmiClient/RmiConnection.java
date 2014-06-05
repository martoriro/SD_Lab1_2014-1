/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiClient;

import interfaceServer.ChatInterface;
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
    private static ChatInterface chat;
    private String ipservidor;
    
    public boolean rmiRegistry() throws RemoteException{
        try{
            //Se inicia rmiregistry para el registro de objetos
            java.security.AllPermission permission = new java.security.AllPermission();
            System.setProperty("java.security.policy", "rmi.policy");
            //Se indica la dirección y el puerto
            startRegistry(ipservidor,1098);
            server = (InterfaceS)registry.lookup("IMP");
            chat = (ChatInterface) registry.lookup("CHAT");
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
    
    public void setIp(String ip){
        ipservidor = ip;
    }
    
    public InterfaceS getServer(){
        return server;
    }
    
    public ChatInterface getChat(){
        return chat;
    }
    
}

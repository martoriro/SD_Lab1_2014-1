/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiClient;

import java.rmi.RemoteException;
import rmiClient.RmiConnection;

/**
 *
 * @author Gustavo Salvo Lara
 */
public class Main {
    private static RmiConnection connection = new RmiConnection();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        if(connection.rmiRegistry()){
            if(connection.getServer().userLogin("juanito", "1234")){
                System.out.println("Bienvenido :)");
            }else{
                System.out.println("No eres Bienvenido :(");
            }
            
        }else{
            System.out.println("no se pudo :(");
        }
    }
}

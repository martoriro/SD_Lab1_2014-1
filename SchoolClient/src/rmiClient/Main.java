/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiClient;

import java.rmi.RemoteException;
import rmiClient.RmiConnection;
import viewClient.Index;

/**
 *
 * @author Gustavo Salvo Lara
 */
public class Main {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        Index login = new Index();
        login.setVisible(true);
        

    }
}

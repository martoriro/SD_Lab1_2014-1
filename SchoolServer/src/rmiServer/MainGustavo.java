/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiServer;

import implementation.ServerImplementation;
import java.rmi.RemoteException;
import viewServer.Index;

/**
 *
 * @author Gustavo Salvo Lara
 */
public class MainGustavo {
    
    
    public static void main(String[] args) throws RemoteException, Exception {
        ServerImplementation a = new ServerImplementation();        
        Index window = new Index();        
        window.setVisible(true);        
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiServer;

import java.rmi.RemoteException;
import viewServer.Index;

/**
 *
 * @author Gustavo Salvo Lara
 */
public class MainGustavo {
    
    
    public static void main(String[] args) throws RemoteException, Exception {
        Index window = new Index();        
        window.setVisible(true);        
    }
}

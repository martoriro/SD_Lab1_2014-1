/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiServer;

import java.rmi.RemoteException;
import viewServer.Index;
import viewServer.Index2;

/**
 *
 * @author Gustavo Salvo Lara
 */
public class MainGustavo {
    
    
    public static void main(String[] args) throws RemoteException, Exception {
        
        Index2 window = new Index2();
        window.setVisible(true);
        System.out.println("no sale :(");
        
    }
}

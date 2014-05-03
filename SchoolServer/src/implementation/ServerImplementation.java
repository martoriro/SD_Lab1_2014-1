/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import entityClass.Anotacion;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import sessionBeans.*;

/**
 *
 * @author Gustavo Salvo Lara
 */
public class ServerImplementation extends UnicastRemoteObject implements interfaceServer.InterfaceS {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("SchoolServerPU");
    UsuarioJpaController userFunction = new UsuarioJpaController(factory);
    
    public ServerImplementation() throws RemoteException{
        
    }

    @Override
    public String userLogin(String user, String pass) throws RemoteException {
        String resp = null;
        try {
            resp = userFunction.login(user, pass);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ServerImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }


}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiServer;

import dataBaseFunctions.DataBase;
import implementation.ServerFunctions;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.sql.ResultSet;

/**
 *
 * @author Gustavo Salvo Lara
 */
public class Main {
    static private RmiConnection connection = new RmiConnection();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        DataBase sql = new DataBase("botis_sd","botis_labsd","pelaorico","botis.cl");
        sql.startConnection();
        sql.run("INSERT INTO `USUARIO` (`usuario`, `password`) VALUES ('alfredoavalos', 'asdfasdf');");
        ResultSet res = sql.query("Select * from USUARIO");
        try{
        while (res.next())
{
   System.out.println("usuario="+res.getObject("usuario")+", pass="+res.getObject("password"));
}
res.close();
        }catch(Exception e){
            System.out.println(":(");
        }
        sql.disconnect();
        
        Registry registry;
        registry = connection.getRegistry();
        ServerFunctions sf = new ServerFunctions();
        registry.rebind("IMP", sf);
        System.out.println("conectado...");
        //connection.stop();
        // TODO code application logic here
    }
}

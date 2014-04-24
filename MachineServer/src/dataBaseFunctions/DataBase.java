/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBaseFunctions;

import java.sql.*;

/**
 *
 * @author Gustavo Salvo Lara
 */
public class DataBase {
    private static Connection connection;
    private static String bd;
    private static String user;
    private static String pass;
    private static String host;
    private static String server;

    
    
    public DataBase(String bdP, String userP, String passP, String hostP) {
        setBd(bdP);
        setUser(userP);
        setPass(passP);
        setHost(hostP);
        setServer("jdbc:mysql://"+getHost()+"/"+getBd());
                       
    }
    public boolean run(String sql){
        try{
            Statement sentence = getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentence.executeUpdate(sql);
            sentence.close();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public ResultSet query(String sql) {
        ResultSet result;
        try {
            Statement sentence = getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            result = sentence.executeQuery(sql);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }        
    }
    
    
    public boolean startConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(server,user,pass);
            System.out.println("conexión a base de datos "+server+" ... OK");
            return true;
        }catch(ClassNotFoundException ex){
            System.out.println("Error cargando el Driver MySQL JDBC ... FAIL");
            return false;
        }catch(SQLException ex){
             System.out.println("Imposible realizar conexion con "+server+" ... FAIL");
            return false;
        }
    }
    
    public boolean disconnect(){
        try{
            connection.close();
            System.out.println("Cerrar conexión "+server+" ...OK" );
            return true;
        }catch(SQLException ex){
            System.out.println("Imposible cerrar la conexión ...FAIL");
            return false;
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        DataBase.connection = connection;
    }

    public static String getBd() {
        return bd;
    }

    public static void setBd(String bd) {
        DataBase.bd = bd;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        DataBase.user = user;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        DataBase.pass = pass;
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        DataBase.host = host;
    }

    public static String getServer() {
        return server;
    }

    public static void setServer(String server) {
        DataBase.server = server;
    }
    
   
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaceServer;

import java.rmi.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

public interface ChatInterface extends Remote{
    public String getName() throws RemoteException;
    public void send(String msg, JTextArea area) throws RemoteException;
    public void addClient(ChatInterface cliente)throws RemoteException;
    public List<ChatInterface> getClients() throws RemoteException;
    public void broadcast(String msg, JTextArea area, List<ChatInterface> clients) throws RemoteException;
    public void setChatArea(JTextArea area) throws RemoteException;
}

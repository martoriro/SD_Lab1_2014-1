/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chat;

import interfaceServer.ChatInterface;
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

public class Chat extends UnicastRemoteObject implements ChatInterface {
    public String name;
    public List<ChatInterface> clients = new ArrayList();
    public JTextArea area;
     
    public Chat(String n) throws RemoteException {
        this.name=n;
    }
    public String getName() throws RemoteException {
        return this.name;
    }
     
    public void addClient(ChatInterface c){
        clients.add(c);
    }
    
    public List<ChatInterface> getClients(){
        return clients;
    }
     
    public void send(String s,JTextArea area) throws RemoteException{
        this.area.append(s);
    }
    
    @Override
    public void broadcast(String msg, JTextArea area, List<ChatInterface> clients) throws RemoteException{
        for(ChatInterface client: clients){
            client.send(msg, area);
        }
    }
    
    public void setChatArea(JTextArea area){
        this.area = area;
    }
}
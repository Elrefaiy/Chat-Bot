/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import ui.ChatScreenController;

public class User extends Agent{
    static User user;
    ChatScreenController chatscreen;
    ACLMessage acl = new ACLMessage();
    @Override
    protected void setup(){
        user = this;
        System.out.println("User agent created");
        acl.addReceiver(new AID("Bot", false));               
        addBehaviour(new CyclicBehaviour(){
            @Override
            public void action() {
                ACLMessage aa = receive();
            }
        });
    }
    
    public static User getUser(){
        return user;
    }
    
    public void setChatScreen(ChatScreenController c){
        this.chatscreen = c;
    }
    
    public void userSend(String messege){
        acl.setContent(messege);
        acl.setPerformative(ACLMessage.INFORM);
        send(acl);        
    }
}

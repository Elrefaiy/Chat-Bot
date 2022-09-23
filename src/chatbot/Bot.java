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
import jade.wrapper.StaleProxyException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.Callback;
import ui.ChatScreenController;


public class Bot extends Agent {
    private static final String BotName = "Chatter Bot";
    private static final String BotInfo = "Chatter Bot and I was created in 2021\nfor entertainment,I simulate your favourite person who you\ntalk with so don't be embarrassed to talk with me any time";
    static Bot bot;
    ChatScreenController chatscreen;
    ACLMessage acl = new ACLMessage();
    ReplyGenerator reply;
    @Override
    protected void setup(){
        bot = this;
        System.out.println("Bot agent created");
        reply = new ReplyGenerator();
        acl.addReceiver(new AID("User", false));    
        addBehaviour(new CyclicBehaviour(){
            @Override
            public void action() {
                ACLMessage aa = receive();
                if (aa != null)
                {
                    String s = aa.getContent();
                    try {
                        String Rep = reply.Reply(s);
                        botSend(Rep);
                        for (int i = 0;i < ReplyGenerator.byeAnswerList.length;i ++)
                        {
                            if (Rep == ReplyGenerator.byeAnswerList[i]){
                                try {
                                    Thread.sleep(1000);
                                    ChatBot.killAllAgents();
                                    System.exit(0);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (StaleProxyException ex) {
                                    Logger.getLogger(Bot.class.getName()).log(Level.SEVERE, null, ex);
                                }                            
                            }
                        }
                     } catch (InterruptedException ex) {
                        Logger.getLogger(Bot.class.getName()).log(Level.SEVERE, null, ex);
                    }                       
                }
            }
        });       
    }
    
    public static String getBotName(){
        return BotName;
    }
    
    public static String getBotInfo(){
        return BotInfo;
    }
    
    public static Bot getBot(){
        return bot;
    }
    
    public void setChatScreen(ChatScreenController c){
        this.chatscreen = c;
    }
    
    public void botSend(String messege){
        acl.setContent(messege);
        acl.setPerformative(ACLMessage.INFORM);
        send(acl);
        this.chatscreen.botSent(messege);
    }    
}

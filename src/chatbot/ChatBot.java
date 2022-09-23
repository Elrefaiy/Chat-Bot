/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ui.Callback;

public class ChatBot extends Application{

    public FXMLLoader loader;
    public Callback callback;
    static AgentController rma;
    static AgentController BotAgent;
    static AgentController UserAgent;
    
    @Override
    
    public void start(Stage stage) throws Exception {
        loader = new FXMLLoader(getClass().getResource("/ui/ChatScreen.fxml"));
        Parent root = loader.load();
        callback = loader.getController();
        //botCtrl = loader.getController();
        callback.setUser(User.user);
        callback.setBot(Bot.bot);
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Chat Bot");
        stage.setResizable(false);
        stage.getIcons().add(new Image("/ui/BotIcon.png"));
        stage.setOnCloseRequest(e -> {
            try {
                killAllAgents();
                System.exit(0);
            } catch (StaleProxyException ex) {
                Logger.getLogger(ChatBot.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public static void main(String[] args) throws StaleProxyException {
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        Profile profile = new ProfileImpl("localhost", 2000, "ChatPlatform");
        ContainerController main1 = runtime.createMainContainer(profile);
        try {
            
            rma = main1.createNewAgent("jade", "jade.tools.rma.rma", null);
            rma.start();

            BotAgent = main1.createNewAgent("Bot", "chatbot.Bot", null);
            BotAgent.start(); 
            
            UserAgent = main1.createNewAgent("User", "chatbot.User", null);
            UserAgent.start();           
            
        } catch (StaleProxyException staleProxyException) {
            
        }
        launch(args);
    }
    
    public static void killAllAgents() throws StaleProxyException{
        rma.kill();
        BotAgent.kill();
        UserAgent.kill();        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import chatbot.Bot;
import chatbot.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class ChatScreenController implements Initializable,Callback {

    private User user;
    private Bot bot;
    
    @FXML
    private AnchorPane MainPane;
    @FXML
    private TextField UserTxt;
    @FXML
    private TextArea ChatTxt;
    @FXML
    private Button SendBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SendBtn.disableProperty().bind(UserTxt.textProperty().isEmpty());
        UserTxt.setOnKeyPressed((EventHandler<KeyEvent>) e ->{
            if (e.getCode().equals(KeyCode.ENTER)){
                MessegeSend();
            }
        });
    }    

    @FXML
    private void UserSend(ActionEvent event) {
        MessegeSend();
    }

    @Override
    public void setUser(User u) {
        user = u;
        user.setChatScreen(this);
    }

    @Override
    public void setBot(Bot b) {
        bot = b;
        bot.setChatScreen(this);
    }
    
    private void MessegeSend(){
        if (!UserTxt.getText().isEmpty()){
            ChatTxt.setText(ChatTxt.getText()+"User: "+UserTxt.getText()+"\n");
            user.userSend(UserTxt.getText());
            UserTxt.setText("");
            UserTxt.setDisable(true);
        }
    }
    
    public void botSent(String messege){
        ChatTxt.setText(ChatTxt.getText()+"Bot: "+messege+"\n");
        UserTxt.setDisable(false);
    }
    
}

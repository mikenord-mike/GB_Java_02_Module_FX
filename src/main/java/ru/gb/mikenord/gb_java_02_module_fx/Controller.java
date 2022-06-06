package ru.gb.mikenord.gb_java_02_module_fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Controller {
    private final String COUNT_MSG = "Messages sent:  %d";
    private final String USER_NAME_MSG = "User:  %s";
    @FXML
    private Label userNameLabel;
    @FXML
    private Label msgCountLabel;
    @FXML
    private TextArea chatWindow;
    @FXML
    private TextField chatMsgField;

    private NetChat netChat;

    public void clickSendButton(ActionEvent actionEvent) {
        String msg = chatMsgField.getText();
        if (msg.isBlank()) {
            return;
        }
        if (!msgCountLabel.isVisible()) {
            netChat = new NetChat(NetChatApplication.getInputName());
            msgCountLabel.setVisible(true);
            userNameLabel.setText(String.format(USER_NAME_MSG, netChat.getUserName()));
            userNameLabel.setVisible(true);
        }
        LocalDateTime timeStamp = LocalDateTime.now();
        msg = timeStamp.format(DateTimeFormatter.ofPattern("dd.MM.yy HH:mm:ss")) + ":  " + msg + "\n";

        netChat.addMessage(timeStamp, msg);

        msgCountLabel.setText(String.format(COUNT_MSG, netChat.getMessagesCount()));
        chatWindow.appendText(msg);
        chatMsgField.clear();
        chatMsgField.requestFocus();
    }
}
package ru.gb.mikenord.gb_java_02_module_fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class NetChatApplication extends Application {
    private static String userName;

    public static String getInputName() {
        return userName;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(NetChatApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("NetChat");
        stage.setScene(scene);
        stage.setMinWidth(320);
        stage.setMinHeight(240);
        stage.show();

        TextInputDialog userNameDialog = new TextInputDialog("username");
        userNameDialog.setTitle("Username setup");
        userNameDialog.setHeaderText("Username setup");
        userNameDialog.setContentText("Enter username");
        Optional<String> result = userNameDialog.showAndWait();
        userName = result.orElse("noname");
    }

    public static void main(String[] args) {
        launch();
    }
}
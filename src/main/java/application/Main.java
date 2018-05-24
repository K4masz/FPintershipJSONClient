package application;

import application.controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("/mainWindow.fxml"));
        primaryStage.setTitle("Rest Client");
        primaryStage.setScene(new Scene(root, 700, 800));
        primaryStage.setResizable(false);
        primaryStage.setOnShowing(event -> MainController.getInstance().init());
        primaryStage.show();
    }
}

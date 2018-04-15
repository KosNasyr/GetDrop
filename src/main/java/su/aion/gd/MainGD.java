package su.aion.gd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


public class MainGD extends Application {
    Parent root;
    Stage stage;

    @Override
    public void start(Stage primaryStage) throws IOException {

        URL resource = getClass().getClassLoader().getResource("Pane.fxml");
        if (resource == null)
            throw new RuntimeException("Unable to load Pane.fxml");

        root = FXMLLoader.load(resource);
        stage = primaryStage;

        primaryStage.setTitle("Aion: Drop Informer");
        primaryStage.setScene(new Scene(root));
        primaryStage.setHeight(600);
        primaryStage.setWidth(500);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

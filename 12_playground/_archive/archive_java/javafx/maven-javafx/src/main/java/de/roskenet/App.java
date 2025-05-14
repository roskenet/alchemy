package de.roskenet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        var props = AppProperties.readProperties("config.properties");
        var title = props.getProperty("application.title");

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/main.fxml"));
        primaryStage.setTitle(title);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

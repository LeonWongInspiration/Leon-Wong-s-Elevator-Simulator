import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class View extends Application {

    private Stage primaryStage;
    private BorderPane layout;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Elevator Simulator");

        this.initLayout();
    }

    public void initLayout(){
        try {
            // Load layout from FXML file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Application.class.getResource("View.fxml"));
            this.layout = loader.load();

            // Show the scene
            Scene scene = new Scene(this.layout);
            this.primaryStage.setScene(scene);
            this.primaryStage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

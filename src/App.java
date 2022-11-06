import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String [] args){
        launch(args);
    }

    public void start(Stage stage){
        GamePane pane = new GamePane();
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}
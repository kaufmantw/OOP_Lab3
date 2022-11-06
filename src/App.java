import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String [] args){
        launch(args);
    }

    public void start(Stage stage){
        BorderPane bpane = new BorderPane();
        GamePane pane = new GamePane();

        bpane.setCenter(pane);

        Scene scene = new Scene(bpane, 500, 500);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
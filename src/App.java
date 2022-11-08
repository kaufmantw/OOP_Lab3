import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String [] args){
        launch(args);
    }

    public void start(Stage stage){
        GamePane gpane = new GamePane();

        TimePane tpane = new TimePane();
        //tpane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(gpane, 400, 400);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
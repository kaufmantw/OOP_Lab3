import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class ButtonHandlerClass implements EventHandler<ActionEvent>{
    String emoji;
    Button btn;
    public ButtonHandlerClass(String text, Button button){
        this.emoji = text;
        this.btn = button;
    }
    @Override
    public void handle(ActionEvent e){
        System.out.println("This button was pressed: " + this.emoji);
        btn.setVisible(false);
    }
}
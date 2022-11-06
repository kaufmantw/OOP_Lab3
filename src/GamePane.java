import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class GamePane extends GridPane{
    
    Button[][] buttons;
    ArrayList<String> emojis;
    String[][] picture;

    int rows = 4, cols = 4;

    public GamePane(){
        buttons = new Button[rows][cols];
        picture = new String[rows][cols];
        emojis = new ArrayList<>();
        fillList();
        makeButtons();
    }

    public void makeButtons(){
        
        for(int i = 0;i<rows;i++){
            for (int j = 0; j<cols; j++){
                int index = ((int)(Math.random() * emojis.size()));
                String temp = emojis.get(index);
                emojis.remove(index);

                //picture[i][j] = temp;
                
                Button button = new Button(temp);
                ButtonHandlerClass handle = new ButtonHandlerClass();

                buttons[i][j] = button;
                this.add(button, i, j);
                //System.out.print(temp + " ");
            }
        }
    }

    public void fillList(){
        //16 emojis
        emojis.add("💥");
        emojis.add("💥");
        emojis.add("🙉");
        emojis.add("🙉");
        emojis.add("🐱");
        emojis.add("🐱");
        emojis.add("🐎");
        emojis.add("🐎");
        emojis.add("🐐");
        emojis.add("🐐");
        emojis.add("🦇");
        emojis.add("🦇");
        emojis.add("🐧");
        emojis.add("🐧");
        emojis.add("🐸");
        emojis.add("🐸");
    }
}
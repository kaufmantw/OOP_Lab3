import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

//TODO: change opacity -> setting to deactive.

public class GamePane extends BorderPane{
    
    ArrayList<String> emojis;
    ArrayList<Button> list;

    int rows = 4, cols = 4;

    IntegerProperty counter;
    
    Button first;
    Button second;

    public GamePane(){
        this.list = new ArrayList<>();
        this.counter = new SimpleIntegerProperty(0);
        this.first = null;
        this.second = null;

        emojis = new ArrayList<>();

        GridPane gpane = new GridPane();
        fillList();
        makeButtons(gpane);
        gpane.setAlignment(Pos.CENTER);
        this.setCenter(gpane);

        HBox hbox = new HBox();
        createTimer(hbox);
        hbox.setAlignment(Pos.CENTER);
        this.setBottom(hbox);
    }

    public void makeButtons(GridPane gpane){
        
        for(int i = 0;i<rows;i++){
            for (int j = 0; j<cols; j++){
                int index = ((int)(Math.random() * emojis.size()));
                String temp = emojis.get(index);
                emojis.remove(index);
                
                Button button = new Button(temp);
                list.add(button);
                button.setPrefSize(50,50);
                //use this set on action to do deactive logic.
                button.setOnAction(e ->{
                    if (this.first == null){
                        this.first = button;
                        this.first.setOpacity(.50);
                    }
                    else{
                        this.second = button;
                        if (this.first.getText().equalsIgnoreCase(this.second.getText()) && this.first != this.second){
                            this.first.setOpacity(.50);
                            this.second.setOpacity(.50);
                            list.remove(this.first);
                            list.remove(this.second);
                        }
                        
                        else{
                            this.first.setOpacity(1.0);
                        }
                        
                        this.first = null;
                        this.second = null;
                    }
                });

                gpane.add(button, i, j);
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

    public void createTimer(HBox hbox){
        Label lbl = new Label("Time Elapsed: 0");
        hbox.getChildren().add(lbl);
    
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), ov ->{
            counter.set(counter.get()+1);

        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        counter.addListener(ov ->{
            if(list.size() ==  0){
                animation.stop();
            }
            else{
                lbl.setText("Time Elapsed: " + counter.get());
            }
        });

    }
}
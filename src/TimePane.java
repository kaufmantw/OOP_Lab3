import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class TimePane extends Pane{
    IntegerProperty counter;

    public TimePane(){
        this.counter = new SimpleIntegerProperty(0);

        Label lbl = new Label("Time Elapsed: 0");
        this.getChildren().add(lbl);
    
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), ov ->{
            counter.set(counter.get()+1);

        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        counter.addListener(ov ->{
            lbl.setText("Time Elapsed: " + counter.get());
        });


        //animation.setCycleCount(0);
    }

    public IntegerProperty counterProperty(){
        return this.counter;
    }
}
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class alertBox {
    static boolean answer;
    public static boolean display(){
            Stage stage = new Stage();
            
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("log out");
            stage.setMinWidth(250);
            stage.setMinHeight(150);

            Label label = new Label("Are you sure you want to log out ?");
            Button yes = new Button("Yes");
            Button no = new Button("No");
            HBox hBox = new HBox(25,no, yes);
            hBox.setAlignment(Pos.CENTER);
            VBox box = new VBox(30,label,hBox);
            box.setAlignment(Pos.CENTER);
            Scene scene = new Scene(box);
            stage.setScene(scene);
            stage.show();

            yes.setOnAction(e->{
                answer=true;
                stage.close();
                
                
            });
            no.setOnAction(e->{
                answer=false;
                stage.close();
            });
            return answer;
            
            
    }
}

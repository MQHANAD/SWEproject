import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class confirmationMessage {
    
    public static void display(String message){
            Stage stage = new Stage();
            
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Confirmation Message");
            stage.setMinWidth(300);
            stage.setMinHeight(150);

            Label label = new Label(message);
            VBox box = new VBox(30,label);
            box.setAlignment(Pos.CENTER);
            Scene scene = new Scene(box);
            scene.getStylesheets().add("style.css");
            stage.setScene(scene);
            stage.getIcons().add(new Image("file:icon.png"));
            
            stage.show();
            box.requestFocus();
            
            
            
            
            
    }

}

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class alertBox {
    
    public static void display(Scene scene1,Stage stage2){
            Stage stage = new Stage();
            
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("log out");
            stage.setMinWidth(300);
            stage.setMinHeight(150);

            Label label = new Label("Are you sure you want to log out ?");
            Button yes = new Button("Yes");
            Button no = new Button("No");
            yes.setMinWidth(60);
            no.setMinWidth(60);
            HBox hBox = new HBox(25,no, yes);
            hBox.setAlignment(Pos.CENTER);
            VBox box = new VBox(30,label,hBox);
            box.setAlignment(Pos.CENTER);
            Scene scene = new Scene(box);
            scene.getStylesheets().add("style.css");
            stage.setScene(scene);
            stage.getIcons().add(new Image("file:icon.png"));
            
            stage.show();
            box.requestFocus();
            yes.setOnAction(e->{
                double width =stage2.getWidth();
                double heigt = stage2.getHeight();
                stage2.setHeight(heigt);
                stage2.setWidth(width);
                stage2.setScene(scene1);
                stage.close();
                
                
            });
            no.setOnAction(e->{
                stage.close();
            });
            
            
    }

}

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class guestPage {
    public static void guestLogedin(Stage stage,Scene scane1){
        Image image = new Image("file:Screenshot 2023-04-08 at 11.56.03 PM.png");
        ImageView imageView = new ImageView(image);
        // autosizing the image with the stage
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());

        
        Button viewTournament = new Button("View tournaments");
        Button backButton = new Button("Back");

        

        
        
        
        viewTournament.setMaxSize(600 ,60);
        viewTournament.setMinSize(400,25);
        backButton.setMaxSize(600 ,60);
        backButton.setMinSize(400,25);
        

        


        VBox box = new VBox(20,viewTournament,backButton);
        box.setAlignment(Pos.CENTER);
        box.prefHeightProperty().bind(stage.heightProperty());
        box.prefWidthProperty().bind(stage.widthProperty());
        

        Group root = new Group(imageView,box);
        Scene scene = new Scene(root);
        stage.setScene(scene); 
        root.requestFocus();
        
        
        viewTournament.setOnAction(e->{
            // call the method
        });
       
        
        backButton.setOnAction(e->{
            double width =stage.getWidth();
            Double heigt = stage.getHeight();
            stage.setScene(scane1);
            stage.setHeight(heigt);
            stage.setWidth(width);
            
        });
    }    
}

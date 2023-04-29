import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class studentPage {
    public static void studentLogedin(Stage stage,Scene scane1){
        Image image = new Image("file:Screenshot 2023-04-08 at 11.56.03 PM.png");
        ImageView imageView = new ImageView(image);
        // autosizing the image with the stage
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());

        Button registerToTournament = new Button("Register to a tournament");
        Button registerToTeam = new Button("register to a team");
        Button viewTournament = new Button("View tournaments");
        Button logout = new Button("Logout");

        

        
        
        registerToTournament.setMaxSize(600 ,60);
        registerToTournament.setMinSize(400,25);
        registerToTeam.setMaxSize(600 ,60);
        registerToTeam.setMinSize(400,25);
        viewTournament.setMaxSize(600 ,60);
        viewTournament.setMinSize(400,25);
        logout.setMaxSize(600 ,60);
        logout.setMinSize(400,25);
        

        


        VBox box = new VBox(20,viewTournament,registerToTournament,registerToTeam,logout);
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
        registerToTournament.setOnAction(e->{
            // call the method
        });
        registerToTeam.setOnAction(e->{
            // call the method
        });
        
        logout.setOnAction(e->{
            // show a confirmation window
            double width =stage.getWidth();
            Double heigt = stage.getHeight();
            stage.setScene(scane1);
            stage.setHeight(heigt);
            stage.setWidth(width);
            
        });
    }    
}


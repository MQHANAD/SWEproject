import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class adminsPage {
    public static void adminLogedin(Stage stage,Scene scane1){
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);
        // autosizing the image with the stage
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());

        Button creatTournament = new Button("Creat a tournament");
        Button creatTeams = new Button("Creat a team");
        Button archivedTournaments = new Button("Archived tournaments");
        Button viewTournament = new Button("View tournaments");
        Button logout = new Button("Logout");

        

        
        
        creatTeams.setMaxSize(600 ,60);
        creatTeams.setMinSize(400,25);
        creatTournament.setMaxSize(600 ,60);
        creatTournament.setMinSize(400,25);
        archivedTournaments.setMaxSize(600 ,60);
        archivedTournaments.setMinSize(400,25);
        viewTournament.setMaxSize(600 ,60);
        viewTournament.setMinSize(400,25);
        logout.setMaxSize(600 ,60);
        logout.setMinSize(400,25);
        

        


        VBox box = new VBox(20,viewTournament,creatTournament,creatTeams,archivedTournaments,logout);
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
        creatTournament.setOnAction(e->{
            // creatTournamentClicked()
        });
        creatTeams.setOnAction(e->{
            // call the method
        });
        archivedTournaments.setOnAction(e->{
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


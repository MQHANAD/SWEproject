import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class adminsPage {
    static boolean confirmed =false;
    public static void adminLogedin(Stage stage,Scene scane1){
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);
        // autosizing the image with the stage
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());

        Button creatTournament = new Button("Create a tournament");
        Button creatTeams = new Button("Creat a team");
        Button archivedTournaments = new Button("Archived tournaments");
        Button viewTournament = new Button("View tournaments");
        Button logout = new Button("Logout");

        creatTournament.setOnMouseEntered(e ->{
            creatTournament.setId("buttonOnTouch");    
        });
        creatTournament.setOnMouseExited(e->{
            creatTournament.setId("buttonOut");    
        });
        
        creatTeams.setOnMouseEntered(e ->{
            creatTeams.setId("buttonOnTouch");    
        });
        creatTeams.setOnMouseExited(e->{
            creatTeams.setId("buttonOut");    
        });

        archivedTournaments.setOnMouseEntered(e ->{
            archivedTournaments.setId("buttonOnTouch");    
        });
        archivedTournaments.setOnMouseExited(e->{
            archivedTournaments.setId("buttonOut");    
        });

        viewTournament.setOnMouseEntered(e ->{
            viewTournament.setId("buttonOnTouch");    
        });
        viewTournament.setOnMouseExited(e->{
            viewTournament.setId("buttonOut");    
        });

        logout.setOnMouseEntered(e ->{
            logout.setId("buttonOnTouch");    
        });
        logout.setOnMouseExited(e->{
            logout.setId("buttonOut");    
        });
        

        
        
        creatTeams.setMaxSize(300 ,60);
        creatTeams.setMinSize(200,25);
        creatTournament.setMaxSize(300 ,60);
        creatTournament.setMinSize(200,25);
        archivedTournaments.setMaxSize(300 ,60);
        archivedTournaments.setMinSize(200,25);
        viewTournament.setMaxSize(300 ,60);
        viewTournament.setMinSize(200,25);
        logout.setMaxSize(300 ,60);
        logout.setMinSize(200,25);
        

        


        VBox box = new VBox(20,viewTournament,creatTournament,creatTeams,archivedTournaments,logout);
        box.setAlignment(Pos.CENTER);
        box.prefHeightProperty().bind(stage.heightProperty());
        box.prefWidthProperty().bind(stage.widthProperty());
        box.getStyleClass().add("shade");
        
        Group root = new Group(imageView,box);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene); 
        root.requestFocus();
        
        
        viewTournament.setOnAction(e->{
            // call the method
            // here where the admin can add students/teams to tournaments
            // remove students/teams from the tournaments
            // view mathes 
        });
        creatTournament.setOnAction(e->{
            createTournamentPage.tournamentPageCalled(stage, scene);
        });
        creatTeams.setOnAction(e->{
            creatTeamPage.creatTeamPageCalled(stage, scene);
        });
        archivedTournaments.setOnAction(e->{
            // call the method
        });
        logout.setOnAction(e->{
            // show a confirmation window
            alertBox.display(scane1,stage);
        });
        
        
        
        
        
        
        
    }    
}


import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class studentPage {
    public static void studentLogedin(Stage stage,Scene scane1, TableView<tournament> table, TableView<teams> table1,student student1){
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);
        // autosizing the image with the stage
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());

        
        Button viewTeams = new Button("View teams");
        Button viewTournament = new Button("View tournaments");
        Button logout = new Button("Logout");

        
        viewTeams.setOnMouseEntered(e ->{
            viewTeams.setId("buttonOnTouch");    
        });
        viewTeams.setOnMouseExited(e->{
            viewTeams.setId("buttonOut");    
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
        
        
        
        viewTeams.setMaxSize(300 ,60);
        viewTeams.setMinSize(200,25);
        viewTournament.setMaxSize(300 ,60);
        viewTournament.setMinSize(200,25);
        logout.setMaxSize(300 ,60);
        logout.setMinSize(200,25);
        

        


        VBox box = new VBox(20,viewTournament,viewTeams,logout);
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
            viewTournamentPage.viewTRstudentPageCalled(stage, scene, table,student1);
        });
        
        viewTeams.setOnAction(e->{
            viewTeamsPage.viewTeamsPageCalled(stage, scene, table1,student1);
            // here where the student can register to a team
        });
        
        logout.setOnAction(e->{
            // show a confirmation window
            alertBox.display(scane1,stage);
        });
    }    
}


import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class adminsPage {
    static boolean confirmed =false;
    public static void adminLogedin(Stage stage,Scene scane1,ObservableList<tournament> tournaments,TableView <tournament> table, ObservableList<teams> teamList, TableView<teams> table1){
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);
        // autosizing the image with the stage
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());

        Button creatTournament = new Button("Create a tournament");
        Button creatTeams = new Button("Create a team");
        Button archivedTournaments = new Button("Archived tournaments");
        Button viewTournament = new Button("View tournaments");
        Button logout = new Button("Logout");
        Button addnewSport = new Button("Add New Sport");

        creatTournament.setOnMouseEntered(e ->{
            creatTournament.setId("buttonOnTouch");    
        });
        creatTournament.setOnMouseExited(e->{
            creatTournament.setId("buttonOut");    
        });
        addnewSport.setOnMouseEntered(e ->{
            addnewSport.setId("buttonOnTouch");    
        });
        addnewSport.setOnMouseExited(e->{
            addnewSport.setId("buttonOut");    
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
        addnewSport.setMaxSize(300 ,60);
        addnewSport.setMinSize(200,25);
        

        


        VBox box = new VBox(20,viewTournament,creatTournament,creatTeams,archivedTournaments,addnewSport,logout);
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
            viewTournamentPage.viewtournamentPageCalled(stage, scene,table,tournaments);
        });
        creatTournament.setOnAction(e->{
            createTournamentPage.tournamentPageCalled(stage, scene,tournaments,x);
        });
        creatTeams.setOnAction(e->{
            creatTeamPage.creatTeamPageCalled(stage, scene,teamList);
        });
        archivedTournaments.setOnAction(e->{
            // call the method
        });
        logout.setOnAction(e->{
            // show a confirmation window
            alertBox.display(scane1,stage);
        });
        addnewSport.setOnAction(e ->{
            addSportPageCalled(stage, scene);
        } );        
        
        
        
        
        
        
    } 
    static String x=""; 
    public static void addSportPageCalled(Stage stage , Scene scane1){
        
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);
        // autosizing the image with the stage
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());

        
        Button logout = new Button("Back");
        Button addnewSport = new Button("Add New Sport");
        TextField text = new TextField();
        text.setPromptText("Type a Sport");
        
        addnewSport.setOnMouseEntered(e ->{
            addnewSport.setId("buttonOnTouch");    
        });
        addnewSport.setOnMouseExited(e->{
            addnewSport.setId("buttonOut");    
        });
        
       

        

        logout.setOnMouseEntered(e ->{
            logout.setId("buttonOnTouch");    
        });
        logout.setOnMouseExited(e->{
            logout.setId("buttonOut");    
        });
        

        
        
       
        logout.setMaxSize(150 ,60);
        logout.setMinSize(100,25);
        addnewSport.setMaxSize(150 ,60);
        addnewSport.setMinSize(100,25);
        text.setMaxSize(300 ,60);
        text.setMinSize(200,25);

        logout.setAlignment(Pos.CENTER);
        addnewSport.setAlignment(Pos.CENTER);
        text.setAlignment(Pos.CENTER);
        text.getStyleClass().add("normal-color");
        

        


        HBox box2 = new HBox(20,logout,addnewSport);
        box2.setAlignment(Pos.CENTER);
        VBox box = new VBox(20, text,box2);
        box.setAlignment(Pos.CENTER);
        box.prefHeightProperty().bind(stage.heightProperty());
        box.prefWidthProperty().bind(stage.widthProperty());
        box.getStyleClass().add("shade");
        
        Group root = new Group(imageView,box);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene); 
        root.requestFocus();

        logout.setOnAction(e->{
            double width =stage.getWidth();
            Double heigt = stage.getHeight();
            stage.setScene(scane1);
            stage.setHeight(heigt);
            stage.setWidth(width);
        });
        addnewSport.setOnAction(e->{
            x=text.getText();
        });
    }
      
}



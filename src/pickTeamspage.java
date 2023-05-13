import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class pickTeamspage {

    public static  void viewTeams(Stage stage,Scene scane1,Scene scane12, ObservableList<tournament> tournaments ,String name, String type, String sport, Integer numOfPar, Integer numOfdayBetStages, Date date){
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);
        // autosizing the image with the stage
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());
        ObservableList <teams> teamList =  teams.loadTeams();
        Label ctrl = new Label("Hold CTRL When Selecting Multiple Teams!!");
        ctrl.setId("bold");
        ctrl.setFont(new Font(20));
        ListView<teams> teamsListView = new ListView<>();
        teamsListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        for (int i =0; i<teamList.size() ;i++ ){
            teamsListView.getItems().add((teams) teamList.get(i));
        }
        
        
    
        Button backButton = new Button("Back");
        Button delete= new Button("Delete team");
        
        Button selectTeamMembers = new Button("Create");

        backButton.setOnMouseEntered(e ->{
            backButton.setId("buttonOnTouch");    
        });
        backButton.setOnMouseExited(e->{
            backButton.setId("buttonOut");    
        });

        delete.setOnMouseEntered(e ->{
            delete.setId("buttonOnTouch");    
        });
        delete.setOnMouseExited(e->{
            delete.setId("buttonOut");    
        });

        

        selectTeamMembers.setOnMouseEntered(e ->{
            selectTeamMembers.setId("buttonOnTouch");    
        });
        selectTeamMembers.setOnMouseExited(e->{
            selectTeamMembers.setId("buttonOut");    
        });

    
        
        
        backButton.setMaxSize(150 ,30);
        backButton.setMinSize(100,12.5);
        selectTeamMembers.setMaxSize(150 ,30);
        selectTeamMembers.setMinSize(100,12.5);
        delete.setMaxSize(150 ,30);
        delete.setMinSize(100,12.5);
        
        
        

        
        HBox butttonsBox = new HBox(20,backButton,delete,selectTeamMembers);
        
        
        selectTeamMembers.setAlignment(Pos.CENTER);
        butttonsBox.setAlignment(Pos.CENTER);


        VBox box = new VBox(10,teamsListView,butttonsBox,ctrl);
        box.setPadding(new Insets(0, 55, 0, 40));
        box.setAlignment(Pos.CENTER);
        box.prefHeightProperty().bind(stage.heightProperty());
        box.prefWidthProperty().bind(stage.widthProperty());
        box.getStyleClass().add("shade");

        Group root = new Group(imageView,box);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene); 
        root.requestFocus();

        selectTeamMembers.setOnAction(e->{
            if(type.equals("Elimination")){
                // create elimination tournament
                tournaments.add(new elimination(name,type,sport,numOfPar,numOfdayBetStages,new ArrayList<> (teamsListView.getSelectionModel().getSelectedItems()),date));
                tournament.saveTournaments(tournaments);
                
            }
            else if(type.equals("Round Robin")){
                //create Round Robin tournament
                tournaments.add(new roundRobin(name,type,sport,numOfPar,numOfdayBetStages,new ArrayList<> (teamsListView.getSelectionModel().getSelectedItems()),date));
                tournament.saveTournaments(tournaments);
            }
            double width =stage.getWidth();
            Double heigt = stage.getHeight();
            stage.setScene(scane12);
            stage.setHeight(heigt);
            stage.setWidth(width);
            confirmationMessage.display("Tournament Created!!");
            
                
        });
        backButton.setOnAction(e->{
            double width =stage.getWidth();
            Double heigt = stage.getHeight();
            stage.setScene(scane1);
            stage.setHeight(heigt);
            stage.setWidth(width);
        });
        
        delete.setOnAction(e->{
            //call the method to delete the tournament
            ObservableList<teams> teamSelected, allTeams;
            allTeams=teamsListView.getItems();
            teamSelected=teamsListView.getSelectionModel().getSelectedItems();
            teamSelected.forEach(allTeams::remove);
            teams.saveTeams(allTeams);
        });
        
    } 
}

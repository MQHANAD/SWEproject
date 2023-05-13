import java.time.LocalDate;
import java.util.ArrayList;
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
public class pickStudents {

    public static  void viewStudents(Stage stage,Scene scane1,Scene scane12, ObservableList<tournament> tournaments ,String name, String type, String sport, Integer numOfPar, Integer numOfdayBetStages,LocalDate date){
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);
        // autosizing the image with the stage
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());
        ArrayList<student> studentList = student.loadStudents();
        Label ctrl = new Label("Hold CTRL When Selecting Multiple Students!!");
        ctrl.setId("bold");
        ctrl.setFont(new Font(20));
        ListView<student> studentListView = new ListView<>();
        studentListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        for (int i =0; i<studentList.size() ;i++ ){
            studentListView.getItems().add((student) studentList.get(i));
        }
        
        
    
        Button backButton = new Button("Back");
        
        Button selectTeamMembers = new Button("Create");

        backButton.setOnMouseEntered(e ->{
            backButton.setId("buttonOnTouch");    
        });
        backButton.setOnMouseExited(e->{
            backButton.setId("buttonOut");    
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
        
        

        
        HBox butttonsBox = new HBox(20,backButton,selectTeamMembers);
        
        
        selectTeamMembers.setAlignment(Pos.CENTER);
        butttonsBox.setAlignment(Pos.CENTER);


        VBox box = new VBox(10,studentListView,butttonsBox,ctrl);
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
                tournaments.add(new elimination(name,type,numOfPar,sport,numOfdayBetStages,new ArrayList<> (studentListView.getSelectionModel().getSelectedItems())));
                tournament.saveTournaments(tournaments);
                
            }
            else if(type.equals("Round Robin")){
                //create Round Robin tournament
                tournaments.add(new roundRobin(name,type,numOfPar,sport,numOfdayBetStages,new ArrayList<> (studentListView.getSelectionModel().getSelectedItems())));
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
        
        
    } 
}


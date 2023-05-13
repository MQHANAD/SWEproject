import java.util.ArrayList;

import javax.security.auth.kerberos.KerberosKey;

import javafx.collections.ObservableList;
import javafx.css.Size;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class viewTeamsPage {
    public static void viewTeamsPageCalled(Stage stage,Scene scane1,TableView <teams> table,student st){
        ObservableList<teams> teamss=teams.loadTeams();
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);
        ArrayList <student> studentsList = student.loadStudents();
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());
        Button backButton = new Button("Back");
        Button viewTeamsDetails = new Button("View Details");
        Button register = new Button("Register");

        backButton.setOnMouseEntered(e ->{
            backButton.setId("buttonOnTouch");    
        });
        backButton.setOnMouseExited(e->{
            backButton.setId("buttonOut");    
        });

        viewTeamsDetails.setOnMouseEntered(e->{
            viewTeamsDetails.setId("buttonOnTouch");
        });
        viewTeamsDetails.setOnMouseExited(e->{
            viewTeamsDetails.setId("buttonOut");
        });
        register.setOnMouseEntered(e ->{
            register.setId("buttonOnTouch");    
        });
        register.setOnMouseExited(e->{
            register.setId("buttonOut");    
        });
        
       

        backButton.setOnAction(e->{
            double width =stage.getWidth();
            Double heigt = stage.getHeight();
            stage.setScene(scane1);
            stage.setHeight(heigt);
            stage.setWidth(width);
            
        });
        register.setOnAction(e->{
            teams selcted =table.getSelectionModel().getSelectedItem();
            Boolean conflict = false;
            

            
            for (int i=0; i<selcted.getStudents().size();i++){//to check if the user in the same team
                if(st.getUserName().equals(selcted.getStudents().get(i).getUserName())){
                    conflict=true;
                    break;
                }
            }
            ArrayList<teams> tr = st.getTeam();
            for (int j=0 ;j<selcted.getRegisterdTournament().size();j++){//this loop doesn't work selcted.getRegisterdTournament().size() is always zero
                System.out.println("hh");                                // if it works it would check conflict with other teams 
                for(int k =0 ;k<tr.size();k++){
                    for (int q =0 ; q<tr.get(k).getRegisterdTournament().size();q++){
                        if(tr.get(k).getRegisterdTournament().get(q).getId()==selcted.getRegisterdTournament().get(j).getId()){
                            conflict=true;
                        }
                    }
                }
            }
            if (!conflict){
                st.registerForTeam(selcted,studentsList);
                selcted.addPlayer(st,teamss);
                table.refresh();
                double width =stage.getWidth();
                Double heigt = stage.getHeight();
                stage.setScene(scane1);
                stage.setHeight(heigt);
                stage.setWidth(width);
                confirmationMessage.display("You have been registered\nto "+selcted.getName()+" Successfuly");
            }
            else {
                confirmationMessage.display("This Team Plays in a Tournament You are\nPlaying in, or You are already in this team");
            }

        });

        
        
        


        
        HBox buttonsBox = new HBox(20, backButton,viewTeamsDetails,register);

        buttonsBox.setAlignment(Pos.CENTER);

        backButton.setMaxSize(150 ,30);
        backButton.setMinSize(100,12.5);
        viewTeamsDetails.setMaxSize(150, 30);
        viewTeamsDetails.setMinSize(100, 12.5);
        
        

        VBox box =new VBox(20,table,buttonsBox);
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
        viewTeamsDetails.setOnAction(e->{
            //call the method
            ObservableList<teams> teamSelected;
            teamSelected=table.getSelectionModel().getSelectedItems();
            viewTeamsDetailspage.viewTeamsDetails(stage, scane1, teamSelected);
            
        });
    }
    public static void viewTeamsPageAdminCalled(Stage stage,Scene scane1,TableView <teams> table){
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);

        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());
        Button backButton = new Button("Back");
        Button viewTeamsDetails = new Button("View Details");

        backButton.setOnMouseEntered(e ->{
            backButton.setId("buttonOnTouch");    
        });
        backButton.setOnMouseExited(e->{
            backButton.setId("buttonOut");    
        });

        viewTeamsDetails.setOnMouseEntered(e->{
            viewTeamsDetails.setId("buttonOnTouch");
        });
        viewTeamsDetails.setOnMouseExited(e->{
            viewTeamsDetails.setId("buttonOut");
        });
        
       

        backButton.setOnAction(e->{
            double width =stage.getWidth();
            Double heigt = stage.getHeight();
            stage.setScene(scane1);
            stage.setHeight(heigt);
            stage.setWidth(width);
            
        });

        HBox butttonsBox = new HBox(20,backButton,viewTeamsDetails);
        butttonsBox.setAlignment(Pos.CENTER);

        backButton.setMaxSize(150 ,30);
        backButton.setMinSize(100,12.5);
        viewTeamsDetails.setMaxSize(150, 30);
        viewTeamsDetails.setMinSize(100, 12.5);
        
        

        VBox box =new VBox(20,table,butttonsBox);
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
        viewTeamsDetails.setOnAction(e->{
            //call the method
        });
    }
    
    
}

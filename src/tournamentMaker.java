import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class tournamentMaker extends Application { 
    
    private TableView<tournament>  table = new TableView<>();
    private TableView<teams>  table1 = new TableView<>();
    ObservableList<tournament> tournaments=tournament.loadTournaments();
    ObservableList<teams> teamList = teams.loadTeams();
    
    @Override
    public void start(Stage stage) {       
        // background image
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);
        // autosizing the image with the stage
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());
        // ------------------------------------------------------------------------------------

        // tournaments table
        
        
        // Name column
        TableColumn<tournament,String> nameCoulmn = new TableColumn<>("Name");
        nameCoulmn.setMinWidth(150);
        nameCoulmn.setCellValueFactory(new PropertyValueFactory("name"));

        // Type column
        TableColumn<tournament,String> typeCoulmn = new TableColumn<>("Type");
        typeCoulmn.setMinWidth(150);
        typeCoulmn.setCellValueFactory(new PropertyValueFactory("type"));

        // Sport column
        TableColumn<tournament,String> sportCoulmn = new TableColumn<>("Sport");
        sportCoulmn.setMinWidth(150);
        sportCoulmn.setCellValueFactory(new PropertyValueFactory("sport"));

        // NumOfParticibents column get
        TableColumn<tournament,Integer> numOfParticibentsCoulmn = new TableColumn<>("Requierd Number of Players In a Team");
        numOfParticibentsCoulmn.setMinWidth(300);
        numOfParticibentsCoulmn.setCellValueFactory(new PropertyValueFactory("numOfParticibents"));

        // NumOfteams column get
        TableColumn<tournament,Integer> numOfteamsCoulmn = new TableColumn<>("Number Of participants");
        numOfteamsCoulmn.setMinWidth(200);
        numOfteamsCoulmn.setCellValueFactory(new PropertyValueFactory("numOfteams"));

        // startTime column
        TableColumn<tournament, LocalDate> startTimeColumn = new TableColumn<>("Start time");
        startTimeColumn.setMinWidth(200);
        startTimeColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));

        table=new TableView<>();
        table.setItems(tournaments);
        table.getColumns().addAll(nameCoulmn, typeCoulmn, sportCoulmn, numOfParticibentsCoulmn,numOfteamsCoulmn,startTimeColumn);
        
        //teams table
        // Name column
        TableColumn<teams,String> namCoulmn = new TableColumn<>("Name");
        namCoulmn.setMinWidth(200);
        namCoulmn.setCellValueFactory(new PropertyValueFactory("name"));

        // NumOfParticibents column get
        TableColumn<teams,Integer> numOfPlayersCoulmn = new TableColumn<>("Number Of Player");
        numOfPlayersCoulmn.setMinWidth(200);
        numOfPlayersCoulmn.setCellValueFactory(new PropertyValueFactory("numOfPlayers"));

        table1=new TableView<>();
        table1.setItems(teamList);
        table1.getColumns().addAll(namCoulmn,numOfPlayersCoulmn );
        
        
        

        
        
        

        //=========================================================================================
        // menu's buttons
        Button admin = new Button("admin");
        Button student = new Button("student");
        Button guest = new Button("guest");

        // sizing the buttons
        admin.setMaxSize(300 ,60);
        admin.setMinSize(200,25);
        student.setMaxSize(300 ,60);
        student.setMinSize(200,25);
        guest.setMaxSize(300 ,60);
        guest.setMinSize(200,25);

        admin.setOnMouseEntered(e ->{
            admin.setId("buttonOnTouch");    
        });
        admin.setOnMouseExited(e->{
            admin.setId("buttonOut");    
        });

        student.setOnMouseEntered(e ->{
            student.setId("buttonOnTouch");    
        });
        student.setOnMouseExited(e->{
            student.setId("buttonOut");    
        });

        guest.setOnMouseEntered(e ->{
            guest.setId("buttonOnTouch");    
        });
        guest.setOnMouseExited(e->{
            guest.setId("buttonOut");    
        });
        
        
        // -------------------------------------------------------------------------------------
        // putting the buttons above eache other in a Vbox called menu
        VBox menu = new VBox(20,admin,student,guest);
        menu.setAlignment(Pos.CENTER);
        // autosizing
        menu.prefHeightProperty().bind(stage.heightProperty());
        menu.prefWidthProperty().bind(stage.widthProperty());
        
        // creating the scene
        Group root = new Group(imageView,menu);
        Scene scene = new Scene(root, 1000, 600);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:icon.png"));
        stage.show();
        root.requestFocus();



        // loging in scene
        admin.setOnAction(e->{
            loginPage.login(stage,scene,menu,tournaments,table,teamList,table1);
        });
        student.setOnAction(e->{
            loginPage.login(stage,scene,menu,tournaments,table,teamList,table1);
        });
        guest.setOnAction(e->{
            guestPage.guestLogedin(stage, scene,table);
        });

    }
    
    public static void main(String[] args) {
        launch();
    }

    

}


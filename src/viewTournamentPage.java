
import javafx.collections.ObservableList;
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

public class viewTournamentPage {
    public static void viewtournamentPageCalled(Stage stage,Scene scane1,TableView <tournament> table,ObservableList<tournament> tournaments){
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);

        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());
        Button backButton = new Button("Back");
        Button viewTournamentDetails = new Button("View Details");
        Button deleteTournament = new Button("Delete");
        Button editTournament = new Button("Edit");
        



        backButton.setOnMouseEntered(e ->{
            backButton.setId("buttonOnTouch");    
        });
        backButton.setOnMouseExited(e->{
            backButton.setId("buttonOut");    
        });

        viewTournamentDetails.setOnMouseEntered(e->{
            viewTournamentDetails.setId("buttonOnTouch");
        });
        viewTournamentDetails.setOnMouseExited(e->{
            viewTournamentDetails.setId("buttonOut");
        });
        deleteTournament.setOnMouseEntered(e->{
            deleteTournament.setId("buttonOnTouch");
        });
        deleteTournament.setOnMouseExited(e->{
            deleteTournament.setId("buttonOut");
        });
        editTournament.setOnMouseEntered(e->{
            editTournament.setId("buttonOnTouch");
        });
        editTournament.setOnMouseExited(e->{
            editTournament.setId("buttonOut");
        });

        backButton.setOnAction(e->{
            double width =stage.getWidth();
            Double heigt = stage.getHeight();
            stage.setScene(scane1);
            stage.setHeight(heigt);
            stage.setWidth(width);
            
        });

        
        
        deleteTournament.setOnAction(e->{
            //call the method to delete the tournament
            ObservableList<tournament> tournamentSelected, allTournaments;
            allTournaments=table.getItems();
            tournamentSelected=table.getSelectionModel().getSelectedItems();
            tournamentSelected.forEach(allTournaments::remove);
            tournament.saveTournaments(tournaments);
        });


        HBox butttonsBox = new HBox(20,backButton,viewTournamentDetails,editTournament,deleteTournament);
        butttonsBox.setAlignment(Pos.CENTER);

        backButton.setMaxSize(150 ,30);
        backButton.setMinSize(100,12.5);
        viewTournamentDetails.setMaxSize(150, 30);
        viewTournamentDetails.setMinSize(100, 12.5);
        deleteTournament.setMaxSize(150, 30);
        deleteTournament.setMinSize(100, 12.5);
        editTournament.setMaxSize(150, 30);
        editTournament.setMinSize(100, 12.5);

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
        viewTournamentDetails.setOnAction(e->{
            tournamentDetails.viewDetailsPageCalled(stage, scene);
        });
        editTournament.setOnAction(e->{
            editTournamentPage.editTournamentPageCalled(stage, scene, table, tournaments);;
        });
    }
    public static void viewTRstudentPageCalled(Stage stage,Scene scane1,TableView <tournament> table){
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);

        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());
        Button backButton = new Button("Back");
        Button viewTournamentDetails = new Button("View Details");
        Button registerForTournament = new Button("Register");
        
        



        backButton.setOnMouseEntered(e ->{
            backButton.setId("buttonOnTouch");    
        });
        backButton.setOnMouseExited(e->{
            backButton.setId("buttonOut");    
        });

        viewTournamentDetails.setOnMouseEntered(e->{
            viewTournamentDetails.setId("buttonOnTouch");
        });
        viewTournamentDetails.setOnMouseExited(e->{
            viewTournamentDetails.setId("buttonOut");
        });
        registerForTournament.setOnMouseEntered(e->{
            registerForTournament.setId("buttonOnTouch");
        });
        registerForTournament.setOnMouseExited(e->{
            registerForTournament.setId("buttonOut");
        });
       

        backButton.setOnAction(e->{
            double width =stage.getWidth();
            Double heigt = stage.getHeight();
            stage.setScene(scane1);
            stage.setHeight(heigt);
            stage.setWidth(width);
            
        });

        
        registerForTournament.setOnAction(e->{
            //call the method 
        });
        


        HBox butttonsBox = new HBox(20,backButton,viewTournamentDetails,registerForTournament);
        butttonsBox.setAlignment(Pos.CENTER);

        backButton.setMaxSize(150 ,30);
        backButton.setMinSize(100,12.5);
        viewTournamentDetails.setMaxSize(150, 30);
        viewTournamentDetails.setMinSize(100, 12.5);
        registerForTournament.setMaxSize(150, 30);
        registerForTournament.setMinSize(100, 12.5);
        

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
        viewTournamentDetails.setOnAction(e->{
            tournamentDetails.viewDetailsForStudentsPageCalled(stage, scene);
        });
    }
    public static void viewTRForGuestPageCalled(Stage stage,Scene scane1,TableView <tournament> table){
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);

        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());
        Button backButton = new Button("Back");
        Button viewTournamentDetails = new Button("View Details");

        backButton.setOnMouseEntered(e ->{
            backButton.setId("buttonOnTouch");    
        });
        backButton.setOnMouseExited(e->{
            backButton.setId("buttonOut");    
        });

        viewTournamentDetails.setOnMouseEntered(e->{
            viewTournamentDetails.setId("buttonOnTouch");
        });
        viewTournamentDetails.setOnMouseExited(e->{
            viewTournamentDetails.setId("buttonOut");
        });
        
       

        backButton.setOnAction(e->{
            double width =stage.getWidth();
            Double heigt = stage.getHeight();
            stage.setScene(scane1);
            stage.setHeight(heigt);
            stage.setWidth(width);
            
        });

        
        
        


        HBox butttonsBox = new HBox(20,backButton,viewTournamentDetails);
        butttonsBox.setAlignment(Pos.CENTER);

        backButton.setMaxSize(150 ,30);
        backButton.setMinSize(100,12.5);
        viewTournamentDetails.setMaxSize(150, 30);
        viewTournamentDetails.setMinSize(100, 12.5);
        
        

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
        viewTournamentDetails.setOnAction(e->{
            tournamentDetails.viewDetailsForStudentsPageCalled(stage, scene);
        });
    }
    
}




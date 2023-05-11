import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class createTournamentPage {
    public static void tournamentPageCalled(Stage stage,Scene scane1){
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);
        // autosizing the image with the stage
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());

        
        TextField name = new TextField();
        name.getStyleClass().add("normal-color");
    
        Button backButton = new Button("Back");
        Button createButton = new Button( "Create");
        Label type = new Label("Type");
        type.setId("bold");
        Label sport = new Label("Sport");
        sport.setId("bold");
        Label numOfParLabel = new Label("Players");
        numOfParLabel.setId("bold");
        Label nameLabel = new Label("Name");
        nameLabel.setId("bold");
        Label numberOfDays = new Label("Number Of Days \n Between Stages");
        numberOfDays.setId("bold");
        ChoiceBox <String> types = new ChoiceBox<>();
        ChoiceBox <String> sports = new ChoiceBox<>();
        ChoiceBox <Integer> numOfPAr = new ChoiceBox<>();
        ChoiceBox <Integer> numOfStage = new ChoiceBox<>();
        types.getStyleClass().add("normal-color");
        sports.getStyleClass().add("normal-color");
        numOfPAr.getStyleClass().add("normal-color");
        numOfStage.getStyleClass().add("normal-color");
        types.getItems().addAll("Elimination","Round Robin");
        sports.getItems().addAll("FootBall","BasketBall","tennis","Volleyball");
        numOfPAr.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11);
        numOfStage.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        type.setFont(new Font(20));
        numOfParLabel.setFont(new Font(20));
        sport.setFont(new Font(20));
        nameLabel.setFont(new Font(20));

        
        backButton.setOnMouseEntered(e ->{
            backButton.setId("buttonOnTouch");    
        });
        backButton.setOnMouseExited(e->{
            backButton.setId("buttonOut");    
        });

        createButton.setOnMouseEntered(e ->{
            createButton.setId("buttonOnTouch");    
        });
        createButton.setOnMouseExited(e->{
            createButton.setId("buttonOut");    
        });



        

    
        name.setPromptText("Tournament's Name");
        name.setMinWidth(300);
        types.setMinWidth(300);
        sports.setMinWidth(300);
        numOfPAr.setMinWidth(300);
        numOfStage.setMinWidth(300);
        backButton.setMaxSize(150 ,30);
        backButton.setMinSize(100,12.5);
        createButton.setMaxSize(150 ,30);
        createButton.setMinSize(100,12.5);
        

        HBox sportBox = new HBox(65,sport,sports );
        HBox typeBox = new HBox(75,type,types );
        HBox nameBox = new HBox(65,nameLabel,name );
        HBox numOfDays = new HBox(0,numberOfDays,numOfStage);
        HBox numOfplayersBox = new HBox(60,numOfParLabel,numOfPAr );
        HBox butttonsBox = new HBox(20,backButton,createButton);
        
        sportBox.setAlignment(Pos.CENTER);
        typeBox.setAlignment(Pos.CENTER);
        numOfplayersBox.setAlignment(Pos.CENTER);
        nameBox.setAlignment(Pos.CENTER);
        butttonsBox.setAlignment(Pos.CENTER);
        numOfDays.setAlignment(Pos.CENTER);


        VBox box = new VBox(10,nameBox,sportBox,numOfplayersBox,typeBox, numOfDays ,butttonsBox);
        box.setAlignment(Pos.CENTER);
        box.prefHeightProperty().bind(stage.heightProperty());
        box.prefWidthProperty().bind(stage.widthProperty());
        box.getStyleClass().add("shade");
        

        Group root = new Group(imageView,box);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene); 
        root.requestFocus();

        backButton.setOnAction(e->{
            double width =stage.getWidth();
            Double heigt = stage.getHeight();
            stage.setScene(scane1);
            stage.setHeight(heigt);
            stage.setWidth(width);
            
        });

        createButton.setOnAction(e->{
            System.out.println(types.getValue());
            System.out.println(sports.getValue());
            System.out.println(numOfPAr.getValue());
            System.out.println(numOfStage.getValue());
            

            if(types.getValue().equals("Elimination")){
                // create elimination tournament
                tournament tr = new elimination(name.getText(), types.getValue(), sports.getValue(), numOfPAr.getValue());
                tournamentMaker.table.getItems().add(tr);
                System.out.println(tournamentMaker.table.toString());
                 
                
            }
            else if(types.getValue().equals("Round Robin")){
                //create Round Robin tournament
                tournament tr = new roundRobin(name.getText(), types.getValue(), sports.getValue(), numOfPAr.getValue());
                tournamentMaker.table.getItems().add(tr);
            }
            

        });
           
    }    
    
}

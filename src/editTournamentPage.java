import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
public class editTournamentPage {
    public static void editTournamentPageCalled(Stage stage,Scene scane1,TableView <tournament> table,ObservableList<tournament> tournaments){
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);
        tournament tournamentSelected = table.getSelectionModel().getSelectedItem();
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());
        Button backButton = new Button("Back");
        Button edit = new Button("Edit");
        Button editParticbents = new Button("Edit Particibents");
        TextField name = new TextField(tournamentSelected.getName());
        name.getStyleClass().add("normal-color");

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
        types.getSelectionModel().selectFirst();
        types.setValue(tournamentSelected.getType());
        sports.getSelectionModel().selectFirst();
        sports.setValue(tournamentSelected.getSport());
        numOfPAr.getSelectionModel().selectFirst();
        numOfPAr.setValue(tournamentSelected.getNumOfParticibents());
        numOfStage.getSelectionModel().selectFirst();
        numOfStage.setValue(tournamentSelected.getStages());
        types.getStyleClass().add("normal-color");
        sports.getStyleClass().add("normal-color");
        numOfPAr.getStyleClass().add("normal-color");
        numOfStage.getStyleClass().add("normal-color");
        types.getItems().addAll("Elimination","Round Robin");
        sports.getItems().addAll("Football","Basketball","Tennis","Volleyball");
        numOfPAr.getItems().addAll(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
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

        edit.setOnMouseEntered(e ->{
            edit.setId("buttonOnTouch");    
        });
        edit.setOnMouseExited(e->{
            edit.setId("buttonOut");    
        });
        editParticbents.setOnMouseEntered(e ->{
            editParticbents.setId("buttonOnTouch");    
        });
        editParticbents.setOnMouseExited(e->{
            editParticbents.setId("buttonOut");    
        });

        name.setMinWidth(300);
        types.setMinWidth(300);
        sports.setMinWidth(300);
        numOfPAr.setMinWidth(300);
        numOfStage.setMinWidth(300);
        backButton.setMaxSize(150 ,30);
        backButton.setMinSize(100,12.5);
        edit.setMaxSize(150 ,30);
        edit.setMinSize(100,12.5);
        editParticbents.setMaxSize(300 ,30);
        editParticbents.setMinSize(200,12.5);
        
    

        backButton.setOnAction(e->{
            double width =stage.getWidth();
            Double heigt = stage.getHeight();
            stage.setScene(scane1);
            stage.setHeight(heigt);
            stage.setWidth(width);
            
        });

        

        HBox butttonsBox = new HBox(20,backButton,editParticbents,edit);
        HBox sportBox = new HBox(73,sport,sports );
        HBox typeBox = new HBox(83,type,types );
        HBox nameBox = new HBox(71,nameLabel,name );
        HBox numOfDays = new HBox(0,numberOfDays,numOfStage);
        HBox numOfplayersBox = new HBox(66,numOfParLabel,numOfPAr );
        
        
        sportBox.setAlignment(Pos.CENTER);
        typeBox.setAlignment(Pos.CENTER);
        numOfplayersBox.setAlignment(Pos.CENTER);
        nameBox.setAlignment(Pos.CENTER);
        butttonsBox.setAlignment(Pos.CENTER);
        numOfDays.setAlignment(Pos.CENTER);


        VBox box = new VBox(30,nameBox,sportBox,numOfplayersBox,typeBox, numOfDays ,butttonsBox);
        butttonsBox.setAlignment(Pos.CENTER);
        backButton.setMaxSize(150 ,30);
        backButton.setMinSize(100,12.5);
        
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

        edit.setOnAction(e->{
            tournamentSelected.setName(name.getText());
            tournamentSelected.setType(types.getValue());
            tournamentSelected.setNumOfParticibents(numOfPAr.getValue());
            tournamentSelected.setSport(sports.getValue());
            tournamentSelected.setStages(numOfStage.getValue());
            tournament.saveTournaments(tournaments);
            table.refresh();
        });
        
    }
}

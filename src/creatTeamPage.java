import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class creatTeamPage {
    public static void creatTeamPageCalled(Stage stage,Scene scane1){
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);
        // autosizing the image with the stage
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());

        
        TextField name = new TextField();
        name.getStyleClass().add("normal-color");
    
        Button backButton = new Button("Back");
        Button createButton = new Button( "Create");
        Button selectTeamMembers = new Button("Add members");

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

        selectTeamMembers.setOnMouseEntered(e ->{
            selectTeamMembers.setId("buttonOnTouch");    
        });
        selectTeamMembers.setOnMouseExited(e->{
            selectTeamMembers.setId("buttonOut");    
        });

    
        name.setPromptText("Tournament's Name");
        name.setMaxWidth(300);
        selectTeamMembers.setMaxWidth(300);
        backButton.setMaxSize(150 ,30);
        backButton.setMinSize(100,12.5);
        createButton.setMaxSize(150 ,30);
        createButton.setMinSize(100,12.5);
        

        
        HBox butttonsBox = new HBox(20,backButton,createButton);
        
        name.setAlignment(Pos.CENTER);
        selectTeamMembers.setAlignment(Pos.CENTER);
        butttonsBox.setAlignment(Pos.CENTER);


        VBox box = new VBox(10,name,selectTeamMembers,butttonsBox);
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
            System.out.println(name.getText());
            //get the student selcted and add them to the team
            

        
            

        });
           
    }    
    
}

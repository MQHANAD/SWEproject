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
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);

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
            
            st.registerForTeam(selcted);
            selcted.addPlayer(st);
            table.refresh();
            double width =stage.getWidth();
            Double heigt = stage.getHeight();
            stage.setScene(scane1);
            stage.setHeight(heigt);
            stage.setWidth(width);
            confirmationMessage.display("You have been registered to "+selcted.getName()+" Successfuly");

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

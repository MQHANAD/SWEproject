import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class tournamentDetails {
    public static void viewDetailsPageCalled(Stage stage,Scene scane1){
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);

        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());
        Button backButton = new Button("Back");
        
        Button viewMathes = new Button("Edit");
        Button openRegistration = new Button("Open registration");
        Button stopRegistration = new Button("Stop Registration");
        Button startTournament = new Button("Start");
        Button endTournament = new Button("End");
        Label label = new Label();
        Label label1 = new Label();
        Label label2 = new Label();

        label.setText("tournament details, name, type, sport");
        label1.setText("------------------------");
        label2.setText("today's matches(will not appear until the tournament starts)");
        label.setFont(new Font(30));
        label1.setFont(new Font(30));
        label2.setFont(new Font(30));

        VBox vBox =new VBox(label,label1,label2);
        vBox.setAlignment(Pos.CENTER);

        backButton.setOnMouseEntered(e ->{
            backButton.setId("buttonOnTouch");    
        });
        backButton.setOnMouseExited(e->{
            backButton.setId("buttonOut");    
        });

        startTournament.setOnMouseEntered(e->{
            startTournament.setId("buttonOnTouch");
        });
        startTournament.setOnMouseExited(e->{
            startTournament.setId("buttonOut");
        });
        endTournament.setOnMouseEntered(e->{
            endTournament.setId("buttonOnTouch");
        });
        endTournament.setOnMouseExited(e->{
            endTournament.setId("buttonOut");
        });
        stopRegistration.setOnMouseEntered(e->{
            stopRegistration.setId("buttonOnTouch");
        });
        stopRegistration.setOnMouseExited(e->{
            stopRegistration.setId("buttonOut");
        });
        openRegistration.setOnMouseEntered(e->{
            openRegistration.setId("buttonOnTouch");
        });
        openRegistration.setOnMouseExited(e->{
            openRegistration.setId("buttonOut");
        });
        viewMathes.setOnMouseEntered(e->{
            viewMathes.setId("buttonOnTouch");
        });
        viewMathes.setOnMouseExited(e->{
            viewMathes.setId("buttonOut");
        });

        backButton.setOnAction(e->{
            double width =stage.getWidth();
            Double heigt = stage.getHeight();
            stage.setScene(scane1);
            stage.setHeight(heigt);
            stage.setWidth(width);
            
        });

        startTournament.setOnAction(e->{
            //call the method to stop registering and start the tournament 
        });
        stopRegistration.setOnAction(e->{
            //call the method to stop students from registration 
        });
        endTournament.setOnAction(e->{
            //call the method to end and archive the tournament
        });
        viewMathes.setOnAction(e->{
            //call the method to view matches page
        });
        openRegistration.setOnAction(e->{
            //call the method to open registration 
        });


        HBox butttonsBox = new HBox(20,backButton,viewMathes,stopRegistration,openRegistration,startTournament,endTournament);
        butttonsBox.setAlignment(Pos.CENTER);

        backButton.setMaxSize(150 ,30);
        backButton.setMinSize(100,12.5);
        startTournament.setMaxSize(150, 30);
        startTournament.setMinSize(100, 12.5);
        stopRegistration.setMaxSize(150, 30);
        stopRegistration.setMinSize(100, 12.5);
        endTournament.setMaxSize(150, 30);
        endTournament.setMinSize(100, 12.5);
        openRegistration.setMaxSize(150, 30);
        openRegistration.setMinSize(100, 12.5);
        viewMathes.setMaxSize(150, 30);
        viewMathes.setMinSize(100, 12.5);

        VBox box =new VBox(20,vBox,butttonsBox);
        box.setAlignment(Pos.CENTER);
        box.prefHeightProperty().bind(stage.heightProperty());
        box.prefWidthProperty().bind(stage.widthProperty());
        box.getStyleClass().add("shade");

        Group root = new Group(imageView,box);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene); 
        root.requestFocus();
    }
    public static void viewDetailsForStudentsPageCalled(Stage stage,Scene scane1) {
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);

        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());
        Button backButton = new Button("Back");
        
        Button viewMathes = new Button("Edit");
        
        Label label = new Label();
        Label label1 = new Label();
        Label label2 = new Label();

        label.setText("tournamnet details, name, type, sport");
        label1.setText("------------------------");
        label2.setText("today's matches(will not appear until the tournament starts)");
        label.setFont(new Font(30));
        label1.setFont(new Font(30));
        label2.setFont(new Font(30));

        VBox vBox =new VBox(label,label1,label2);
        vBox.setAlignment(Pos.CENTER);

        backButton.setOnMouseEntered(e ->{
            backButton.setId("buttonOnTouch");    
        });
        backButton.setOnMouseExited(e->{
            backButton.setId("buttonOut");    
        });

       
        viewMathes.setOnMouseEntered(e->{
            viewMathes.setId("buttonOnTouch");
        });
        viewMathes.setOnMouseExited(e->{
            viewMathes.setId("buttonOut");
        });

        backButton.setOnAction(e->{
            double width =stage.getWidth();
            Double heigt = stage.getHeight();
            stage.setScene(scane1);
            stage.setHeight(heigt);
            stage.setWidth(width);
            
        });

       
        viewMathes.setOnAction(e->{
            //call the method to view matches page
        });
        


        HBox butttonsBox = new HBox(20,backButton,viewMathes);
        butttonsBox.setAlignment(Pos.CENTER);

        backButton.setMaxSize(150 ,30);
        backButton.setMinSize(100,12.5);
        
        viewMathes.setMaxSize(150, 30);
        viewMathes.setMinSize(100, 12.5);

        VBox box =new VBox(20,vBox,butttonsBox);
        box.setAlignment(Pos.CENTER);
        box.prefHeightProperty().bind(stage.heightProperty());
        box.prefWidthProperty().bind(stage.widthProperty());
        box.getStyleClass().add("shade");

        Group root = new Group(imageView,box);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene); 
        root.requestFocus();
    }
}


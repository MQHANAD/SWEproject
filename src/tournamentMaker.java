import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class tournamentMaker extends Application {   
    @Override
    public void start(Stage stage) {
        // background image
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);
        // autosizing the image with the stage
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());
        // ------------------------------------------------------------------------------------
        
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
            loginPage.login(stage,scene,1,menu);
        });
        student.setOnAction(e->{
            loginPage.login(stage,scene,2,menu);
        });
        guest.setOnAction(e->{
            guestPage.guestLogedin(stage, scene);
        });

    }
    
    public static void main(String[] args) {
        launch();
    }

}


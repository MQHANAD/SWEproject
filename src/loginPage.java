import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class loginPage {
    public static void login(Stage stage,Scene scane1){
        Image image = new Image("file:Screenshot 2023-04-08 at 11.56.03 PM.png");
        ImageView imageView = new ImageView(image);
        // autosizing the image with the stage
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());

        Button login = new Button("login");
        TextField email = new TextField();
        PasswordField password = new PasswordField();
        Button backButton = new Button("Back");


        email.setPromptText("Email");
        password.setPromptText("Password");

        
        email.setMaxSize(300 ,60);
        email.setMinSize(200,25);
        password.setMaxSize(300 ,60);
        password.setMinSize(200,25);
        login.setMaxSize(150 ,30);
        login.setMinSize(100,12.5);
        backButton.setMaxSize(150 ,30);
        backButton.setMinSize(100,12.5);

        HBox hBox = new HBox(10,backButton, login);
        hBox.setAlignment(Pos.CENTER);


        VBox box = new VBox(20,email,password,hBox);
        box.setAlignment(Pos.CENTER);
        box.prefHeightProperty().bind(stage.heightProperty());
        box.prefWidthProperty().bind(stage.widthProperty());
        

        Group root = new Group(imageView,box);
        Scene scene = new Scene(root);
        stage.setScene(scene); 
        root.requestFocus();
        
        // extacting informaion and checking if the the email is available
        login.setOnAction(e->{
            System.out.println(email.getText());
            System.out.println(password.getText());
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

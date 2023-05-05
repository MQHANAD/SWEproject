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

public class registrationPage {
    public static void registraionButtonClicked(int i,Stage stage,Scene scane1){//if i == 1 then admin registering, if i == 2 then it's student
        TextField name = new TextField();
        PasswordField password = new PasswordField();
        TextField email = new TextField();
        Button signUp = new Button("Sign up");
        Button backButton = new Button("Back");
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);
        // autosizing the image with the stage
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());

        name.setPromptText("Name");
        password.setPromptText("Password");
        email.setPromptText("Email");
    

        name.setMinSize(300, 25);
        password.setMinSize(300, 25);
        email.setMinSize(300, 25);
        name.setMaxSize(300, 25);
        password.setMaxSize(300, 25);
        email.setMaxSize(300, 25);
        backButton.setMinWidth(100);
        signUp.setMinWidth(100);

        HBox hBox = new HBox(20,backButton, signUp);
        hBox.setAlignment(Pos.CENTER);

        VBox box = new VBox(10,name,password,email,hBox);
        box.setAlignment(Pos.CENTER);
        box.prefHeightProperty().bind(stage.heightProperty());
        box.prefWidthProperty().bind(stage.widthProperty());
        
        Group root = new Group(imageView,box);
        Scene scene = new Scene(root);
        stage.setScene(scene); 
        root.requestFocus();

        backButton.setOnAction(e->{
            double width =stage.getWidth();
            Double heigt = stage.getHeight();
            stage.setScene(scane1);
            stage.setHeight(heigt);
            stage.setWidth(width);
            
        });

        signUp.setOnAction(e->{
            System.out.println(name.getText());
            System.out.println(password.getText());
            System.out.println(email.getText());
            if (i==1){
                //admin
            }
            else if (i==2){
                //student
            }
        });

        

    }
}

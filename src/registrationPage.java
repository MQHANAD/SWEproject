import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class registrationPage {
    public static void registraionButtonClicked(){
        TextField userName = new TextField();
        PasswordField password = new PasswordField();
        TextField email = new TextField();
        Button signUp = new Button("Sign up");

        userName.setPromptText("Username");
        password.setPromptText("Password");
        email.setPromptText("Email");

        VBox box = new VBox(10,userName,password,email,signUp);
        

    }
}

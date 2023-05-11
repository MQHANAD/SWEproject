import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class loginPage extends Httprequist {

    public static void login(Stage stage,Scene scane1,int i,VBox box1,ObservableList<tournament> tournaments,TableView <tournament> table, ObservableList<teams> teamList, TableView<teams> table1){
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);
        // autosizing the image with the stage
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());

        Button login = new Button("log in");
        TextField email = new TextField();
        email.getStyleClass().add("normal-color");
        PasswordField password = new PasswordField();
        password.getStyleClass().add("normal-color");
        Button backButton = new Button("Back");
        Button register = new Button("sign up");

        login.setOnMouseEntered(e ->{
            login.setId("buttonOnTouch");    
        });
        login.setOnMouseExited(e->{
            login.setId("buttonOut");    
        });

        backButton.setOnMouseEntered(e ->{
            backButton.setId("buttonOnTouch");    
        });
        backButton.setOnMouseExited(e->{
            backButton.setId("buttonOut");    
        });

        register.setOnMouseEntered(e ->{
            register.setId("buttonOnTouch");    
        });
        register.setOnMouseExited(e->{
            register.setId("buttonOut");    
        });


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
        register.setMaxSize(210 ,30);
        register.setMinSize(200,25);

        HBox hBox = new HBox(10,backButton, login);
        hBox.setAlignment(Pos.CENTER);


        VBox box = new VBox(10,email,password,hBox,register);
        box.setAlignment(Pos.CENTER);
        box.prefHeightProperty().bind(stage.heightProperty());
        box.prefWidthProperty().bind(stage.widthProperty());
        box.getStyleClass().add("shade");

        Group root = new Group(imageView,box);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("style.css");
        stage.setScene(scene);
        root.requestFocus();
        
        // extacting informaion and checking if the the email is available
        login.setOnAction(e-> {
            String inpUsername = email.getText();
            String inpPassword = password.getText();
            URL url = null; // i put the password and user name just to test but it need to be removed
            try {
                url = new URL("https://us-central1-swe206-221.cloudfunctions.net/app/UserSignIn" + "?" + "username=" + inpUsername +"&"+ "password=" + inpPassword);
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }
            HttpURLConnection con = null;
            try {
                con = (HttpURLConnection) url.openConnection();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                con.setRequestMethod("GET");
            } catch (ProtocolException ex) {
                throw new RuntimeException(ex);
            }
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            int status;
            try {
                status = con.getResponseCode();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            if (i == 1 && status == 200)//if admin
                adminsPage.adminLogedin(stage, scane1, tournaments, table, teamList, table1);
            else if (i == 2)//if student
                studentPage.studentLogedin(stage, scane1, table, table1);

        });
        backButton.setOnAction(e->{
            double width =stage.getWidth();
            Double heigt = stage.getHeight();
            stage.setScene(scane1);
            stage.setHeight(heigt);
            stage.setWidth(width);
            
        });
        register.setOnAction(e->{
            registrationPage.registraionButtonClicked(i, stage ,scene);
        });
    }    
}

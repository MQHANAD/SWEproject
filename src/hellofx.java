
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class hellofx extends Application {

    @Override
    public void start(Stage stage) {
        Image image = new Image("file:Screenshot 2023-04-08 at 11.56.03 PM.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(600);
        imageView.setFitWidth(1000);
        

        Button admin = new Button("admin");
        Button student = new Button("student");
        Button guest = new Button("guest");

        admin.setMaxSize(600 ,60);
        admin.setMinSize(400,25);
        student.setMaxSize(600 ,60);
        student.setMinSize(400,25);
        guest.setMaxSize(600 ,60);
        guest.setMinSize(400,25);

        VBox menu = new VBox(20,admin,student,guest);
        menu.setLayoutX(300);
        menu.setLayoutY(200);
        Group root = new Group(imageView,menu);
        menu.setPadding(new Insets(10,10,10,10));
        menu.setAlignment(Pos.CENTER);

        
        Scene scene = new Scene(root, 1000, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}


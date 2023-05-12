import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class viewTeamsDetailspage {
    public static void viewTeamsDetails(Stage stage,Scene scane1,ObservableList<teams> team){
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);

        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());
        Button backButton = new Button("Back");
        Label label = new Label();
        Label label1 = new Label();
        Label label2 = new Label();



        backButton.setOnMouseEntered(e ->{
            backButton.setId("buttonOnTouch");    
        });
        backButton.setOnMouseExited(e->{
            backButton.setId("buttonOut");    
        });

        backButton.setOnAction(e->{
            double width =stage.getWidth();
            Double heigt = stage.getHeight();
            stage.setScene(scane1);
            stage.setHeight(heigt);
            stage.setWidth(width);
            
        });


        HBox butttonsBox = new HBox(20,backButton);
        butttonsBox.setAlignment(Pos.CENTER);

        backButton.setMaxSize(150 ,30);
        backButton.setMinSize(100,12.5);
        label.setText(team.get(0).getName());
        label1.setText(team.get(0).getStudents().toString());
        label.setFont(new Font(30));
        label1.setFont(new Font(8));

        VBox box =new VBox(20,label,label1,butttonsBox);

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
        
        
        

        
    }
}

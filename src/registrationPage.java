import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
    //list of registerd students and admins
    private static ArrayList<Admin> admins= new ArrayList<>(); 
     

    public static void registraionButtonClicked(int i,Stage stage,Scene scane1, ArrayList<student> studentsList){//if i == 1 then admin registering, if i == 2 then it's student
        TextField name = new TextField();
        PasswordField password = new PasswordField();
        TextField email = new TextField();
        Button signUp = new Button("Sign up");
        Button backButton = new Button("Back");
        Image image = new Image("file:sports_banners-1200x653.png");
        ImageView imageView = new ImageView(image);

        //styling ---------------------------------------------

        email.getStyleClass().add("normal-color");
        password.getStyleClass().add("normal-color");
        name.getStyleClass().add("normal-color");

        
        signUp.setOnMouseEntered(e ->{
            signUp.setId("buttonOnTouch");    
        });
        signUp.setOnMouseExited(e->{
            signUp.setId("buttonOut");    
        });
        backButton.setOnMouseEntered(e ->{
            backButton.setId("buttonOnTouch");    
        });
        backButton.setOnMouseExited(e->{
            backButton.setId("buttonOut");    
        });
        //--------------------------------------------------------
        // autosizing the image with the stage
        imageView.fitHeightProperty().bind(stage.heightProperty());
        imageView.fitWidthProperty().bind(stage.widthProperty());

        //adding texts on the fields 
        name.setPromptText("Name");
        password.setPromptText("Password");
        email.setPromptText("Email");
    
        //sizing
        name.setMinSize(200, 25);
        password.setMinSize(200, 25);
        email.setMinSize(200, 25);
        name.setMaxSize(300, 60);
        password.setMaxSize(300, 60);
        email.setMaxSize(300, 60);
        backButton.setMinWidth(100);
        signUp.setMinWidth(100);

        HBox hBox = new HBox(20,backButton, signUp); // adding back button and sign up button in a horizental box so they can be next to each other
        hBox.setAlignment(Pos.CENTER); //setting the horizental box at the center

        VBox box = new VBox(10,name,password,email,hBox);//adding component to a vertcal box
        box.setAlignment(Pos.CENTER);//setting the box at the center

        //to auto size the box with the window
        box.prefHeightProperty().bind(stage.heightProperty());
        box.prefWidthProperty().bind(stage.widthProperty());

        box.getStyleClass().add("shade");//styling

        Group root = new Group(imageView,box);
        Scene scene = new Scene(root);

        scene.getStylesheets().add("style.css");//styling
        stage.setScene(scene); 


        root.requestFocus();// to remove the blue border from buttons

        backButton.setOnAction(e->{
            //to keep the same size of the window
            double width =stage.getWidth(); 
            Double heigt = stage.getHeight();

            stage.setScene(scane1);
            stage.setHeight(heigt);
            stage.setWidth(width);
            
        });

        signUp.setOnAction(e->{
            
            if (i==1){//1 for admin
                //adding the admin arraylist to a file.dat
               admins.add(new Admin(name.getText(),email.getText(),password.getText()));
               try{
                File adminsFile = new File("admins.dat");
                if(!adminsFile.exists()){
                    adminsFile.createNewFile();
                }
                FileOutputStream fos = new FileOutputStream(adminsFile);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(admins);
                oos.close();
                fos.close();
                
            }catch(Exception event){
                System.out.println(event);
            }
                  
            }
            else if (i==2){//2 for student
                //adding the student arraylist to a file.dat
                studentsList.add(new student(name.getText(),email.getText(),password.getText()));
                
               try{
                File studentsFile = new File("students.dat");
                if(!studentsFile.exists()){
                    studentsFile.createNewFile();
                }
                FileOutputStream fos = new FileOutputStream(studentsFile);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(studentsList);
                oos.close();
                fos.close();
                
            }catch(Exception event){
                System.out.println(event);
            }
            }
        });       

        

    }
}

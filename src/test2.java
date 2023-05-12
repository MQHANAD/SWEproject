import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ListView;

public class test2 {
    public static void main(String[] args) {
        ArrayList <student> students = new ArrayList<>();
        // reading from a file 
        
        //File file = new File("students.dat");
        try {
            
            
            //FileInputStream fis = new FileInputStream(file);
            // try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            //     students = (ArrayList<student>)ois.readObject() ;
            //     ois.close();
            //     fis.close();
            // }
            
            BufferedReader br = new BufferedReader(new FileReader("StudentDetails.csv"));
            String line =br.readLine();
            while ((line = br.readLine()) !=null ){
                String[] list = line.split(",");
                System.out.println(list[0]+list[1]+list[2]+list[3]+list[4]+list[5]);

            }

        }catch(FileNotFoundException e){
            System.out.println("file not found");
        }
        catch (Exception e) {
            System.out.println("error");
        }
       
        

    
    }
}

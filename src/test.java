import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class test {// you can edit and do any thing you want here, this class is not important it's just for testing.
    
    public static void main(String[] args) {
        //writing to a file 
        File file = new File("admins.dat");
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                
                ArrayList<Admin> admins = new ArrayList<>();
                oos.writeObject(admins);
                oos.close();
                fos.close();
            }

        } catch (Exception e) {
            // TODO: handle exception
            
            
        }
        // reading from a file 
        File file1 = new File("admins.dat");
        try {
            FileInputStream fis = new FileInputStream(file1);
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                ArrayList<Admin> admins = (ArrayList<Admin>) ois.readObject();
                System.out.println("hello "+admins.get(0).getName());
                for(int i=0 ; i < admins.size();i++){
                    System.out.println(admins.get(i).getName());
                }
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        

    }
    

}


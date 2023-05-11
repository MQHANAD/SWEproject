import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class student implements Serializable {
    private String name;
    private String email;
    private int id;
    private String password;
    private teams team;


    public student(String name, String email, String password){

        this.name=name;
        this.email=email;
        this.id=UUID.randomUUID().hashCode();
        this.password=password;
        this.team = null;
        
    }

    public String getEmail() {
        return email;
    }
    public int getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    
    public teams getTeam(){
        return team;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setTeam(teams team) {
        this.team = team;
    }

    public void registerForTournament(){

    }
    public void registerForTeam() {
        
    }
    public void viewTournament(){

    }
    public void viewMatches() {
        
    }
    public static ArrayList<student> loadStudents(){
        ArrayList <student> students = new ArrayList<>();
        // reading from a file 
        File file = new File("students.dat");
        try {
            FileInputStream fis = new FileInputStream(file);
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                students = (ArrayList<student>)ois.readObject() ;
                ois.close();
                fis.close();
            }
            
        } catch (Exception e) {
            
        }
        return students;
        

    }
    public static void saveTournaments(ArrayList students){
        File file = new File("students.dat");
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(students);
                oos.close();
                fos.close();
            }

        } catch (Exception e) {
            // TODO: handle exception
            
            
           
        }
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "name:  "+this.getName() + "        team:  " + this.getTeam() + "        email:  " + this.getEmail() + "          ID:  " + this.getId();
    }

}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class student implements Serializable {
    private String name;
    private String userName;
    private String lastname;
    private String email;
    private int id;
    private String password;
    private teams team;


    public student(String userName,String password, String email,String lastname,String name){

        this.name=name;
        this.email=email;
        this.id=UUID.randomUUID().hashCode();
        this.password=password;
        this.lastname=lastname;
        this.userName=userName;
        this.team = null;
        
    }
    public String getLastname() {
        return lastname;
    }
    public String getUserName() {
        return userName;
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
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public void setUserName(String userName) {
        this.userName = userName;
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
            
        }
        catch (Exception e) {
            System.out.println("reading student.dat exception");
        }
        try (BufferedReader br = new BufferedReader(new FileReader("StudentDetails.csv"))) {
            String line =br.readLine();
            while ((line = br.readLine()) !=null ){
                boolean inlist = false;
                String [] list = line.split(",");
                for (int i =0; i< students.size();i++){
                    if(list[0].equals(students.get(i).getUserName())){
                        inlist=true;
                        break;
                    }
                }
                if(!inlist){
                    students.add(new student(list[0], list[1],list[3],list[4],list[5]));
                }
            }
        }catch(Exception e){
            System.out.println("reading studentDetails.csf exception");

        }
        finally{
            saveStudents(students);
        }

        return students;
        

    }
    public static void saveStudents(ArrayList students){
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
            System.out.println("reading student.dat exception");
            
            
           
        }
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Username:  "+this.getUserName() +  "        email:  " + this.getEmail() + "          name:  " + this.getLastname()+ ", "+this.getName();
    }

}

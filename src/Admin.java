import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Admin implements Serializable {

    private String name;
    private String email;
    private int id;
    private String password;
    private List<tournament> tournaments;
    private List<teams> teams;

    public Admin(String name, String email, String password){

        this.name=name;
        this.email=email;
        this.id= UUID.randomUUID().hashCode();
        this.password=password;
        this.tournaments = new ArrayList<>();
        teams = new ArrayList<>();


    }   

    public String getName(){
        return name;
    }

    private String getEmail(){
        return email;
    }

    private int getId(){
        return id;
    }

    private String getPassword(){
        return password;
    }

    public List<tournament> getTournaments() {
        return tournaments;
    }

    public List<teams> getTeams() {
        return teams;
    }

    private void setName(String name){
        this.name=name;
    }

    private void setEmail(String email){
        this.email=email;
    }

    private void setId(int id){
        this.id=id;
    }

    private void setPassword(String password){
        this.password=password;
    }

    public void createTournament(String name, String type,String sport, int id, int numOfParticibents){
        tournament tournament=new tournament(name, type, sport, numOfParticibents);
        tournaments.add(tournament);
 
    }

    public void createTeams(String name){
        
        teams team= new teams(name);
        teams.add(team);
        
    }

    public void saveTournament(String filename){
        
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(tournaments);
            out.close();
            System.out.println("Tournaments saved to file " + filename);
        } catch (IOException e) {
            System.out.println("Error saving tournaments to file " + filename + ": " + e.getMessage());
        }
    
    }

    public void deleteTournament(tournament tournament) {
        tournaments.remove(tournament);
    }

    









    
}

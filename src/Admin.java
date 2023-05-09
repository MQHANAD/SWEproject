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
    
    public void deleteTeam(teams team){

        if (team != null){
            teams.remove(team);
            List<student> st=team.getStudents();
            for(student student:st){
                student.setTeam(null);
            }
            System.out.println(team.getName() + " has been deleted");


        }

        else {
            System.out.println("Unable to delete team");
        }

    }
    
    public void addStudentToTeam(teams team, student st){
        if (team != null && st.getTeam() == null){
            team.getStudents().add(st);
            st.setTeam(team);
            System.out.println(st.getName() + " has been added to " + team.getName());
        
        }
        
        else{System.out.println("Unable to add player to team");}
    }
    
     public void removeStudentFromTeam(student st){
        if (st.getTeam() != null){
            teams team= st.getTeam();
            team.getStudents().remove(st);
            st.setTeam(null);
            System.out.println(st.getName() + " has been removed from " + team.getName()); 
           
        }

        else {
            System.out.println("Unable to remove player from team");
        }
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
    
    public void viewTournaments(){
        if (tournaments.isEmpty()) {
            System.out.println("No tournaments available");
        }

        else{
            for (tournament tournament : tournaments){
                System.out.println("Tournament Name: " + tournament.getName());
                System.out.println("Sport: " + tournament.getSport());
                System.out.println("Tournament Type: " + tournament.getType());

                System.out.println("Teams/Players:");
                for (teams team : tournament.getParticipant()){

                    System.out.println("  - " + team.getName());

                }
                System.out.println("----------------------------------------");
            }
        }
    }

    public void deleteTournament(tournament tournament) {
        tournaments.remove(tournament);
    }

    









    
}

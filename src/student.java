import java.io.Serializable;
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

}

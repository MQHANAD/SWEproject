import java.util.ArrayList;

public class elimination extends tournament {

    public elimination(String name, String type, String sport, int numOfParticibents,int stages,ArrayList<teams> par) {
        super(name, type, sport, numOfParticibents,stages,par);
        
    
    }

    private teams[] eliminated;
    
    public teams[] getEliminated() {
        return eliminated;
    }

    public void setEliminated(teams[] eliminated) {
        this.eliminated = eliminated;
    }

    public void drowTournament() {
        
    }
}

import java.util.ArrayList;

public class elimination extends tournament {

    public elimination(String name, String type, String sport, int numOfParticibents,int stages,ArrayList<teams> par) {
        super(name, type, sport, numOfParticibents,stages,par);
        
    
    }

    public elimination(String name, String type, int numOfPar, String sport, int numOfdayBetStages,ArrayList<student> par) {
        super(name, type,numOfPar,sport,numOfdayBetStages,par);
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

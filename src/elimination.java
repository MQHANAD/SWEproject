public class elimination extends tournament {

    public elimination(String name, String type, String sport, int numOfParticibents) {
        super(name, type, sport, numOfParticibents);
        
    
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

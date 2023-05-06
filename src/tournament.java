import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class tournament {
    private String name;
    private String type;
    private String sport;
    private int id;
    private int numOfParticibents;
    private teams winner;
    private int totalGoals;
    private List<teams> participant;
    
    public tournament(String name, String type, String sport,  int numOfParticibents){
        this.name=name;
        this.type=type;
        this.sport=sport;
        this.id = UUID.randomUUID().hashCode();
        this.numOfParticibents=numOfParticibents;
        participant = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public List<teams> getParticipant() {
        return participant;
    }
    public int getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public int getNumOfParticibents() {
        return numOfParticibents;
    }
    public String getSport() {
        return sport;
    }
    public teams getWinner() {
        return winner;
    }
    public int getTotalGoals() {
        return totalGoals;
    }

    public void setParticipant(List<teams> participant) {
        this.participant = participant;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setSport(String sport) {
        this.sport = sport;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNumOfParticibents(int numOfParticibents) {
        this.numOfParticibents = numOfParticibents;
    }
    public void setWinner(teams winner) {
        this.winner = winner;
    }
    public void setTotalGoals(int totalGoals) {
        this.totalGoals = totalGoals;
    }
    public void addParticipant(teams participant) {
        this.participant.add(participant);
    }
    public void removeParticipant(teams participant) {
        this.participant.remove(participant);
    }    
}

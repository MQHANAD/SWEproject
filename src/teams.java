import java.util.ArrayList;
import java.util.List;
public class teams {
    private String name;
    private int goals;
    private int goalsAgainst;
    private int wins;
    private int losses;
    private int ties;
    private int points;
    private List <tournament> registerdTournament;
    private List<student> students;
    
    public teams(String name) {
        this.name = name;
        this.goals = 0;
        this.goalsAgainst=0;
        this.wins = 0;
        this.losses = 0;
        this.ties = 0;
        this.points = 0;
        registerdTournament= new ArrayList<>();
        this.students=new ArrayList<>();
    }
    
     public String getName() {
        return name;
    }

    public int getGoals() {
        return goals;
    }

    public int getWins() {
        return wins;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getLosses() {
        return losses;
    }

    public int getTies() {
        return ties;
    }

    public int getPoints() {
        return points;
    }
    
    public List<student> getStudents(){
        return students;
    }
    public List<tournament> getRegisterdTournament() {
        return registerdTournament;
    }

    public void RegisterTournament( tournament t) {
        registerdTournament.add(t); 
        t.addParticipant(this);
    }
    public void removeTournament( tournament t) {
        registerdTournament.remove(t);
        t.removeParticipant(this); 
    }

    public void addGoals(int goals) {
        this.goals += goals;
        // or this.goals = matchObj.getScore1 or .getScore2, we can use if statment;
    }

    public void addGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst += goalsAgainst;
    }
    public void removeGoalesAgainst(int goalsAgainst) {
        this.goalsAgainst -= goalsAgainst;
    }


    public void addWin() {
        this.wins++;
        this.points += 3;
    }
    public void removeWin() {
        this.wins--;
        this.points -= 3;
    }

    public void addLoss() {
        this.losses++;
    }
    public void removeLoss() {
        this.losses--;
    }

    public void removeTie() {
        this.ties--;
        this.points -= 1;
    }
    public void addTie() {
        this.ties++;
        this.points += 1;
    }
    public void addGoal() {
        goals++;
    }
    public void removeGoal() {
        goals--;
    }
    public void addPoints() {
        points++;
    }
    public void removePoints() {
        points--;
    }
    
}

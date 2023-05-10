import java.util.ArrayList;
import java.util.List;
public class teams {
    private String name;
    private int goals;
    private int goalsAgainst;
    private int wins; // THE SECOND
    private int losses;
    private int ties;
    private int points; //THE FIRST
    private int gamesPlayed; // to show it in the table
    private int goalsDiff; // Goals for - Goals against (Important in league standings "The Third")
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
        this.gamesPlayed = 0;
        this.goalsDiff = 0;
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

    public int getGamesPlayed() {return gamesPlayed;}

    public int getGoalsDiff() {return goalsDiff;}

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
        this.goalsDiff += goals;
        // or this.goals = matchObj.getScore1 or .getScore2, we can use if statment;
    }

    public void addGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst += goalsAgainst;
        this.goalsDiff -= goals;
    }
    public void removeGoalesAgainst(int goalsAgainst) {
        this.goalsAgainst -= goalsAgainst;
        this.goalsDiff += goals;
    }


    public void addWin() {
        this.wins++;
        this.points += 3;
        this.gamesPlayed +=1;
    }
    public void removeWin() {
        this.wins--;
        this.points -= 3;
        this.gamesPlayed -=1;
    }

    public void addLoss() {
        this.losses++;
        this.gamesPlayed +=1; // Every lose&win&tie that mean the team played one game more
    }
    public void removeLoss() {
        this.losses--;
        this.gamesPlayed -=1;
    }

    public void removeTie() {
        this.ties--;
        this.points -= 1;
        this.gamesPlayed -=1;
    }
    public void addTie() {
        this.ties++;
        this.points += 1;
        this.gamesPlayed +=1;
    }
    public void addGoal() {
        goals++;
        goalsDiff++;
    }
    public void removeGoal() {
        goals--;
        goalsDiff--;
    }
    public void addPoints() {
        points++;
    }
    public void removePoints() {
        points--;
    }
    
}

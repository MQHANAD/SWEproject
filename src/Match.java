public class Match {
    private teams team1;
    private teams team2;
    private int score1;
    private int score2;

    public Match(teams team1, teams team2) {
        this.team1 = team1;
        this.team2 = team2;
        this.score1 = 0;
        this.score2 = 0;
    }

    public teams getTeam1() {
        return team1;
    }

    public teams getTeam2() {
        return team2;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore(Match match, int score1, int score2){

        teams team1 = match.getTeam1();
        teams team2 = match.getTeam2();

        team1.addGoals(score1);
        team2.addGoals(score2);
        team1.addGoalsAgainst(score2);
        team2.addGoalsAgainst(score1);
        if (score1 > score2) {
            team1.addWin();
            team2.addLoss();
        } else if (score1 < score2) {
            team1.addLoss();
            team2.addWin();
        } else {
            team1.addTie();
            team2.addTie();
        }

    }



    
}

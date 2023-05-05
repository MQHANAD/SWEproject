public class Match {
    private teams team1;
    private teams team2;
    private int score1;
    private int score2;
    private teams winner;
    private teams loser;

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
    public void setTeam1(teams team1) {
        this.team1 = team1;
    }
    public void setTeam2(teams team2) {
        this.team2 = team2;
    }
    public void setWinner(teams winner) {
        this.winner = winner;
    }
    public void setLoser(teams loser) {
        this.loser = loser;
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
            setWinner(team1);
            team2.addLoss();
            setLoser(team2);
        } else if (score1 < score2) {
            team1.addLoss();
            setLoser(team1);
            team2.addWin();
            setWinner(team2);
        } else {
            setWinner(null);
            setLoser(null);
            team1.addTie();
            team2.addTie();
        }

    }
    public void scoreGoleForTeam1() {
        score1++;
    }
    public void scoreGoleForTeam2() {
        score2++;
    }
    public void removeGoleFromTeam1() {
        score1--;
    }
    public void removeGoleFromTeam2() {
        score2--;
    }

}

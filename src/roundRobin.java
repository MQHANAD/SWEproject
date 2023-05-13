import java.util.ArrayList;
import java.util.Date;

public class roundRobin extends tournament{
    public roundRobin(String name, String type, String sport, int numOfParticibents,int stages,ArrayList<teams> par) {
        super(name, type, sport, numOfParticibents,stages,par);
       
    }
    public roundRobin(String name, String type, int numOfPar, String sport, int numOfdayBetStages,ArrayList<student> par) {
        super(name, type,numOfPar,sport,numOfdayBetStages,par);
    }

    public roundRobin(String name, String type, String sport, int numOfParticibents,int stages,ArrayList<teams> par, Date startDate) {
        super(name, type, sport, numOfParticibents,stages,par,startDate);
       
    }

    

    private int points;

    public int getPoints() {
        return points;
    }

    public void drowTable(){

    }
}

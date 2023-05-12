import java.util.ArrayList;

public class roundRobin extends tournament{
    public roundRobin(String name, String type, String sport, int numOfParticibents,int stages,ArrayList<teams> par) {
        super(name, type, sport, numOfParticibents,stages,par);
       
    }

    

    private int points;

    public int getPoints() {
        return points;
    }

    public void drowTable(){

    }
}

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
public class tournament implements Serializable {
    private String name;
    private String type;
    private String sport;
    private int id;
    private int numOfParticibents;
    private teams winner;
    private int totalGoals;
    private List<teams> participant;

    public tournament(){
        this.name="";
        this.type="";
        this.sport="";
        this.numOfParticibents=0;
    }
    
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
    public String getType() {
        return type;
    }
    public String getSport() {
        return sport;
    }
    public int getNumOfParticibents() {
        return numOfParticibents;
    }
    public List<teams> getParticipant() {
        return participant;
    }
    public int getId() {
        return id;
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
    public static ObservableList loadTournaments(){
        ObservableList tournaments = FXCollections.observableArrayList();
        // reading from a file 
        File file = new File("tournaments.dat");
        try {
            FileInputStream fis = new FileInputStream(file);
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                tournaments = FXCollections.observableList((List<tournament>) ois.readObject());
                ois.close();
                fis.close();
            }
            
        } catch (Exception e) {
            
        }
        return tournaments;
        

    }
    public static void saveTournaments(ObservableList tournaments){
        File file = new File("tournaments.dat");
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(new ArrayList<>(tournaments));
                oos.close();
                fos.close();
            }

        } catch (Exception e) {
            // TODO: handle exception
            
            
           
        }
    }
}

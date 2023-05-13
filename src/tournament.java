import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.print.attribute.standard.DateTimeAtCompleted;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class tournament implements Serializable {
    private String name;
    private String type;
    private String sport;
    private int id;
    private int numOfParticibents;
    private int numOfteams;
    private teams winner;
    private int totalGoals;
    private List<teams> participantTr;
    private List<student> participantST;
    private int stages;
    private Date startDate;
    private Date endDate;

    public tournament(String name2, String type2, String sport2, int numOfParticibents2, int stages2){
        this.name="";
        this.type="";
        this.sport="";
        this.numOfParticibents=0;
    }
    
    public tournament(String name, String type, String sport,  int numOfParticibents,int stages,ArrayList<teams> participant){
        this.name=name;
        this.type=type;
        this.sport=sport;
        this.id = UUID.randomUUID().hashCode();
        this.numOfParticibents=numOfParticibents;
        this.participantTr = participant;
        this.stages= stages;
        numOfteams=participant.size();
    }
    public tournament(String name, String type, int numOfParticibents, String sport,int stages,ArrayList<student> participant){
        this.name=name;
        this.type=type;
        this.sport=sport;
        this.id = UUID.randomUUID().hashCode();
        this.numOfParticibents=numOfParticibents;
        this.participantST = participant;
        this.stages= stages;
        numOfteams=participant.size();
    }

    public tournament(String name, String type, String sport,  int numOfParticibents,int stages,ArrayList<teams> participant,Date startDate){
        this.name=name;
        this.type=type;
        this.sport=sport;
        this.startDate=startDate;
        this.id = UUID.randomUUID().hashCode();
        this.numOfParticibents=numOfParticibents;
        this.participantTr = participant;
        this.stages= stages;
        numOfteams=participant.size();
    }

    public tournament(String name, String type, int numOfParticibents, String sport,int stages,ArrayList<student> participant,Date startDate){
        this.name=name;
        this.type=type;
        this.sport=sport;
        this.startDate=startDate;
        this.id = UUID.randomUUID().hashCode();
        this.numOfParticibents=numOfParticibents;
        this.participantST = participant;
        this.stages= stages;
        numOfteams=participant.size();
    }

    public int getNumOfteams() {
        return numOfteams;
    }
    public void setNumOfteams(int numOfteams) {
        this.numOfteams = numOfteams;
    }
    public int getStages() {
        return stages;
    }
    public void setStages(int stages) {
        this.stages = stages;
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
    public List<teams> getParticipantTr() {
        return participantTr;
    }
    public int getId() {
        return id;
    }
    public List<student> getParticipantST() {
        return participantST;
    }

    public Date getDate(){
        return startDate;
    }

    public void setDate(Date startDate){
        this.startDate=startDate;

    }
    
    
    
    public teams getWinner() {
        return winner;
    }
    public int getTotalGoals() {
        return totalGoals;
    }
    public void setParticipantST(List<student> participantST) {
        this.participantST = participantST;
    }

    public void setParticipantTr(List<teams> participant) {
        this.participantTr = participant;
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
        this.participantTr.add(participant);
    }
    public void removeParticipant(teams participant) {
        this.participantTr.remove(participant);
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

    public void addParticipant(student student1) {
        participantST.add(student1);
    }
    public void addParticipantTeam(teams team) {
        participantTr.add(team);
    }
    
    
}

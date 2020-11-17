package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class infoStudent {
    private final SimpleIntegerProperty semesterID;
    private final SimpleStringProperty Course;
    private final SimpleStringProperty Season;
    private final SimpleIntegerProperty Grade;

    public infoStudent(int semID, String couS, String seaS, int grD) {
        this.semesterID = new SimpleIntegerProperty(semID);
        this.Course = new SimpleStringProperty(couS);
        this.Season = new SimpleStringProperty(seaS);
        this.Grade = new SimpleIntegerProperty(grD);
    }

    public int getSemesterID() {
        return semesterID.get();
    }

    public void setSemesterID(int semID) {
        semesterID.set(semID);
    }

    public String getCourse() {
        return Course.get();
    }

    public void setCourse(String couS) {
        Course.set(couS);
    }
    public String getSeason(){
        return Season.get();
    }
    public void setSeason(String season) {
        this.Season.set(season);
    }
    public int getGrade() {
        return Grade.get();
    }

    public void setGrade(int grade) {
        this.Grade.set(grade);
    }
}

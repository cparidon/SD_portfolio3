package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ShowStudent {

    private final SimpleIntegerProperty StudentID;
    private final SimpleStringProperty Name;

    public ShowStudent(int sStudID, String showName){
        this.StudentID = new SimpleIntegerProperty(sStudID);
        this.Name = new SimpleStringProperty(showName);
    }

    public int getStudentID() {
        return StudentID.get();
    }
    public void setStudentID(int sStudID){
        StudentID.set(sStudID);
    }
    public String getName(){
        return Name.get();
    }
    public void setName(String showName){
        Name.set(showName);
    }
}

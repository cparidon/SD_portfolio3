package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;


public class GradAvgShow {

    private final SimpleStringProperty Course;
    private final SimpleDoubleProperty CouAvgGra;

    public GradAvgShow(String CC, double cAG){

        this.Course = new SimpleStringProperty(CC);
        this.CouAvgGra = new SimpleDoubleProperty(cAG);
    }

    public String getCourse() {
        return Course.get();
    }
    public void setCourse(String CC){
        Course.set(CC);
    }

    public Double getCouAvgGra () {
        return CouAvgGra.get();
    }
    public void setCouAvgGra(double cCID){
        CouAvgGra.set(cCID);
    }
}

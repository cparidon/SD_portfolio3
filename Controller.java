package sample;

import java.sql.SQLException;

public class Controller {

    CourseModel model;
    CourseView view;


    public Controller(CourseModel model) {
        this.model = model;
        try {
            model.connect();
            model.CreateStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}


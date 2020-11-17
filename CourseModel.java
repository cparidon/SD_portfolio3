package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import static java.sql.DriverManager.getConnection;

public class CourseModel {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt;
    String url;

    private ObservableList<ObservableList> data;

    public CourseModel(String url){
        this.url = url;
    }

    public void connect() throws SQLException {
        conn = getConnection(this.url);
    }

    public void CreateStatement() throws SQLException {
        this.stmt = conn.createStatement();
    }

    public ObservableList<String> studentNameQuerystmt(){
        ObservableList<String> showNStud = FXCollections.observableArrayList();
        try {
            String sql= "SELECT Name FROM Student";
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs != null && rs.next()){
                //Integer Istu = rs.getInt(1);
                String NcolS = rs.getString("Name");
                showNStud.add(NcolS);
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return showNStud;
    }
    public ObservableList<GradAvgShow> courseNameQuerystmt(){
        ObservableList<GradAvgShow> courseNames = FXCollections.observableArrayList();
        try {
            String sql= "SELECT Course, CouAvgGra FROM ShowAvgCourse";
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs != null && rs.next()){
                String CgCol = rs.getString(1);
                Double CagCol = rs.getDouble(2);

                courseNames.add(new GradAvgShow(CgCol,CagCol));
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return courseNames;
    }
    public String studentAvgQuerystmt(String Name){
        ResultSet rs;
        double AvgStud = 0.0;
        try {
            String sql= "SELECT AvgGrad FROM ShowAvgStudent WHERE Name = '" + Name + "'";
            pstmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(sql);
            while (rs != null && rs.next()){
                AvgStud = rs.getDouble(1);
            }
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return String.valueOf(AvgStud);
    }
    public String courseAvgQuerystmt(int CourseID){
        String sql= "SELECT CouAvgGra FROM ShowAvgCourse WHERE CourseID = " + CourseID;
        ResultSet rs;
        double AvgCours = 0.0;
        try {
            rs = stmt.executeQuery(sql);
            AvgCours = rs.getDouble(1);

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return String.valueOf(AvgCours);
    }

    public ObservableList<infoStudent> getGrades(String Name){
        ObservableList<infoStudent> data = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM ShowStudent WHERE Student = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Integer sId = rs.getInt(2);
                String ccol = rs.getString(6);
                String sCol = rs.getString(5);
                Integer gCol = rs.getInt(4);

                data.add(new infoStudent(sId,ccol,sCol,gCol));
            }
    } catch (Exception e) {
        e.printStackTrace();
            System.out.println("Error");
        }
        return data;
    }
}



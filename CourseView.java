package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class CourseView {

    CourseModel model;
    Controller control;
    private GridPane startView;
    Button closeWindowBtn = new Button("Close window");
    Label selectStudentLbl = new Label("Select a student: ");
    Label insertGradeLbl = new Label("Average grade for courses: ");
    Label showStudAvg = new Label();
    ComboBox<String> studentSelectBox  = new ComboBox<>();
    TableView<GradAvgShow> courseSelectBox= new TableView<>();
    TableView<infoStudent> studentTWInfo = new TableView<>();

    public CourseView(CourseModel model, Controller control){
        this.model = model;
        this.control = control;
        createAndConfigure();
    }

    private void createAndConfigure(){
        startView = new GridPane();
        startView.setMinSize(300,200);
        startView.setPadding(new Insets(10,5,5,10));
        startView.setVgap(5);
        startView.setHgap(1);

        //Select student
        startView.add(selectStudentLbl, 1, 1);
        startView.add(showStudAvg, 2,2);

        //Combobox for students
        studentSelectBox.setItems(model.studentNameQuerystmt());
        startView.add(studentSelectBox, 2,1);
        studentSelectBox.setPromptText("Choose student");
        studentSelectBox.setEditable(true);
        studentSelectBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showStudAvg.setText("The average grade is: " + model.studentAvgQuerystmt(studentSelectBox.getValue()));
                studentTWInfo.setItems(model.getGrades(studentSelectBox.getValue()));
            }
        });

        //Tableview
        startView.add(studentTWInfo,1, 3, 3,2);
        studentTWInfo.setEditable(true);
        TableColumn semIDCol = new TableColumn("Semester");
        semIDCol.setCellValueFactory(new PropertyValueFactory<infoStudent, Integer>("semesterID"));

        TableColumn courseCol = new TableColumn("Course");
        courseCol.setCellValueFactory(new PropertyValueFactory<infoStudent, String>("Course"));

        TableColumn seaCol = new TableColumn("Season");
        seaCol.setCellValueFactory(new PropertyValueFactory<infoStudent, String>("Season"));

        TableColumn gradCol = new TableColumn("Grade");
        gradCol.setCellValueFactory(new PropertyValueFactory<infoStudent, Integer>("Grade"));

        studentTWInfo.getColumns().addAll(semIDCol,courseCol,seaCol,gradCol);

        courseSelectBox.setItems(model.courseNameQuerystmt());
        startView.add(courseSelectBox,1, 7, 2,2);
        courseSelectBox.setEditable(true);
        TableColumn CC = new TableColumn("Course");
        CC.setCellValueFactory(new PropertyValueFactory<GradAvgShow, String>("Course"));

        TableColumn cAg = new TableColumn("Average");
        cAg.setCellValueFactory(new PropertyValueFactory<GradAvgShow, Double>("CouAvgGra"));

        courseSelectBox.getColumns().addAll(CC,cAg);

        //Insert grade
        startView.add(insertGradeLbl, 1, 6);

        //Exit button
        startView.add(closeWindowBtn, 4,9);
        closeWindowBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

    }
    public Parent asParent(){
        return startView;
    }
}

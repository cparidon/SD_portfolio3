package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    static String url= "jdbc:sqlite:/Users/Clara/Desktop/Databaser/CourseRegistrationDB";
    static CourseModel CDB = new CourseModel(url);

    @Override
    public void start(Stage primaryStage) throws Exception{

        Controller control = new Controller(CDB);
        CourseView view = new CourseView(CDB,control);
        //control.setView(view);

     // Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Course Registration");
        primaryStage.setScene(new Scene(view.asParent(), 450, 320));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

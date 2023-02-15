module com.example.testingproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testingproject to javafx.fxml;
    exports com.example.testingproject.view;



    opens com.example.testingproject.view to javafx.fxml;

    opens com.example.testingproject.control to javafx.fxml;
exports com.example.testingproject.control;

}
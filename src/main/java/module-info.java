module com.example.testingproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testingproject to javafx.fxml;
    exports com.example.testingproject.view;

    opens com.example.testingproject.view to javafx.fxml;
    exports com.example.testingproject.control;
    opens com.example.testingproject.control to javafx.fxml;
    opens com.example.testingproject.view.login to javafx.fxml;
    exports com.example.testingproject.view.login;

    opens com.example.testingproject.view.LoadingPage to javafx.fxml;
    exports com.example.testingproject.view.LoadingPage;

    opens com.example.testingproject.view.homePage to javafx.fxml;
    exports com.example.testingproject.view.homePage;



}
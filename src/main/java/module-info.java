module com.example.testingproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.testingproject to javafx.fxml;
    exports com.example.testingproject.view;
    opens com.example.testingproject.view to javafx.fxml;
    exports com.example.testingproject.control;
    opens com.example.testingproject.control to javafx.fxml;
    opens com.example.testingproject.view.login to javafx.fxml;
    exports com.example.testingproject.view.login;

    opens  com.example.testingproject.view.Land to javafx.fxml;
exports com.example.testingproject.view.Voli.VoliArrivo to javafx.graphics;

    opens com.example.testingproject.view.LoadingPage to javafx.fxml;
    exports com.example.testingproject.view.LoadingPage;

    opens com.example.testingproject.view.luggage to javafx.fxml;
    exports com.example.testingproject.view.luggage;

    opens com.example.testingproject.view.homePage to javafx.fxml;
    exports com.example.testingproject.view.homePage;

    opens com.example.testingproject.view.Voli to javafx.fxml;
    exports com.example.testingproject.view.Voli;


    opens com.example.testingproject.view.piste to javafx.fxml,javafx.graphics;
    exports com.example.testingproject.view.piste;






}

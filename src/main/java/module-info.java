module com.example.testingproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.testng;
   // requires mysql.connector.j;
    //requires org.testng;


    opens com.example.testingproject to javafx.fxml,javafx.graphics;
    opens com.example.testingproject.view to javafx.fxml;
    exports com.example.testingproject.control;
    opens com.example.testingproject.control to javafx.fxml;
    opens com.example.testingproject.view.login to javafx.fxml;
    exports com.example.testingproject.view.login;

    opens  com.example.testingproject.view.Land to javafx.fxml;
exports com.example.testingproject.view.Land to javafx.graphics;

    opens  com.example.testingproject.view.Land.assign to javafx.fxml;


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

    opens com.example.testingproject.view.creazioneAccount to javafx.fxml,javafx.graphics;
    exports com.example.testingproject.view.creazioneAccount;

    opens com.example.testingproject.view.ModificaAccount to javafx.fxml,javafx.graphics;
    exports com.example.testingproject.view.ModificaAccount;

    opens com.example.testingproject.view.GestioneAccount to javafx.fxml,javafx.graphics;
    exports com.example.testingproject.view.GestioneAccount;

    exports Test to org.testng;
    opens Test to org.testng;

opens com.example.testingproject.view.Voli.AggiuntaVoli;
opens com.example.testingproject.view.Voli.VoliArrivo;
opens com.example.testingproject.view.Voli.VoliPartenze;
exports com.example.testingproject.view.Voli.AggiuntaVoli to javafx.graphics,javafx.fxml;
    exports com.example.testingproject.view.Voli.VoliArrivo to javafx.graphics,javafx.fxml;
    exports com.example.testingproject.view.Voli.VoliPartenze to javafx.graphics,javafx.fxml;









}

import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.*;


public class Test  extends Application {
    Button button;

    public static void main(String[] args) {

        System.out.println("Hello World");
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
                     stage.setTitle("Yes");
        button = new Button();
        button.setText("Touch Me");
        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 100, 100);
        stage.setScene(scene);
        stage.show();

    }
}

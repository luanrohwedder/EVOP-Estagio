import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String input = "layout.fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(input));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        primaryStage.setTitle("Calculadora de Muro");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

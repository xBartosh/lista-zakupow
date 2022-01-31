import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class JavaFxApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        Text text = new Text("Tekst z pierwszej apki");

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(text);
        // scene
        Scene scene = new Scene(stackPane);



        // stage
        primaryStage.setScene(scene);

        primaryStage.setTitle("Apka");

        primaryStage.setX(300);
        primaryStage.setY(300);

        primaryStage.setWidth(800);
        primaryStage.setHeight(600);



        primaryStage.show();

    }
}

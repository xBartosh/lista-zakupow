import ShoppingArt.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Controls extends Application {

    // lista do zapisywania
    static List<String> list = new ArrayList<>();
    // buttons
    public Button b0, b1, b2, b3, b4, b5, b6, b7, b8, sort, clear;
    // text field
    TextField textField = new TextField();
    // checker
    static int which;
    // label
    static Label label;
    // scene
    Scene scene1;
    // textfield
    static TextArea textArea;

    public static void main(String[] args) {
        launch(args);
    }


    final EventHandler<ActionEvent> myHandler = new EventHandler<ActionEvent>() {

        @Override
        public void handle(final ActionEvent event) {
            switch ((((Button) event.getSource()).getText())) {
                case "Fruits":
                    which = 0;
                    break;
                case "Vegetables":
                    which = 1;
                    break;
                case "Baking":
                    which = 2;
                    break;
                case "Dairy":
                    which = 3;
                    break;
                case "Meat":
                    which = 4;
                    break;
                case "Chemicals":
                    which = 5;
                    break;
                case "Candies":
                    which = 6;
                    break;
                case "Others":
                    which = 7;
                    break;
                default:
                    System.out.println("Blad");
                    break;
            }
            textField.requestFocus();
        }
    };

    public void whichOne() {
        switch (which) {
            case 0:
                Fruits fruits = new Fruits(textField.getText());
                break;
            case 1:
                Vegetables vegetables = new Vegetables(textField.getText());
                break;
            case 2:
                Baking baking = new Baking(textField.getText());
                break;
            case 3:
                Dairy dairy = new Dairy(textField.getText());
                break;
            case 4:
                Meat meat = new Meat(textField.getText());
                break;
            case 5:
                Chemicals chemicals = new Chemicals(textField.getText());
                break;
            case 6:
                Sweets sweets = new Sweets(textField.getText());
                break;
            case 7:
                Others others = new Others(textField.getText());
                break;

            default:
                break;
        }
    }

    public static void save() {
        Vegetables vegetables = new Vegetables();
        Fruits fruits = new Fruits();
        Meat meat = new Meat();
        Baking baking = new Baking();
        Chemicals chemicals = new Chemicals();
        Dairy dairy = new Dairy();
        Others others = new Others();
        Sweets sweets = new Sweets();

        try {
            PrintWriter printWriter = new PrintWriter("zakupy.txt");

            if (baking.getList().size() == 0) {
            } else {
                baking.sortListAlf(baking.getList());
                printWriter.println("Baking:");
                for (int i = 0; i < baking.getList().size(); i++) {
                    printWriter.println(baking.getList().get(i));
                }
                printWriter.println();
            }

            if (vegetables.getList().size() == 0) {
            } else {
                vegetables.sortListAlf(vegetables.getList());
                printWriter.println("Vegetables:");
                for (int i = 0; i < vegetables.getList().size(); i++) {
                    printWriter.println(vegetables.getList().get(i));
                }
                printWriter.println();
            }

            if (fruits.getList().size() == 0) {
            } else {
                fruits.sortListAlf(fruits.getList());
                printWriter.println("Fruits:");
                for (int i = 0; i < fruits.getList().size(); i++) {
                    printWriter.println(fruits.getList().get(i));
                }
                printWriter.println();
            }

            if (meat.getList().size() == 0) {
            } else {
                meat.sortListAlf(meat.getList());
                printWriter.println("Meat:");
                for (int i = 0; i < meat.getList().size(); i++) {
                    printWriter.println(meat.getList().get(i));
                }
                printWriter.println();
            }

            if (dairy.getList().size() == 0) {
            } else {
                dairy.sortListAlf(dairy.getList());
                printWriter.println("Dairy:");
                for (int i = 0; i < dairy.getList().size(); i++) {
                    printWriter.println(dairy.getList().get(i));
                }
                printWriter.println();
            }

            if (chemicals.getList().size() == 0) {
            } else {
                chemicals.sortListAlf(chemicals.getList());
                printWriter.println("Chemicals:");
                for (int i = 0; i < chemicals.getList().size(); i++) {
                    printWriter.println(chemicals.getList().get(i));
                }
                printWriter.println();
            }
            if (sweets.getList().size() == 0) {
            } else {
                sweets.sortListAlf(sweets.getList());
                printWriter.println("Sweets:");
                for (int i = 0; i < sweets.getList().size(); i++) {
                    printWriter.println(sweets.getList().get(i));
                }
                printWriter.println();
            }

            if (others.getList().size() == 0) {
            } else {
                others.sortListAlf(others.getList());
                printWriter.println("Others:");
                for (int i = 0; i < others.getList().size(); i++) {
                    printWriter.println(others.getList().get(i));
                }
                printWriter.println();
            }

            printWriter.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error!");
        }
    }

    public static void load() {
        if (textArea.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("ERROR");
            alert.setContentText("First there must be something in the label to sort it!");
            alert.showAndWait();
        } else {
            save();
            try {
                FileReader fileReader = new FileReader("zakupy.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                textArea.setText("");
                while ((line = bufferedReader.readLine()) != null) {
                    if (textArea.getText().isEmpty()) {
                        textArea.setText("    " + line + "\n");
                    } else {
                        textArea.setText(textArea.getText() + "    " + line + "\n");
                    }
                }
                bufferedReader.close();

            } catch (FileNotFoundException e) {
                System.out.println("Blad");
            } catch (IOException e) {
                System.out.println("Blad");
            }
        }


    }

    public static void clear() {
        Vegetables vegetables = new Vegetables();
        Fruits fruits = new Fruits();
        Meat meat = new Meat();
        Baking baking = new Baking();
        Chemicals chemicals = new Chemicals();
        Dairy dairy = new Dairy();
        Others others = new Others();
        Sweets sweets = new Sweets();

        vegetables.clearList();
        fruits.clearList();
        meat.clearList();
        baking.clearList();
        chemicals.clearList();
        dairy.clearList();
        others.clearList();
        sweets.clearList();

        textArea.setText("");
        save();

    }


    @Override
    public void start(Stage primaryStage) {

        // textfield
        textField.setStyle(
                "-fx-background-color: #ffffff;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-color: #000000;" +
                        "-fx-focus-color: -fx-control-inner-background;" +
                        "-fx-faint-focus-color: -fx-control-inner-background;");
        textField.setLayoutX(10);
        textField.setLayoutY(360);
        textField.setPrefSize(250, 10);

        // textfield on enter
        textField.setOnAction(e -> {
            if (textArea.getText().isEmpty()) {
                whichOne();
                textArea.setText("    " + textField.getText() + "\n");
            } else {
                whichOne();
                textArea.setText(textArea.getText() + "    " + textField.getText() + "\n");
            }
            list.add(textField.getText());
            textField.clear();
        });

        EventHandler<MouseEvent> mouseEn = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                scene1.setCursor(Cursor.HAND);
                Button button = new Button();
                button = (Button) event.getSource();
                if(button.getText().equals("Sort") || button.getText().equals("Clear")){
                }else{
                    button.getStyleClass().add("button-onEn");
                }


            }
        };

        EventHandler<MouseEvent> mouseEx = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                scene1.setCursor(Cursor.DEFAULT);
                Button button = new Button();
                button = (Button) event.getSource();
                if(button.getText().equals("Sort") || button.getText().equals("Clear")){
                }else {
                    button.getStyleClass().remove("button-onEn");
                    button.getStyleClass().add("button-default");
                }

            }
        };

        // buttons
        b0 = new Button("Fruits");
        b0.setLayoutY(50);
        b0.setLayoutX(10);
        b0.setOnAction(myHandler);
        b0.setOnMouseEntered(mouseEn);
        b0.setOnMouseExited(mouseEx);


        b1 = new Button("Vegetables");
        b1.setLayoutY(80);
        b1.setLayoutX(10);
        b1.setOnAction(myHandler);
        b1.setOnMouseEntered(mouseEn);
        b1.setOnMouseExited(mouseEx);

        b2 = new Button("Baking");
        b2.setLayoutY(110);
        b2.setLayoutX(10);
        b2.setOnAction(myHandler);
        b2.setOnMouseEntered(mouseEn);
        b2.setOnMouseExited(mouseEx);

        b3 = new Button("Dairy");
        b3.setLayoutY(140);
        b3.setLayoutX(10);
        b3.setOnAction(myHandler);
        b3.setOnMouseEntered(mouseEn);
        b3.setOnMouseExited(mouseEx);

        b4 = new Button("Meat");
        b4.setLayoutY(170);
        b4.setLayoutX(10);
        b4.setOnAction(myHandler);
        b4.setOnMouseEntered(mouseEn);
        b4.setOnMouseExited(mouseEx);

        b5 = new Button("Chemicals");
        b5.setLayoutY(200);
        b5.setLayoutX(10);
        b5.setOnAction(myHandler);
        b5.setOnMouseEntered(mouseEn);
        b5.setOnMouseExited(mouseEx);

        b6 = new Button("Others");
        b6.setLayoutY(290);
        b6.setLayoutX(10);
        b6.setOnAction(myHandler);
        b6.setOnMouseEntered(mouseEn);
        b6.setOnMouseExited(mouseEx);

        b7 = new Button("Candies");
        b7.setLayoutY(260);
        b7.setLayoutX(10);
        b7.setOnAction(myHandler);
        b7.setOnMouseEntered(mouseEn);
        b7.setOnMouseExited(mouseEx);

        b8 = new Button("Drinks");
        b8.setLayoutY(230);
        b8.setLayoutX(10);
        b8.setOnAction(myHandler);
        b8.setOnMouseEntered(mouseEn);
        b8.setOnMouseExited(mouseEx);

        clear = new Button("Clear");
        clear.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (textArea.getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("ERROR");
                    alert.setContentText("There is nothing to clear!");
                    alert.showAndWait();
                } else {
                    clear();
                }

            }
        });
        clear.setLayoutX(480);
        clear.setLayoutY(555);
        clear.setPickOnBounds(true);
        clear.setPrefSize(50, 35);
        clear.setOnMouseEntered(mouseEn);
        clear.setOnMouseExited(mouseEx);

        sort = new Button("Sort");
        sort.setLayoutX(422);
        sort.setLayoutY(555);
        sort.setPrefSize(50, 35);
        sort.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                load();
            }
        });
        sort.setOnMouseEntered(mouseEn);
        sort.setOnMouseExited(mouseEx);

        // TextArea
        textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setLayoutX(320);
        textArea.setLayoutY(50);
        textArea.setWrapText(true);
        textArea.setPrefSize(350,500);
        textArea.setStyle("-fx-border-width: 1;\n" +
                "-fx-border-color: #000000;" +
                "-fx-background-radius: 18;" +
                "-fx-background-color: #ffffff;");

        Stream.of(b0, b1, b2, b3, b4, b5, b6, b7, b8).forEach(button ->
                button.getStyleClass().add("button-default"));

        // ScrollPane
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(textArea);
        scrollPane.setLayoutX(320);
        scrollPane.setLayoutY(50);
        scrollPane.setPrefSize(351, 502);
        scrollPane.setFitToWidth(true);

        // Imageview
        ImageView saveImg = new ImageView("saveImg.png");
        saveImg.setPickOnBounds(true);
        saveImg.setLayoutX(537);
        saveImg.setLayoutY(555);
        saveImg.setFitHeight(35);
        saveImg.setPreserveRatio(true);

        // Img
        Image image = new Image("background.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(image, null, null, null, null);

        // group
        Group group = new Group();
        group.getChildren().add(textField);
        group.getChildren().addAll(b0, b1, b2, b3, b4, b5, b6, b7, b8, clear, sort, saveImg);
        group.getChildren().add(textArea);
        group.getChildren().add(scrollPane);


        // scene
        scene1 = new Scene(group, 700, 600);
        scene1.setFill(Color.web("#ffffff"));
        scene1.getStylesheets().add("my-style.css");

        // stage
        primaryStage.setScene(scene1);
        primaryStage.setResizable(false);
        primaryStage.setTitle(("Shopping list"));
        primaryStage.show();

        // handlers
        saveImg.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                scene1.setCursor(Cursor.HAND);
            }
        });
        saveImg.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                scene1.setCursor(Cursor.DEFAULT);
            }
        });
        saveImg.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                if (textArea.getText().isEmpty()) {
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                    alert1.setHeaderText("ERROR");
                    alert1.setContentText("You cannot save an empty list!");
                    alert1.showAndWait();
                } else {
                    save();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.getDialogPane().setContentText("");
                    alert.getDialogPane().setHeaderText("Zapisano!");
                    alert.showAndWait();
                }

            }
        });
    }


}



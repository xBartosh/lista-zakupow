import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.TextArea;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controls extends Application {

    // lista do zapisywania
    static List<String> list = new ArrayList<>();
    // buttons
    public Button b0, b1, b2, b3, b4, b5, b6, b7, sort, clear;
    // text field
    TextField textField = new TextField();
    // checker
    static int which;
    // label
    static Label label;
    // scene
    Scene scene1;

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
                Owoce owoce = new Owoce(textField.getText());
                break;
            case 1:
                Warzywa warzywa = new Warzywa(textField.getText());
                break;
            case 2:
                Pieczywo pieczywo = new Pieczywo(textField.getText());
                break;
            case 3:
                Nabial nabial = new Nabial(textField.getText());
                break;
            case 4:
                Mieso mieso = new Mieso(textField.getText());
                break;
            case 5:
                Chemia chemia = new Chemia(textField.getText());
                break;
            case 6:
                Slodycze slodycze = new Slodycze(textField.getText());
                break;
            case 7:
                Inne inne = new Inne(textField.getText());
                break;

            default:
                break;
        }
    }

    public static void zapisz() {
        Warzywa warzywa = new Warzywa();
        Owoce owoce = new Owoce();
        Mieso mieso = new Mieso();
        Pieczywo pieczywo = new Pieczywo();
        Chemia chemia = new Chemia();
        Nabial nabial = new Nabial();
        Inne inne = new Inne();
        Slodycze slodycze = new Slodycze();

        try {
            PrintWriter zapis = new PrintWriter("zakupy.txt");

            if (pieczywo.zbierzListe().size() == 0) {
            } else {
                zapis.println("Pieczywo:");
                for (int i = 0; i < pieczywo.zbierzListe().size(); i++) {
                    zapis.println(pieczywo.zbierzListe().get(i));
                }
                zapis.println();
            }

            if (warzywa.zbierzListe().size() == 0) {
            } else {
                zapis.println("Warzywa:");
                for (int i = 0; i < warzywa.zbierzListe().size(); i++) {
                    zapis.println(warzywa.zbierzListe().get(i));
                }
                zapis.println();
            }

            if (owoce.zbierzListe().size() == 0) {
            } else {
                zapis.println("Owoce:");
                for (int i = 0; i < owoce.zbierzListe().size(); i++) {
                    zapis.println(owoce.zbierzListe().get(i));
                }
                zapis.println();
            }

            if (mieso.zbierzListe().size() == 0) {
            } else {
                zapis.println("Mieso: ");
                for (int i = 0; i < mieso.zbierzListe().size(); i++) {
                    zapis.println(mieso.zbierzListe().get(i));
                }
                zapis.println();
            }

            if (nabial.zbierzListe().size() == 0) {
            } else {
                zapis.println("Nabial:");
                for (int i = 0; i < nabial.zbierzListe().size(); i++) {
                    zapis.println(nabial.zbierzListe().get(i));
                }
                zapis.println();
            }

            if (chemia.zbierzListe().size() == 0) {
            } else {
                zapis.println("Chemia:");
                for (int i = 0; i < chemia.zbierzListe().size(); i++) {
                    zapis.println(chemia.zbierzListe().get(i));
                }
                zapis.println();
            }
            if (slodycze.zbierzListe().size() == 0) {
            } else {
                zapis.println("Slodycze:");
                for (int i = 0; i < slodycze.zbierzListe().size(); i++) {
                    zapis.println(slodycze.zbierzListe().get(i));
                }
                zapis.println();
            }

            if (inne.zbierzListe().size() == 0) {
            } else {
                zapis.println("Inne:");
                for (int i = 0; i < inne.zbierzListe().size(); i++) {
                    zapis.println(inne.zbierzListe().get(i));
                }
                zapis.println();
            }


            zapis.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error!");
        }
    }

    public static void sczytaj() {
        if (label.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("ERROR");
            alert.setContentText("First there must be something in the label to sort it!");
            alert.showAndWait();
        } else {
            zapisz();
            try {
                FileReader fileReader = new FileReader("zakupy.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                label.setText("");
                while ((line = bufferedReader.readLine()) != null) {
                    if (label.getText().isEmpty()) {
                        label.setText("    " + line + "\n");
                    } else {
                        label.setText(label.getText() + "    " + line + "\n");
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

    public static void wyczysc() {
        Warzywa warzywa = new Warzywa();
        Owoce owoce = new Owoce();
        Mieso mieso = new Mieso();
        Pieczywo pieczywo = new Pieczywo();
        Chemia chemia = new Chemia();
        Nabial nabial = new Nabial();
        Inne inne = new Inne();
        Slodycze slodycze = new Slodycze();

        warzywa.wyczyscListe();
        owoce.wyczyscListe();
        mieso.wyczyscListe();
        pieczywo.wyczyscListe();
        chemia.wyczyscListe();
        nabial.wyczyscListe();
        inne.wyczyscListe();
        slodycze.wyczyscListe();

        label.setText("");
        zapisz();

    }


    @Override
    public void start(Stage primaryStage) {

        // label
        label = new Label();
        label.setLayoutY(50);
        label.setLayoutX(500);
        label.setPrefSize(350, 500);
        label.setStyle("-fx-border-width: 2;\n" +
                "-fx-border-color: #000000;" +
                " -fx-border-radius: 18 18 18 18;" +
                "-fx-background-radius: 18;" +
                "-fx-background-color: #ffffff;");


        label.setWrapText(true);
        label.setTextAlignment(TextAlignment.LEFT);
        label.setAlignment(Pos.TOP_LEFT);
        label.maxHeight(500);
        label.maxWidth(350);


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
            if (label.getText().isEmpty()) {
                whichOne();
                label.setText("    " + textField.getText() + "\n");
            } else {
                whichOne();
                label.setText(label.getText() + "    " + textField.getText() + "\n");
            }

            list.add(textField.getText());
            textField.clear();
        });

        EventHandler<MouseEvent> mouseEn = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                scene1.setCursor(Cursor.HAND);
            }
        };

        EventHandler<MouseEvent> mouseEx = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                scene1.setCursor(Cursor.DEFAULT);
            }
        };
        // buttons
        b0 = new Button("Fruits");
        b0.setPrefSize(100, 100);
        b0.setLayoutY(50);
        b0.setLayoutX(10);
        b0.setContentDisplay(ContentDisplay.CENTER);
        b0.setOnAction(myHandler);
        b0.setOnMouseEntered(mouseEn);
        b0.setOnMouseExited(mouseEx);


        b1 = new Button("Vegetables");
        b1.setPrefSize(100, 100);
        b1.setLayoutY(50);
        b1.setLayoutX(110);
        b1.setContentDisplay(ContentDisplay.CENTER);
        b1.setOnAction(myHandler);
        b1.setOnMouseEntered(mouseEn);
        b1.setOnMouseExited(mouseEx);

        b2 = new Button("Baking");
        b2.setPrefSize(100, 100);
        b2.setLayoutY(50);
        b2.setLayoutX(210);
        b2.setOnAction(myHandler);
        b2.setOnMouseEntered(mouseEn);
        b2.setOnMouseExited(mouseEx);

        b3 = new Button("Dairy");
        b3.setPrefSize(100, 100);
        b3.setLayoutY(150);
        b3.setLayoutX(210);
        b3.setOnAction(myHandler);
        b3.setOnMouseEntered(mouseEn);
        b3.setOnMouseExited(mouseEx);

        b4 = new Button("Meat");
        b4.setPrefSize(100, 100);
        b4.setLayoutY(150);
        b4.setLayoutX(10);
        b4.setOnAction(myHandler);
        b4.setOnMouseEntered(mouseEn);
        b4.setOnMouseExited(mouseEx);

        b5 = new Button("Chemicals");
        b5.setPrefSize(100, 100);
        b5.setLayoutY(150);
        b5.setLayoutX(110);
        b5.setOnAction(myHandler);
        b5.setOnMouseEntered(mouseEn);
        b5.setOnMouseExited(mouseEx);

        b6 = new Button("Others");
        b6.setPrefSize(100, 100);
        b6.setLayoutY(250);
        b6.setLayoutX(110);
        b6.setOnAction(myHandler);
        b6.setOnMouseEntered(mouseEn);
        b6.setOnMouseExited(mouseEx);

        b7 = new Button("Candies");
        b7.setPrefSize(100, 100);
        b7.setLayoutY(250);
        b7.setLayoutX(10);
        b7.setOnAction(myHandler);
        b7.setOnMouseEntered(mouseEn);
        b7.setOnMouseExited(mouseEx);

        clear = new Button("Clear");
        clear.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (label.getText().isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("ERROR");
                    alert.setContentText("There is nothing to clear!");
                    alert.showAndWait();
                } else {
                    wyczysc();
                }

            }
        });
        clear.setLayoutX(650);
        clear.setLayoutY(555);
        clear.setPickOnBounds(true);
        clear.setPrefSize(50, 35);
        clear.setOnMouseEntered(mouseEn);
        clear.setOnMouseExited(mouseEx);

        sort = new Button("Sort");
        sort.setLayoutY(555);
        sort.setLayoutX(590);
        sort.setPrefSize(50, 35);
        sort.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sczytaj();
            }
        });
        sort.setOnMouseEntered(mouseEn);
        sort.setOnMouseExited(mouseEx);

        // Textfield
        TextField textField1 = new TextField();
        textField1.setEditable(false);
        textField1.setLayoutX(500);
        textField1.setLayoutY(50);
        textField1.setPrefSize(350,500);
        textField1.setAlignment(Pos.TOP_LEFT);
        textField1.setStyle("-fx-border-width: 2;\n" +
                "-fx-border-color: #000000;" +
                //" -fx-border-radius: 18 18 18 18;" +
                "-fx-background-radius: 18;" +
                "-fx-background-color: #ffffff;");



        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(textField1);
        scrollPane.setLayoutX(500);
        scrollPane.setLayoutY(50);
        scrollPane.setPrefSize(350, 500);
        scrollPane.setFitToWidth(true);



        // Imageview
        ImageView saveImg = new ImageView("saveImg.png");
        saveImg.setPickOnBounds(true);
        saveImg.setLayoutX(710);
        saveImg.setLayoutY(555);
        saveImg.setFitHeight(35);
        saveImg.setPreserveRatio(true);

        // group
        Group group = new Group();
        group.getChildren().add(textField);
        //group.getChildren().add(label);
        group.getChildren().addAll(b0, b1, b2, b3, b4, b5, b6, b7, clear, sort, saveImg);
        group.getChildren().add(textField1);
        group.getChildren().add(scrollPane);

        // scene
        scene1 = new Scene(group, 880, 600);
        scene1.setFill(Color.web("#ffffff"));
        scene1.getStylesheets().add("mystyles.css");

        // stage
        primaryStage.setScene(scene1);
        //primaryStage.setResizable(false);
        primaryStage.setTitle(("Shopping list"));
        primaryStage.show();


        // handlers
        // img
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
                if (label.getText().isEmpty()) {
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                    alert1.setHeaderText("ERROR");
                    alert1.setContentText("You cannot save an empty list!");
                    alert1.showAndWait();
                } else {
                    zapisz();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.getDialogPane().setContentText("");
                    alert.getDialogPane().setHeaderText("Zapisano!");
                    alert.showAndWait();
                }

            }
        });


    }

    ;


}



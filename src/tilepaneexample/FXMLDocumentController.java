/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilepaneexample;

import java.io.*;
import java.net.*;
import java.util.*;
import javafx.animation.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.util.*;

/**
 *
 * @author blj0011
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    VBox vbox1, vbox2, vbox3;
    @FXML
    VBox vbox1b, vbox2b, vbox3b;

    List<ImageView> imageViewContainer1a = new ArrayList();
    List<ImageView> imageViewContainer2a = new ArrayList();
    List<ImageView> imageViewContainer3a = new ArrayList();

    List<ImageView> imageViewContainer1b = new ArrayList();
    List<ImageView> imageViewContainer2b = new ArrayList();
    List<ImageView> imageViewContainer3b = new ArrayList();

    boolean currentRealTwo = true;

    int numberOfLetterImages = 27;
    final double vboxHeight = numberOfLetterImages * 100;
    Random random = new Random();

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        ((Button) event.getSource()).setDisable(true);

        String musicFile = "src/sound/slot_machine_winning.mp3";     // For example
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

        double random1 = 14 + (17 - 14) * random.nextDouble();
        double random2 = 14 + (17 - 14) * random.nextDouble();
        double random3 = 14 + (17 - 14) * random.nextDouble();

        AnimationTimer at = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime)
            {
                vbox1.setLayoutY(vbox1.getLayoutY() - random1);
                vbox1b.setLayoutY(vbox1b.getLayoutY() - random1);
                vbox2.setLayoutY(vbox2.getLayoutY() - random2);
                vbox2b.setLayoutY(vbox2b.getLayoutY() - random2);
                vbox3.setLayoutY(vbox3.getLayoutY() - random3);
                vbox3b.setLayoutY(vbox3b.getLayoutY() - random3);

                if (vbox1.getLayoutY() <= -vboxHeight) {
                    double delta = vboxHeight + vbox1.getLayoutY();
                    vbox1.setLayoutY(vboxHeight + delta);
                }

                if (vbox1b.getLayoutY() <= -vboxHeight) {
                    double delta = vboxHeight + vbox1b.getLayoutY();
                    vbox1b.setLayoutY(vboxHeight + delta);
                }

                if (vbox2.getLayoutY() <= -vboxHeight) {
                    double delta = vboxHeight + vbox2.getLayoutY();
                    vbox2.setLayoutY(vboxHeight + delta);
                }

                if (vbox2b.getLayoutY() <= -vboxHeight) {
                    double delta = vboxHeight + vbox2b.getLayoutY();
                    vbox2b.setLayoutY(vboxHeight + delta);
                }

                if (vbox3.getLayoutY() <= -vboxHeight) {
                    double delta = vboxHeight + vbox3.getLayoutY();
                    vbox3.setLayoutY(vboxHeight + delta);
                }

                if (vbox3b.getLayoutY() <= -vboxHeight) {
                    double delta = vboxHeight + vbox3b.getLayoutY();
                    vbox3b.setLayoutY(vboxHeight + delta);
                }
            }
        };
        at.start();

        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(event1 -> {
            at.stop();
            mediaPlayer.stop();
            String slotFace = "";

            int rounded1 = vbox1.getLayoutY() > 0 ? (int) Math.floor(vbox1.getLayoutY() / 100) * 100 : (int) Math.floor(vbox1.getLayoutY() / 100) * 100;
            int rounded1b = vbox1b.getLayoutY() > 0 ? (int) Math.floor(vbox1b.getLayoutY() / 100) * 100 : (int) Math.floor(vbox1b.getLayoutY() / 100) * 100;
            vbox1.setLayoutY(rounded1);
            vbox1b.setLayoutY(rounded1b);

            slotFace += getFaceValueFromHeight(rounded1);

            int rounded2 = vbox2.getLayoutY() > 0 ? (int) Math.floor(vbox2.getLayoutY() / 100) * 100 : (int) Math.floor(vbox2.getLayoutY() / 100) * 100;
            int rounded2b = vbox2b.getLayoutY() > 0 ? (int) Math.floor(vbox2b.getLayoutY() / 100) * 100 : (int) Math.floor(vbox2b.getLayoutY() / 100) * 100;
            vbox2.setLayoutY(rounded2);
            vbox2b.setLayoutY(rounded2b);

            slotFace += getFaceValueFromHeight(rounded2);

            int rounded3 = vbox3.getLayoutY() > 0 ? (int) Math.floor(vbox3.getLayoutY() / 100) * 100 : (int) Math.floor(vbox3.getLayoutY() / 100) * 100;
            int rounded3b = vbox3b.getLayoutY() > 0 ? (int) Math.floor(vbox3b.getLayoutY() / 100) * 100 : (int) Math.floor(vbox3b.getLayoutY() / 100) * 100;
            vbox3.setLayoutY(rounded3);
            vbox3b.setLayoutY(rounded3b);

            System.out.println("slot face int: " + rounded1 + ":" + rounded2 + ":" + rounded3);
            slotFace += getFaceValueFromHeight(rounded3);

            System.out.println(slotFace);
            System.out.println("Winner: " + checkForWinner(slotFace));
            ((Button) event.getSource()).setDisable(false);
        });
        delay.play();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        File folder = new File("src/images/Wood");

        for (File entry : folder.listFiles()) {
            ImageView a = new ImageView(new Image(entry.toURI().toString()));
            a.setFitHeight(100);
            a.setFitWidth(100);
            imageViewContainer1a.add(a);

            ImageView b = new ImageView(new Image(entry.toURI().toString()));
            b.setFitHeight(100);
            b.setFitWidth(100);
            imageViewContainer2a.add(b);

            ImageView c = new ImageView(new Image(entry.toURI().toString()));
            c.setFitHeight(100);
            c.setFitWidth(100);
            imageViewContainer3a.add(c);

            ImageView a2 = new ImageView(new Image(entry.toURI().toString()));
            a2.setFitHeight(100);
            a2.setFitWidth(100);
            imageViewContainer1b.add(a2);

            ImageView b2 = new ImageView(new Image(entry.toURI().toString()));
            b2.setFitHeight(100);
            b2.setFitWidth(100);
            imageViewContainer2b.add(b2);

            ImageView c2 = new ImageView(new Image(entry.toURI().toString()));
            c2.setFitHeight(100);
            c2.setFitWidth(100);
            imageViewContainer3b.add(c2);
        }

        vbox1.getChildren().addAll(imageViewContainer1a);
        vbox2.getChildren().addAll(imageViewContainer2a);
        vbox3.getChildren().addAll(imageViewContainer3a);

        vbox1b.getChildren().addAll(imageViewContainer1b);
        vbox2b.getChildren().addAll(imageViewContainer2b);
        vbox3b.getChildren().addAll(imageViewContainer3b);

        vbox1b.setLayoutY(vboxHeight);
        vbox2b.setLayoutY(vboxHeight);
        vbox3b.setLayoutY(vboxHeight);
    }

    private String getFaceValueFromHeight(int height)
    {
        switch (height) {
            case 0:
            case 2700:
            case -2700:
                return "*";
            case -100:
            case 2600:
                return "A";
            case -200:
            case 2500:
                return "B";
            case -300:
            case 2400:
                return "C";
            case -400:
            case 2300:
                return "D";
            case -500:
            case 2200:
                return "E";
            case -600:
            case 2100:
                return "F";
            case -700:
            case 2000:
                return "G";
            case -800:
            case 1900:
                return "H";
            case -900:
            case 1800:
                return "I";
            case -1000:
            case 1700:
                return "J";
            case -1100:
            case 1600:
                return "K";
            case -1200:
            case 1500:
                return "L";
            case -1300:
            case 1400:
                return "M";
            case -1400:
            case 1300:
                return "N";
            case -1500:
            case 1200:
                return "O";
            case -1600:
            case 1100:
                return "P";
            case -1700:
            case 1000:
                return "Q";
            case -1800:
            case 900:
                return "R";
            case -1900:
            case 800:
                return "S";
            case -2000:
            case 700:
                return "T";
            case -2100:
            case 600:
                return "U";
            case -2200:
            case 500:
                return "V";
            case -2300:
            case 400:
                return "W";
            case -2400:
            case 300:
                return "X";
            case -2500:
            case 200:
                return "Y";
            case -2600:
            case 100:
                return "Z";
        }

        return "error! in method getFaceValueFromHeight";
    }

    private boolean checkForWinner(String string)
    {
        boolean control = false;

        if (string.length() - string.replace("*", "").length() == 3) {
            control = true;
        }
        else if (string.length() - string.replace("*", "").length() == 1) {
            control = true;
        }
        else if (string.length() - string.replace("*", "").length() == 2) {
            control = true;
        }
        else if (string.codePointAt(0) == string.codePointAt(1) && string.codePointAt(1) == string.codePointAt(2)) {
            control = true;
        }

        return control;
    }

}

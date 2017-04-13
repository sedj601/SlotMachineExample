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

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        ((Button) event.getSource()).setDisable(true);
        System.out.println("Start: " + vbox1.getLayoutY() + " : " + vbox1b.getLayoutY());
        //final long startNanoTime = System.nanoTime();

        AnimationTimer at = new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime)
            {
                //double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                
                vbox1.setLayoutY(vbox1.getLayoutY() - 15.7);
                vbox1b.setLayoutY(vbox1b.getLayoutY() - 15.7);
                vbox2.setLayoutY(vbox2.getLayoutY() - 16.13);
                vbox2b.setLayoutY(vbox2b.getLayoutY() - 16.13);
                vbox3.setLayoutY(vbox3.getLayoutY() - 24.56);
                vbox3b.setLayoutY(vbox3b.getLayoutY() - 24.56);

                if (vbox1.getLayoutY() <= -vboxHeight) {
                    double delta = vboxHeight + vbox1.getLayoutY();
                    //System.out.println(vbox1.getLayoutY() + " : " + vboxHeight + " delta: " + delta);
                    vbox1.setLayoutY(vboxHeight + delta);
                }

                if (vbox1b.getLayoutY() <= -vboxHeight) {
                    double delta = vboxHeight + vbox1b.getLayoutY();
                    //System.out.println(vbox1b.getLayoutY() + " : " + vboxHeight + " delta: " + delta);
                    vbox1b.setLayoutY(vboxHeight + delta);
                }

                if (vbox2.getLayoutY() <= -vboxHeight) {
                    double delta = vboxHeight + vbox2.getLayoutY();
                    //System.out.println(vbox2.getLayoutY() + " : " + vboxHeight + " delta: " + delta);
                    vbox2.setLayoutY(vboxHeight + delta);
                }

                if (vbox2b.getLayoutY() <= -vboxHeight) {
                    double delta = vboxHeight + vbox2b.getLayoutY();
                    //System.out.println(vbox2b.getLayoutY() + " : " + vboxHeight + " delta: " + delta);
                    vbox2b.setLayoutY(vboxHeight + delta);
                }

                if (vbox3.getLayoutY() <= -vboxHeight) {
                    double delta = vboxHeight + vbox3.getLayoutY();
                    //System.out.println(vbox3.getLayoutY() + " : " + vboxHeight + " delta: " + delta);
                    vbox3.setLayoutY(vboxHeight + delta);
                }

                if (vbox3b.getLayoutY() <= -vboxHeight) {
                    double delta = vboxHeight + vbox3b.getLayoutY();
                    //System.out.println(vbox3b.getLayoutY() + " : " + vboxHeight + " delta: " + delta);
                    vbox3b.setLayoutY(vboxHeight + delta);
                }
            }
        };
        at.start();

        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(event1 -> {
            at.stop();
            int rounded1 = vbox1.getLayoutY() > 0 ? (int)Math.floor(vbox1.getLayoutY()/100) * 100 : (int)Math.floor(vbox1.getLayoutY()/100) * 100;
            int rounded1b = vbox1b.getLayoutY() > 0 ? (int)Math.floor(vbox1b.getLayoutY()/100) * 100 : (int)Math.floor(vbox1b.getLayoutY()/100) * 100;
            vbox1.setLayoutY(rounded1);
            vbox1b.setLayoutY(rounded1b);
            
            int rounded2 = vbox2.getLayoutY() > 0 ? (int)Math.floor(vbox2.getLayoutY()/100) * 100 : (int)Math.floor(vbox2.getLayoutY()/100) * 100;
            int rounded2b = vbox2b.getLayoutY() > 0 ? (int)Math.floor(vbox2b.getLayoutY()/100) * 100 : (int)Math.floor(vbox2b.getLayoutY()/100) * 100;
            vbox2.setLayoutY(rounded2);
            vbox2b.setLayoutY(rounded2b);
            
            int rounded3 = vbox3.getLayoutY() > 0 ? (int)Math.floor(vbox3.getLayoutY()/100) * 100 : (int)Math.floor(vbox3.getLayoutY()/100) * 100;
            int rounded3b = vbox3b.getLayoutY() > 0 ? (int)Math.floor(vbox3b.getLayoutY()/100) * 100 : (int)Math.floor(vbox3b.getLayoutY()/100) * 100;
            vbox3.setLayoutY(rounded3);
            vbox3b.setLayoutY(rounded3b);
            
            
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

}

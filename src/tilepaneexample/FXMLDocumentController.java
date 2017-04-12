/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tilepaneexample;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author blj0011
 */
public class FXMLDocumentController implements Initializable
{
    
    @FXML VBox vbox1, vbox2, vbox3;
    @FXML VBox vbox1b, vbox2b, vbox3b;
    
    List<ImageView> imageViewContainer1a = new ArrayList();
    List<ImageView> imageViewContainer2a = new ArrayList();
    List<ImageView> imageViewContainer3a = new ArrayList();
    
    List<ImageView> imageViewContainer1b = new ArrayList();
    List<ImageView> imageViewContainer2b = new ArrayList();
    List<ImageView> imageViewContainer3b = new ArrayList();
    
    int currentFrame = 0;
    long lastTimeFPS = 0;    
    double realOneCurrentHeight = 0;
    double realTwoCurrentHeight = 0;
    double realThreeCurrentHeight = 0;    
    
    boolean currentRealTwo = true;
     
    final  double vboxHeight = 200;
    
    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        
               
        vbox1b.setLayoutY(vboxHeight); 
        vbox2b.setLayoutY(vboxHeight);
        vbox3b.setLayoutY(vboxHeight);
        
        final long startNanoTime = System.nanoTime();
       
        new AnimationTimer()
        {
            @Override
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
               
                vbox1.setLayoutY(vbox1.getLayoutY() - 10);
                vbox1b.setLayoutY(vbox1b.getLayoutY() - 10);
                vbox2.setLayoutY(vbox2.getLayoutY() - 5);
                vbox2b.setLayoutY(vbox2b.getLayoutY() - 5);
                vbox3.setLayoutY(vbox3.getLayoutY() - 15);
                vbox3b.setLayoutY(vbox3b.getLayoutY() - 15);
                
                if(vbox1.getLayoutY() <= -vboxHeight)
                {                    
                    double delta = vboxHeight + vbox1.getLayoutY();
                    //System.out.println(vbox1.getLayoutY() + " : " + vboxHeight + " delta: " + delta);
                    vbox1.setLayoutY(vboxHeight + delta);
                }
                
                if(vbox1b.getLayoutY() <= -vboxHeight)
                {
                    double delta = vboxHeight + vbox1b.getLayoutY();
                    //System.out.println(vbox1b.getLayoutY() + " : " + vboxHeight + " delta: " + delta);
                    vbox1b.setLayoutY(vboxHeight + delta);
                } 
                
                if(vbox2.getLayoutY() <= -vboxHeight)
                {                    
                    double delta = vboxHeight + vbox2.getLayoutY();
                    System.out.println(vbox2.getLayoutY() + " : " + vboxHeight + " delta: " + delta);
                    vbox2.setLayoutY(vboxHeight + delta);
                }
                
                if(vbox2b.getLayoutY() <= -vboxHeight)
                {
                    double delta = vboxHeight + vbox2b.getLayoutY();
                    System.out.println(vbox2b.getLayoutY() + " : " + vboxHeight + " delta: " + delta);
                    vbox2b.setLayoutY(vboxHeight + delta);
                } 
                
                if(vbox3.getLayoutY() <= -vboxHeight)
                {                    
                    double delta = vboxHeight + vbox3.getLayoutY();
                    //System.out.println(vbox3.getLayoutY() + " : " + vboxHeight + " delta: " + delta);
                    vbox3.setLayoutY(vboxHeight + delta);
                }
                
                if(vbox3b.getLayoutY() <= -vboxHeight)
                {
                    double delta = vboxHeight + vbox3b.getLayoutY();
                    //System.out.println(vbox3b.getLayoutY() + " : " + vboxHeight + " delta: " + delta);
                    vbox3b.setLayoutY(vboxHeight + delta);
                }                
            }
        }.start();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {        
        File folder = new File("src/images/Wood");
        
        for(File entry : folder.listFiles())
        {
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
    }    
    
}

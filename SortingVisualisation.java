/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingvisualisation;

import java.util.ArrayList;
import java.util.Collections;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Ranjeth
 */
public class SortingVisualisation extends Application {

    public static Group root;
    Scene scene;
    public static double screenW = 1200, screenH = 720;
    
    public static int i = 0, width = 5;

    public static ArrayList<Element> arr = new ArrayList<>();
    
    AnimationTimer animation;

    @Override
    public void start(Stage primaryStage) {

        root = new Group();

        scene = new Scene(root, screenW, screenH);
        scene.setFill(Color.BLACK);

        drawArray();
        
        update();

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void drawArray(){
        for (int j = 0; j < screenW; j+=width) {
            arr.add(new Element(j,screenH));
        }
    }    
    
    public void update() {
        animation = new AnimationTimer() {
            @Override
            public void handle(long now) {
                bubbleSort();
            }
        };
        animation.start();
                
    }
    
    public void bubbleSort(){
        if (i < arr.size()-1) {
            for (int j = 0; j < arr.size()-i-1; j++) {
                if (arr.get(j).height < arr.get(j+1).height) {
                    Collections.swap(arr, j, j+1);
                    arr.get(j).move(arr.get(j+1));        
                }
            }
        }else{
            System.out.println("Fin");
            animation.stop();
        }
        i++;
    }
    

}

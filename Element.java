/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingvisualisation;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 *
 * @author Ranjeth
 */
public class Element {

    double x, y, height;
    Line shape;

    public Element(double x, double y) {
        this.x = x;
        this.y = y;
        this.height = Math.random() * SortingVisualisation.screenH;

        this.shape = new Line(this.x, this.y, this.x, this.height);
        this.shape.setFill(null);
        this.shape.setStroke(Color.WHITE);
        this.shape.setStrokeWidth(SortingVisualisation.width);

        SortingVisualisation.root.getChildren().add(shape);
    }

    void move(Element get) {
        double tempX = get.x;
        
        get.x = this.x;
        this.x = tempX;

        
        this.shape.setStartX(this.x);
        this.shape.setEndX(this.x);

        
        get.shape.setStartX(get.x);
        get.shape.setEndX(get.x);

    }

}

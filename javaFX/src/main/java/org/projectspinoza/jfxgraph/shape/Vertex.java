package org.projectspinoza.jfxgraph.shape;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Vertex extends Rectangle {
    
    Text label;
    List<Vertex> childs = new ArrayList<Vertex>();
    
    public Vertex(String id){
        super();
    }

    public Vertex(double startX, double startY, double endX, double endY, String text){
        super(startX, startY, endX, endY);
        this.setStroke(Color.BLUE);        
        this.setFill(Color.TRANSPARENT);
        this.setArcWidth(12);
        this.setArcHeight(12);
        
        this.label = new Text(text);
        
        this.label.xProperty().bind(this.xProperty().add(5));
        this.label.yProperty().bind(this.yProperty().add(this.heightProperty()).subtract(10));
        
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                System.out.println("x: "+event.getX()+", y: "+event.getY());
            }});
    }
    
    public void addChild(Vertex child) {
        childs.add(child);
    }
    
    public List<Vertex> getChilds(){
        return this.childs;
    }
    public Text getLabel(){
        return this.label;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((label == null) ? 0 : label.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (label == null) {
            if (other.label != null)
                return false;
        } else if (!label.getText().equals(other.label.getText()))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Vertex [label=" + label + ", childs=" + childs + "]";
    }
    
}

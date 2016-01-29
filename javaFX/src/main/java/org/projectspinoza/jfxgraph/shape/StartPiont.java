package org.projectspinoza.jfxgraph.shape;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class StartPiont extends Application{
	public final int panelwidth = 500;
	public final int panelhieght = 700;
	
	public static void main(String[] args) {
    	launch(args);
    }
    
    @Override
    public void start(Stage stage){
    	double nodeWidth = 60;
    	double nodeHeight = 30;
    	 Group root = new Group();
        Scene scene = new Scene(root,panelwidth,panelhieght, Color.WHITE);
 
        Vertex rootNode = new Vertex(250, 25, nodeWidth, nodeHeight, "parent");
        
        RelationBuilder rb = new RelationBuilder(rootNode);
        
        Vertex c1 = new Vertex(0, 0, nodeWidth, nodeHeight, "child1");
        Vertex c2 = new Vertex(0, 0, nodeWidth, nodeHeight, "child2");
        Vertex c3 = new Vertex(0, 0, nodeWidth, nodeHeight, "child3");
        Vertex c4 = new Vertex(0, 0, nodeWidth, nodeHeight, "child4");
        Vertex c5 = new Vertex(0, 0, nodeWidth, nodeHeight, "child5");
        Vertex c6 = new Vertex(0, 0, nodeWidth, nodeHeight, "child6");
        Vertex c7 = new Vertex(0, 0, nodeWidth, nodeHeight, "child7");
        Vertex c8 = new Vertex(0, 0, nodeWidth, nodeHeight, "child8");
        Vertex c9 = new Vertex(0, 0, nodeWidth, nodeHeight, "child9");
        Vertex c10 = new Vertex(0, 0, nodeWidth, nodeHeight, "child10");
        Vertex c11 = new Vertex(0, 0, nodeWidth, nodeHeight, "child11");
        
        Vertex c12 = new Vertex(0, 0, nodeWidth, nodeHeight, "child12");
        Vertex c13 = new Vertex(0, 0, nodeWidth, nodeHeight, "child13");
        
        Vertex c14 = new Vertex(0, 0, nodeWidth, nodeHeight, "child14");
        Vertex c15 = new Vertex(0, 0, nodeWidth, nodeHeight, "child15");
        Vertex c16 = new Vertex(0, 0, nodeWidth, nodeHeight, "child16");
        
        Vertex c17 = new Vertex(0, 0, nodeWidth, nodeHeight, "child17");
        Vertex c18 = new Vertex(0, 0, nodeWidth, nodeHeight, "child18");
        Vertex c19 = new Vertex(0, 0, nodeWidth, nodeHeight, "child19");
        
        
//        rb.addChild(rootNode, c3);
        Vertex x2  = rb.getVertex("parent");
        
        
 //       Vertex child1 = setChild(x2,c1);        
        rb.addChild(x2, c1); 
//        Vertex child2 = setChild(x2, c2);
        rb.addChild(x2, c2);  
//        Vertex child3 = setChild(x2,c3);        
        rb.addChild(x2, c3);      
 //       Vertex child4 = setChild(x2,c4);        
        rb.addChild(x2, c4);
       
 //       Vertex child6 = setChild(c1, c6);
        rb.addChild(c1, c6);
//        Vertex child7 = setChild(c1, c7);
        rb.addChild(c1, c7);        
//        Vertex child8 = setChild(c1, c8);
        rb.addChild(c1, c8);
//        Vertex child10 = setChild(c1, c10);
        rb.addChild(c1, c10);
//         Vertex child11 = setChild(c1, c11);
        rb.addChild(c1, c11);
        
 //       Vertex child5 = setChild(c2, c5);
        rb.addChild(c2, c5);
//        Vertex child9 = setChild(c2, c9);
        rb.addChild(c2, c9);

 //       Vertex child12 = setChild(c4, c12);
        rb.addChild(c4, c12);
 //        Vertex child13 = setChild(c4, c13);
        rb.addChild(c4, c13);
        
//        Vertex child14 = setChild(c11, c14);
        rb.addChild(c11, c14);
 //        Vertex child15 = setChild(c11, c15);
        rb.addChild(c11, c15);
        
//        Vertex child16 = setChild(c13, c16);
        rb.addChild(c13, c16);
//        Vertex child17 = setChild(c13, c17);
        rb.addChild(c13, c17);
 //       Vertex child18 = setChild(c13, c18);
        rb.addChild(c13, c18);
//        Vertex child19 = setChild(c13, c19);
        rb.addChild(c13, c19);
     
        System.out.println();
        root.getChildren().add(rb);
        
        rb.build();
        stage.setHeight(700);
        stage.setWidth(1000);
        stage.setTitle("JavaFX Scene Graph Demo");
        stage.setScene(scene);
        stage.show(); 
    }
    
//	public Vertex setChild(Vertex parent, Vertex child) {
//		
//		int childsCount = parent.getChilds().size();
//		int distance = 60;
//		
//		child.setY(parent.getY() + distance);
//		double xaxis = parent.getX();
//		
//		if (childsCount != 0) {
//
//			xaxis = parent.getX()-((childsCount)*30);
//			
//			for(int i= 0; i < childsCount; i++){
//
//				parent.getChilds().get(i).setX(xaxis);
//				xaxis += 100;	
//			}
//			child.setX(xaxis);
//		}else{
//			child.setX(xaxis);
//		}
//		return child;
//	}
	
	/// collision detection
	private void checkShapeIntersection(Rectangle rect) {
		ArrayList<Rectangle> nodes = new ArrayList<Rectangle>();
		boolean collisionDetected = false;
		for (Shape static_bloc : nodes) {
			if (static_bloc != rect) {
				static_bloc.setFill(Color.GREEN);
				Shape intersect = Shape.intersect(rect, static_bloc);
				if (intersect.getBoundsInLocal().getWidth() != -1) {
					collisionDetected = true;
				}
			}
		}
		if (collisionDetected) {
			System.out.println("collied");
		}
	}
}

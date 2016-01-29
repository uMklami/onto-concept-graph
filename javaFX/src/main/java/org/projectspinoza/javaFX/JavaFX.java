package org.projectspinoza.javaFX;

import java.util.Map;

import javafx.application.Application;

public abstract class JavaFX extends Application {

    public static void main(String[] args) {
    	
     //   TabbedApp.launch(TabbedApp.class);
    }
    
    public static void setData( Map<String, Object> data){
    	BubbleGraph.setMap(data);
    	PieGraph.setMap(data);
//    	System.out.println("MAP DATA : "+data);
    }

}

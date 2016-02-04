package org.projectspinoza.ontology.javafx;

import java.util.List;
import java.util.Map;

import javafx.application.Application;

import org.projectspinoza.ontology.util.Term;

public abstract class JavaFX extends Application {

    public static void main(String[] args) {
    }
    
    public static void setData( Map<String, Object> data, List<Term> hierarchicalData){
    	BubbleGraph.setMap(data);
    	PieGraph.setMap(data);
    	TreeGraph.setOntoData(hierarchicalData);
    }
}

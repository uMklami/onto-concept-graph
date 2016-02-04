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
    
//    public static Vertix getVertix(List<Term> ontologyResult){
//        Vertix root = new Vertix("ontology");
//        RelationBuilder rb = new RelationBuilder(root);
//        for (Term term : ontologyResult) {
//        	Vertix vt = new Vertix(term.getTerm().trim().toLowerCase());
//        		rb.addChild(root, vt);
//			if (term.getChilds() != null) {
//				for (Term child : term.getChilds()) {
//					Vertix vt2 = new Vertix(child.getTerm().trim().toLowerCase());
//					rb.addChild(vt, vt2);
//					if (child.getChilds() != null) {
//						for (Term subchild : child.getChilds()) {
//							Vertix vt3 = new Vertix(subchild.getTerm().trim().toLowerCase());
//							rb.addChild(vt2, vt3);
//						}
//					}
//				}
//			}
//		}
//        return root;
//    }
}

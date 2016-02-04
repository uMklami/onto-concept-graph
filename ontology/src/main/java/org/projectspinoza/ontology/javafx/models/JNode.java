package org.projectspinoza.ontology.javafx.models;

public class JNode {
	 int id;
     String label;
     static int nodeCount = 0;
     /**
      * Creates node with unique id, and label
      * @param id
      * @param label
      */
     public JNode(String label) {
         this.id = nodeCount++;
         this.label = label;
     }
     public String toString() {
         return label;
     }        
}

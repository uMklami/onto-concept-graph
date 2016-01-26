package org.projectspinoza.concept.models;

import java.util.ArrayList;
import java.util.List;

public class TagConceptNet {

    private String concept;
    private List<Relation> relations;
    
    public TagConceptNet(){
    }
    
    public TagConceptNet(String concept, List<Relation> relations) {
        this.concept = concept;
        this.relations = relations;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public List<Relation> getRelations() {
        return relations;
    }

    public void setRelations(List<Relation> relations) {
        this.relations = relations;
    }

    public void addConcept(Relation relation) {
        if (relations == null) {
            relations = new ArrayList<Relation>();
        }
        relations.add(relation);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(concept)
        .append(relations);
        return sb.toString();
    }

}

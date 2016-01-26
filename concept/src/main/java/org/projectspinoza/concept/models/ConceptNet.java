package org.projectspinoza.concept.models;

import java.util.List;

public class ConceptNet {

    private List<Object> edges;
    private String numFound;

    public ConceptNet() {

    }

    public List<Object> getEdges() {
        return edges;
    }

    public void setEdges(List<Object> edges) {
        this.edges = edges;
    }

    public String getNumFound() {
        return numFound;
    }

    public void setNumFound(String numFound) {
        this.numFound = numFound;
    }

    @Override
    public String toString() {
        return "ConceptNet [edges=" + edges + ", numFound=" + numFound + "]";
    }
}

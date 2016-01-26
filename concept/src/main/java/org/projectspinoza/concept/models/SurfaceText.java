package org.projectspinoza.concept.models;

public class SurfaceText {

    private String tag;
    private String surfaceText;
    private Double weight = 0.0;

    public SurfaceText(String tag, String surfaceText, Double weight) {       
            this.tag = tag;
            setSurfaceText(surfaceText);
            this.weight = weight;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSurfaceText() {
        return surfaceText;
    }

    public void setSurfaceText(String surfaceText) {
        this.surfaceText = surfaceText;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(surfaceText);
        return sb.toString();
    }
}

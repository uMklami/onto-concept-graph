package org.projectspinoza.concept.models;

public class Relation {

    private String relType;
    private SurfaceText surfaceTextStart;
    private SurfaceText surfaceTextEnd;

    public Relation(String reltype, SurfaceText surfaceText) {
        this.relType = reltype;
        if (surfaceText.getTag().equals("start")) {
            setSurfaceTextStart(surfaceText);
        }else{
            setSurfaceTextEnd(surfaceText);
        }
    }

    public String getRelType() {
        return relType;
    }

    public void setRelType(String relType) {
        this.relType = relType;
    }
    
    public SurfaceText getSurfaceTextStart() {
        return surfaceTextStart;
    }

    public void setSurfaceTextStart(SurfaceText surfaceText) {
        if(surfaceTextStart != null){
            surfaceTextStart = surfaceTextStart.getWeight() < surfaceText.getWeight() ? surfaceText : surfaceTextStart; 
        }else{
            surfaceTextStart = surfaceText;
        }
    }

    public SurfaceText getSurfaceTextEnd() {
        return surfaceTextEnd;
    }

    public void setSurfaceTextEnd(SurfaceText surfaceText) {
        if(surfaceTextEnd != null){
            surfaceTextEnd = surfaceTextEnd.getWeight() < surfaceText.getWeight() ? surfaceText : surfaceTextEnd; 
        }else{
            surfaceTextEnd = surfaceText;
        }
    }

    @Override
    public String toString() {
        return "relType=" + relType + ",surfaceText ["
                + surfaceTextStart + "\\\n" + surfaceTextEnd +"]";
    }

}

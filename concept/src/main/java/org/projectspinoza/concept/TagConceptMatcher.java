package org.projectspinoza.concept;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.projectspinoza.concept.models.Relation;
import org.projectspinoza.concept.models.SurfaceText;
import org.projectspinoza.concept.models.TagConceptNet;
import org.projectspinoza.concept.utils.DataParser;

public class TagConceptMatcher {
    
    private static Logger log = LogManager.getRootLogger();
    ObjectMapper mapper = new ObjectMapper();

    public TagConceptMatcher() {
    }

    public List<TagConceptNet> getConcepts(Set<String> tags, String rel) {
        List<TagConceptNet> tagConcepts = new ArrayList<TagConceptNet>();
        for (String tag : tags) {
            log.debug("Runing ConceptNet for "+tag+"...");
            String result = DataParser.getData(tag, rel);
            if(result == null || result == ""){
            log.debug("No data found for tag: "+tag);
            return tagConcepts;
            }
            List<Relation> conceptRelations = getRelations(tag, result);
            tagConcepts.add(new TagConceptNet(tag, conceptRelations));
        }
       return tagConcepts;
    }

    @SuppressWarnings("unchecked")
    public List<Relation> getRelations(String word, String edges) {
        List<Relation> relations = new ArrayList<Relation>();
        SurfaceText surfaceText = null;
        try {
            List<Object> objects = mapper.readValue(edges, ArrayList.class);

            for (Object edge : objects) {

                Map<String, Object> attributes = (Map<String, Object>) edge;

                String rel = (String) attributes.get("rel");
                String start = (String) attributes.get("start");
                String end = (String) attributes.get("end");
                Double weight = (Double) attributes.get("weight");
                String text = (String) attributes.get("surfaceText");
                if (text == null) {
                    continue;
                }
                    text = text.replaceAll("[\\[\\]]", "");
                    rel = rel.replace("/r/", "");
                    start = start.replace("/c/en/", "");
                    end = end.replace("/c/en/", "");
                    
                    if (start.contains(word)) {
                        surfaceText = new SurfaceText("start", text, weight);
                    } else if(end.contains(word)){
                        surfaceText = new SurfaceText("end", text, weight);
                    }
                    if (relations.size() == 0) {
                        relations.add(new Relation(rel, surfaceText));
                    } else {
                        addToRelations(relations,
                                new Relation(rel, surfaceText));
                    }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return relations;
    }

    public void addToRelations(List<Relation> relations, Relation other) {
       
        for (int i = 0; i < relations.size(); i++) {
            if (relations.get(i).getRelType().equals(other.getRelType())) {
                if (other.getSurfaceTextStart() != null) {
                    relations.get(i).setSurfaceTextStart(other.getSurfaceTextStart());
                } else {
                    relations.get(i).setSurfaceTextEnd(other.getSurfaceTextEnd());
                }
                return;
            } 
        }
        log.debug("Adding relation of type ["+other.getRelType()+"]");
        relations.add(other);
    }
}

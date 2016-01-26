package org.projectspinoza.concept.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.projectspinoza.concept.models.ConceptNet;

public class DataExtractor {

    static ObjectMapper mapper;

    public static ConceptNet getCurlData(String keyword) {
        URL url;
        StringBuilder response = new StringBuilder();
        try {
            url = new URL("http://localhost:8080//concept/c/en?tag="+ keyword);
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    url.openStream(), "UTF-8"));
            if (reader.toString() == "") {
                System.out.println("No result found");
                System.exit(0);
            }
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String conceptNetData = response.toString();
        
        return parse(conceptNetData);
    }

    public static ConceptNet parse(String response) {

        ConceptNet conepts = new ConceptNet();
        mapper = new ObjectMapper();
        try {
            conepts = mapper.readValue(response,
                    new TypeReference<ConceptNet>() {});

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conepts;
    }

//    @SuppressWarnings("unchecked")
//    public List<TagConcept> getSurfaceText(ConceptNet concepts, String word) {
//
//        List<TagConcept> tagConcepts = new ArrayList<TagConcept>();
//
//        for (Object edge : concepts.getEdges()) {
//            try {
//                Map<String, Object> attributes = (Map<String, Object>) edge;
//
//                String relation = (String) attributes.get("rel");
//                String start = (String) attributes.get("start");
//                String end = (String) attributes.get("end");
//                Double weight = (Double) attributes.get("weight");
//                String surfaceText = (String) attributes.get("surfaceText");
//                if (surfaceText != null) {
//                    surfaceText =  surfaceText.replaceAll("[\\[\\]]", "");
//                    relation = relation.replace("/r/", "");
//                    start = start.replace("/c/en/", "");
//                    end = end.replace("/c/en/", "");
//
//                    if (tagConcepts.isEmpty()) {
//                        if (start.contains(word)) {
//                            tagConcepts.add(new TagConcept("start", relation, weight, surfaceText));
//                        } else if (end.contains(word)) {
//                            tagConcepts.add(new TagConcept("end", relation, weight, surfaceText));
//                        }
//                    } else {
//                        for (int j = 0; j < tagConcepts.size(); j++) {
//
//                            if (tagConcepts.get(j).getRelationtType().equals(relation)) {
//
//                                Double old_weight_start = tagConcepts.get(j).getWeightStart();
//                                Double old_weight_end = tagConcepts.get(j).getWeightEnd();
//
//                                if (start.contains(word)
//                                        && weight > old_weight_start) {
//                                    tagConcepts.get(j).setWeight_start(weight);
//                                    tagConcepts.get(j).setSurfaceTextStart(surfaceText);
//
//                                } else if (end.contains(word)
//                                        && weight > old_weight_end) {
//                                    tagConcepts.get(j).setWeightEnd(weight);
//                                    tagConcepts.get(j).setSurfaceTextEnd(surfaceText);
//                                }
//                                break;
//                            } else if (j != tagConcepts.size() - 1) {
//                                continue;
//                            } else {
//                                if (start.contains(word)) {
//                                    tagConcepts.add(new TagConcept("start", relation, weight, surfaceText));
//                                } else if (end.contains(word)) {
//                                    tagConcepts.add(new TagConcept("end", relation, weight, surfaceText));
//                                }
//                                break;
//                            }
//                        }
//                    }
//                }
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//        return tagConcepts;
//    }

}

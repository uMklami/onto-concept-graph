package org.projectspinoza.ontology;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.projectspinoza.concept.TagConceptMatcher;
import org.projectspinoza.concept.models.TagConceptNet;
import org.projectspinoza.javaFX.Chart;

public class Main {
    private static Logger log = LogManager.getRootLogger();
    public static Set<String> tweetTags = new HashSet<String>();
    static TermOntologyMatcher termOntologyMatcher;
    
    public static void main(String[] args) {
        if (args.length != 2) {
            log.error("Please provide two arguments, e.g tweets.txt ontologies.json");
            System.exit(0);
        }
        log.info("Initializing ontologies!");
        termOntologyMatcher = new TermOntologyMatcher(args[0], args[1]);
        Map<String,Object> onotolgy = termOntologyMatcher.getOntology();
        OntoConceptResultGenerator.generatFile("ontology_result", onotolgy);
        tweetTags = termOntologyMatcher.getConceptTweetTags();
        log.info("Done with Ontology!");
        log.info("Initializing conceptNet...");
        List<TagConceptNet> concepts = new TagConceptMatcher().getConcepts(tweetTags);
        OntoConceptResultGenerator.generatFile("conceptNet_result", concepts);
        log.info("Done with conceptNet!");
 //       new Chart().setData_map(termOntologyMatcher.getTags());
        Chart.launch(args);
    }
}

package org.projectspinoza.concept;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.projectspinoza.concept.models.TagConceptNet;
import org.projectspinoza.concept.utils.OntoConceptResultGenerator;

/**
 * author : OrbitSoft
 *
 */
public class Main 
{
    public static Set<String> tags = new HashSet<String>();
    private static Logger log = LogManager.getRootLogger();
    public static void main( String[] args ) throws IOException
    {
      log.info("Inside Concept Main....");
      tags.add("bmw");
      tags.add("morning");
      tags.add("coffee");
      
      List<TagConceptNet> concepts = new TagConceptMatcher().getConcepts(tags, "AtLocation");
      OntoConceptResultGenerator.generatFile("conceptNet_result", concepts);
      log.info("Done with conceptNet!");
    }
}

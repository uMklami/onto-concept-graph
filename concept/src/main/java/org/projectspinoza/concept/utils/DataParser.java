package org.projectspinoza.concept.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

public class DataParser {

    static ObjectMapper mapper;

    public static String getData(String tag, String rel) {
        URL url;
        String line;
        StringBuilder result = new StringBuilder();
        try {
            if(rel == null){
                url = new URL("http://localhost:8080//concept/c/en?tag="+tag);
            }else{
                url = new URL("http://localhost:8080//concept/search?rel="+rel+"&start="+tag);
            } 
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            if (reader.toString() == "") {
                System.out.println("No result found");
                System.exit(0);
            }
            while ((line= reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
        } catch (UnsupportedEncodingException e) {
           // e.printStackTrace();
        } catch (IOException e) {
           // e.printStackTrace();
        }
        
        return result.toString();
    }

}
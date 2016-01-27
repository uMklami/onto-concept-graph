package org.projectspinoza.javaFX;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;

public abstract class Main extends Application {

    public static void main(String[] args) {
//       JavaFXtest jfx = new JavaFXtest();
//       JavaFXtest.launch(JavaFXtest.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("car", new int[] { 2, 6 });
        map.put("bmw", new int[] { 8, 16 });
        map.put("coffee", new int[] { 1, 5 });
        map.put("watch", new int[] { 2, 6 });
        map.put("boom", new int[] { 22, 31 });
        map.put("wasim", new int[] { 13, 18 });
        map.put("imran", new int[] { 22, 16 });
        map.put("watch", new int[] { 21, 36 });
        map.put("watch", new int[] { 12, 26 });
        map.put("lamp", new int[] { 8, 20 });
        
//       Chart c =  new Chart(map);
//        c.getMap();
//        
        //c.start(null);
       Chart.setMap(map);
       Chart.launch(Chart.class);
    }

}

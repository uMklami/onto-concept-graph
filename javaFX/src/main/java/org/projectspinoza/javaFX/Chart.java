package org.projectspinoza.javaFX;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Chart extends Application {
    
    private static Map<String, Object> data_map ;
    
    public Chart(){
        super();
    }

    public static void setMap(Map<String, Object> map) {
        data_map = map;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void start(Stage stage) throws Exception {
        // For testing purpose...
//        Map<String, Object> map = this.getMap();
//        map.put("car", new int[]{2,6});
//        map.put("bmw", new int[]{8,16});
//        map.put("coffee", new int[]{1,5});
//        map.put("watch", new int[]{2,6});
//        map.put("boom", new int[]{22,31});
//        map.put("wasim", new int[]{13,18});
//        map.put("imran", new int[]{22,16});
//        map.put("watch", new int[]{21,36});
//        map.put("watch", new int[]{12,26});
//        map.put("lamp", new int[]{8,20});
        // Ends here
        stage.setTitle("Bubble Chart");
        final NumberAxis xAxis = new NumberAxis(1, 50, 2);
        final NumberAxis yAxis = new NumberAxis(0, 50, 2);
        final BubbleChart<Number, Number> blc = new BubbleChart<Number, Number>(xAxis, yAxis);
        xAxis.setLabel("Indivisual Frequency");
        yAxis.setLabel("Overall Frequency ");
        blc.setTitle("Onto-concept");
//        
//       
        for (String key : data_map.keySet()) {
            XYChart.Series tag = new XYChart.Series();
            tag.setName(key);
            int[] frequences = (int[]) data_map.get(key);
            tag.getData().add(new XYChart.Data(frequences[0], frequences[1]));
            blc.getData().addAll(tag);
        }

        Scene scene = new Scene(blc);
        stage.setScene(scene);
        stage.show();
    }
    
    public Map<String, Object> setData(Map<String, Object> data){
        Map<String, Object> map = new HashMap<String, Object>(data);
        return map;
    }
}

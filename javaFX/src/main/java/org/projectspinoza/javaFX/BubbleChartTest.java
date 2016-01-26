package org.projectspinoza.javaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BubbleChartTest extends Application {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Bubble Chart");
        final NumberAxis xAxis = new NumberAxis(1, 53, 4);
        final NumberAxis yAxis = new NumberAxis(0, 80, 10);
        final BubbleChart<Number, Number> blc = new BubbleChart<Number, Number>(
                xAxis, yAxis);
        xAxis.setLabel("Week");
        yAxis.setLabel("Product Budget");
        blc.setTitle("Monitoring");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Product 1");
        series1.getData().add(new XYChart.Data(3, 35, 3));
        series1.getData().add(new XYChart.Data(12, 60, 3));
        series1.getData().add(new XYChart.Data(15, 15));
        series1.getData().add(new XYChart.Data(22, 30));
        series1.getData().add(new XYChart.Data(28, 20));
        series1.getData().add(new XYChart.Data(35, 41));
        series1.getData().add(new XYChart.Data(42, 17));
        series1.getData().add(new XYChart.Data(49, 30));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Product 2");
        series2.getData().add(new XYChart.Data(8, 15));
        series2.getData().add(new XYChart.Data(13, 23));
        series2.getData().add(new XYChart.Data(15, 45));
        series2.getData().add(new XYChart.Data(24, 30));
        series2.getData().add(new XYChart.Data(38, 78));
        series2.getData().add(new XYChart.Data(40, 41));
        series2.getData().add(new XYChart.Data(45, 57));
        series2.getData().add(new XYChart.Data(47, 23));
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Product 3");
        series3.getData().add(new XYChart.Data(9, 14));
        series3.getData().add(new XYChart.Data(14, 22));
        series3.getData().add(new XYChart.Data(16, 44));
        series3.getData().add(new XYChart.Data(25, 29));
        series3.getData().add(new XYChart.Data(39, 77));
        series3.getData().add(new XYChart.Data(41, 40));
        series3.getData().add(new XYChart.Data(46, 56));
        series3.getData().add(new XYChart.Data(48, 22));

        Scene scene = new Scene(blc);
        blc.getData().addAll(series1, series2, series3);
        stage.setScene(scene);
        stage.show();
    }

}

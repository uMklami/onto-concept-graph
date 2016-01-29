package org.projectspinoza.javaFX;

import java.util.Map;
import java.util.Map.Entry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class PieGraph {

	private static Map<String, Object> pieData;

	public Map<String, Object> getPieData() {
		return pieData;
	}

	public static void setMap(Map<String, Object> map) {
		pieData = map;
	}

	public Group start() {
		Group pie = new Group();
		ObservableList<PieChart.Data> pieChartData = null;
		ObservableWrap wraper = new ObservableWrap();

		for (Entry<String, Object> entry : pieData.entrySet()) {
			int val = ((int[]) entry.getValue())[0];
			wraper.addPieData(new PieChart.Data(entry.getKey(), val));
		}

		pieChartData = FXCollections.observableArrayList(wraper.getalldata());

		final PieChart chart = new PieChart(pieChartData);
		chart.setTitle("Tweet tags");
		chart.setLegendSide(Side.LEFT);
		chart.setMinWidth(800);
		chart.setMinHeight(800);

		// . adding mouse Event
//		final Label caption = new Label("");
//        caption.setTextFill(Color.BLACK);
//        caption.setStyle("-fx-font: 24 arial;");
//
//        for (final PieChart.Data data : chart.getData()) {
//            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
//                new EventHandler<MouseEvent>() {
//                    @Override public void handle(MouseEvent e) {
//                        caption.setTranslateX(e.getSceneX());
//                        caption.setTranslateY(e.getSceneY());
//                        double percent = (data.getPieValue()/chart.getData().size())*100;
//                        caption.setText(String.valueOf(percent) + "%");
//                     }
//                });
//        }
//        pie.getChildren().addAll(chart,caption);
        pie.getChildren().addAll(chart);
		return pie;
		// ((Group) scene.getRoot()).getChildren().add(chart);

	}
}
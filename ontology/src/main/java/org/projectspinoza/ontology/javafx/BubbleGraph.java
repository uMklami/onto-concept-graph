package org.projectspinoza.ontology.javafx;

import java.util.Map;

import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class BubbleGraph {
	
	//
//	Map<String, Object> map = new HashMap<String, Object>();
	//
	private static Map<String, Object> data_map;

	public BubbleGraph() {
	}

	public static void setMap(Map<String, Object> map) {
		data_map = map;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BubbleChart<Number, Number> start() throws Exception {

		final NumberAxis xAxis = new NumberAxis(0, 50, 2);
		final NumberAxis yAxis = new NumberAxis(0, 50, 2);
		final BubbleChart<Number, Number> blc = new BubbleChart<Number, Number>(
				xAxis, yAxis);
		yAxis.setLabel("Indivisual Frequency");
		xAxis.setLabel("Overall Frequency ");
		blc.setTitle("Onto-concept");

		for (String key : data_map.keySet()) {
			XYChart.Series tag = new XYChart.Series();
			tag.setName(key);
			int[] frequences = (int[]) data_map.get(key);
			tag.getData().add(new XYChart.Data(frequences[0], frequences[1]));
			blc.getData().addAll(tag);
		}

		return blc;
	}
}

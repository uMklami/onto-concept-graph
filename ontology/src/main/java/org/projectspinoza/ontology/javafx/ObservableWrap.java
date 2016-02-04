package org.projectspinoza.ontology.javafx;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.chart.PieChart;

public class ObservableWrap  {
	
	List<PieChart.Data> list = new ArrayList<PieChart.Data>();
	
	public List<PieChart.Data> getalldata() {
		return this.list;
	}
	
	public void addPieData(PieChart.Data arg0) {
		list.add(arg0);
	}
}
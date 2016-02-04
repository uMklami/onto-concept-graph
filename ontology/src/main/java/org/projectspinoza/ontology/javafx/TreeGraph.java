package org.projectspinoza.ontology.javafx;

/*
 * Copyright (c) 2003, the JUNG Project and the Regents of the University of
 * California All rights reserved.
 * 
 * This software is open-source under the BSD license; see either "license.txt"
 * or http://jung.sourceforge.net/license.txt for a description.
 * 
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Shape;
import java.util.List;

import javafx.embed.swing.SwingNode;

import org.apache.commons.collections15.Transformer;
import org.apache.commons.collections15.functors.ConstantTransformer;
import org.projectspinoza.ontology.javafx.models.JEdge;
import org.projectspinoza.ontology.javafx.models.JNode;
import org.projectspinoza.ontology.util.Term;

import edu.uci.ics.jung.algorithms.layout.RadialTreeLayout;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.DelegateForest;
import edu.uci.ics.jung.graph.Forest;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.VisualizationServer;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.decorators.EllipseVertexShapeTransformer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.subLayout.TreeCollapser;

public class TreeGraph {

	private static List<Term> ontoData;
	
	public static List<Term> getOntoData() {
		return ontoData;
	}
	public static void setOntoData(List<Term> ontoData) {
		TreeGraph.ontoData = ontoData;
	}

	/**
	 * the graph
	 */
	final GraphZoomScrollPane panel;
	Forest<JNode, JEdge> graph;
	
	/**
	 * the visual component and renderer for the graph
	 */
	VisualizationViewer<JNode, JEdge> vv;
	VisualizationServer.Paintable rings;
	TreeLayout<JNode, JEdge> layout;
	TreeCollapser collapser;
	RadialTreeLayout<JNode, JEdge> radialLayout;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public TreeGraph() {

		// create a simple graph for ontology data
		graph = new DelegateForest<JNode, JEdge>();
		addData();

		layout = new TreeLayout<JNode, JEdge>(graph);
		
		vv = new VisualizationViewer<JNode, JEdge>(layout, new Dimension(
				800, 700));
		vv.setBackground(Color.white);
		vv.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Line());
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		vv.getRenderContext().setVertexShapeTransformer(
				new ClusterVertexShapeFunction());
		vv.setVertexToolTipTransformer(new ToStringLabeller());
		vv.getRenderContext().setArrowFillPaintTransformer(
				new ConstantTransformer(Color.lightGray));	
		
		panel = new GraphZoomScrollPane(vv);
		final DefaultModalGraphMouse<?, ?> graphMouse = new DefaultModalGraphMouse();
		vv.setGraphMouse(graphMouse);
		graphMouse.setMode(ModalGraphMouse.Mode.TRANSFORMING);
	}

	/**
	 * class that will create a vertex shape that is either a polygon or
	 * star. The number of sides corresponds to the number of vertices that were
	 * collapsed into the vertex represented by this shape.
	 * @param <V>
	 */
	class ClusterVertexShapeFunction<V> extends
			EllipseVertexShapeTransformer<V> {

		ClusterVertexShapeFunction() {
			setSizeTransformer(new ClusterVertexSizeFunction<V>(20));
		}

		@Override
		public Shape transform(V v) {
			if (v instanceof Graph) {
				int size = ((Graph<?, ?>) v).getVertexCount();
				if (size < 8) {
					int sides = Math.max(size, 3);
					return factory.getRegularPolygon(v, sides);
				} else {
					return factory.getRegularStar(v, size);
				}
			}
			return super.transform(v);
		}
	}

	/**
	 * A class that will make vertices larger if they represent a collapsed
	 * collection of original vertices
	 *
	 * @param <V>
	 */
	class ClusterVertexSizeFunction<V> implements Transformer<V, Integer> {
		int size;

		public ClusterVertexSizeFunction(Integer size) {
			this.size = size;
		}

		public Integer transform(V v) {
			if (v instanceof Graph) {
				return 20;
			}
			return size;
		}
	}

	/**
	 * Adding data to graph
	 * 
	 * @param data
	 */
	public void addData(){
		JNode root = new JNode("ontology");
		graph.addVertex(root);
		for (Term term : ontoData) {
			JNode jchild = new JNode(term.getTerm());
			graph.addEdge(new JEdge(), root, jchild , EdgeType.DIRECTED);
			if (term.getChilds() != null) {
				for (Term child : term.getChilds()) {
					JNode jsubchild = new JNode(child.getTerm());
					graph.addEdge(new JEdge(), jchild, jsubchild, EdgeType.DIRECTED);
					if (child.getChilds() != null) {
						for (Term subchild : child.getChilds()) {
							graph.addEdge(new JEdge(), jsubchild, new JNode(subchild.getTerm()), EdgeType.DIRECTED);
						}
					}
				}
			}
		}
	}

	/**
	 * A driver for this Graph
	 */
	public SwingNode start() {
		final SwingNode swingNode = new SwingNode();
		swingNode.setContent(panel);
		return swingNode;
	}
}

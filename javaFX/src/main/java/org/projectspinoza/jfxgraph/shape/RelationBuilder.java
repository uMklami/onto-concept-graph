package org.projectspinoza.jfxgraph.shape;

import java.util.List;

import javafx.scene.Group;
import javafx.scene.shape.Line;

public class RelationBuilder extends Group {
	Vertex root;

	public RelationBuilder() {
		super();
	}

	public RelationBuilder(Vertex root) {
		super();
		this.root = root;
	}

	public void addChild(Vertex parent, Vertex child){
        if(root.equals(parent)){
            root.addChild(child);
            bindChildWithParent(root, child);
        }else{
            Vertex p = recursiveSearch(root, parent);
            if(p != null){
                p.addChild(child);
                bindChildWithParent(p, child);
            }else{
                System.out.println("parent is null for: "+ child);
            }
        }
    }

	private void bindChildWithParent(Vertex parentNode, Vertex childNode) {

		int size = parentNode.getChilds().size();
		double half = size / 2;
		int rightChilds = (int) half;

		if (size % 2 == 0) {
			double position = rightChilds * 60 + rightChilds * 10 - 10;
			childNode.xProperty().bind(parentNode.xProperty().add(position));
			childNode.yProperty().bind(parentNode.yProperty().add(80));
		} else {
			int leftChilds = rightChilds + 1;
			double position = leftChilds * 60 + leftChilds * 10 - 10;
			childNode.xProperty().bind(
					parentNode.xProperty().subtract(position));
			childNode.yProperty().bind(parentNode.yProperty().add(80));
		}
	}

	public Vertex recursiveSearch(Vertex other, Vertex p) {
		List<Vertex> childs = other.getChilds();
		Vertex f = null;
		for (Vertex c : childs) {
			if (c.equals(p)) {
				return c;
			}
			f = recursiveSearch(c, p);
		}
		return f;
	}

	public Vertex getVertex(String label) {

		Vertex vertex = new Vertex(0, 0, 0, 0, label);

		if (root.equals(vertex)) {
			return root;
		}
		return recursiveSearch(root, vertex);
	}

	public void build() {
		setPosition();
		this.getChildren().add(root);
		this.getChildren().add(root.getLabel());
		buildRecursiveEdges(root);
	}

	public void buildRecursiveEdges(Vertex v) {
		List<Vertex> childs = v.getChilds();
		for (Vertex c : childs) {
			buildLink(v, c);
			buildRecursiveEdges(c);
		}
	}

	public void buildLink(Vertex parent, Vertex child) {

		Line line = buildLineFor(parent, child);

		this.getChildren().add(child);
		this.getChildren().add(child.getLabel());
		this.getChildren().add(line);
	}

	public Line getLineFor(Vertex source, Vertex target) {
		double halfWidth = source.getWidth() / 2;
		return new Line(source.getX() + halfWidth, source.getY()
				+ source.getHeight(), target.getX() + halfWidth, target.getY());
	}

	public Line buildLineFor(Vertex parent, Vertex child) {
		double halfWidth = parent.getWidth() / 2;

		Line line = new Line();
		line.startXProperty().bind(parent.xProperty().add(halfWidth));
		line.startYProperty().bind(
				parent.yProperty().add(parent.heightProperty()));

		line.endXProperty().bind(child.xProperty().add(halfWidth));
		line.endYProperty().bind(child.yProperty());

		return line;
	}

	public void setPosition() {
		this.setLayoutX(this.root.getX());
		this.setLayoutY(this.root.getY());
	}
}

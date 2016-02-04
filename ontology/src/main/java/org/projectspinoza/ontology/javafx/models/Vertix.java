package org.projectspinoza.ontology.javafx.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Vertix implements Serializable {

	private static final long serialVersionUID = 5589019198655780243L;
	Vertix parent;
	String label;
	List<Vertix> childs = new ArrayList<Vertix>();

	public Vertix(String id) {
		this.label = id;
	}

	public Vertix getParent() {
		return parent;
	}

	public void setParent(Vertix parent) {
		this.parent = parent;
	}

	public void addChild(Vertix child) {
		if (child.getParent() == null) {
			child.setParent(this);
			childs.add(child);
		}
	}

	public void setChilds(List<Vertix> childs) {
		this.childs = childs;
	}

	public List<Vertix> getChilds() {
		return this.childs;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

	@Override
	public boolean equals(Object obj) {
		Vertix other = (Vertix) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vertex [label=" + label + ", childs=" + childs + "]";
	}

}

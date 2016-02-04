package org.projectspinoza.ontology.javafx;

import java.util.List;

import org.projectspinoza.ontology.javafx.models.Vertix;

public class RelationBuilder{
	Vertix root;

	public RelationBuilder() {
		super();
	}

	public RelationBuilder(Vertix root) {
		super();
		this.root = root;
	}

	public void addChild(Vertix parent, Vertix child){
        Vertix v = getVertex(child.getLabel());
        if(v != null){
        	return;
        }
		if(root.equals(parent)){
            root.addChild(child);
        }else{
            Vertix p = recursiveSearch(root, parent);
            if(p != null){
                p.addChild(child);
            }else{
                System.out.println("parent is null for: "+ child);
            }
        }
    }

	public Vertix recursiveSearch(Vertix other, Vertix p) {
		List<Vertix> childs = other.getChilds();
		Vertix f = null;
		for (Vertix c : childs) {
			if (c.equals(p)) {
				return c;
			}
			f = recursiveSearch(c, p);
			if(f != null){
				return f;
			}
		}
		return f;
	}

	public Vertix getVertex(String label) {

		Vertix vertex = new Vertix(label);

		if (root.equals(vertex)) {
			return root;
		}
		return recursiveSearch(root, vertex);
	}

	public void build() {
		buildRecursiveEdges(root);
	}

	public void buildRecursiveEdges(Vertix v) {
		List<Vertix> childs = v.getChilds();
		for (Vertix c : childs) {
			System.out.println("parent: " + v + ", child: " + c);
			buildRecursiveEdges(c);
		}
	}
}

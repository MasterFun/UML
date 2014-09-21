package application;

import javafx.scene.control.TreeItem;

public class Package {
	private String name;
	private TreeItem<?> parent;

	public TreeItem<?> getParent() {
		return parent;
	}

	public void setParent(TreeItem<?> parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

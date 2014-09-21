package application;

import javafx.scene.control.TreeItem;

public class Package extends Typ {

	private TreeItem<?> parent;

	public TreeItem<?> getParent() {
		return parent;
	}

	public void setParent(TreeItem<?> parent) {
		this.parent = parent;
	}

	public Package(String name, String stereotyp) {

		super.setName(name);
		super.setStereotyp(stereotyp);
		super.setType("Package");
	}

	
}

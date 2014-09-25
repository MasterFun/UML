package application;

import javafx.scene.control.TreeItem;

public class Package extends Typ {

	public Package(String name, String stereotyp, String childName) {

		super.setName(name);
		super.setStereotyp(stereotyp);
		super.setType("Package");
		super.setChildName(childName);
	}

	
}

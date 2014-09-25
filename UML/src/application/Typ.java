package application;

import java.io.Serializable;

import javafx.scene.control.TreeItem;

public class Typ implements Serializable {

	private static final long serialVersionUID = 8508251409736830247L;
	private String name;
	private String stereotyp;
	private String type;
	private String parentName;

	public String getChildName() {
		return parentName;
	}
	public void setChildName(String childName) {
		this.parentName = childName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStereotyp() {
		return stereotyp;
	}
	public void setStereotyp(String stereotyp) {
		this.stereotyp = stereotyp;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}

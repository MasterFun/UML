package application;

import java.io.Serializable;

public class Operation implements Serializable {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatic() {
		return isStatic;
	}
	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}
	public String getRueckgabetyp() {
		return rueckgabetyp;
	}
	public void setRueckgabetyp(String rueckgabetyp) {
		this.rueckgabetyp = rueckgabetyp;
	}
	public String getStereotyp() {
		return stereotyp;
	}
	public void setStereotyp(String stereotyp) {
		this.stereotyp = stereotyp;
	}
	public Sichtbarkeit getSichtbar() {
		return sichtbar;
	}
	public void setSichtbar(Sichtbarkeit sichtbar) {
		this.sichtbar = sichtbar;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 8072952538432906727L;
	private String name;
	private boolean isStatic;
	private String rueckgabetyp;
	private String stereotyp;
	private Sichtbarkeit sichtbar;
	
	
}

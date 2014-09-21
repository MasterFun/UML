package application;

import java.io.Serializable;

public class Operation implements Serializable {

	private static final long serialVersionUID = 8072952538432906727L;
	private String name;
	private boolean isStatic;
	private String rueckgabetyp;
	private String stereotyp;
	private String sichtbar;

	// ----------------------------------------------------------------------------
	// TODO ck 29.09.2014 - sollte nicht OK sein
	// neue Operation
	
	public Operation(String name, boolean isStatic, String rueckgabetyp, String stereotyp, String sichtbar){

		this.name = name;
		this.isStatic = isStatic;
		this.rueckgabetyp = rueckgabetyp;
		this.stereotyp = stereotyp;
		this.sichtbar = sichtbar;
	}
	// ----------------------------------------------------------------------------
	
	
	public String getName() {
		return name;
	}

	public boolean isStatic() {
		return isStatic;
	}

	public String getRueckgabetyp() {
		return rueckgabetyp;
	}

	public String getStereotyp() {
		return stereotyp;
	}

	public String getSichtbar() {
		return sichtbar;
	}

}

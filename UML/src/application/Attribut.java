package application;

import java.io.Serializable;

public class Attribut implements Serializable{

	private static final long serialVersionUID = 5546661732545627789L;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public Sichtbarkeit getSichtbar() {
		return sichtbar;
	}
	public void setSichtbar(Sichtbarkeit sichtbar) {
		this.sichtbar = sichtbar;
	}

	
	public String getTyp() {
		return typ;
	}
	public void setTyp(String typ) {
		this.typ = typ;
	}

	
	public String getInitialwert() {
		return initialwert;
	}
	public void setInitialwert(String initialwert) {
		this.initialwert = initialwert;
	}


	public String getStereotyp() {
		return stereotyp;
	}
	public void setStereotyp(String stereotyp) {
		this.stereotyp = stereotyp;
	}
	private String name;
	private Sichtbarkeit sichtbar;
	private String typ;
	private String initialwert;
	private String stereotyp;
	
	
}

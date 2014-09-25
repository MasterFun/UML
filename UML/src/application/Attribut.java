package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Attribut implements Serializable {

	private static final long serialVersionUID = 5546661732545627789L;

	private String name;
	private String sichtbar;
	private String typ;
	private String initialwert;
	private String stereotyp;

	// Neues Attribut
	public Attribut(String name, String sichtbar, String typ,
			String initialwert, String stereotyp) {

		this.name = name;
		this.sichtbar = sichtbar;
		this.typ = typ;
		this.initialwert = initialwert;
		this.stereotyp = stereotyp;

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSichtbar(String sichtbar) {
		this.sichtbar = sichtbar;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public void setInitialwert(String initialwert) {
		this.initialwert = initialwert;
	}

	public void setStereotyp(String stereotyp) {
		this.stereotyp = stereotyp;
	}

	public String getName() {
		return name;
	}

	public String getSichtbar() {
		return sichtbar;
	}

	public String getTyp() {
		return typ;
	}

	public String getInitialwert() {
		return initialwert;
	}

	public String getStereotyp() {
		return stereotyp;
	}

}

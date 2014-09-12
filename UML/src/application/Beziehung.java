package application;

import java.io.Serializable;

public class Beziehung implements Serializable {
	
	public String getRollennamen() {
		return rollennamen;
	}
	public void setRollennamen(String rollennamen) {
		this.rollennamen = rollennamen;
	}
	public Typ getZieltyp() {
		return zieltyp;
	}
	public void setZieltyp(Typ zieltyp) {
		this.zieltyp = zieltyp;
	}
	public String getNavigierbarkeit() {
		return navigierbarkeit;
	}
	public void setNavigierbarkeit(String navigierbarkeit) {
		this.navigierbarkeit = navigierbarkeit;
	}
	public Sichtbarkeit getSichtbar() {
		return sichtbar;
	}
	public void setSichtbar(Sichtbarkeit sichtbar) {
		this.sichtbar = sichtbar;
	}
	public String getKardinalitaet() {
		return kardinalitaet;
	}
	public void setKardinalitaet(String kardinalitaet) {
		this.kardinalitaet = kardinalitaet;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 418365226982860206L;
	private String rollennamen;
	private Typ zieltyp;
	private String navigierbarkeit;
	private Sichtbarkeit sichtbar;
	private String kardinalitaet;
	
}

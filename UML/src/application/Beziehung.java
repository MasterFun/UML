package application;

import java.io.Serializable;

public class Beziehung implements Serializable {
	
	private static final long serialVersionUID = 418365226982860206L;
	private String rollenname;
	private Typ zieltyp;
	private String navigierbarkeit;
	private String sichtbar;
	private String kardinalitaet;

	// Neue Beziehung
	public Beziehung(String rollenname, Typ zieltyp, String navigierbarkeit, String sichtbar, String kardinalitaet){

			this.rollenname = rollenname;
			this.zieltyp = zieltyp;
			this.navigierbarkeit = navigierbarkeit;
			this.sichtbar = sichtbar;
			this.kardinalitaet = kardinalitaet;
	}
	
	
	
	
	public String getRollenname() {
		return rollenname;
	}
	public Typ getZieltyp() {
		return zieltyp;
	}
	public String getNavigierbarkeit() {
		return navigierbarkeit;
	}
	public String getSichtbar() {
		return sichtbar;
	}
	public String getKardinalitaet() {
		return kardinalitaet;
	}

	
	
	
}

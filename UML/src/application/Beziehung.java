package application;

import java.io.Serializable;

public class Beziehung implements Serializable {
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

package application;

import java.util.ArrayList;
import java.util.List;

public class Klasse extends Typ {

	private static final long serialVersionUID = -1969721676564819295L;

	// überlegen, ob String sinnvoll ist oder Objekt?!?
	// TODO
	// Wenn das Feld ausgefüllt ist, dann wird die übergeordnete Klasse zur
	// Superklasse
//	private Klasse vererbungVon;
	private List<Attribut> attribute;
	private List<Operation> operationen;
	private List<Beziehung> beziehungen;

	// ----------------------------------------------------------------------------
	// TODO ck 29.09.2014 - sollte OK sein
	// Neue Klasse wird angelegt
	
	public Klasse(String name, String stereotyp, String parentName) {

		super.setName(name);
		super.setStereotyp(stereotyp);
		super.setType("Klasse");
		super.setParentName(parentName);
		attribute = new ArrayList<Attribut>();
		operationen = new ArrayList<Operation>();
		beziehungen = new ArrayList<Beziehung>();
	}
	// ----------------------------------------------------------------------------

	
	
	
	// ----------------------------------------------------------------------------
	// TODO ck 29.09.2014 - sollte OK sein
	// Attribute
	// Liste aller Attribute
	public List<Attribut> getAttribute() {
		return attribute;
	}
	
	// Attribut hinzufügen
	public void addAttribut(Attribut attribut) {
		attribute.add(attribut);
	}
	
	// Attribut löschen
	public void delAttribut(Attribut attribut){
		attribute.remove(attribut);
	}
	// ----------------------------------------------------------------------------

	
	
	// ----------------------------------------------------------------------------
	// TODO ck 29.09.2014
	// Operationen
	// Liste aller Attribute
	public List<Operation> getOperationen() {
		return operationen;
	}
	
	// Operation hinzufügen
	public void addOperation(Operation operation) {
		operationen.add(operation);
	}
	
	// Operation löschen
	public void delOperation(Operation operation){
		operationen.remove(operation);
	}
	// ----------------------------------------------------------------------------
	
	
	// ----------------------------------------------------------------------------
	// TODO ck 29.09.2014  NICHT!!
	// Beziehungen
	// Liste aller Beziehungen
	public List<Beziehung> getBeziehungen() {
		return beziehungen;
	}
	
	// Beziehung hinzufügen
	public void addBeziehung(Beziehung beziehung) {
		beziehungen.add(beziehung);
	}
	
	// Beziehung löschen
	public void delBeziehnung(Beziehung beziehung){
		beziehungen.remove(beziehung);
	}
	// ----------------------------------------------------------------------------
	
	

}

package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Frido Zurlinden / Christian Kiss
 * @version 1.0 / 12.09.2014
 */
public class UMLEditor {

	// TODO Setter bauen, damit er überschrieben werden kann mit aktuellem
	// Dateiname
	private String DATEINAME = "UMLEditor.tmp";

	private static UMLEditor umleditor = null;
	private ArrayList<Object> objectList;
	
//	private List<Klasse> klassen;
//	private List<Interface> interfaces;
//	private List<Package> packages;
	private File datei;
	
	private boolean debug = true;

	/**
	 * Konstruktor, in dem die Variablen instantiiert werden.
	 */
	private UMLEditor() {
		objectList = new ArrayList<>();
		datei = new File(DATEINAME);
		// einlesen();
	}

	public List getObjectList() {
		neueKlasse("Klasse1", "Klasse", "Root");
		neueKlasse("Klasse2", "Klasse", "Klasse1");
		neueKlasse("Klasse3", "Klasse", "Root");
		return objectList;
		
	}

	//-------------------------------------------------------------------------
	// ck 21.09.2014 Klassen
	/**
	 * eine neue Klasse wird angelegt
	 * 
	 * @param
	 * @param
	 * @param
	 * @return
	 */
	public Klasse neueKlasse(String name, String stereotyp, String parentName) {

		Klasse newKlasse = new Klasse(name, stereotyp, parentName);
		// Befülle Liste aller Klassen damit holeKlasse ausgeführt werden kann
		objectList.add(newKlasse);

		// speichern();

		// DEBUG ck
		if (debug == true) {
			System.out.println("neueKlasse:\n"
								+ "Name: " + newKlasse.getName() + "\n"
								+ "Stereotyp: " + newKlasse.getStereotyp() + "\n"
								+ "Vererbung Von: " + newKlasse.getVererbungVon()  + "\n"
								+ "----------------------------------------------");
		}

		return newKlasse;
	}
	
	
	public Klasse holeKlasse(String name){

		// DEBUG ck
		if (debug == true) {
			System.out.println("holeKlasse: " + name  + "\n"
					+ "----------------------------------------------");
		}

		
		for(Klasse k : klassen){
			if(k.getName().equals(name)){
				return k;
			}
		}
		return null;
	}
	
	
	
	//-------------------------------------------------------------------------

	
	//-------------------------------------------------------------------------
	// ck 21.09.2014 Interface
	public Interface neuesInterface(String name, String stereotyp, String parentName){
		
		Interface newInterface = new Interface(name, stereotyp, parentName);
		// Befülle Liste Interfaces
		objectList.add(newInterface);
		
		if (debug == true) {
			System.out.println("Neues Interface anlegen:\n"
								+ "Name: " + newInterface.getName() + "\n"
								+ "Stereotyp: " + newInterface.getStereotyp()  + "\n"
								+ "----------------------------------------------");
		}

		return newInterface;
		
	}
	
	public Interface holeInterface(String name){
		// DEBUG ck
		if (debug == true) {
			System.out.println("holeInterface: " + name  + "\n"
					+ "----------------------------------------------");
		}

		
		for(Interface i : interfaces){
			if(i.getName().equals(name)){
				return i;
			}
		}
		return null;
	}
	//-------------------------------------------------------------------------
	

	//-------------------------------------------------------------------------
	// ck 21.09.2014 Package
	public Package neuesPackage(String name, String stereotyp, String parentName){
		
		Package newPackage = new Package(name, stereotyp, parentName);
		// Befülle Liste
		objectList.add(newPackage);
		
		if (debug == true) {
			System.out.println("Neues Package anlegen:\n"
								+ "Name: " + newPackage.getName() + "\n"
								+ "Stereotyp: " + newPackage.getStereotyp()  + "\n"
								+ "----------------------------------------------");
		}

		return newPackage;
		
	}
	public Package holePackage(String name){
		// DEBUG ck
		if (debug == true) {
			System.out.println("holePackage: " + name  + "\n"
					+ "----------------------------------------------");
		}

		
		for(Package p : packages){
			if(p.getName().equals(name)){
				return p;
			}
		}
		return null;
	}	
	
	
	//-------------------------------------------------------------------------
	
	
	
	
	// TypeCheck
	// ermittelt was das objekt für einen Typ hat für PaneAufbau
	public String typeCheck(String type){
	
		// Prüfen ob in Klasse vorhanden
		for(Klasse k : klassen){
			if(k.getName().equals(type)){return k.getType();}
		}
		
		// Prüfen ob in Interface vorhanden
		for(Interface i : interfaces){
			if(i.getName().equals(type)){return i.getType();}
		}
		
		// Prüfen ob in Package vorhanden
		for(Package p : packages){
			if(p.getName().equals(type)){return p.getType();}
		}
		
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// // Alle objekte einlesen
	// public void einlesen() {
	// if (datei.exists()) {
	// try {
	// ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datei +
	// "tmp"));
	// UMLObject = (UMLEditor) ois.readObject();
	// ois.close();
	// }
	// catch (Exception ex) {
	// System.out.println(ex.getMessage());
	// }
	// }
	// }
	//
	// // Datei bzw Pfad m�ssen noch �bergeben werden in Methode
	// public void speichern() {
	// try {
	// ObjectOutputStream oos = new ObjectOutputStream(new
	// FileOutputStream(datei));
	// oos.writeObject(UMLObject);
	// oos.close();
	// }
	// catch (Exception ex) {
	// System.out.println(ex.getMessage());
	// }
	// }
	//
	//
	// public static UMLEditor getInstance() {
	// if (UMLObject == null) { UMLObject = new UMLEditor();
	// }
	// return UMLObject;
	// }
	//
	//

	public static UMLEditor getInstance() {
		if (umleditor == null) {
			umleditor = new UMLEditor();
		}
		return umleditor;
	}

}
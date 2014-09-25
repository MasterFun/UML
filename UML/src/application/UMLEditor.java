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
		klasseNeu("Klasse1", "Klasse", "Root");
		klasseNeu("Klasse2", "Klasse", "Klasse1");
		klasseNeu("Klasse3", "Klasse", "Root");
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
	public Klasse klasseNeu(String name, String stereotyp, String parentName) {

		Klasse newKlasse = new Klasse(name, stereotyp, parentName);
		// Befülle Liste aller Klassen damit holeKlasse ausgeführt werden kann
		objectList.add(newKlasse);

		// speichern();

		// DEBUG ck
		if (debug == true) {
			System.out.println("klasseNeu:\n"
								+ "Name: " + newKlasse.getName() + "\n"
								+ "Stereotyp: " + newKlasse.getStereotyp() + "\n"
								+ "Parent: " + newKlasse.getParentName()  + "\n"
								+ "----------------------------------------------");
		}

		return newKlasse;
	}
	
	
	public void klasseBearbeiten(String name, String stereotyp, String parentName, Object objekt){
		
		Klasse o = (Klasse) objekt;
		o.setName(name);
		o.setStereotyp(stereotyp);
		o.setParentName(parentName);

		if (debug == true) {
			System.out.println("klasseBearbeiten:\n"
								+ "Name: " + o.getName() + "\n"
								+ "Stereotyp: " + o.getStereotyp()  + "\n"
								+ "Parent: " + o.getParentName()  + "\n"
								+ "----------------------------------------------");
		}
		
	}
	
	//-------------------------------------------------------------------------

	
	//-------------------------------------------------------------------------
	// ck 25.09.2014 Attribut

	public void attributNeu(String name, String sichtbar, String typ, String initialwert, String stereotyp, Object objekt){
		
		Attribut newAttribut = new Attribut(name, sichtbar, typ, initialwert, stereotyp);
		
		Klasse klassenObjekt = (Klasse) objekt;
		
		klassenObjekt.addAttribut(newAttribut);

		// DEBUG ck
		if (debug == true) {
			System.out.println("attributNeu:\n"
								+ "name: " + newAttribut.getName() + "\n"
								+ "sichtbar: " + newAttribut.getSichtbar() + "\n"
								+ "typ: " + newAttribut.getTyp()  + "\n"
								+ "initialwert: " + newAttribut.getInitialwert()  + "\n"
								+ "stereotyp: " + newAttribut.getStereotyp()  + "\n"
								+ "----------------------------------------------");
		}
	}

	
	public void attributBearbeiten(String name, String sichtbar, String typ, String initialwert, String stereotyp, Attribut attribut){
		
		attribut.setName(name);
		attribut.setSichtbar(sichtbar);
		attribut.setTyp(typ);
		attribut.setInitialwert(initialwert);
		attribut.setStereotyp(stereotyp);

		// DEBUG ck
		if (debug == true) {
			System.out.println("attributBearbeiten:\n"
								+ "name: " + attribut.getName() + "\n"
								+ "sichtbar: " + attribut.getSichtbar() + "\n"
								+ "typ: " + attribut.getTyp()  + "\n"
								+ "initialwert: " + attribut.getInitialwert()  + "\n"
								+ "stereotyp: " + attribut.getStereotyp()  + "\n"
								+ "----------------------------------------------");
		}

		
	}
		

	public void attributDelete(Klasse klasse, Attribut attribut){
		klasse.delAttribut(attribut);
	}
	
	//-------------------------------------------------------------------------
	
	
	//-------------------------------------------------------------------------
	// ck 25.09.2014 Operationen
	public void operationNeu(String name, boolean isStatic, String rueckgabetyp, String stereotyp, String sichtbar, Object objekt){
		
		Operation op = new Operation(name, isStatic, rueckgabetyp, stereotyp, sichtbar);
		Klasse klassenObjekt = (Klasse) objekt;

		klassenObjekt.addOperation(op);

		// DEBUG ck
		if (debug == true) {
			System.out.println("operationNeu:\n"
								+ "name: " + op.getName() + "\n"
								+ "isStatic: " + op.isStatic() + "\n"
								+ "rueckgabetyp: " + op.getRueckgabetyp() + "\n"
								+ "stereotyp: " + op.getStereotyp()  + "\n"
								+ "sichtbar: " + op.getSichtbar()  + "\n"
								+ "----------------------------------------------");
		}
	}

	
	public void operationBearbeiten(String name, boolean isStatic, String rueckgabetyp, String stereotyp, String sichtbar, Operation operation){
		
		operation.setName(name);
		operation.setStatic(isStatic);
		operation.setRueckgabetyp(rueckgabetyp);
		operation.setStereotyp(stereotyp);
		operation.setSichtbar(sichtbar);
		
		// DEBUG ck
		if (debug == true) {
			System.out.println("operationBearbeiten:\n"
								+ "name: " + operation.getName() + "\n"
								+ "isStatic: " + operation.isStatic() + "\n"
								+ "rueckgabetyp: " + operation.getRueckgabetyp()  + "\n"
								+ "stereotyp: " + operation.getStereotyp()  + "\n"
								+ "sichtbar: " + operation.getSichtbar()  + "\n"
								+ "----------------------------------------------");
		}

		
	}
		

	public void operationDelete(Klasse klasse, Operation operation){
		klasse.delOperation(operation);;
	}
	
	//-------------------------------------------------------------------------
	
	
	//-------------------------------------------------------------------------
	// ck 21.09.2014 Interface
	public Interface interfaceNeu(String name, String stereotyp, String parentName){
		
		Interface newInterface = new Interface(name, stereotyp, parentName);
		// Befülle Liste Interfaces
		objectList.add(newInterface);
		
		if (debug == true) {
			System.out.println("Neues Interface anlegen:\n"
								+ "Name: " + newInterface.getName() + "\n"
								+ "Stereotyp: " + newInterface.getStereotyp()  + "\n"
								+ "Parent: " + newInterface.getParentName()  + "\n"
								+ "----------------------------------------------");
		}

		return newInterface;
		
	}
	
	
	public void interfaceBearbeiten(String name, String stereotyp, String parentName, Object objekt){
		
		Interface o = (Interface) objekt;
		o.setName(name);
		o.setStereotyp(stereotyp);
		o.setParentName(parentName);
		
		if (debug == true) {
			System.out.println("Interface bearbeitet:\n"
								+ "Name: " + o.getName() + "\n"
								+ "Stereotyp: " + o.getStereotyp()  + "\n"
								+ "Parent: " + o.getParentName()  + "\n"
								+ "----------------------------------------------");
		}


	}
	//-------------------------------------------------------------------------
	

	//-------------------------------------------------------------------------
	// ck 21.09.2014 Package
	public Package PackageNeu(String name, String stereotyp, String parentName){
		
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
	
	
	public void PackageBearbeiten(String name, String stereotyp, String parentName, Object objekt){
		
		Package o = (Package) objekt;
		o.setName(name);
		o.setStereotyp(stereotyp);
		o.setParentName(parentName);

		if (debug == true) {
			System.out.println("Package bearbeitet:\n"
								+ "Name: " + o.getName() + "\n"
								+ "Stereotyp: " + o.getStereotyp()  + "\n"
								+ "Parent: " + o.getParentName()  + "\n"
								+ "----------------------------------------------");
		}
		
	}
	//-------------------------------------------------------------------------
	
	
	public List<Object> objectListeHolen(){
		
		return objectList;
		
	}
	
	/// Liste generieren für Atrtribute und Operationen
	// Beziehungen???
	// GUI
	
	
	//-------------------------------------------------------------------------
	// TypeCheck
	// ermittelt was das Objekt für einen Typ hat für PaneAufbau
	public String typeCheck(Object objekt){
	
		// Prüfen, was für ein Type das Object hat
		for(Object o : objectList){
			if(o.equals(objekt)){
				return o.getClass().getSimpleName().toString();
			}
		}
		
		return null;
		
	}
	//-------------------------------------------------------------------------

	
	//-------------------------------------------------------------------------
	// Objektsuche
	public Object objektHolen(Object objekt){
		
		//hole das Objekt
		for(Object o : objectList){
			if(o.equals(objekt)){
				return o;
			}

		}
		
		return null;
		
		
	}
	//-------------------------------------------------------------------------
		
	
	//-------------------------------------------------------------------------
	// Objektsuche
	public void objektDelete(Object objekt){
		
		objectList.remove(objekt);
		
	}
	//-------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
	// Datei bzw Pfad m�ssen noch �bergeben werden in Methode
//	public void speichern(datei) {
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
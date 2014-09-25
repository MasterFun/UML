package application;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class testklasse {

	public static void main(String[] args) {

		UMLEditor umlEditor = UMLEditor.getInstance();
//
//
//		
//		ArrayList<Interface> interfaces = new ArrayList<Interface>();
//		Interface face = new Interface("Interface1", "stereotyp");
//		interfaces.add(face);
//		Interface face2 = new Interface("Interface2", "stereotyp");
//		interfaces.add(face2);
//		
//		for(Interface i : interfaces){
//			
//			System.out.println(i.getName());
//			//if(i.getName().equals("Klasse3")){
//			//	return k;
//			//	System.out.println("gefunden");
//			//}
//		}	
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		// Testklassen anlegen
//		ArrayList<Klasse> klassen = new ArrayList<Klasse>();
		Object klasseEins = umlEditor.klasseNeu("Klasse 1", "stereotyp", "parentName");
		Object InterfaceEins = umlEditor.interfaceNeu("Interface1111", "stereotyp", null);
		
		String bla = umlEditor.typeCheck(klasseEins);
		System.out.println(bla);
		
		Object geholtesObject= umlEditor.holeObjekt(klasseEins);
		Object geholtesInterface= umlEditor.holeObjekt(InterfaceEins);
		
		Klasse test = (Klasse) umlEditor.holeObjekt(klasseEins);
		Interface testi = (Interface) umlEditor.holeObjekt(InterfaceEins);
		System.out.println(test.getName());
		System.out.println(testi.getName());
		
		
		umlEditor.klasseBearbeiten("Klasse bearbeitet", "stereotyp neu", "parentNameNeu", geholtesObject);
		umlEditor.interfaceBearbeiten("Interfaceneu", "stereotyp", "parentName", geholtesInterface);
		
		Klasse testk1 = (Klasse) umlEditor.holeObjekt(klasseEins);
		System.out.println(testk1.getName());
		Interface testi1 = (Interface) umlEditor.holeObjekt(geholtesInterface);
		System.out.println(testi1.getName());
		
		umlEditor.attributNeu("name", "sichtbar", "typ", "initialwert", "stereotyp", testk1);
		
		
//		System.out.println(umlEditor.objectDerKlasse(geholtesObject));
//		System.out.println(umlEditor.nameDerKlasse(geholtesObject));
			
		
		
		
		
		
		
		
		
		
//		Klasse kla = new Klasse("Klasse1", "Stereo", "Root");
//		klassen.add(kla);
//		Klasse kla2 = new Klasse("Klasse2", "Stereo", "Klasse1");
//		klassen.add(kla2);
		
//		System.out.println(kla.getName());
//
//		// Attribute anlegen
//		for (int faktor = 1; faktor <= 3; faktor++) {
//			kla.addAttribut(new Attribut("Attribute " + faktor, "sichtbar",
//					"typ", "initialwert", "stereotyp"));
//		}
//		// Print Out Attribute
//		List<Attribut> attributeKlasse = kla.getAttribute();
//		System.out.println("Attribute:");
//		for (Attribut a : attributeKlasse) {
//			System.out.println(a.getName());
//		}

//		// Operationen anlegen
//		for (int faktor = 1; faktor <= 3; faktor++) {
//			kla.addOperation(new Operation("Operation " + faktor, true,
//					"rueckgabetyp", "stereotyp", "sichtbar"));
//		}
//		// Print Out Operationen
//		List<Operation> operationenKlasse = kla.getOperationen();
//		System.out.println("Operationen:");
//		for (Operation o : operationenKlasse) {
//			System.out.println(o.getName());
//		}
//
//		// Beziehungen anlegen
//		for (int faktor = 1; faktor <= 3; faktor++) {
//			kla.addBeziehung(new Beziehung("rollenname" + faktor, face,
//					"navigierbarkeit", "sichtbar", "kardinalitaet"));
//		}
//		// Print Out Operationen
//		List<Beziehung> BeziehungenKlasse = kla.getBeziehungen();
//		System.out.println("Beziehungen:");
//		for (Beziehung b : BeziehungenKlasse) {
//			System.out.println(b.getRollenname());
//		}
//
//	
//		for(Klasse k : klassen){
//			
//			System.out.println(k.getName());
//			if(k.getName().equals("Klasse2")){
//
//				System.out.println(k.getType());
//			}
//		}
//		

//		public class Tree{
//		    public Node root;
//		}
//
//		public class Node{
//		    public ArrayList<Node> children;
//		    public Node parent;
//		    public String value;
//		}

	
	
	}

}

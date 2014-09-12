package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * @author Frido Zurlinden / Christian Kiss
 * @version 1.0 / 12.09.2014
 */
public class UMLEditor {
	
   //Name der Datei, die die Kunden speichert.

  private static UMLEditor UMLObject = null;
  private File datei = null;

  private UMLEditor() {


  }


//  /**
//   * Ein neuer Kunde wird aufgenommen.
//   * @param kundennummer Nummer des Kunden bei der Bank
//   * @param passwort Passwort des Kunden (nicht verschlÃ¼sselt!)
//   * @param name Name des Kunden
//   * @return Gibt den neuen Kunden zurÃ¼ck
//   */
//  public Kunde neuerKunde(String kundennummer, String passwort, String name, Boolean role) {
//    Kunde kunde = new Kunde(kundennummer, passwort, name, role);
//    kunden.add(kunde);
//    speichern();
//    return kunde;
//  }
  



  // Alle objekte einlesen
  public void einlesen() { 
    if (datei.exists()) {
      try {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datei));
        UMLObject = (UMLEditor) ois.readObject();
        ois.close();
      }
      catch (Exception ex) {
        System.out.println(ex.getMessage());
      }
    }
  }

  // Datei bzw Pfad müssen noch übergeben werden in Methode
  public void speichern() { 
    try {
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(datei));
      oos.writeObject(UMLObject);
      oos.close();
    }
    catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }


public static UMLEditor getInstance() {
	    if (UMLObject == null) {  	UMLObject = new UMLEditor();
		    }
		    return UMLObject;
		  }
	
	
}

  

package application;


import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.channels.SelectableChannel;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.TreeMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class UMLEditorController implements Initializable {
	
	private UMLEditor umlEditor = UMLEditor.getInstance();
	
	// Alle ContentPanes
	@FXML
	Pane painMain, paneOperation, paneAttribut, paneKlasse, statusFeld, testpane;

	@FXML
	ListView<String> listAttribut, listOperation, listBeziehung;

	@FXML
	TreeView<String> klassenTree = new TreeView<String>();
	

	@FXML
	Text statusFeldText;

	// Pane Klasse - Felder
	@FXML
	TextField paneKlasseName, paneKlasseStereotyp;
	@FXML
	ComboBox<String> paneKlasseVererbung, paneKlasseTyp;
	@FXML
	Text paneKlasseStatus;
	
	// Pane Attribut - Felder
	@FXML
	TextField paneAttributName, paneAttributTypString, paneAttributInitialwert,
			paneAttributStereotyp;
	@FXML
	ComboBox<String> paneAttributSichtbarkeit, paneAttributTyp;
	
	@FXML
	CheckBox paneAttributSetter, paneAttributGetter, paneAttributAbgeleitet,
			paneAttributKonstante, paneAttributKlassenattribut;
	
	// Hilfslisten f�r Felder
	// Liste f�r Dropdown Sichtbarkeit
//	List<String> sichtbarkeit = Arrays.asList("public", "private", "protected");
	List<Sichtbarkeit> sichtbarkeit = new ArrayList<Sichtbarkeit>(Arrays.asList(Sichtbarkeit.values()));

	// Liste f�r Dropdown Typ - Standard Datentypen
//	List<String> datentypenStd = Arrays.asList("boolean", "byte", "char",
//			"double", "float", "int", "long", "short", "String");
	List<Datentyp> datentypenStd = new ArrayList<Datentyp>(Arrays.asList(Datentyp.values()));

	
	// ----------------------------------------------------------------------------
	// TODO ck 29.09.2014
	// Tree bauen bei initialisierung
	// Frido gebaut, nur angepasst
	private final Node iconRoot = new ImageView(new Image(getClass().getResourceAsStream("TreeRootNode.png")));
	private final Image iconPackage = new Image(getClass().getResourceAsStream("TreePackage.png"));
	private final Image iconClass = new Image(getClass().getResourceAsStream("TreeClass.png"));
	private final Image iconInterface = new Image(getClass().getResourceAsStream("TreeInterface.png"));
	public String hostname;
	
	public void initialize(URL location, ResourceBundle resources) {
		try {
			hostname = InetAddress.getLocalHost().getHostName();
			// TODO Beim Mac wird nicht nur der Name angezeigt
			//System.out.println(hostname.split(".")[0].toString());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		
		// Root-Eintrag erzeugen und immer ausgeklappt
		TreeItem<String> klassenRoot = new TreeItem<String>(hostname, iconRoot);
		klassenRoot.setExpanded(true);
		klassenTree.setRoot(klassenRoot);
	
	}
	// ----------------------------------------------------------------------------	
	
	
		
	
	
	// Funktionen
	// Statusfeld gespeichert - Grün
	public void statusFeldSave() {
		statusFeldText.setText("gespeichert...");
		statusFeld.setStyle("-fx-background-color: #65f565");
	}

	// Statusfeld gelöscht - Rot
	public void statusFeldDelete() {
		statusFeldText.setText("gelöscht...");
		statusFeld.setStyle("-fx-background-color: #f67d7d");
	}

	public void disableContentPanes() {
		paneOperation.setVisible(false);
		paneAttribut.setVisible(false);
		paneKlasse.setVisible(false);
		// Statusfeldfarbe zur�cksetzen
		statusFeld.setStyle("-fx-background-color: #c0c0c0");
	}

	
	// ----- Attribut -----
	// TODO bauen, wenn ein Objekt ausgew�hlt ist oder Neu angelegt wird

	// Liste der Attribute f�llen
	public void listAttributAnzeigen() {

		statusFeldText.setText("Liste Attribute anzeigen...");

		// leere Liste erzeugen
		ObservableList<String> observableListAttribut = FXCollections
				.observableList(new ArrayList<String>());

		// ersten Eintrag erzeugen
		observableListAttribut.add("hinzuf�gen...");
		observableListAttribut.add("Attribut1");

		// Liste einlesen aus Klasse
		// TODO

		// Liste in GUI schreiben
		listAttribut.setItems(observableListAttribut);
	}

	// Attributsverwaltung neu, bearbeiten
	public void attributSet() {

		// Pane aktivieren
		disableContentPanes();
		paneAttribut.setVisible(true);

		// Pane Attribut - Felder
		// TODO Alle Felder verbauen
		// TextField paneAttributName, paneAttributTypString,
		// paneAttributInitialwert, paneAttributStereotyp;
		// CheckBox paneAttributSetter, paneAttributGetter,
		// paneAttributAbgeleitet, paneAttributKonstante,
		// paneAttributKlassenattribut;

		// Feld paneAttributSichtbarkeit bef�llen
		// TODO beim bearbeiten von Datens�tzen das richtige Feld auf "selected"
		// setzen
		paneAttributSichtbarkeit.getItems().clear();
		for (Sichtbarkeit sicht : sichtbarkeit) {
			paneAttributSichtbarkeit.getItems().add(sicht.toString());
		}

		// Feld paneAttributTyp bef�llen
		// TODO beim bearbeiten von Datens�tzen das richtige Feld auf "selected"
		// setzen
		paneAttributTyp.getItems().clear();
		for (Datentyp typ : datentypenStd) {
			paneAttributTyp.getItems().add(typ.toString());
		}

		// Neues Attribut anlegen
		if (listAttribut.getSelectionModel().getSelectedItem()
				.equals("hinzuf�gen...")) {
			statusFeldText.setText("neues Attribut hinzuf�gen...");
		}

		// Attribut bearbeiten
		else {
			statusFeldText.setText(listAttribut.getSelectionModel()
					.getSelectedItems() + " bearbeiten...");
		}

	}

	public void attributSave() {
		// TODO Wert schreiben mit Logik

		statusFeldSave();
	}

	public void attributDelete() {
		// TODO Wert schreiben mit Logik

		statusFeldDelete();
	}

	// -------------------------

	// ----- Operation -----
	// TODO bauen, wenn ein Objekt ausgew�hlt ist oder Neu angelegt wird

	// Liste der Operation f�llen
	public void listOperationAnzeigen() {

		statusFeldText.setText("Liste Operationen anzeigen...");

		// leere Liste erzeugen
		ObservableList<String> observableListOperation = FXCollections
				.observableList(new ArrayList<String>());

		// ersten Eintrag erzeugen
		observableListOperation.add("hinzufügen...");
		observableListOperation.add("Operation1");

		// Liste einlesen aus Klasse
		// TODO

		// Liste in GUI schreiben
		listOperation.setItems(observableListOperation);

	}

	// Attributsverwaltung neu, bearbeiten / Pane
	public void operationSet() {

		// Pane aktivieren
		disableContentPanes();
		paneOperation.setVisible(true);

		// Neue Operation anlegen
		if (listOperation.getSelectionModel().getSelectedItem()
				.equals("hinzuf�gen...")) {
			statusFeldText.setText("Neue Operationen hinzuf�gen...");
		}

		// Operation bearbeiten
		else {
			statusFeldText.setText(listOperation.getSelectionModel()
					.getSelectedItems() + " bearbeiten...");
		}

	}

	public void operationSave() {
		// TODO Wert schreiben mit Logik

		statusFeldSave();
	}

	public void operationDelete() {
		// TODO Wert schreiben mit Logik

		statusFeldDelete();
	}

	// -------------------------

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// ----------------------------------------------------------------------------
	// TODO ck 29.09.2014
	// Typ ermitteln für speicherung
	public void objectSave() {
		
		// Prüfen ob es neu oder bearbeiten ist!
		paneKlasseStatus.getText();

		// Auswahl welche Methode zum speichern gewählt wird
		// Fehler anzeigen, wenn kein Typ ausgewählt
		if (paneKlasseTyp.getSelectionModel().getSelectedItem().isEmpty()) {
			// TODO ck 20.09.2014
			// Fehler zurück werfen, dass es leer ist!! Muss noch gebaut werden!!
			System.out.println("Kein Typ angegeben");
		} 
		
		
		
		else {
			switch (paneKlasseTyp.getSelectionModel().getSelectedItem()) {
			case "Package":
				umlEditor.neuesPackage(paneKlasseName.getText(),
						paneKlasseStereotyp.getText());
				break;
			case "Klasse":
				umlEditor.neueKlasse(paneKlasseName.getText(),
						paneKlasseStereotyp.getText(), null); // hier muss noch abgefangen werden, wenn es vererbt wird
				break;
			case "Interface":
				// Neues Interface
				umlEditor.neuesInterface(paneKlasseName.getText(),
						paneKlasseStereotyp.getText());
			default:
				break;
			}
		}
		
		
		// schreiben in Baum
		//Set icon and create object
		ImageView itemIcon = null;
		switch (paneKlasseTyp.getSelectionModel().getSelectedItem()) {
		case "Package":
			itemIcon = new ImageView(iconPackage);
			break;
		case "Klasse":
			itemIcon = new ImageView(iconClass);
			break;
		case "Interface":
			itemIcon = new ImageView(iconInterface);
		default:
			break;
		}
		
		//Add item to TreeView
		TreeItem<String> selectedItem = klassenTree.getSelectionModel().getSelectedItem();
		TreeItem<String> newItem = new TreeItem<String>(paneKlasseName.getText(), itemIcon);
		newItem.setExpanded(true);
		selectedItem.getChildren().add(newItem);	
		
		
		//diable all panes
		disableContentPanes();
		
		
	}
	// ----------------------------------------------------------------------------


	// ----------------------------------------------------------------------------
	// TODO ck 29.09.2014
	public void objectNew(){
		
		objectPaneInit();

		// Status auf neues Objekt setzen
		paneKlasseStatus.setText("new");
		
		// alle Werte löschen
		paneKlasseName.clear();
		paneKlasseStereotyp.clear();
		paneKlasseTyp.setValue(null);
				
	}

	
	public void objectEdit(){
		
		objectPaneInit();
	
		// Status auf Objekt bearbeiten setzen
		paneKlasseStatus.setText("edit");
		
		//wenn edit root, dann nichts pane disablen
		if(klassenTree.getSelectionModel().getSelectedItem().equals(klassenTree.getTreeItem(0))){
			disableContentPanes();
		}

		else{

			String switchvar = umlEditor.typeCheck(klassenTree
					.getSelectionModel().getSelectedItem().getValue());
			switch (switchvar) {
			case "Klasse":
				Klasse klasseHolen = umlEditor.holeKlasse(klassenTree
						.getSelectionModel().getSelectedItem().getValue());
				paneKlasseName.setText(klasseHolen.getName());
				paneKlasseStereotyp.setText(klasseHolen.getStereotyp());
				paneKlasseTyp.getSelectionModel().select(klasseHolen.getType());
				break;
			case "Interface":
				Interface interfaceHolen = umlEditor.holeInterface(klassenTree
						.getSelectionModel().getSelectedItem().getValue());
				paneKlasseName.setText(interfaceHolen.getName());
				paneKlasseStereotyp.setText(interfaceHolen.getStereotyp());
				paneKlasseTyp.getSelectionModel().select(
						interfaceHolen.getType());
				break;
			default:
				// Package
				break;
		
		}


		}
	}
	
	
	
		
	// paneKlasse Initialisierung
	public void objectPaneInit() {

		//alle Panes deaktivieren
		disableContentPanes();

		
		// Pane klasse anzeigen
		paneKlasse.setVisible(true);
		
		// Feld Type befüllen mit Standartwerten
		paneKlasseTyp.getItems().clear();
		String typ[] = {"Package","Klasse","Interface"};

		// Prüfen, was für ein Typ das vorherige Objekt hat
		String switchvar = umlEditor.typeCheck(klassenTree.getSelectionModel().getSelectedItem().getValue());
		if(switchvar == null){switchvar = "Package";}
		
		switch (switchvar) {
		case "Klasse":
			// Neue Klasse
			paneKlasseTyp.getItems().addAll(typ[1], typ[2]);
			break;
		case "Interface":
			// Neues Interface
			paneKlasseTyp.getItems().addAll(typ[2]);
			break;
		default:
			paneKlasseTyp.getItems().addAll(typ);
			break;
		}
		

		
	}
	// ----------------------------------------------------------------------------
	
	
	
	
	
						// Pane für neue Klasse
//						public void klassePaneNew(){
//							objectPaneInit();
//							statusFeldText.setText("Neue Klasse anlegen...");
//							
//							paneKlasseTyp.getItems().clear();
//							paneKlasseTyp.getItems().addAll(
//									"Package",
//									"Klasse",
//									"Interface"
//								);
////							
////						}
//						
//						// Pane um eine Klasse zu bearbeiten
//						public void klassePaneEdit(){
//							objectPaneInit();
//							statusFeldText.setText(klassenTree.getSelectionModel().getSelectedItems() + " bearbeiten...");
//						}
//						
//						public void klasseSet() {
//					
//						
//							// Neue Klasse anlegen
//							// TODO
//					
//							// Klasse bearbeiten - Pane mit Werten bef�llen
//							// TODO
//							// paneKlasseName.setText(klassenTree.getSelectionModel().getSelectedItem().getValue().toString());
//							// paneKlasseStereotyp
//							// paneKlasseVererbung
//							//buildTree(klassenTree.getSelectionModel().getSelectedItem());
//					
//						}
//						// ----------------------------------------------------------------------------
					
						
						
						
	
	
	
	
	
	// ----------------------------------------------------------------------------
	// TODO ck 29.09.2014
//	// Tree neu bauen
//	private TreeItem<String> rootItemTree;
//    TreeView<String> treeNew = new TreeView<String>(rootItemTree);        
//    private TreeItem<String> treeItemNew = null;
//    	
//	public void treeBuildNew{
//        TreeItem<String> rootItem = TreeItem<String>(hostname, iconRoot);
    	
//    	klassenTree.setRoot(rootItem);

//	}
	
	


	
	// ----------------------------------------------------------------------------
	
//	
//	
//	public void buildTree(TreeItem<String> treeItem){
//		//Felder vorbereiten
//		//TODO
//		TreeItem<?> selectedItem = klassenTree.getSelectionModel().getSelectedItem();
//		TreeItem<?> treeRoot = klassenTree.getTreeItem(0);
//		//Check if selectedItem is root
//		//int itemLevel = klassenTree.getTreeItemLevel(selectedItem);
//		if(selectedItem.equals(treeRoot)) {
//			//Root Item
//			paneKlasseTyp.getItems().addAll(
//				"Package",
//				"Klasse",
//				"Interface"
//			);
//			paneKlasseTyp.getSelectionModel().select(0);
//			paneKlasseVererbung.setDisable(true);
//		} else {
//			//Sub Item
//			paneKlasseVererbung.setDisable(true);
//			//Ensure only valid types 
//			/*switch () {
//			case value:
//				
//				break;
//
//			default:
//				break;
//			}*/
//		}
//	}
//
//	
//	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	
//	
//	
//	
//	
//	// ck 20.09.2014
//	public void typSave() {
//		// TODO Wert schreiben mit Logik
//		//Check required fields
//		if(paneKlasseName.getText().isEmpty()) {
//			statusFeldText.setText("Name für Objekt eintragen!");
//			statusFeld.setStyle("-fx-background-color: #f67d7d");
//		
//			// TODO mit swtich abfangen 
//			// paneKlasseTyp
//			//WIE OBJECTE IN coisebox, damit ich klasse hinterlegen kann
//			// paneKlasseVererbung.getSelectionModel().getSelectedItem(). 
//			umlEditor.neueKlasse(paneKlasseName.getText(), paneKlasseStereotyp.getText(),null);
//
//		//TODO neuschreiben des baumes!!
//		
//			
//			return;
//
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
//		//Set icon and create object
//		ImageView itemIcon = null;
//		String name = paneKlasseName.getText();
//		switch (paneKlasseTyp.getSelectionModel().getSelectedItem()) {
//		case "Package":
//			itemIcon = new ImageView(iconPackage);
//			/*Package newPackage = new Package();
//			newPackage.setName(paneKlasseName.getText());*/
//			break;
//		case "Klasse":
//			itemIcon = new ImageView(iconClass);
//			/*Klasse newClass = new Klasse();
//			newClass.setName(paneKlasseName.getText());
//			newClass.setStereotyp(paneKlasseStereotyp.getText());
//			newClass.setType("class");*/
//			break;
//		case "Interface":
//			itemIcon = new ImageView(iconInterface);
//			/*Interface newInterface = new Interface();
//			newInterface.setName(paneKlasseName.getText());
//			newInterface.setStereotyp(paneKlasseStereotyp.getText());
//			newInterface.setType("interface");*/
//		default:
//			break;
//		}
//		
//		//Add item to TreeView
//		TreeItem<String> selectedItem = klassenTree.getSelectionModel().getSelectedItem();
//		TreeItem<String> treeRoot = klassenTree.getTreeItem(0);
//		TreeItem<String> newItem = new TreeItem<String>(paneKlasseName.getText(), itemIcon );
//		selectedItem.getChildren().add(newItem);
//		
//		statusFeldSave();
//	}
//
//	
//	
	
	
	
	public void klasseDelete() {
		// TODO Wert schreiben mit Logik
		statusFeldDelete();

	}

	// -------------------------


	
	
	// ----- Men� -> DAtei -----
	// Men� -> Datei �ffnen
	public void fileOpen(){
		Window stage = null;
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Datei speichern unter...");
		File file = fileChooser.showOpenDialog(stage);
		// Pfad mit Dateiname
		System.out.println(file.getAbsolutePath());
		// Dateiname
		System.out.println(file.getName());
		//TODO Dateiname bekannt, dann Methode open aufrufen!! 

	}	
	
	
	// Men� -> Datei speichern unter...
	public void fileSaveAs(){
		Window stage = null;
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Datei speichern unter...");
		File file = fileChooser.showSaveDialog(stage);
		// Pfad mit Dateiname
		System.out.println(file.getAbsolutePath());
		// Dateiname
		System.out.println(file.getName());
		//TODO Dateiname bekannt, dann Methode save aufrufen!! 
	}
	
	// Men� -> Datei speichern 
	public void fileSave(){
		//TODO Methode zum speichern aufrufen mit bekanntem Dateiname
	}
	// -------------------------

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Background wird ge�ndert
	public void ckEasterEggColor() {

		// Farbe �ndern
		final String alphabet = "0123456789ABCDE";
		final int N = alphabet.length();

		Random r = new Random();

		String farbeneu = "";
		for (int i = 0; i < 6; i++) {
			farbeneu = farbeneu + alphabet.charAt(r.nextInt(N));
		}

		painMain.setStyle("-fx-background-color: #" + farbeneu);
		
		//testpane.setStyle("-fx-background-image: url(\"background2.png\");");


		System.out.println("#" + farbeneu);
        
	}



	// Test Hintergrund �ndern
//TODO geht noch nicht
//  Random zahl = new Random();
//  String setBgNew = "-fx-background-image: url(\"background" + (1 + zahl.nextInt(9)) + ".png\");";
//  System.out.println(setBgNew);
	





}

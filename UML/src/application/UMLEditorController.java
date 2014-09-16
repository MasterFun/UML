package application;


import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

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
	public TreeView<String> classTreeBuild = new TreeView<String>();
	
	

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
	ComboBox<String> paneKlasseVererbung;

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

	
	
	private final Node iconRoot = new ImageView(new Image(getClass().getResourceAsStream("TreeRootNode.png")));
	private final Image iconPackage = new Image(getClass().getResourceAsStream("TreePackage.png"));
	private final Image iconClass = new Image(getClass().getResourceAsStream("TreeClass.png"));
	private final Image iconInterface = new Image(getClass().getResourceAsStream("TreeInterface.png"));
	
//	private final Node rootIcon = new ImageView(new Image(getClass().getResourceAsStream("/images/root.png")));
//    private final Image depIcon = new Image(getClass().getResourceAsStream("/images/department.png"));
//    List<Employee> employees = Arrays.<Employee>asList(
//            new Employee("Ethan Williams", "Sales Department"),
//            new Employee("Emma Jones", "Sales Department"),
//            new Employee("Michael Brown", "Sales Department"),
//            new Employee("Anna Black", "Sales Department"),
//            new Employee("Rodger York", "Sales Department"),
//            new Employee("Susan Collins", "Sales Department"),
//            new Employee("Mike Graham", "IT Support"),
//            new Employee("Judy Mayer", "IT Support"),
//            new Employee("Gregory Smith", "IT Support"),
//            new Employee("Jacob Smith", "Accounts Department"),
//            new Employee("Isabella Johnson", "Accounts Department"));
//    TreeItem<String> rootNode = new TreeItem<String>("MyCompany Human Resources", rootIcon);
	
	
	
	
	
	
	public String hostname;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try {
			hostname = InetAddress.getLocalHost().getHostName();
			//TODO
			//System.out.println(hostname.split(".")[0].toString());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	    
		TreeItem<String> classTreeBuild = new TreeItem<String>(hostname, iconRoot);
		

		
		klassenTree.setRoot(classTreeBuild);
		
	    }
	
	
	
	
		
	
	
	// Funktionen
	// Statusfeld gespeichert - Gr�n
	public void statusFeldSave() {
		statusFeldText.setText("gespeichert...");
		statusFeld.setStyle("-fx-background-color: #65f565");
	}

	// Statusfeld gel�scht - Rot
	public void statusFeldDelete() {
		statusFeldText.setText("gel�scht...");
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
		observableListOperation.add("hinzuf�gen...");
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

	// ----- KlassenTree -----
	public void listKlassenTree() {

		statusFeldText.setText("KlassenTree anzeigen...");

		TreeItem<String> stufeEins = new TreeItem<String>("Stufe 1", new ImageView(iconClass));
		TreeItem<String> stufeZwei = new TreeItem<String>("Stufe 2", new ImageView(iconInterface));
		stufeZwei.getChildren().add(new TreeItem<String>("Stufe 2.1", new ImageView(iconPackage)));
		TreeItem<String> stufeDrei = new TreeItem<String>("Stufe 3", new ImageView(iconClass));
		TreeItem<String> stufeVier = new TreeItem<String>("Stufe 4", new ImageView(iconInterface));

		// stufeEins.setExpanded(true);
		
		
		
		stufeEins.getChildren().add(stufeZwei);
		stufeZwei.getChildren().add(stufeDrei);
		stufeDrei.getChildren().add(stufeVier);
		

		
		
		
		klassenTree.setRoot(stufeEins);
		

	}

	// Abfrage f�r Liste Klasse, damit keine Nullpointer Exeption kommt
	public void klasseSetCheckEmpty() {

		if (klassenTree.getSelectionModel().isEmpty()) {
			statusFeldText.setText("KlassenTree leer");
		} else {
			klasseSet();
		}

	}

	public void klasseSet() {

		// TODO Klasse umbauen sonst kann man nicht speichern, auf Funktionen
		// kann nicht zugegriffen werden!

		// Pane aktivieren
		disableContentPanes();

		// Pane klasse anzeigen
		paneKlasse.setVisible(true);
		if (klassenTree.getSelectionModel().isEmpty())
			statusFeldText.setText("Neue Klasse anlegen...");
		else
			statusFeldText.setText(klassenTree.getSelectionModel()
					.getSelectedItems() + " bearbeiten...");
		
		//Felder vorbereiten
		//TODO
		TreeItem<?> selectedItem = klassenTree.getSelectionModel().getSelectedItem();
		TreeItem<?> treeRoot = klassenTree.getTreeItem(0);
		//Check if selectedItem is root
		//int itemLevel = klassenTree.getTreeItemLevel(selectedItem);
		if(selectedItem.equals(treeRoot)) {
			//Root Item
			paneAttributTyp.getItems().addAll(
				"Package",
				"Klasse",
				"Interface"
			);
		} else {
			//Sub Item
			
		}
		
		
		// Neue Klasse anlegen
		// TODO

		// Klasse bearbeiten - Pane mit Werten bef�llen
		// TODO
		// paneKlasseName.setText(klassenTree.getSelectionModel().getSelectedItem().getValue().toString());
		// paneKlasseStereotyp
		// paneKlasseVererbung

	}

	public void klasseSave() {
		// TODO Wert schreiben mit Logik

		statusFeldSave();
	}

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

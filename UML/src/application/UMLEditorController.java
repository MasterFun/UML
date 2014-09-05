package application;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class UMLEditorController {

	// Alle ContentPanes
	@FXML
	Pane painMain, paneOperation, paneAttribut, paneKlasse, statusFeld;

	@FXML
	ListView<String> listAttribut, listOperation, listBeziehung;

	@FXML
	TreeView<String> klassenTree;

	@FXML
	Text statusFeldText;

	// Pane Klasse - Felder
	@FXML
	TextField paneKlasseName, paneKlasseStereotyp;
	@FXML
	ChoiceBox paneKlasseVererbung;

	// Pane Attribut - Felder
	@FXML
	TextField paneAttributName, paneAttributTypString, paneAttributInitialwert,
			paneAttributStereotyp;
	@FXML
	ChoiceBox<String> paneAttributSichtbarkeit, paneAttributTyp;
	@FXML
	CheckBox paneAttributSetter, paneAttributGetter, paneAttributAbgeleitet,
			paneAttributKonstante, paneAttributKlassenattribut;

	// Hilfslisten für Felder
	// Liste für Dropdown Sichtbarkeit
	List<String> sichtbarkeit = Arrays.asList("public", "private", "protected");

	// Liste für Dropdown Typ - Standard Datentypen
	List<String> datentypenStd = Arrays.asList("boolean", "byte", "char",
			"double", "float", "int", "long", "short", "String");

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
		// Statusfeldfarbe zurücksetzen
		statusFeld.setStyle("-fx-background-color: #c0c0c0");
	}

	// ----- Attribut -----
	// TODO bauen, wenn ein Objekt ausgewählt ist oder Neu angelegt wird

	// Liste der Attribute füllen
	public void listAttributAnzeigen() {

		statusFeldText.setText("Liste Attribute anzeigen...");

		// leere Liste erzeugen
		ObservableList<String> observableListAttribut = FXCollections
				.observableList(new ArrayList<String>());

		// ersten Eintrag erzeugen
		observableListAttribut.add("hinzufügen...");
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

		// Feld paneAttributSichtbarkeit befüllen
		// TODO beim bearbeiten von Datensätzen das richtige Feld auf "selected"
		// setzen
		paneAttributSichtbarkeit.getItems().clear();
		for (String sicht : sichtbarkeit) {
			paneAttributSichtbarkeit.getItems().add(sicht);
		}

		// Feld paneAttributTyp befüllen
		// TODO beim bearbeiten von Datensätzen das richtige Feld auf "selected"
		// setzen
		paneAttributTyp.getItems().clear();
		for (String typ : datentypenStd) {
			paneAttributTyp.getItems().add(typ);
		}

		// Neues Attribut anlegen
		if (listAttribut.getSelectionModel().getSelectedItem()
				.equals("hinzufügen...")) {
			statusFeldText.setText("neues Attribut hinzufügen...");
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
	// TODO bauen, wenn ein Objekt ausgewählt ist oder Neu angelegt wird

	// Liste der Operation füllen
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
				.equals("hinzufügen...")) {
			statusFeldText.setText("Neue Operationen hinzufügen...");
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

		TreeItem<String> stufeEins = new TreeItem<String>("Stufe 1");
		TreeItem<String> stufeZwei = new TreeItem<String>("Stufe 2");
		stufeZwei.getChildren().add(new TreeItem<String>("Stufe 2.1"));
		TreeItem<String> stufeDrei = new TreeItem<String>("Stufe 3");
		TreeItem<String> stufeVier = new TreeItem<String>("Stufe 4");

		// stufeEins.setExpanded(true);

		stufeEins.getChildren().add(stufeZwei);
		stufeZwei.getChildren().add(stufeDrei);
		stufeDrei.getChildren().add(stufeVier);

		klassenTree.setRoot(stufeEins);

	}

	// Abfrage für Liste Klasse, damit keine Nullpointer Exeption kommt
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

		// Neue Klasse anlegen
		// TODO

		// Klasse bearbeiten - Pane mit Werten befüllen
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


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Background wird geändert
	public void ckEasterEggColor() throws InterruptedException {

		final String alphabet = "0123456789ABCDEF";
		final int N = alphabet.length();

		Random r = new Random();

		String farbeneu = "";
		for (int i = 0; i < 6; i++) {
			farbeneu = farbeneu + alphabet.charAt(r.nextInt(N));
		}

		painMain.setStyle("-fx-background-color: #" + farbeneu);
	}

}

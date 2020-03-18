package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private TextField txtTime;
    
    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML 
    private Button btnDelete;

    @FXML
    void doDelete(ActionEvent event) {
    	long startTime = System.nanoTime();
    	String word = txtResult.getSelectedText();
    	elenco.remove(word);
    	display(startTime);
    	
    }
    
    void display(long startTime) {
    	String res = "";
    	for (String s : elenco.getElenco()) {
    		res += s + "\n";
    	}
    	txtResult.clear();
    	txtTime.clear();
    	txtResult.appendText(res);
    	long diff = System.nanoTime() - startTime;
    	txtTime.appendText( String.valueOf(diff));
    }
    @FXML
    void doInsert(ActionEvent event) {
    	// TODO
    	long startTime = System.nanoTime();
    	elenco.addParola(txtParola.getText());
    	display(startTime);
    }

    @FXML
    void doReset(ActionEvent event) {
    	// TODO
    	long startTime = System.nanoTime();
    	elenco.reset();
    	txtResult.clear();
    	txtTime.clear();
    	long diff = System.nanoTime() - startTime;
    	txtTime.appendText( String.valueOf(diff));
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}

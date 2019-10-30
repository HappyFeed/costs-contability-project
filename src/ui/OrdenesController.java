package ui;

import java.util.ArrayList;
import java.util.List;

import customeExceptions.NegativeNumberException;
import customeExceptions.NoDataException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;
import jdk.nashorn.internal.ir.ContinueNode;
import model.EstadoCostos;
import model.Orden;

public class OrdenesController {

    @FXML
    private TextField term;

    @FXML
    private TextField companyName;

    @FXML
    private ComboBox<String> tasaCIFComboBox;

    @FXML
    private TextField cifPresupuestados;

    @FXML
    private TextField baseCif;

    @FXML
    private TextField nameOrden;

    @FXML
    private TextField mdOrden;

    @FXML
    private TextField cifAOrden;

    @FXML
    private TextField modOrden;

    @FXML
    private TextField tasaCif;
    
    @FXML
    private ComboBox<String> periodoOrden;

    @FXML
    private ComboBox<String> estadoOrden;

    @FXML
    private VBox estadoVboxP;

    @FXML
    private VBox nameVboxP;

    @FXML
    private VBox mdVboxP;

    @FXML
    private VBox modVboxP;

    @FXML
    private VBox cifVboxP;

    @FXML
    private Button buttonNameP;

    @FXML
    private Button buttonMDP;

    @FXML
    private Button buttonMODP;

    @FXML
    private Button buttonCIFP;

    @FXML
    private Button buttonEstadoP;

    @FXML
    private VBox estadoVboxA;

    @FXML
    private VBox nameVboxA;

    @FXML
    private VBox mdVboxA;

    @FXML
    private VBox modVboxA;

    @FXML
    private VBox cifVboxA;

    @FXML
    private Button buttonCIFA;

    @FXML
    private Button buttonMODA;

    @FXML
    private Button buttonMDA;

    @FXML
    private Button buttonNameA;

    @FXML
    private Button buttonEstadoA;

    @FXML
    private Label nPaginaP;

    @FXML
    private Label baseKnd;
    
    @FXML
    private Button paginaAnteriorP;

    @FXML
    private Button paginaSgtP;

    @FXML
    private Button paginaAnteriorA;

    @FXML
    private Label nPaginaA;
    
    
    @FXML
    private Label cifPresupuestadasLabel;
    
    @FXML
    private Label  baseLabel;
    
    @FXML
    private Button paginaSgtA;

    @FXML
    private Button buttonTerminar;

    @FXML
    private Button buttonNewOrder;

    @FXML
    private Button buttonContinuar;

    @FXML
    private Button buttonCIFP1;
    
    private EstadoCostos ec;
    private List<Orden> ordenes=new ArrayList<Orden>();

    @FXML
    void initialize() {
    	tasaCIFComboBox.getItems().add("Horas maquina");
    	tasaCIFComboBox.getItems().add("Horas hombre");
    	tasaCif.setEditable(false);
    }
    
    @FXML
    void calculateCifTasa(ActionEvent event) {
    	try {
        	term.setEditable(false);
        	companyName.setEditable(false);
        	String n=tasaCIFComboBox.getValue();
        	if(n.equals("Horas maquina")) {
        		tasaCIFComboBox.setEditable(false);
        		baseKnd.setText("Horas maquina");
        	}else {
        		tasaCIFComboBox.setEditable(false);
        		baseKnd.setText("Horas hombre");
        	}
    	    buttonContinuar.setDisable(false);
    	}catch(NullPointerException npe) {
    		npe.printStackTrace();
    	}

    }
        
    @FXML
    void calculateCostState(ActionEvent event) {

    }

    @FXML
    void lastPageA(ActionEvent event) {

    }

    @FXML
    void lastPageP(ActionEvent event) {

    }

    @FXML
    void makeOrder(ActionEvent event) {
    	try{
        	String nameOrder=nameOrden.getText();
        	if(nameOrder.isEmpty()) {
        		throw new NoDataException(nameOrder);
        	}
        	double md= Double.parseDouble(mdOrden.getText());
        	if(md<0) {
        		throw new NegativeNumberException(md);
        	}else if(mdOrden.getText().isEmpty()) {
        		throw new NoDataException(mdOrden.getText());
        	}
        	double mod=Double.parseDouble(modOrden.getText());
        	if(mod<0) {
        		throw new NegativeNumberException(md);
        	}else if(modOrden.getText().isEmpty()) {
        		throw new NoDataException(modOrden.getText());
        	}
        	/*if(tasaCIFComboBox.getValue().equals("Si")|| ) {
        		
        	}*/
        	//Order n= new Order();
    	}catch(NoDataException nde) {
    		Alert score = new Alert(AlertType.ERROR);
		    score.setTitle("Contabilidad y costos");
		    score.initStyle(StageStyle.DECORATED);
		    score.setContentText(nde.getMessage());
		    score.show();
		    nameOrden.setText("");
    	}catch(NegativeNumberException nne) {
			Alert score = new Alert(AlertType.ERROR);
		    score.setTitle("Contabilidad y costos");
		    score.initStyle(StageStyle.DECORATED);
		    score.setContentText(nne.getMessage());
		    score.show();
		    mdOrden.setText("");
    	}

    	
    }

    @FXML
    void nextPageA(ActionEvent event) {

    }

    @FXML
    void nextPageP(ActionEvent event) {

    }

    @FXML
    void preData(ActionEvent event){
    	try {

        	String nameCompany=companyName.getText();
        	String termStateCost=term.getText();
        	if(nameCompany.isEmpty()) {
        		throw new NoDataException(nameCompany);
        	}
        	if(termStateCost.isEmpty()) {
        		throw new NoDataException(nameCompany);
        	}
        		double cifPre=Double.parseDouble(cifPresupuestados.getText());
            	double baseCif1=Double.parseDouble(baseCif.getText());
            	if(cifPre<0) {
            		throw new NegativeNumberException(cifPre);
            	}else if(cifPresupuestados.getText().isEmpty()) {
            		throw new NoDataException(cifPresupuestados.getText());
            	}
            	if(baseCif1<0) {
            		throw new NegativeNumberException(baseCif1);
            	}else if(baseCif.getText().isEmpty()) {
            		throw new NoDataException(baseCif.getText());
            	}
            	double tasa=cifPre/baseCif1;
            	tasaCif.setText(""+tasa);
            	buttonContinuar.setDisable(true);
        	
    	}catch(NoDataException nde) {
			Alert score = new Alert(AlertType.ERROR);
		    score.setTitle("Contabilidad y costos");
		    score.initStyle(StageStyle.DECORATED);
		    score.setContentText(nde.getMessage());
		    score.show();
		    companyName.setText("");
		    term.setText("");
		    buttonContinuar.setDisable(true);
    		term.setEditable(true);
        	companyName.setEditable(true);
        	tasaCIFComboBox.setEditable(true);
    	}catch(NegativeNumberException nne) {
			Alert score = new Alert(AlertType.ERROR);
		    score.setTitle("Contabilidad y costos");
		    score.initStyle(StageStyle.DECORATED);
		    score.setContentText(nne.getMessage());
		    score.show();
		    cifPresupuestados.setText("");
		    baseCif.setText("");
		    buttonContinuar.setDisable(true);
		    tasaCIFComboBox.setEditable(true);
    	}catch(NumberFormatException nfe) {
			Alert score = new Alert(AlertType.ERROR);
		    score.setTitle("Contabilidad y costos");
		    score.initStyle(StageStyle.DECORATED);
		    score.setContentText(nfe.getMessage());
		    score.show();
		    cifPresupuestados.setText("");
		    baseCif.setText("");
		    buttonContinuar.setDisable(true);
		    tasaCIFComboBox.setEditable(true);
    	}

    	
    }

}


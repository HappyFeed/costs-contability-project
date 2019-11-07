package ui;

import java.io.FileNotFoundException;
import java.util.ArrayList;


import customeExceptions.NegativeNumberException;
import customeExceptions.NoDataException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;
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
    
    @FXML
    private Label nombreLabel;
    
    @FXML
    private Label mdLabel;

    @FXML
    private Label modLabel;
    
    @FXML
    private Button buttonEliminar;

    @FXML
    private TextField nameOrdenToDelete;

    @FXML
    private Label nombreLabel1;

    @FXML
    private Label cifRealesLabel1;

    @FXML
    private TextField cifReales1;
    
    private EstadoCostos ec;
    private ArrayList<Orden> ordenes=new ArrayList<Orden>();
    private double cifReales=0;

    @FXML
    void initialize() {
    	tasaCIFComboBox.getItems().add("Horas maquina");
    	tasaCIFComboBox.getItems().add("Horas hombre");
    	periodoOrden.getItems().add("ACTUAL");
    	periodoOrden.getItems().add("ANTERIOR");
    	estadoOrden.getItems().add("TERMINADO");
    	estadoOrden.getItems().add("PROCESO");
    	estadoOrden.getItems().add("VENDIDA");
    	tasaCif.setEditable(false);
    	nameOrden.setVisible(false);
    	nombreLabel.setVisible(false);
    	mdLabel.setVisible(false);
    	modLabel.setVisible(false);
    	nameOrden.setVisible(false);
    	mdOrden.setVisible(false);
    	modOrden.setVisible(false);
    	cifAOrden.setVisible(false);
    	estadoOrden.setVisible(false);
    	periodoOrden.setVisible(false);
    	buttonNewOrder.setVisible(false);
    	baseKnd.setVisible(false);
    	ec=new EstadoCostos();
    	buttonEliminar.setVisible(false);
    	nombreLabel1.setVisible(false);
    	nameOrdenToDelete.setVisible(false);
    }
    
    @FXML
    void deleteOrden(ActionEvent event) {
    
    	try {
    	String nameOrden= nameOrdenToDelete.getText();
    	if (nameOrden.isEmpty()) {
			throw new NoDataException(nameOrden);
		}
    		
    	if (ordenes.isEmpty()) {
    		
    	}else {
			for (int i = 0; i < ordenes.size(); i++) {
				if (ordenes.get(i).getNombre().equals(nameOrden)) {
					ordenes.remove(i);
					if (ordenes.isEmpty()) {
						buttonEliminar.setVisible(false);
				    	nombreLabel1.setVisible(false);
				    	nameOrdenToDelete.setVisible(false);
					}
				}
			}
		}
    	}catch (NoDataException nd) {
    		Alert score = new Alert(AlertType.ERROR);
		    score.setTitle("Contabilidad y costos");
		    score.initStyle(StageStyle.DECORATED);
		    score.setContentText(nd.getMessage());
		    score.show();
			
		}

    }
    
    @FXML
    void calculateCifTasa(ActionEvent event) {
    	try {
        	String nameCompany=companyName.getText();
        	String termStateCost=term.getText();
        	
        	ec.setPeriodoRealizacion(termStateCost);
        	
        	if(nameCompany.isEmpty()) {
        		throw new NoDataException(nameCompany);
        	}
        	if(termStateCost.isEmpty()) {
        		throw new NoDataException(nameCompany);
        	}
        	ec.setCifReales(cifReales);
        	ec.setNombreEmpresa(nameCompany);
        	term.setEditable(false);
        	companyName.setEditable(false);
        	String n=tasaCIFComboBox.getValue();
        	if(n.equals("Horas maquina")) {
        		tasaCIFComboBox.setDisable(false);
        		baseKnd.setText("Horas maquina");
        	}else {
        		tasaCIFComboBox.setDisable(false);
        		baseKnd.setText("Horas hombre");
        	}
    	    buttonContinuar.setDisable(false);
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
        	tasaCIFComboBox.setDisable(false);
    	}
    	
    	
    }
        
    @FXML
    void calculateCostState(ActionEvent event) {
    	ec.setOrdenes(ordenes);
    	try {
			ec.exportCostState("data/EstadoDeCostos.txt");
			Alert score = new Alert(AlertType.CONFIRMATION);
		    score.setTitle("Contabilidad y costos");
		    score.initStyle(StageStyle.DECORATED);
		    score.setContentText("Su estado de costos ha sido creado con exito, por favor reviselo en la carpeta data");
		    score.show();
		    
			
		} catch (FileNotFoundException e) {
			Alert score = new Alert(AlertType.ERROR);
		    score.setTitle("Contabilidad y costos");
		    score.initStyle(StageStyle.DECORATED);
		    score.setContentText("Hubo un  error al generar el estaado de costos");
		    score.show();
		}
    }

    @FXML
    void lastPageA(ActionEvent event) {
        int newPage= Integer.parseInt(nPaginaA.getText())-1;
        if(newPage>0) {
        	nPaginaA.setText(newPage+"");
        	clearDataA();
        	showTableA();
        }
    }

    @FXML
    void lastPageP(ActionEvent event) {
        int newPage= Integer.parseInt(nPaginaP.getText())-1;
        if(newPage>0) {
        	nPaginaP.setText(newPage+"");
        	clearDataP();
        	showTableP();
        }
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
        	
        	Orden n= new Orden(nameOrden.getText(), periodoOrden.getValue(), estadoOrden.getValue(),Double.parseDouble( mdOrden.getText()), Double.parseDouble(cifAOrden.getText())*Double.parseDouble(tasaCif.getText()),Double.parseDouble(modOrden.getText()));
        	ordenes.add(n);
        	buttonEliminar.setVisible(true);
        	nombreLabel1.setVisible(true);
        	nameOrdenToDelete.setVisible(true);
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

    public void clearDataA() {
    	estadoVboxA.getChildren().clear();
    	nameVboxA.getChildren().clear();
    	mdVboxA.getChildren().clear();
    	modVboxA.getChildren().clear();
    	cifVboxA.getChildren().clear();
    }
    
    public void clearDataP() {
    	estadoVboxP.getChildren().clear();
    	nameVboxP.getChildren().clear();
    	mdVboxP.getChildren().clear();
    	modVboxP.getChildren().clear();
    	cifVboxP.getChildren().clear();
    }
    
    @FXML
    void nextPageA(ActionEvent event) {
    	ArrayList<Orden> n= new ArrayList<Orden>();
    	for(int i=0;i<ordenes.size();i++) {
    		if(ordenes.get(i).getPeriodo().equals("ACTUAL")) {
    			n.add(ordenes.get(i));
    		}
    	}
    	int newPage= Integer.parseInt(nPaginaA.getText())+1;
        if(newPage<(n.size()/4)+2) {
        	nPaginaA.setText(newPage+"");
        	clearDataA();
        	showTableA();
        }
    }

    @FXML
    void nextPageP(ActionEvent event) {
    	ArrayList<Orden> n= new ArrayList<Orden>();
    	for(int i=0;i<ordenes.size();i++) {
    		if(ordenes.get(i).getPeriodo().equals("ACTUAL")) {
    			n.add(ordenes.get(i));
    		}
    	}
    	int newPage= Integer.parseInt(nPaginaP.getText())+1;
        if(newPage<(n.size()/4)+2) {
        	nPaginaP.setText(newPage+"");
        	clearDataP();
        	showTableP();
        }
    }

    public void showTableP() {
    	ArrayList<Orden> n= new ArrayList<Orden>();
    	for(int i=0;i<ordenes.size();i++) {
    		if(ordenes.get(i).getPeriodo().equals("ANTERIOR")) {
    			n.add(ordenes.get(i));
    		}
    	}
    	int pages=(n.size()/4);
    	if(n.size()%4>0) {
    		pages+=1;
    	}
    	for(int j=0;j<pages;j++){
    		if(j+1==Integer.parseInt(nPaginaP.getText())){
    	    	for (int i = (4*j); i <4+(4*j) && i<n.size(); i++) {
    	    		Label e = new Label("\t"+n.get(i).getEstado());
    				Label na = new Label("\t"+n.get(i).getNombre());
    				Label md = new Label("\t"+n.get(i).getMd());
    				Label mod = new Label("\t"+n.get(i).getMod());
    				Label cif = new Label("\t"+n.get(i).getCif());			
    				
    				estadoVboxP.getChildren().add(e);
    				nameVboxP.getChildren().add(na);
    				mdVboxP.getChildren().add(md);
    				modVboxP.getChildren().add(mod);
    				cifVboxP.getChildren().add(cif);
    		    }
    	    }
		}
    }
    
    public void showTableA() {
    	ArrayList<Orden> n= new ArrayList<Orden>();
    	for(int i=0;i<ordenes.size();i++) {
    		if(ordenes.get(i).getPeriodo().equals("ACTUAL")) {
    			n.add(ordenes.get(i));
    		}
    	}
    	int pages=(n.size()/4);
    	if(n.size()%4>0) {
    		pages+=1;
    	}
    	for(int j=0;j<pages;j++){
    		if(j+1==Integer.parseInt(nPaginaA.getText())){
    	    	for (int i = (4*j); i <4+(4*j) && i<n.size(); i++) {
    	    		Label e = new Label("\t"+n.get(i).getEstado());
    				Label na = new Label("\t"+n.get(i).getNombre());
    				Label md = new Label("\t"+n.get(i).getMd());
    				Label mod = new Label("\t"+n.get(i).getMod());
    				Label cif = new Label("\t"+n.get(i).getCif());			
    				
    				estadoVboxA.getChildren().add(e);
    				nameVboxA.getChildren().add(na);
    				mdVboxA.getChildren().add(md);
    				modVboxA.getChildren().add(mod);
    				cifVboxA.getChildren().add(cif);
    		    }
    	    }
		}
    }
    
    @FXML
    void preData(ActionEvent event){
    	try {


        		double cifPre=Double.parseDouble(cifPresupuestados.getText());
            	double baseCif1=Double.parseDouble(baseCif.getText());
            	cifReales=Double.parseDouble(cifReales1.getText());
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
            	if(cifReales==0) {
            		throw new NegativeNumberException(baseCif1);
            	}else if(cifReales1.getText().isEmpty()) {
            		throw new NoDataException(baseCif.getText());
            	}
            	
            	double tasa=redondearDecimales((cifPre/baseCif1),2); 
            	tasaCif.setText(tasa+"");
            	buttonContinuar.setDisable(true);
            	tasaCIFComboBox.setDisable(true);

            	nameOrden.setVisible(true);
            	nombreLabel.setVisible(true);
            	mdLabel.setVisible(true);
            	modLabel.setVisible(true);
            	nameOrden.setVisible(true);
            	mdOrden.setVisible(true);
            	modOrden.setVisible(true);
            	cifAOrden.setVisible(true);
            	estadoOrden.setVisible(true);
            	periodoOrden.setVisible(true);
            	buttonNewOrder.setVisible(true);
            	baseKnd.setVisible(true);

    	}catch(NoDataException nde) {
			Alert score = new Alert(AlertType.ERROR);
		    score.setTitle("Contabilidad y costos");
		    score.initStyle(StageStyle.DECORATED);
		    score.setContentText(nde.getMessage());
		    score.show();
		    baseCif.setText("");
		    cifPresupuestados.setText("");
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
    
    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }

}


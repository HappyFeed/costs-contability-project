package ui;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
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
    private CheckBox porcentajeTasa;

    @FXML
    private Button buttonYesCalculate;

    @FXML
    private Button buttonNoCalculate;

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
    private Button paginaAnteriorP;

    @FXML
    private Button paginaSgtP;

    @FXML
    private Button paginaAnteriorA;

    @FXML
    private Label nPaginaA;
    
    @FXML
    private Label questionCif;
    
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
    	tasaCIFComboBox.getItems().add("Si");
    	tasaCIFComboBox.getItems().add("No");
    	questionCif.setVisible(false);
    	buttonYesCalculate.setVisible(false);
    	buttonNoCalculate.setVisible(false);
    	cifPresupuestadasLabel.setVisible(false);
    	baseLabel.setVisible(false);
    	cifPresupuestados.setVisible(false);
    	baseCif.setVisible(false);
    	tasaCif.setVisible(false);
    	buttonContinuar.setDisable(true);
    }
    
    @FXML
    void calculateCifTasa(ActionEvent event) {
    	if(tasaCIFComboBox.getValue().equals("No")) {
    		tasaCIFComboBox.setDisable(true);
        	questionCif.setVisible(true);
        	buttonYesCalculate.setVisible(true);
        	buttonNoCalculate.setVisible(true);

    	}else {
    		tasaCif.setVisible(true);   
    		tasaCIFComboBox.setDisable(true);
    	}
    }
    
    @FXML
    void correctData(ActionEvent event) {
		if(tasaCif.getText()!=null) {
			buttonContinuar.setDisable(false);
		}else {
			
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
    	

    }

    @FXML
    void nextPageA(ActionEvent event) {

    }

    @FXML
    void nextPageP(ActionEvent event) {

    }

    @FXML
    void preData(ActionEvent event) {
    	if(cifPresupuestados.isDisable()) {
    		double cifPre=Double.parseDouble(cifPresupuestados.getText());
        	double baseCif=Double.parseDouble(cifPresupuestados.getText());
        	double tasa=cifPre/baseCif;
        	//linea para asignar los cif aplicados ya con la tasa
        	buttonContinuar.setDisable(true);
    	}
    	
    	
    	
    }
    
    @FXML
    void yesCalculate(ActionEvent event) {
    	cifPresupuestadasLabel.setVisible(true);
    	baseLabel.setVisible(true);
    	cifPresupuestados.setVisible(true);
    	baseCif.setVisible(true);
    }
    @FXML
    void noCalculate(ActionEvent event) {
    	buttonContinuar.setDisable(false);
    }

}



package UserInterface.Form;

import java.net.URL;
import java.util.ResourceBundle;
import DataAccess.DTO.SistemaSeguimientoYAsistencia_DTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * Clase FXML Controller class para control de la ventana del menu
 */
public class VentanaMenuController implements Initializable {
    @FXML
    private BorderPane anchorPanePrincipal;
    @FXML
    private Label laberlFechasActual;
    @FXML
    private Button botonInicio;
    @FXML
    private Label laberlFracesMotivadores;
    @FXML
    private ToggleButton botonRegistro;
    @FXML
    private ToggleGroup PrincipalButtons;
    @FXML
    private ToggleButton botonIngresoSalida;
    @FXML
    private ToggleButton botonCalculoRemuneracion;

    public Pane view;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SistemaSeguimientoYAsistencia_DTO sis = new SistemaSeguimientoYAsistencia_DTO();
        laberlFechasActual.setText(sis.getNombreDiaDeLaSemana()+", "+sis.getNumeroDia()+" de "+sis.getNombreMes().toLowerCase()+" de "+2024);
    }    

    /**
     * evento para que se muestre la ventana de Vacio
     * @param event: el evento espera a que el boton sea seleccionado
     */
    @FXML
    private void acBotonInicio(ActionEvent event) {
        VentanaMenuController object = new VentanaMenuController();
        view = object.getPage("Vacio");
        anchorPanePrincipal.setCenter(view);
    }

    /**
     * evento para que se muestre la ventana de RegistroTrabajador
     * @param event: el evento espera a que el boton sea seleccionado
     */
    @FXML
    private void acBotonRegistro(ActionEvent event) {
        if(botonRegistro.isSelected()){
            VentanaMenuController object = new VentanaMenuController();
            view = object.getPage("RegistroTrabajador");
            anchorPanePrincipal.setCenter(view);
        }else{
            VentanaMenuController object = new VentanaMenuController();
            view = object.getPage("Vacio");
            anchorPanePrincipal.setCenter(view);
        }
    }

    /**
     * evento para que se muestre la ventana de RegistroEntradaSalida
     * @param event: el evento espera a que el boton sea seleccionado
     */
    @FXML
    private void acBotonIngresoSalida(ActionEvent event) {
        if(botonIngresoSalida.isSelected()){
            VentanaMenuController object = new VentanaMenuController();
            view = object.getPage("RegistroEntradaSalida");
            anchorPanePrincipal.setCenter(view);
        }else{
            VentanaMenuController object = new VentanaMenuController();
            view = object.getPage("Vacio");
            anchorPanePrincipal.setCenter(view);
        }
    }

    /**
     * evento para que se muestre la ventana de CalculoRemuneracion
     * @param event: el evento espera a que el boton sea seleccionado
     */
    @FXML
    private void acBotonCalculoRemuneracion(ActionEvent event) {
        if(botonCalculoRemuneracion.isSelected()){
            VentanaMenuController object = new VentanaMenuController();
            view = object.getPage("CalculoRemuneracion");
            anchorPanePrincipal.setCenter(view);
        }else{
            VentanaMenuController object = new VentanaMenuController();
            view = object.getPage("Vacio");
            anchorPanePrincipal.setCenter(view);
        }
    }

    /**
     * evento para que se cierre el programa
     * @param event: el evento espera a que el boton sea seleccionado
     */
    @FXML
    private void terminarAplicacion(ActionEvent event) {
        System.exit(0);
    }
    
    /**
     * Metodo para conectarse con las ventanas a abrir
     * @param fileName: nombre del archivo de la ventana
     * @return: retorna el nombre del pane del archivo
     */
    public Pane getPage (String fileName){
        try {
            URL fileUrl = VentanaMenuController.class.getResource("/UserInterface/CustomerControl/"+fileName+".fxml");
            if(fileName == null){
                throw new java.io.FileNotFoundException("FXML no se encuentra");
            }
            view = new FXMLLoader().load(fileUrl);
        } catch (Exception e) {
            System.out.println("FXML no se encuentra");
        }
        return view;
    }
}


package UserInterface.Form;

import FrameWork.GroupThreeException;

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
 * FXML Controller class
 *
 * @author jonat
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

    @FXML
    private void acBotonInicio(ActionEvent event) {
        VentanaMenuController object = new VentanaMenuController();
        view = object.getPage("Carga");
        anchorPanePrincipal.setCenter(view);
    }

    @FXML
    private void acBotonRegistro(ActionEvent event) {
        VentanaMenuController object = new VentanaMenuController();
        view = object.getPage("RegistroTrabajador");
        anchorPanePrincipal.setCenter(view);
    }

    @FXML
    private void acBotonIngresoSalida(ActionEvent event) {
        VentanaMenuController object = new VentanaMenuController();
        view = object.getPage("RegistroEntradaSalida");
        anchorPanePrincipal.setCenter(view);
    }

    @FXML
    private void acBotonCalculoRemuneracion(ActionEvent event) {
        VentanaMenuController object = new VentanaMenuController();
        view = object.getPage("CalculoRemuneracion");
        anchorPanePrincipal.setCenter(view);
    }

    @FXML
    private void terminarAplicacion(ActionEvent event) {
        System.exit(0);
    }
    
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

package UserInterface.Form;

import java.net.URL;
import java.util.ResourceBundle;
import Business.BusinessLogic.RegistroEmpleadoBL;
import Business.BusinessLogic.SistemaControlAccesoBL;
import Business.BusinessLogic.SistemaSeguimientoYAsistenciaBL;
import DataAccess.DAO.SistemaSeguimientoYAsistencia_DAO;
import DataAccess.DTO.RegistroEmpleado_DTO;
import DataAccess.DTO.SistemaControlAcceso_DTO;
import DataAccess.DTO.SistemaSeguimientoYAsistencia_DTO;
import FrameWork.GroupThreeException;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Clase FXML Controller class para control de la ventana de entrada y salida
 */
public class RegistroEntradaSalidaController implements Initializable {

    @FXML
    private TextField txtFieldIngresoCodigoBarras;
    @FXML
    private Button btnEntradaYSalida;
    @FXML
    private TextField txtFieldNombresyapellidos;
    @FXML
    private TextField txtFieldHoras;
    @FXML
    private TextField txtFieldDia;
    @FXML
    private TextField txtFieldMes;
    @FXML
    private Label labelInfor;

    SistemaSeguimientoYAsistencia_DTO empleado = new SistemaSeguimientoYAsistencia_DTO();
    SistemaSeguimientoYAsistencia_DAO empleadoCuatro = new SistemaSeguimientoYAsistencia_DAO();
    SistemaControlAcceso_DTO empleadoTres = new SistemaControlAcceso_DTO();
    RegistroEmpleado_DTO empleadoDos = new RegistroEmpleado_DTO();
    SistemaControlAccesoBL elNuevoDos = new SistemaControlAccesoBL();
    SistemaSeguimientoYAsistenciaBL elNuevo = new SistemaSeguimientoYAsistenciaBL();
    RegistroEmpleadoBL elOtroNuevo = new RegistroEmpleadoBL();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtFieldIngresoCodigoBarras.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() >= 6) { 
                    Platform.runLater(() -> btnEntradaYSalida.fire());
                }
            }
        });
    }    

    /**
     * Metodo para registrar tanto la entrada como la salida de una persona
     * @param event el evento espera a que el boton sea seleccionado
     * @throws GroupThreeException En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    @FXML
    private void acRegistrarEntrada(ActionEvent event) throws GroupThreeException {
        if(verficarBarra(txtFieldIngresoCodigoBarras)){
            empleado.setiDPersonas(Integer.parseInt(txtFieldIngresoCodigoBarras.getText()));
            empleadoTres.setiDPersonas(Integer.parseInt(txtFieldIngresoCodigoBarras.getText()));
            try {
                if(elNuevo.create(empleado, labelInfor)){
                    empleadoDos = elOtroNuevo.readBy(Integer.parseInt(txtFieldIngresoCodigoBarras.getText()), labelInfor);
                    llenarBloques();
                    txtFieldMes.setText(empleado.getNombreMes());
                    labelInfor.setText("Registro Exitoso de su entrada");
                    labelInfor.setStyle("-fx-text-fill: #66FF66");
                    txtFieldIngresoCodigoBarras.setText("");
                }else if (elNuevo.update(empleado, labelInfor)){
                    empleadoDos = elOtroNuevo.readBy(Integer.parseInt(txtFieldIngresoCodigoBarras.getText()), labelInfor);
                    llenarBloques();
                    txtFieldMes.setText(empleado.getNombreMes());
                    if(elNuevoDos.create(empleadoTres, labelInfor)){
                        empleado=empleadoCuatro.readByDiaMes(Integer.parseInt(txtFieldIngresoCodigoBarras.getText()), empleado.getNumeroDia(), empleado.getNumeroMes(), labelInfor);
                    }else if (elNuevoDos.update(empleadoTres, labelInfor)){
                    }
                    labelInfor.setText("Registro Exitoso de su Salida");
                    labelInfor.setStyle("-fx-text-fill: #E53935");
                    txtFieldIngresoCodigoBarras.setText("");
                }
            } catch (Exception e) {
                throw new GroupThreeException(e.getMessage(),getClass().getName(),"acRegistrarEntrada()");
            }
        }
        
    }


    /**
     * metodo para llenas los textfields de acuerdo al codigo de barras
     */
    private void llenarBloques() {
        txtFieldNombresyapellidos.setText(empleadoDos.getNombre()+" "+empleadoDos.getSegundoNombre()+" "+empleadoDos.getApellido()+" "+empleadoDos.getSegundoApellido());
        txtFieldHoras.setText(empleado.getHoraAlMomento()+":"+empleado.getMinutoAlMomento());
        txtFieldDia.setText(empleado.getNombreDiaDeLaSemana()+" "+empleado.getNumeroDia()+", de "+empleado.getNombreMes());
    }

    /**
     * metodo para verificar si los datos ingresados al textfield es correcta
     * @param cBarras el dato que ingresa en el lecto de barras
     * @return: retoena un entero que indica si puede ingresar o no
     */
    private int verificarBarraUsuario(String cBarras){
        if(cBarras.length() == 6){
            try {
                Integer.parseInt(cBarras);
                if((((Integer.parseInt(cBarras.substring(0,1)))+(Integer.parseInt(cBarras.substring(1,2)))+(Integer.parseInt(cBarras.substring(2,3)))+(Integer.parseInt(cBarras.substring(3,4)))-(Integer.parseInt(cBarras.substring(4,5)))-(Integer.parseInt(cBarras.substring(5,6))))==1)){
                    return 0;
                }else if((((Integer.parseInt(cBarras.substring(0,1)))+(Integer.parseInt(cBarras.substring(1,2)))+(Integer.parseInt(cBarras.substring(2,3)))+(Integer.parseInt(cBarras.substring(3,4)))+(Integer.parseInt(cBarras.substring(4,5)))+(Integer.parseInt(cBarras.substring(5,6))))==24)){
                    return 1;
                }
                return 4;
            } catch (Exception e) {
                return 2;
            }
        }
        return 3;
    }

    /**
     * Metodo que verifica los datos ingresados al lector de barras
     * @param codigoBarras datos ingresados al lector de barras
     * @return: retorna un booleano que indica si puede proseguir o no con el programa
     */
    public boolean verficarBarra(TextField codigoBarras) {
        try {
            Integer.parseInt(codigoBarras.getText());
            if(verificarBarraUsuario(codigoBarras.getText())==0||verificarBarraUsuario(codigoBarras.getText())==1){
                return true;
            }
            labelInfor.setText("Su codigo de barras no es válido");
            return false;
        } catch (Exception e) {
            labelInfor.setText("Utilice el lector de barras");
            return false;
        }
    }
    
}

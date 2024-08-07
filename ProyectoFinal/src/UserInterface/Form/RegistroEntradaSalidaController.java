/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
 * FXML Controller class
 *
 * @author jonat
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
                // Verificar la longitud del texto
                if (newValue.length() >= 6) { // Cambiar 5 por el número deseado de caracteres
                    // Simular la presión del botón
                    Platform.runLater(() -> btnEntradaYSalida.fire());
                }
            }
        });
    }    

    @FXML
    private void acRegistrarEntrada(ActionEvent event) throws GroupThreeException {
        
        if(verficarBarra(txtFieldIngresoCodigoBarras)){
            empleado.setiDPersonas(Integer.parseInt(txtFieldIngresoCodigoBarras.getText()));
            empleadoTres.setiDPersonas(Integer.parseInt(txtFieldIngresoCodigoBarras.getText()));
            try {
                if(elNuevo.create(empleado, labelInfor)){//entrada
                    empleadoDos = elOtroNuevo.readBy(Integer.parseInt(txtFieldIngresoCodigoBarras.getText()), labelInfor);
                    llenarBloques();
                    txtFieldMes.setText(empleado.getNombreMes());
                    labelInfor.setText("Registro Exitoso de su entrada");
                    labelInfor.setStyle("-fx-text-fill: #66FF66");
                    
                    
                }else if (elNuevo.update(empleado, labelInfor)){//salida
                    empleadoDos = elOtroNuevo.readBy(Integer.parseInt(txtFieldIngresoCodigoBarras.getText()), labelInfor);
                    llenarBloques();
                    txtFieldMes.setText(empleado.getNombreMes());
                    //llenadomes
                    if(elNuevoDos.create(empleadoTres, labelInfor)){
                        empleado=empleadoCuatro.readByDiaMes(Integer.parseInt(txtFieldIngresoCodigoBarras.getText()), empleado.getNumeroDia(), empleado.getNumeroMes(), labelInfor);
                    }else if (elNuevoDos.update(empleadoTres, labelInfor)){//update
                    }
                    labelInfor.setText("Registro Exitoso de su Salida");
                    labelInfor.setStyle("-fx-text-fill: #E53935");
                }
            } catch (Exception e) {
                throw new GroupThreeException(e.getMessage(),getClass().getName(),"acRegistrarEntrada()");
            }
        }
        
    }

    private void llenarBloques() {
        txtFieldNombresyapellidos.setText(empleadoDos.getNombre()+" "+empleadoDos.getSegundoNombre()+" "+empleadoDos.getApellido()+" "+empleadoDos.getSegundoApellido());
        txtFieldHoras.setText(empleado.getHoraAlMomento()+":"+empleado.getMinutoAlMomento());
        txtFieldDia.setText(empleado.getNombreDiaDeLaSemana()+" "+empleado.getNumeroDia()+", de "+empleado.getNombreMes());
    }

    private int verificarBarraUsuario(String cBarras){
        if(cBarras.length() == 6){
            try {
                Integer.parseInt(cBarras);
                if((((Integer.parseInt(cBarras.substring(0,1)))+(Integer.parseInt(cBarras.substring(1,2)))+(Integer.parseInt(cBarras.substring(2,3)))+(Integer.parseInt(cBarras.substring(3,4)))-(Integer.parseInt(cBarras.substring(4,5)))-(Integer.parseInt(cBarras.substring(5,6))))==1)){
                    return 0; // solo si es un administrador
                }else if((((Integer.parseInt(cBarras.substring(0,1)))+(Integer.parseInt(cBarras.substring(1,2)))+(Integer.parseInt(cBarras.substring(2,3)))+(Integer.parseInt(cBarras.substring(3,4)))+(Integer.parseInt(cBarras.substring(4,5)))+(Integer.parseInt(cBarras.substring(5,6))))==24)){
                    return 1; // solo si es un empleado
                }
                return 4; // solo si no coincide con ninguna descripcion
            } catch (Exception e) {
                return 2; // solo si no es un numero
            }
        }
        return 3;//solo si no tiene el tamano de 6
    }

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

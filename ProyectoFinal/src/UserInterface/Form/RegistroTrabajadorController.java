/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package UserInterface.Form;

import DataAccess.DTO.RegistroEmpleado_DTO;
import FrameWork.GroupThreeException;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Business.BusinessLogic.RegistroEmpleadoBL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author jonat
 */
public class RegistroTrabajadorController implements Initializable {

    @FXML
    private Pane panelResgistroPersonas;
    @FXML
    private TextField textFieldCodigoBarras;
    @FXML
    private TextField textFieldSeleccionVacaciones;
    @FXML
    private TextField textFieldSeleccionHorario;
    @FXML
    private TextField textFieldCodigoBarrasCRUD;
    @FXML
    private TextField textFieldPrimerNombre;
    @FXML
    private TextField textFieldSegundoNombre;
    @FXML
    private TextField textFieldPrimerApellido;
    @FXML
    private TextField textFieldSegundoApellido;
    @FXML
    private TextField textFieldNumeroCedula;
    @FXML
    private TextField textFieldEdad;
    @FXML
    private TextField textFieldCorreoElec;
    @FXML
    private TextField textFieldSueldo;
    @FXML
    private RadioButton btnDecTerMensualizado;
    @FXML
    private ToggleGroup DecimoTercer;
    @FXML
    private Label infoRegistro;
    @FXML
    private RadioButton btnEstActivo;
    @FXML
    private ToggleGroup Estado;
    @FXML
    private TextField textFieldNumeroCelular;
    @FXML
    private TextField textFieldNumeroTelefono;
    @FXML
    private RadioButton btnGenMasculino;
    @FXML
    private ToggleGroup Genero;
    @FXML
    private RadioButton btnGenFemenino;
    @FXML
    private RadioButton btnGenOtro;
    @FXML
    private RadioButton btnDecCuarMensualizado;
    @FXML
    private ToggleGroup DecimoCuarto;
    @FXML
    private Pane paneContrasena;
    @FXML
    private TextField entradaContrasena;
    @FXML
    private Label infoContrasena;

    RegistroEmpleado_DTO empleado = new RegistroEmpleado_DTO();
    RegistroEmpleadoBL elNuevo = new RegistroEmpleadoBL();
    private int numeroHorario;
    private int numeroVacacion;
    private int tipoEmpleado=4;

    @FXML
    private RadioButton btnDecTerAnual;
    @FXML
    private RadioButton btnEstNoActivo;
    @FXML
    private RadioButton btnDecCuarAnual;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numeroHorario = empleado.getRandomAsignacionHorario(textFieldSeleccionHorario);
        numeroVacacion = empleado.getRandomAsignacionVacaciones(textFieldSeleccionVacaciones);
    }

    @FXML
    private void acBuscar(ActionEvent event) throws SQLException, GroupThreeException {
        try {
            Integer.parseInt(textFieldCodigoBarras.getText());
            try {
                empleado = elNuevo.readBy(Integer.parseInt(textFieldCodigoBarras.getText()), infoRegistro);
                llenarTextFieldsButtons();
            } catch (Exception e) {
                infoRegistro.setText("No existe la persona que esta buscando");
                infoRegistro.setStyle("-fx-text-fill: #E53935");
            }
        } catch (Exception e) {
            infoRegistro.setText("Coloque un número");
        }
    }

    @FXML
    private void acRegistro(ActionEvent event) throws GroupThreeException {
        asignarTipoEmpleado();
        if(verificarDatosEntrantes(tipoEmpleado)){
            crearEmpleado(tipoEmpleado);
            try {
                elNuevo = new RegistroEmpleadoBL();
                if(elNuevo.create(empleado,infoRegistro)){
                    limpieza();
                }
            } catch (Exception e) {
                throw new GroupThreeException(e.getMessage(),getClass().getName(),"readBy()");
            }
        }
    }

    @FXML
    private void acModificar(ActionEvent event) throws GroupThreeException {
        asignarTipoEmpleado();
        if(verificarDatosEntrantes(tipoEmpleado)){
            crearEmpleado(tipoEmpleado);
            try {
                elNuevo = new RegistroEmpleadoBL();
                if(elNuevo.update(empleado,infoRegistro)){
                    limpieza();
                }
            } catch (Exception e) {
                throw new GroupThreeException(e.getMessage(),getClass().getName(),"acModificar()");
            }
        }
    }

    @FXML
    private void acEliminar(ActionEvent event) throws GroupThreeException {
        asignarTipoEmpleado();
        if(verificarDatosEntrantes(tipoEmpleado)){
            crearEmpleado(tipoEmpleado);
            try {
                elNuevo = new RegistroEmpleadoBL();
                if(elNuevo.delete(empleado,infoRegistro)){
                    limpieza();
                }
            } catch (Exception e) {
                throw new GroupThreeException(e.getMessage(),getClass().getName(),"aceliminar()");
            }
        }
    }

    @FXML
    private void aceptarONo(ActionEvent event) {
        if (entradaContrasena.getText().equals("1234")) {
            infoContrasena.setText("");
            paneContrasena.setVisible(false);
            panelResgistroPersonas.setVisible(true);
        } else {
            infoContrasena.setText("Contraseña incorrecta");
            infoContrasena.setStyle("-fx-text-fill: #E53935");
        }
    }

    @FXML
    private void acLimpiarConsola(ActionEvent event) {
        limpieza();
        infoRegistro.setText("La consola esta LIMPIA");
        infoRegistro.setStyle("-fx-text-fill: #66FF66");
    }

    private void crearEmpleado(int tipoEmpleado) {
        empleado = new RegistroEmpleado_DTO(Integer.parseInt(textFieldCodigoBarras.getText())
                                            ,tipoEmpleado
                                            ,textFieldPrimerNombre.getText()
                                            ,textFieldSegundoNombre.getText()
                                            ,textFieldPrimerApellido.getText()
                                            ,textFieldSegundoApellido.getText()
                                            ,textFieldNumeroCedula.getText()
                                            ,Integer.parseInt(textFieldEdad.getText())
                                            ,empleado.seleccionarGenero(btnGenMasculino
                                            , btnGenFemenino)
                                            ,textFieldCorreoElec.getText()
                                            ,textFieldNumeroCelular.getText()
                                            ,textFieldNumeroTelefono.getText()
                                            ,empleado.seleccionarEstado(btnEstActivo)
                                            ,empleado.seleccionarDecimoTercero(btnDecTerMensualizado)
                                            ,empleado.seleccionarDecimoCuarto(btnDecCuarMensualizado)
                                            ,numeroVacacion
                                            ,Integer.parseInt(textFieldCodigoBarrasCRUD.getText())
                                            ,numeroHorario
                                            ,Double.parseDouble(textFieldSueldo.getText()));
    }

    private Boolean verificarDatosEntrantes(int tipoEmpleado) {
        return empleado.verificarCasos(textFieldCodigoBarras,tipoEmpleado, textFieldPrimerNombre, textFieldSegundoNombre, textFieldPrimerApellido, textFieldSegundoApellido, textFieldNumeroCedula, textFieldEdad, textFieldCorreoElec, textFieldNumeroCelular, textFieldNumeroTelefono, textFieldSeleccionVacaciones, textFieldCodigoBarrasCRUD, textFieldSeleccionHorario, textFieldSueldo, infoRegistro);
    }
    
    private void limpieza() {
        textFieldCodigoBarras.setText("");
        textFieldPrimerNombre.setText("");
        textFieldSegundoNombre.setText("");
        textFieldPrimerApellido.setText("");
        textFieldSegundoApellido.setText("");
        textFieldNumeroCedula.setText("");
        textFieldEdad.setText("");
        textFieldCorreoElec.setText("");
        textFieldNumeroCelular.setText("");
        textFieldNumeroTelefono.setText("");
        textFieldCodigoBarrasCRUD.setText("");
        textFieldSueldo.setText("");
    }
    
    private void asignarTipoEmpleado() {
        if(empleado.verificarBarraUsuario(textFieldCodigoBarras.getText())==1){
            tipoEmpleado=4;//Empleado
        }else if(empleado.verificarBarraUsuario(textFieldCodigoBarras.getText())==0){
            tipoEmpleado=5;//Administrador
        }
    }

    private void llenarTextFieldsButtons() throws Exception {
        textFieldPrimerNombre.setText(empleado.getNombre());
        textFieldSegundoNombre.setText(empleado.getSegundoNombre());
        textFieldPrimerApellido.setText(empleado.getApellido());
        textFieldSegundoApellido.setText(empleado.getSegundoApellido());
        textFieldNumeroCedula.setText(empleado.getCedula());
        textFieldEdad.setText(empleado.getEdad().toString());
        textFieldCorreoElec.setText(empleado.getCorreo());
        textFieldSueldo.setText(empleado.getSueldo().toString());
        textFieldNumeroCelular.setText(empleado.getCelular());
        empleado.devolverDosBtn(btnDecTerMensualizado, btnDecTerAnual, empleado.getPagoDecimoTercero(), "M","A");
        empleado.devolverDosBtn(btnDecCuarMensualizado, btnDecCuarAnual, empleado.getPagoDecimoCuarto(), "M","A");
        empleado.devolverDosBtn(btnEstActivo, btnEstNoActivo, empleado.getEstado(), "A","X");
        empleado.devolverTextoHorario(empleado.getiDHorario(), textFieldSeleccionHorario);
        empleado.devolverTextoMesVaca(empleado.getiDMesVacacion(), textFieldSeleccionVacaciones);
        textFieldNumeroCelular.setText(empleado.getCelular());
        textFieldNumeroTelefono.setText(empleado.getTelefono());
        empleado.devolverTresBtn(btnGenMasculino, btnGenFemenino, btnGenOtro, empleado.getiDGenero());
    }
}

package UserInterface.Form;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import Business.BusinessLogic.RegistroEmpleadoBL;
import Business.BusinessLogic.SistemaControlAccesoBL;
import DataAccess.DTO.RegistroEmpleado_DTO;
import DataAccess.DTO.SistemaControlAcceso_DTO;
import DataAccess.DTO.SistemaSeguimientoYAsistencia_DTO;
import FrameWork.GroupThreeException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * Clase FXML Controller class para control de la ventana del calculoRemuneraxion
 */
public class CalculoRemuneracionController implements Initializable {

    @FXML
    private ComboBox<String> comboBoxMes;
    @FXML
    private ComboBox<String> comboBoxAnio;
    @FXML
    private Label labelInfor;
    @FXML
    private TextField textFielfCodigoBarras;
    @FXML
    private Pane paneCalculo;
    @FXML
    private TextField textFieldNombresApellidos;
    @FXML
    private TextField textFieldSueldo;
    @FXML
    private TextField textFieldAgosto;
    @FXML
    private TextField textFieldOctubre;
    @FXML
    private TextField textFieldHorasExtra;
    @FXML
    private TextField textFieldHorasExtraordinarias;
    @FXML
    private TextField textFieldRemuneracion;
    @FXML
    private TextField textFieldDecimoTercer;
    @FXML
    private TextField textFieldDecimoCuarto;
    @FXML
    private TextField textFieldSep;
    @FXML
    private TextField textFieldNov;
    @FXML
    private TextField textFieldDic;
    @FXML
    private Label labelInfoDos;
    @FXML
    private TextField textFieldIess;
    
    private RegistroEntradaSalidaController regis = new RegistroEntradaSalidaController();
    private String [] meses={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    private String [] mesesAbiles= new String[12];
    private String [] anios={"2024"};
    DecimalFormat formato = new DecimalFormat("#.##");
    RegistroEmpleado_DTO empleado = new RegistroEmpleado_DTO();
    RegistroEmpleadoBL elNuevo = new RegistroEmpleadoBL();
    SistemaControlAcceso_DTO empleadoDos = new SistemaControlAcceso_DTO();
    SistemaControlAccesoBL elNuevoDos = new SistemaControlAccesoBL();
    double agosto,septiembre,octubre,noviembre,diciembre;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBoxes();
    }

    /**
     * Metodo que se realiza al presioanr un boton
     * @param event: al presionar un boton
     */
    @FXML
    private void acBuscar(ActionEvent event) {
        try {
            Integer.parseInt(textFielfCodigoBarras.getText());
            try {
                buscarEImprimirDatos();
            } catch (Exception e) {
                labelInfor.setText("No existe la persona que esta buscando");
                labelInfor.setStyle("-fx-text-fill: #E53935");
                throw new GroupThreeException(e.getMessage(),getClass().getName(),"create()");
            }
        } catch (Exception e) {
            labelInfor.setText("Coloque un número");
        }
    }

    /**
     * Metodo para la busqueda e impresion de datos
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     * @throws GroupThreeException: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    private void buscarEImprimirDatos() throws Exception, GroupThreeException {
        empleado = elNuevo.readBy(Integer.parseInt(textFielfCodigoBarras.getText()), labelInfor);
        empleadoDos=elNuevoDos.readBy(Integer.parseInt(textFielfCodigoBarras.getText()), establecerMes(comboBoxMes.getValue()), 2024, labelInfor);
        textFieldNombresApellidos.setText(empleado.getNombre()+" "+empleado.getSegundoNombre()+" "+empleado.getApellido()+" "+empleado.getSegundoApellido());
        textFieldHorasExtra.setText(calcularValorHoraExtra((calcularValorHoraTrabajo(empleado.getSueldo()))*empleadoDos.getHorasExtra())+"");
        textFieldHorasExtraordinarias.setText(calcularValorHoraExtraordinaria(calcularValorHoraTrabajo(empleado.getSueldo())*empleadoDos.getHorasExtra())+"");
        paneCalculo.setVisible(true);
        textFieldSueldo.setText(empleado.getSueldo()+"");
        textFieldIess.setText(valorAportar(empleado.getSueldo())+"");
        textFieldDecimoTercer.setText(redondear(calcularDecimoTercer(empleado,empleadoDos,establecerMes(comboBoxMes.getValue())))+"");
        textFieldDecimoCuarto.setText(redondear(calcularDecimoCuarto(empleado,empleado.getSueldo(),empleado.getPagoDecimoCuarto()))+"");
        textFieldRemuneracion.setText(redondear(IngresarDoubles(textFieldHorasExtra)+IngresarDoubles(textFieldHorasExtraordinarias)+IngresarDoubles(textFieldSueldo)-IngresarDoubles(textFieldIess)+IngresarDoubles(textFieldDecimoTercer)+IngresarDoubles(textFieldDecimoCuarto))+"");
    }
    
    /**
     * Metodo que indica el ingresar los parametros de doubles
     * @param textFields: mensaje a indicar
     * @return: retorna los doubles del text field
     */
    private Double IngresarDoubles(TextField textFields) {
        return Double.parseDouble(textFields.getText());
    }

    /**
     * Metodo para redondear doubles
     * @param x: double
     * @return retorna el double redondeado
     */
    private double redondear(Double x){
        return Math.round(x*100.0)/100;
    }

    /**
     * metodo para calcular las aportaciones al IESS
     * @param sueldo: sueldo
     * @return: retorn el porcentaje de aportacion
     */
    private Double valorAportar(Double sueldo) {
        return sueldo*0.0945;
    }

    /**
     * metodo para reconocer el mes de acuerdo al comboboc
     * @param value: el string
     * @return: un entero perteneciente al mes
     */
    private int establecerMes(String value) {
        if(value.equals("Enero")){
            return 1;
        }else if(value.equals("Febrero")){
            return 2;
        }else if(value.equals("Marzo")){
            return 3;
        }else if(value.equals("Abril")){
                return 4;
        }else if(value.equals("Mayo")){
            return 5;
        }else if(value.equals("Junio")){
            return 6;
        }else if(value.equals("Julio")){
            return 7;
        }else if(value.equals("Agosto")){
            return 8;
        }else if(value.equals("Septiembre")){
            return 9;
        }else if(value.equals("Octubre")){
            return 10;
        }else if(value.equals("Noviembre")){
            return 11;
        }else if(value.equals("Diciembre")){
            return 12;
        }
        return -1;
    }

    /**
     * Metodo para calcualr el decimo tercer sueldo
     * @param datos: datos de la entidad
     * @param valores: valores
     * @param mes: mes
     * @return retorn el calculo del valor
     * @throws GroupThreeException: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    private double calcularDecimoTercer(RegistroEmpleado_DTO datos,SistemaControlAcceso_DTO valores,int mes) throws GroupThreeException {
        if(datos.getPagoDecimoTercero().equals("A")){
            try {
                agosto = Double.parseDouble(textFieldAgosto.getText());
                septiembre = Double.parseDouble(textFieldSep.getText());
                octubre = Double.parseDouble(textFieldOctubre.getText());
                noviembre = Double.parseDouble(textFieldNov.getText());
                diciembre = Double.parseDouble(textFieldDic.getText());
            } catch (Exception e) {
                agosto =0;
                septiembre =0;
                octubre =0;
                noviembre =0;
                diciembre =0;
                textFieldAgosto.setText("0");
                textFieldSep.setText("0");
                textFieldOctubre.setText("0");
                textFieldNov.setText("0");
                textFieldDic.setText("0");
            }
            if(mes == 8){
                textFieldAgosto.setDisable(false);
                textFieldSep.setDisable(false);
                textFieldOctubre.setDisable(false);
                textFieldNov.setDisable(false);
                textFieldDic.setDisable(false);
                double[] sueldosMensuales = new double[7];
                int[] horasExtrasMensuales = new int[7];
                int[] horasExtraordinariasMensuales = new int[7];
                try {
                    datos = elNuevo.readBy(Integer.parseInt(textFielfCodigoBarras.getText()), labelInfor);
                    for(int i=1;i<8;i++){
                        valores=elNuevoDos.readBy(Integer.parseInt(textFielfCodigoBarras.getText()),i, 2024, labelInfor);
                        sueldosMensuales[i-1]=datos.getSueldo();
                        horasExtrasMensuales[i-1]=valores.getHorasExtra();
                        horasExtraordinariasMensuales[i-1]=valores.getHorasExtraOrdinarias();
                    }
                    /* */
                } catch (Exception e) {
                    throw new GroupThreeException(e.getMessage(),getClass().getName(),"calcularDecimoTercer()");
                }
                return calcularDecimoTercerSueldoAnual(sueldosMensuales, horasExtrasMensuales, horasExtraordinariasMensuales, calcularValorHoraTrabajo(datos.getSueldo()));
            }else{
                textFieldAgosto.setDisable(true);
                textFieldSep.setDisable(true);
                textFieldOctubre.setDisable(true);
                textFieldNov.setDisable(true);
                textFieldDic.setDisable(true);
                return 0;
            }
        }else if(datos.getPagoDecimoTercero().trim().equals("M")){
            textFieldAgosto.setDisable(true);
            textFieldSep.setDisable(true);
            textFieldOctubre.setDisable(true);
            textFieldNov.setDisable(true);
            textFieldDic.setDisable(true);
            try {
                datos = elNuevo.readBy(Integer.parseInt(textFielfCodigoBarras.getText()), labelInfor);
                valores=elNuevoDos.readBy(Integer.parseInt(textFielfCodigoBarras.getText()), establecerMes(comboBoxMes.getValue()), 2024, labelInfor);
                return (calcularValorHoraExtra((calcularValorHoraTrabajo(datos.getSueldo()))*valores.getHorasExtra())+calcularValorHoraExtraordinaria(calcularValorHoraTrabajo(datos.getSueldo())*valores.getHorasExtra())+datos.getSueldo()-valorAportar(datos.getSueldo()))/12;
            } catch (Exception e) {
                throw new GroupThreeException(e.getMessage(),getClass().getName(),"calcularDecimoTercer()");
            }
        }
        return -1;

    }
    
    /**
     * Metodo para calcular el decimo cuarto sueldo
     * @param datos: datos de la entidad
     * @param sueldo: sueldo
     * @param caso: caso
     * @return: retorn el valor del decimo cuarto suledo de una persona
     */
    private double calcularDecimoCuarto(RegistroEmpleado_DTO datos,Double sueldo,String caso) {
        int[] horasFaltantes = new int[12];
        SistemaControlAcceso_DTO empleadoTres = new SistemaControlAcceso_DTO();
        SistemaSeguimientoYAsistencia_DTO empleadoCuatro = new SistemaSeguimientoYAsistencia_DTO();
        empleadoCuatro.setiDPersonas(datos.getiDPersonas());
        if(datos.getPagoDecimoCuarto().equals("A")){
            if(establecerMes(comboBoxMes.getValue())==12){
                for(int mes = 1;mes<=12;mes++){
                    try {
                        empleadoTres=elNuevoDos.readBy(datos.getiDPersonas(), mes, 2024, labelInfor);
                        horasFaltantes[mes-1]=empleadoTres.getHorasFaltantes(empleadoCuatro, mes);
                    } catch (Exception e) {
                        horasFaltantes[mes-1]=0;
                    }
                }
                return calcularDecimoCuartoSueldo(horasFaltantes);
            }
        }else if(datos.getPagoDecimoCuarto().equals("M")){
            return decimoCuartoMensualizado();
        }
        return 0;
    }
    
    /**
     * Metodo para el decimocuaarto sueldo mensualizado
     * @return: retorn el valor
     */
    private double decimoCuartoMensualizado(){
        double sbu = 460;
        return sbu/12;
    }

    /**
     * Metodo para calcular las horas trabajadas
     * @param horasFaltantes: horas que le falta por trabajar
     * @return: retorna el numero de horas trabajadas
     */
    private int calcularTotalHorasTrab(int[] horasFaltantes) {
        int horasCompletas = 240;
        int totalHorasTrab = 0;

        for (int i = 0; i < horasFaltantes.length; i++) {
            totalHorasTrab += (horasCompletas - horasFaltantes[i]);
        }
        return totalHorasTrab;
    }

    /**
     * Metodo para calcular el decimocuartosueldo mensual
     * @param horasFaltantes: las horas que no posee por lo que no tendra
     * @return: el valor que se merece al mes
     */
    public double calcularDecimoCuartoSueldo(int [] horasFaltantes) {
        int totalHorasTrabajadas = calcularTotalHorasTrab(horasFaltantes);
        return (totalHorasTrabajadas * 460) / 2880;
    }

    /**
     * Este metodo genera los valores de la combobox
     */
    private void comboBoxes() {
        mesesAbiles= new String[empleadoDos.getNumeroMes()];
        for(int i = 1;i<= empleadoDos.getNumeroMes();i++){
            mesesAbiles[i-1]=meses[i-1];
        }
        comboBoxMes.getItems().addAll(mesesAbiles);
        comboBoxAnio.getItems().addAll(anios);
    }

    /**
    * Este método calcula el valor de la hora de trabajo del empleado
    * @param sueldoMensual: es el valor del sueldo básico que va a recibir el empleado
    * @return: valor hora de trabajo del empleado
    */
    private static double calcularValorHoraTrabajo (double sueldoMensual){
        return sueldoMensual / 240;
    }
    
    /**
     * Este método calcula el valor de la hora extra que se le va a pagar al empleado
     * @param valorHoraTrabajo: es el valor que tiene cada hora de trabajo del empleado
     * @return: valor hora extra del empleado
     */
    private static double calcularValorHoraExtra(double valorHoraTrabajo){
        return valorHoraTrabajo * 1.5;
    }

    /**
     * Este método calcula el valor de la hora extraordinaria que se le va a pagar al empleado
     * @param valorHoraTrabajo: es el valor que tiene cada hora de trabajo del empleado
     * @return: valor hora extraordinaria del empleado
     */
    private static double calcularValorHoraExtraordinaria (double valorHoraTrabajo){
        return valorHoraTrabajo * 2;
    }
    
    /**
     * Este método calcula el valor del décimo tercer sueldo que se le va a pagar al empleado
     * @param sueldosMensuales: es un arreglo que contiene el sueldo básico de los 12 meses del año.
     * @param horasExtrasMensuales: horas extras realizadas en cada mes por el trabajador a lo largo del año.
     * @param horasExtraordinariasMensuales: horas extraordinarias realizadas en cada mes por el trabajador a lo largo del año.
     * @param valorHoraTrabajo: es el valor que tiene cada hora de trabajo del empleado
     * @return: el valor a pagar del decimo tercer sueldo
     */
    private static double calcularDecimoTercerSueldoAnual (double[] sueldosMensuales, int[] horasExtrasMensuales, int[] horasExtraordinariasMensuales, double valorHoraTrabajo ){
        double sumaTotal = 0;
        for (int i = 0 ; i < sueldosMensuales.length ;i++){
            double valorHoraExtra = calcularValorHoraExtra(valorHoraTrabajo);
            double valorHoraExtraordinaria = calcularValorHoraExtraordinaria(valorHoraTrabajo);

            double sueldoTotalMes = sueldosMensuales[i] + (horasExtrasMensuales[i] * valorHoraExtra)+(horasExtraordinariasMensuales[i]*valorHoraExtraordinaria);
            sumaTotal = sumaTotal + sueldoTotalMes;
        }
        return sumaTotal/12;
    }
}

package DataAccess.DTO;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class RegistroEmpleado_DTO {
    
    private Integer iDPersonas;
    private Integer iDPersonaTipo;
    private String  nombre;
    private String  segundoNombre;
    private String  apellido;
    private String  segundoApellido;
    private String  cedula;
    private Integer edad;
    private Integer iDGenero;
    private String  correo;
    private String  celular;
    private String  telefono;
    private String  estado;
    private String  pagoDecimoTercero;
    private String  pagoDecimoCuarto;
    private Integer iDMesVacacion;
    private String  fechaCreacion;
    private String  fechaModificacion;
    private Integer modificador;
    private Integer iDHorario;
    private Double  sueldo;
    
    public RegistroEmpleado_DTO(Integer iDPersonas, Integer iDPersonaTipo, String nombre, String segundoNombre,
            String apellido, String segundoApellido, String cedula, Integer edad, Integer iDGenero, String correo,
            String celular, String telefono, String estado, String pagoDecimoTercero, String pagoDecimoCuarto,
            Integer iDMesVacacion, Integer modificador, Integer iDHorario,Double  sueldo) {
        /*1*/   this.iDPersonas = iDPersonas;
        /*2*/   this.iDPersonaTipo = iDPersonaTipo;
        /*3*/   this.nombre = nombre;
        /*4*/   this.segundoNombre = segundoNombre;
        /*5*/   this.apellido = apellido;
        /*6*/   this.segundoApellido = segundoApellido;
        /*7*/   this.cedula = cedula;
        /*8*/   this.edad = edad;
        /*9*/   this.iDGenero = iDGenero;
        /*10*/  this.correo = correo;
        /*11*/  this.celular = celular;
        /*12*/  this.telefono = telefono;
        /*13*/  this.estado = estado;
        /*14*/  this.pagoDecimoTercero = pagoDecimoTercero;
        /*15*/  this.pagoDecimoCuarto = pagoDecimoCuarto;
        /*16*/  this.iDMesVacacion = iDMesVacacion;
        /*17*/  this.modificador = modificador;
        /*18*/  this.iDHorario = iDHorario;
        /*19*/  this.sueldo=sueldo;
    }

    public RegistroEmpleado_DTO() {
    }

    public RegistroEmpleado_DTO(Integer iDPersonas, Integer iDPersonaTipo, String nombre, String segundoNombre,
            String apellido, String segundoApellido, String cedula, Integer edad, Integer iDGenero, String correo,
            String celular, String telefono, String estado, String pagoDecimoTercero, String pagoDecimoCuarto,
            Integer iDMesVacacion, String fechaModificacion, Integer modificador, Integer iDHorario,Double  sueldo) {
        this.iDPersonas = iDPersonas;
        this.iDPersonaTipo = iDPersonaTipo;
        this.nombre = nombre;
        this.segundoNombre = segundoNombre;
        this.apellido = apellido;
        this.segundoApellido = segundoApellido;
        this.cedula = cedula;
        this.edad = edad;
        this.iDGenero = iDGenero;
        this.correo = correo;
        this.celular = celular;
        this.telefono = telefono;
        this.estado = estado;
        this.pagoDecimoTercero = pagoDecimoTercero;
        this.pagoDecimoCuarto = pagoDecimoCuarto;
        this.iDMesVacacion = iDMesVacacion;
        this.fechaModificacion = fechaModificacion;
        this.modificador = modificador;
        this.iDHorario = iDHorario;
        this.sueldo=sueldo;
    }

    public RegistroEmpleado_DTO(String nombre, String segundoNombre, String apellido, String segundoApellido,
            String cedula, Integer edad, Integer iDGenero, String correo, String celular, String telefono,
            String estado, String pagoDecimoTercero, String pagoDecimoCuarto, Integer iDMesVacacion, Integer iDHorario,
            Double sueldo) {
        this.nombre = nombre;
        this.segundoNombre = segundoNombre;
        this.apellido = apellido;
        this.segundoApellido = segundoApellido;
        this.cedula = cedula;
        this.edad = edad;
        this.iDGenero = iDGenero;
        this.correo = correo;
        this.celular = celular;
        this.telefono = telefono;
        this.estado = estado;
        this.pagoDecimoTercero = pagoDecimoTercero;
        this.pagoDecimoCuarto = pagoDecimoCuarto;
        this.iDMesVacacion = iDMesVacacion;
        this.iDHorario = iDHorario;
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return getClass().getName()
        + "\n IDPersonas:" + getiDPersonas()
        + "\n IDPersonaTipo:" + getiDPersonaTipo()
        + "\n Nombre:" + getNombre()
        + "\n SegundoNombre:" + getSegundoNombre()
        + "\n Apellido:" + getApellido()
        + "\n SegundoApellido:" + getSegundoApellido()
        + "\n Edad:" + getEdad()
        + "\n IDGenero:" + getiDGenero()
        + "\n Correo:" + getCorreo()
        + "\n Celular:" + getCelular()
        + "\n Telefono:" + getTelefono()
        + "\n Estado:" + getEstado()
        + "\n PagoDecimoTercero:" + getPagoDecimoTercero()
        + "\n PagoDecimoCuarto:" + getPagoDecimoCuarto()
        + "\n IDMesVacacion:" + getiDMesVacacion()
        + "\n FechaCreacion:"+ getFechaCreacion()
        + "\n FechaModificacion:" + getFechaModificacion()
        + "\n Modificador:" + getModificador()
        + "\n IDHorario:" + getiDHorario();
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public int verificarBarraUsuario(String cBarras){
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

    public Boolean verificarCasos(TextField iDPersonasCBarras
    ,int iDPersonaTipo
    ,TextField nombre
    ,TextField segundoNombre
    ,TextField apellido
    ,TextField segundoApellido
    ,TextField cedula
    ,TextField edad
    ,TextField correo
    ,TextField celular
    ,TextField telefono
    ,TextField iDMesVacacion
    ,TextField modificador
    ,TextField iDHorario
    ,TextField sueldo
    ,Label label){
        if (verificarBarraUsuario(iDPersonasCBarras.getText())!=0&&(verificarBarraUsuario(iDPersonasCBarras.getText())!=1)){
            if(verificarBarraUsuario(iDPersonasCBarras.getText())==3){
                label.setText("Utilice el Lector de codigo de barras");
                label.setStyle("-fx-text-fill: #E53935");
            }
            else {
                label.setText("Utilice un codigo de barras que se admita");
                label.setStyle("-fx-text-fill: #E53935");
            }//no proseguir <2 solo si no es un numero>,<3 solo si no tiene el tamano de 6>, <4 solo si no coincide con ninguna descripcion>
        }else{
            if (nombre.getText().isEmpty()||/*segundoNombre.getText().isEmpty()
            ||*/apellido.getText().isEmpty()||/*segundoApellido.getText().isEmpty()
            ||*/cedula.getText().isEmpty()||edad.getText().isEmpty()
            ||correo.getText().isEmpty()||celular.getText().isEmpty()
            ||telefono.getText().isEmpty()||iDMesVacacion.getText().isEmpty()
            ||modificador.getText().isEmpty()||iDHorario.getText().isEmpty()
            ||sueldo.getText().isEmpty()){
                label.setText("Termine de llenar todos los campos!");
                label.setStyle("-fx-text-fill: #E53935"); // solo si no tiene ningun campo lleno
            }else{
                try {
                    Long.parseLong(cedula.getText());
                    if (cedula.getText().length() == 10){
                        try {
                            double valorSueldo = Double.parseDouble(sueldo.getText());
                            if(valorSueldo>2000||valorSueldo<500){
                                label.setText("Su sueldo no puede ser menor a 500 o mayor a 2000");
                                label.setStyle("-fx-text-fill: #E53935");// solo si el sueldo no esta entre 500 y 2000
                            }else{
                                try {
                                    int valorEdad = Integer.parseInt(edad.getText());
                                    if(valorEdad>60||valorEdad<18){
                                        label.setText("La edad no puede ser menor a 18 o mayor a 60");
                                        label.setStyle("-fx-text-fill: #E53935");
                                    }else{
                                        try {
                                            Float.parseFloat(celular.getText());
                                            Float.parseFloat(telefono.getText());
                                            if(celular.getText().length()==10){
                                                if(verificarBarraUsuario(modificador.getText())!=0){
                                                    label.setText("La autorizacion debe estar dada por un administrador");
                                                    label.setStyle("-fx-text-fill: #E53935");
                                                }else{
                                                    label.setText("");
                                                    return true;// si todo esta correcto
                                                }
                                            }else{
                                                label.setText("El celular debe tener 10 digitos");
                                                label.setStyle("-fx-text-fill: #E53935");
                                            }
                                        } catch (Exception e) {
                                            label.setText("Asegurese de colocar correctarmente su numero de telefono y celular");
                                            label.setStyle("-fx-text-fill: #E53935");
                                        }
                                    }
                                } catch (Exception e) {
                                    label.setText("Digite su edad en números");
                                    label.setStyle("-fx-text-fill: #E53935");
                                }
                            }
                        } catch (Exception e) {
                            label.setText("Si usa decimales usar unpuntos (.)");
                            label.setStyle("-fx-text-fill: #E53935");// solo si el sueldo no es un numero
                        }
                    }else{
                        label.setText("Son 10 dígitos en el campo de la CEDULA");
                        label.setStyle("-fx-text-fill: #E53935");// solo si no tiene el tamano de 10 la cedula
                    }
                } catch (Exception e) {
                    label.setText("Asegurece de llenar correctamente la cedula (sin espacios o signos)");
                    label.setStyle("-fx-text-fill: #E53935");// el numero de cedula no son numeros
                }
            }
        }
        return false;
    }

    public int getRandomAsignacionHorario(TextField horario) {
        int randomHorario = 9 + (int) (Math.random() * 2);
        if(randomHorario == 9){
            horario.setText("Manana (7:00 - 16:00)");
        }else{
            horario.setText("Tarde (11:00 - 20:00)");
        }
        return randomHorario;
    }

    public int getRandomAsignacionVacaciones(TextField vacaciones) {
        int randomVaca = 6 + (int) (Math.random() * 3);
        
        if(randomVaca==6){
            vacaciones.setText("Agosto");
        }else if(randomVaca==7){
            vacaciones.setText("Septiembre");
        }else if(randomVaca==8){
            vacaciones.setText("Octubre");
        }
        return randomVaca;
    }
    
    public int seleccionarGenero (RadioButton masculino,RadioButton femenino){
        if(masculino.isSelected()){
            return 1;
        }else if(femenino.isSelected()){
            return 2;
        }
        return 3;
    }

    public String seleccionarEstado (RadioButton activo){
        if(activo.isSelected()){
            return "A";
        }
        return "X";
    }

    public String seleccionarDecimoTercero (RadioButton mensual){
        if(mensual.isSelected()){
            return "M";
        }
        return "A";
    }

    public String seleccionarDecimoCuarto (RadioButton mensual){
        if(mensual.isSelected()){
            return "M";
        }
        return "A";
    }

    public void devolverDosBtn(RadioButton botonUno,RadioButton botonDos,String obtenido,String comparado,String diferente){
        if(obtenido.toString().equals(comparado)){
            botonUno.setSelected(true);
        }else if(obtenido.toString().equals(diferente)){
            botonDos.setSelected(true);
        }
    }

    public void devolverTresBtn(RadioButton botonUno, RadioButton botonDos,RadioButton botonTres, Integer obtenido){
        if(obtenido==1){
            botonUno.setSelected(true);
        }else if(obtenido==2){
            botonDos.setSelected(true);
        }else{
            botonTres.setSelected(true);
        }
    }

    public void devolverTextoHorario(Integer val,TextField txtfl){
        if(val==9){
            txtfl.setText("Manana (7:00 - 16:00)");
        }else{
            txtfl.setText("Tarde (11:00 - 20:00)");
        }
    }

    public void devolverTextoMesVaca(Integer val,TextField txtfl){
        if(val==6){
            txtfl.setText("Agosto");
        }else if(val==7){
            txtfl.setText("Septiembre");
        }else{
            txtfl.setText("Octubre");
        }
    }

    public Integer getiDPersonas() {
        return iDPersonas;
    }

    public void setiDPersonas(Integer iDPersonas) {
        this.iDPersonas = iDPersonas;
    }

    public Integer getiDPersonaTipo() {
        return iDPersonaTipo;
    }

    public void setiDPersonaTipo(Integer iDPersonaTipo) {
        this.iDPersonaTipo = iDPersonaTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getiDGenero() {
        return iDGenero;
    }

    public void setiDGenero(Integer iDGenero) {
        this.iDGenero = iDGenero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPagoDecimoTercero() {
        return pagoDecimoTercero;
    }

    public void setPagoDecimoTercero(String pagoDecimoTercero) {
        this.pagoDecimoTercero = pagoDecimoTercero;
    }

    public String getPagoDecimoCuarto() {
        return pagoDecimoCuarto;
    }

    public void setPagoDecimoCuarto(String pagoDecimoCuarto) {
        this.pagoDecimoCuarto = pagoDecimoCuarto;
    }

    public Integer getiDMesVacacion() {
        return iDMesVacacion;
    }

    public void setiDMesVacacion(Integer iDMesVacacion) {
        this.iDMesVacacion = iDMesVacacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getModificador() {
        return modificador;
    }

    public void setModificador(Integer modificador) {
        this.modificador = modificador;
    }

    public Integer getiDHorario() {
        return iDHorario;
    }

    public void setiDHorario(Integer iDHorario) {
        this.iDHorario = iDHorario;
    }
}


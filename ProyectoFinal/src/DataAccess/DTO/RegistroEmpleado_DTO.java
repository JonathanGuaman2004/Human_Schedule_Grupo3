package DataAccess.DTO;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * La clase RegistroEmpleado_DTO sera la clase mediante el cual podemos crear los objetos junto con sus datos que se necesitaran despues para subir a la base de datos
 */
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
    
    /**
     * Constructor Vacio
     */
    public RegistroEmpleado_DTO() {
    }

    /**
     * ConstructorUno
     * @param iDPersonas: iDPersonas
     * @param iDPersonaTipo: iDPersonaTipo
     * @param nombre: nombre
     * @param segundoNombre: segundoNombre
     * @param apellido: apellido
     * @param segundoApellido: segundoApellido
     * @param cedula: cedula
     * @param edad: edad
     * @param iDGenero: iDGenero
     * @param correo: correo
     * @param celular: celular
     * @param telefono: telefono
     * @param estado: estado
     * @param pagoDecimoTercero: pagoDecimoTercero
     * @param pagoDecimoCuarto: pagoDecimoCuarto
     * @param iDMesVacacion: iDMesVacacion
     * @param modificador: modificador
     * @param iDHorario: iDHorario
     * @param sueldo: sueldo
     */
    public RegistroEmpleado_DTO(Integer iDPersonas, Integer iDPersonaTipo, String nombre, String segundoNombre,
            String apellido, String segundoApellido, String cedula, Integer edad, Integer iDGenero, String correo,
            String celular, String telefono, String estado, String pagoDecimoTercero, String pagoDecimoCuarto,
            Integer iDMesVacacion, Integer modificador, Integer iDHorario,Double  sueldo) {
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
                this.modificador = modificador;
                this.iDHorario = iDHorario;
                this.sueldo=sueldo;
    }
    
    /**
     * ConstructorDos
     * @param iDPersonas: iDPersonas
     * @param iDPersonaTipo: iDPersonaTipo
     * @param nombre: nombre
     * @param segundoNombre: segundoNombre
     * @param apellido: apellido
     * @param segundoApellido: segundoApellido
     * @param cedula: cedula
     * @param edad: edad
     * @param iDGenero: iDGenero
     * @param correo: correo
     * @param celular: celular
     * @param telefono: telefono
     * @param estado: estado
     * @param pagoDecimoTercero: pagoDecimoTercero
     * @param pagoDecimoCuarto: pagoDecimoCuarto
     * @param iDMesVacacion: iDMesVacacion
     * @param fechaModificacion: fechaModificacion
     * @param modificador: modificador
     * @param iDHorario: iDHorario
     * @param sueldo: sueldo
     */
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

    /**
     * ConstructorTres
     * @param nombre: nombre
     * @param segundoNombre: segundoNombre
     * @param apellido: apellido
     * @param segundoApellido: segundoApellido
     * @param cedula: cedula
     * @param edad: edad
     * @param iDGenero: iDGenero
     * @param correo: correo
     * @param celular: celular
     * @param telefono: telefono
     * @param estado: estado
     * @param pagoDecimoTercero: pagoDecimoTercero
     * @param pagoDecimoCuarto: pagoDecimoCuarto
     * @param iDMesVacacion: iDMesVacacion
     * @param iDHorario: iDHorario
     * @param sueldo: sueldo
     */
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

    /**
     * Obtiene el valor del sueldo
     * @return: retorna el valor del sueldo
     */
    public Double getSueldo() {
        return sueldo;
    }

    /**
     * Este metodo permite verificar  si el elemento colocado en una barra de usuario si es funcional para su registro
     * @param cBarras: codigo de barras
     * @return: retorna un entero que indica si se puede usar o no
     */
    public int verificarBarraUsuario(String cBarras){
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
     * Este metodo analiza los casos que pueden existir ene l momento de ingresar los datos a la consola
     * @param iDPersonasCBarras: iDPersonasCBarras
     * @param iDPersonaTipo: iDPersonaTipo
     * @param nombre: nombre
     * @param segundoNombre: segundoNombre
     * @param apellido: apellido
     * @param segundoApellido: segundoApellido
     * @param cedula: cedula
     * @param edad: edad
     * @param correo: correo
     * @param celular: celular
     * @param telefono: telefono
     * @param iDMesVacacion: iDMesVacacion
     * @param modificador: modificador
     * @param iDHorario: iDHorario
     * @param sueldo: sueldo
     * @param label: label
     * @return: retorna un booleano que indica si puede proseguir o no
     */
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
            }
        }else{
            if (nombre.getText().isEmpty()||apellido.getText().isEmpty()
            ||cedula.getText().isEmpty()||edad.getText().isEmpty()
            ||correo.getText().isEmpty()||celular.getText().isEmpty()
            ||telefono.getText().isEmpty()||iDMesVacacion.getText().isEmpty()
            ||modificador.getText().isEmpty()||iDHorario.getText().isEmpty()
            ||sueldo.getText().isEmpty()){
                label.setText("Termine de llenar todos los campos!");
                label.setStyle("-fx-text-fill: #E53935");
            }else{
                try {
                    Long.parseLong(cedula.getText());
                    if (cedula.getText().length() == 10){
                        try {
                            double valorSueldo = Double.parseDouble(sueldo.getText());
                            if(valorSueldo>2000||valorSueldo<500){
                                label.setText("Su sueldo no puede ser menor a 500 o mayor a 2000");
                                label.setStyle("-fx-text-fill: #E53935");
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
                                                    return true;
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
                            label.setText("Si usa decimales usar puntos (.)");
                            label.setStyle("-fx-text-fill: #E53935");
                        }
                    }else{
                        label.setText("Son 10 dígitos en el campo de la CEDULA");
                        label.setStyle("-fx-text-fill: #E53935");
                    }
                } catch (Exception e) {
                    label.setText("Asegurece de llenar correctamente la cedula (sin espacios o signos)");
                    label.setStyle("-fx-text-fill: #E53935");
                }
            }
        }
        return false;
    }

    /**
     * este metodo genera un numero aleatorio para la asignacion de horarios
     * @param horario: es el TextField donde se colocará el horario
     * @return: retorna un entero que es el horario que se le asigno
     */
    public int getRandomAsignacionHorario(TextField horario) {
        int randomHorario = 9 + (int) (Math.random() * 2);
        if(randomHorario == 9){
            horario.setText("Manana (7:00 - 16:00)");
        }else{
            horario.setText("Tarde (11:00 - 20:00)");
        }
        return randomHorario;
    }

    /**
     * este metodo genera un numero aleatorio para la asignacion de vacaciones
     * @param vacaciones: es el TextField donde se colocará el mes de vacaciones
     * @return: retorna un entero que es el mes de vacacion que se le asigno
     */
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
    
    /**
     * Este metodo indica el numero que corresponde al genero seleccionado
     * @param masculino: boton
     * @param femenino: boton
     * @return retorna un numero de acuerdo al genero seleccionado
     */
    public int seleccionarGenero (RadioButton masculino,RadioButton femenino){
        if(masculino.isSelected()){
            return 1;
        }else if(femenino.isSelected()){
            return 2;
        }
        return 3;
    }

    /**
     * Este metodo indica el String que corresponde al estado seleccionado
     * @param activo: boton
     * @return: retona el string de acuerdo al estado
     */
    public String seleccionarEstado (RadioButton activo){
        if(activo.isSelected()){
            return "A";
        }
        return "X";
    }

    /**
     * Este metodo indica el String que corresponde al tipo de forma de recibir el decimo tercero
     * @param mensual: boton
     * @return: retorna un string de acuerdo al tipo de forma de recibir el decimo tercero
     */
    public String seleccionarDecimoTercero (RadioButton mensual){
        if(mensual.isSelected()){
            return "M";
        }
        return "A";
    }

    /**
     * Este metodo indica el String que corresponde al tipo de forma de recibir el decimo cuarto
     * @param mensual: boton
     * @return: retorna un string de acuerdo al tipo de forma de recibir el decimo cuarto
     */
    public String seleccionarDecimoCuarto (RadioButton mensual){
        if(mensual.isSelected()){
            return "M";
        }
        return "A";
    }

    /**
     * este metodo se usa para colocar los botones de la manera adecuada en una busqueda
     * @param botonUno: boton
     * @param botonDos: boton
     * @param obtenido: el valor que ingresa de la persona
     * @param comparado: el valor que se compara
     * @param diferente: el valor que es diferente
     */
    public void devolverDosBtn(RadioButton botonUno,RadioButton botonDos,String obtenido,String comparado,String diferente){
        if(obtenido.toString().equals(comparado)){
            botonUno.setSelected(true);
        }else if(obtenido.toString().equals(diferente)){
            botonDos.setSelected(true);
        }
    }

    /**
     * este metodo se usa para colocar los botones de la manera adecuada en una busqueda
     * @param botonUno: boton
     * @param botonDos: boton
     * @param botonTres: boton
     * @param obtenido: el valor que ingresa
     */
    public void devolverTresBtn(RadioButton botonUno, RadioButton botonDos,RadioButton botonTres, Integer obtenido){
        if(obtenido==1){
            botonUno.setSelected(true);
        }else if(obtenido==2){
            botonDos.setSelected(true);
        }else{
            botonTres.setSelected(true);
        }
    }

    /**
     * metodo que digita el horario asignado
     * @param val: valor que ingresa
     * @param txtfl: TextField que se muestra
     */
    public void devolverTextoHorario(Integer val,TextField txtfl){
        if(val==9){
            txtfl.setText("Manana (7:00 - 16:00)");
        }else{
            txtfl.setText("Tarde (11:00 - 20:00)");
        }
    }

    /**
     * Este metodo indica el mes asignado
     * @param val: valor que ingresa
     * @param txtfl: TextField que se muestra
     */
    public void devolverTextoMesVaca(Integer val,TextField txtfl){
        if(val==6){
            txtfl.setText("Agosto");
        }else if(val==7){
            txtfl.setText("Septiembre");
        }else{
            txtfl.setText("Octubre");
        }
    }

    /**
     * Obtiene el valor del iDPersonas
     * @return: retorna el valor del iDPersonas
     */
    public Integer getiDPersonas() {
        return iDPersonas;
    }

    /**
     * Obtiene el valor del iDPersonaTipo
     * @return: retorna el valor del iDPersonaTipo
     */
    public Integer getiDPersonaTipo() {
        return iDPersonaTipo;
    }

    /**
     * Obtiene el valor del nombre
     * @return: retorna el valor del nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el valor del segundoNombre
     * @return: retorna el valor del segundoNombre
     */
    public String getSegundoNombre() {
        return segundoNombre;
    }

    /**
     * Obtiene el valor del apellido
     * @return: retorna el valor del apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Obtiene el valor del segundoApellido
     * @return: retorna el valor del segundoApellido
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * Obtiene el valor de la cedula
     * @return: retorna el valor de la cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Obtiene el valor de la edad
     * @return: retorna el valor de la edad
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * Obtiene el valor del iDGenero
     * @return: retorna el valor del iDGenero
     */
    public Integer getiDGenero() {
        return iDGenero;
    }

    /**
     * Obtiene el valor del correo
     * @return: retorna el valor del correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Obtiene el valor del celular
     * @return: retorna el valor del celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Obtiene el valor del telefono
     * @return: retorna el valor del telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Obtiene el valor del estado
     * @return: retorna el valor del estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Obtiene el valor del pagoDecimoTercero
     * @return: retorna el valor del pagoDecimoTercero
     */
    public String getPagoDecimoTercero() {
        return pagoDecimoTercero;
    }

    /**
     * Obtiene el valor del pagoDecimoCuarto
     * @return: retorna el valor del pagoDecimoCuarto
     */
    public String getPagoDecimoCuarto() {
        return pagoDecimoCuarto;
    }

    /**
     * Obtiene el valor del iDMesVacacion
     * @return: retorna el valor del iDMesVacacion
     */
    public Integer getiDMesVacacion() {
        return iDMesVacacion;
    }

    /**
     * Obtiene el valor de la fechaCreacion
     * @return: retorna el valor de la fechaCreacion
     */
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Obtiene el valor de la fechaModificacion
     * @return: retorna el valor de la fechaModificacion
     */
    public String getFechaModificacion() {
        return fechaModificacion;
    }

    /**
     * Obtiene el valor del modificador
     * @return: retorna el valor del modificador
     */
    public Integer getModificador() {
        return modificador;
    }

    /**
     * Obtiene el valor del iDHorario
     * @return: retorna el valor del iDHorario
     */
    public Integer getiDHorario() {
        return iDHorario;
    }
}


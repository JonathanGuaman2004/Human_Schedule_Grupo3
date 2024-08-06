package FrameWork;

import javafx.scene.control.Alert;

public class PersonaEmpleado {

    private String cBarras;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String nCedula;
    private String vSueldo;
    private String decimoTercero;
    private String decimoCuarto;

    public PersonaEmpleado(String cBarras, String primerNombre, String segundoNombre, String primerApellido,
            String segundoApellido, String nCedula, String vSueldo, String decimoTercero, String decimoCuarto) {
        this.cBarras = cBarras;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.nCedula = nCedula;
        this.vSueldo = vSueldo;
        this.decimoTercero = decimoTercero;
        this.decimoCuarto = decimoCuarto;
    }

    public PersonaEmpleado() {
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

    public int verificarCasos(){
        if (verificarBarraUsuario(cBarras)!=0&&(verificarBarraUsuario(cBarras)!=1)){
            return verificarBarraUsuario(cBarras); //no proseguir <2 solo si no es un numero>,<3 solo si no tiene el tamano de 6>, <4 solo si no coincide con ninguna descripcion>
        }else{
            if (primerNombre.isEmpty() || primerApellido.isEmpty() || segundoApellido.isEmpty() ||nCedula.isEmpty() ||vSueldo.isEmpty()) {
                return 5; // solo si no tiene ningun campo lleno
            }else{
                try {
                    Long.parseLong(nCedula);
                    if (nCedula.length() == 10){
                        try {
                            double valorSueldo = Double.parseDouble(vSueldo);
                            if(valorSueldo>2000||valorSueldo<500){
                                return 9; // solo si el sueldo no esta entre 500 y 2000
                            }else{
                                return 10; // si todo esta correcto
                            }
                        } catch (Exception e) {
                            return 8; // solo si el sueldo no es un numero
                        }
                    }else{
                        return 7; // solo si no tiene el tamano de 10 la cedula
                    }
                } catch (Exception e) {
                    return 6;// el numero de cedula no son numeros
                }
            }
        }
    }

    public int verificarDatos(String string1, String string2,String string3,String string4){
        if(!((string1.isEmpty()||string2.isEmpty())||(string3.isEmpty()||string4.isEmpty()))){
            if(string1.length()==10){
                try {
                    Long.parseLong(string1);
                    if(string3.length()==10){
                        try {
                            Long.parseLong(string3);
                            try {
                                if(Double.parseDouble(string4)>2000||Double.parseDouble(string4)<500){
                                    return 8;
                                }
                                return 1;
                            } catch (Exception e) {
                                return 7;
                            }
                        } catch (NumberFormatException e) {
                            return 6;
                        }
                    }
                    return 5;
                } catch (NumberFormatException e) {
                    return 4;
                }
            }
            return 3;
        }
        return 2;
    }

    public String getcBarras() {
        return cBarras;
    }

    public void setcBarras(String cBarras) {
        this.cBarras = cBarras;
    }

    public String getprimerNombre() {
        return primerNombre;
    }

    public void setprimerNombre(String primerNombre){
        this.primerNombre = primerNombre;
    }

    public String getnCedula() {
        return nCedula;
    }

    public void setnCedula(String nCedula) {
        this.nCedula = nCedula;
    }

    public String getvSueldo() {
        return vSueldo;
    }

    public void setvSueldo(String vSueldo) {
        this.vSueldo = vSueldo;
    }
}

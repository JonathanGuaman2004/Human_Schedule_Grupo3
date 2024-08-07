package DataAccess.DTO;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase para guarda los registros diarios
 */
public class SistemaSeguimientoYAsistencia_DTO {
    private LocalDate fechaActual=LocalDate.now();
    private LocalTime horaActual = LocalTime.now();
    private DayOfWeek diaDeLaSemana ;
    private Integer iDPersonas;
    private Integer horaEntrada;
    private Integer minutoEntrada;
    private Integer horaSalida;
    private Integer minutoSalida;
    private Integer numeroDia;
    private Integer numeroMes;
    private Integer numeroAnio;
    private String estadoEntrada;
    private String estadoSalida;
    private int numeroDiaDeLaSemana ;
    private Integer horaAlMomento ;
    private Integer minutoAlMomento ;
    private String [] diasDeLaSemana={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
    private String [] meses={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};

    /**
     * Constructor Vacio
     */
    public SistemaSeguimientoYAsistencia_DTO() {
    }

    /**
     * ConstructorUno
     * @param horaEntrada: horaEntrada
     * @param minutoEntrada: minutoEntrada
     * @param horaSalida: horaSalida
     * @param minutoSalida: minutoSalida
     */
    public SistemaSeguimientoYAsistencia_DTO(Integer horaEntrada, Integer minutoEntrada, Integer horaSalida,
            Integer minutoSalida) {
        this.horaEntrada = horaEntrada;
        this.minutoEntrada = minutoEntrada;
        this.horaSalida = horaSalida;
        this.minutoSalida = minutoSalida;
    }
    
    /**
     * ConstructorDos
     * @param iDPersonas: iDPersonas
     */
    public SistemaSeguimientoYAsistencia_DTO(Integer iDPersonas) {
        this.iDPersonas = iDPersonas;
        this.horaEntrada = getHoraAlMomento();
        this.minutoEntrada = getMinutoAlMomento();
        this.numeroDia = getNumeroDia();
        this.numeroMes = getNumeroMes();
        this.numeroAnio = getNumeroAnio();
    }

    /**
     * Metodo para designar el estado de entrada
     * @param horario: horario
     * @return: string del horario de entrada
     */
    public String getEstadoEntrada(int horario) {
        if(horario==9){
            if(getHoraAlMomento()>7){
                return estadoEntrada="A";
            }
        }else{
            if(getHoraAlMomento()>11){
                return estadoEntrada="A";
            }
        }
        return estadoEntrada="I";
    }

    /**
     * Metodo para designar el estado de salida
     * @param horario: horario
     * @return: string del horario de salida
     */
    public String getEstadoSalida(int horario) {
        if(horario==9){
            if(getHoraAlMomento()<16){
                return estadoSalida="V";
            }
        }else{
            if(getHoraAlMomento()<20){
                return estadoSalida="V";
            }
        }
        return estadoSalida="S";
    }

    /**
     * Obtiene el valor de diaDeLaSemana
     * @return: retorna el valor de diaDeLaSemana
     */
    public DayOfWeek getDiaDeLaSemana() {
        return diaDeLaSemana = getFechaActual().getDayOfWeek();
    }

    /**
     * Obtiene el valor de diaDeLaSemana
     * @return: retorna el valor de diaDeLaSemana
     */
    public int getNumeroDiaDeLaSemana() {
        return numeroDiaDeLaSemana = getDiaDeLaSemana().getValue();
    }

    /**
     * Obtiene el valor de diasDeLaSemana
     * @return: retorna el valor de diasDeLaSemana
     */
    public String getNombreDiaDeLaSemana() {
        return diasDeLaSemana[getNumeroDiaDeLaSemana()-1];
    }
    
    /**
     * Obtiene el valor de iDPersonas
     * @return: retorna el valor de iDPersonas
     */
    public Integer getiDPersonas() {
        return iDPersonas;
    }
    
    /**
     * modifica el idpersonas
     * @param iDPersonas: iDPersonas ingresado
     */
    public void setiDPersonas(Integer iDPersonas) {
        this.iDPersonas = iDPersonas;
    }
    
    /**
     * Obtiene el valor de numeroDia
     * @return: retorna el valor de numeroDia
     */
    public Integer getNumeroDia() {
        return numeroDia = getFechaActual().getDayOfMonth();
    }

    /**
     * Obtiene el valor de numeroMes
     * @return: retorna el valor de numeroMes
     */
    public Integer getNumeroMes() {
        return numeroMes = getFechaActual().getMonthValue();
    }
    
    /**
     * Obtiene el valor de meses
     * @return: retorna el valor de meses
     */
    public String getNombreMes() {
        return meses[getNumeroMes()-1];
    }
    
    
    /**
     * Obtiene el valor de numeroAnio
     * @return: retorna el valor de numeroAnio
     */
    public Integer getNumeroAnio() {
        return numeroAnio= getFechaActual().getYear();
    }
    
    /**
     * Obtiene el valor de fechaActual
     * @return: retorna el valor de fechaActual
     */
    public LocalDate getFechaActual() {
        return fechaActual=LocalDate.now();
    }
    
    /**
     * Obtiene el valor de horaActual
     * @return: retorna el valor de horaActual
     */
    public LocalTime getHoraActual() {
        return horaActual;
    }
    
    /**
     * Obtiene el valor de diasDeLaSemana
     * @return: retorna el valor de diasDeLaSemana
     */
    public String[] getDiasDeLaSemana() {
        return diasDeLaSemana;
    }
    
    
    /**
     * Obtiene el valor de meses
     * @return: retorna el valor de meses
     */
    public String[] getMeses() {
        return meses;
    }
    
    /**
     * Obtiene el valor de estadoEntrada
     * @return: retorna el valor de estadoEntrada
     */
    public String getEstadoEntrada() {
        return estadoEntrada;
    }
    
    /**
     * Obtiene el valor de estadoSalida
     * @return: retorna el valor de estadoSalida
     */
    public String getEstadoSalida() {
        return estadoSalida;
    }
    
    /**
     * Obtiene el valor de horaAlMomento
     * @return: retorna el valor de horaAlMomento
     */
    public Integer getHoraAlMomento() {
        return horaAlMomento=getHoraActual().getHour();
    }
    
    /**
     * Obtiene el valor de minutoAlMomento
     * @return: retorna el valor de minutoAlMomento
     */
    public Integer getMinutoAlMomento() {
        return minutoAlMomento=getHoraActual().getMinute();
    }
    
    /**
     * Obtiene el valor de horaEntrada
     * @return: retorna el valor de horaEntrada
     */
    public Integer getHoraEntrada() {
        return horaEntrada;
    }
    
    /**
     * Obtiene el valor de minutoEntrada
     * @return: retorna el valor de minutoEntrada
     */
    public Integer getMinutoEntrada() {
        return minutoEntrada;
    }
    
    /**
     * Obtiene el valor de horaSalida
     * @return: retorna el valor de horaSalida
     */
    public Integer getHoraSalida() {
        return horaSalida;
    }
    
    /**
     * Obtiene el valor de minutoSalida
     * @return: retorna el valor de minutoSalida
     */
    public Integer getMinutoSalida() {
        return minutoSalida;
    }
}

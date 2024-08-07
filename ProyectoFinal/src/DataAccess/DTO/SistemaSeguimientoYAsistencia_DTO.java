package DataAccess.DTO;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

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

    public SistemaSeguimientoYAsistencia_DTO(Integer horaEntrada, Integer minutoEntrada, Integer horaSalida,
            Integer minutoSalida) {
        this.horaEntrada = horaEntrada;
        this.minutoEntrada = minutoEntrada;
        this.horaSalida = horaSalida;
        this.minutoSalida = minutoSalida;
    }
    public SistemaSeguimientoYAsistencia_DTO() {
    }
    //entrada
    public SistemaSeguimientoYAsistencia_DTO(Integer iDPersonas) {
        this.iDPersonas = iDPersonas;
        this.horaEntrada = getHoraAlMomento();
        this.minutoEntrada = getMinutoAlMomento();
        this.numeroDia = getNumeroDia();
        this.numeroMes = getNumeroMes();
        this.numeroAnio = getNumeroAnio();
    }
    public String getEstadoEntrada(int horario) {
        if(horario==9){//manana
            if(getHoraAlMomento()>7){
                return estadoEntrada="A";
            }
        }else{//tarde
            if(getHoraAlMomento()>11){
                return estadoEntrada="A";
            }
        }
        return estadoEntrada="I";
    }
    public String getEstadoSalida(int horario) {
        if(horario==9){//manana
            if(getHoraAlMomento()<16){
                return estadoSalida="V";
            }
        }else{//tarde
            if(getHoraAlMomento()<20){
                return estadoSalida="V";
            }
        }
        return estadoSalida="S";
    }
    public DayOfWeek getDiaDeLaSemana() {
        return diaDeLaSemana = getFechaActual().getDayOfWeek();
    }
    public int getNumeroDiaDeLaSemana() {
        return numeroDiaDeLaSemana = getDiaDeLaSemana().getValue();
    }
    public String getNombreDiaDeLaSemana() {
        return diasDeLaSemana[getNumeroDiaDeLaSemana()-1];
    }
    public Integer getiDPersonas() {
        return iDPersonas;
    }
    public void setiDPersonas(Integer iDPersonas) {
        this.iDPersonas = iDPersonas;
    }
    public Integer getNumeroDia() {
        return numeroDia = getFechaActual().getDayOfMonth();
    }
    public void setNumeroDia(Integer numeroDia) {
        this.numeroDia = numeroDia;
    }
    public Integer getNumeroMes() {
        return numeroMes = getFechaActual().getMonthValue();
    }
    public String getNombreMes() {
        return meses[getNumeroMes()-1];
    }
    public void setNumeroMes(Integer numeroMes) {
        this.numeroMes = numeroMes;
    }
    public Integer getNumeroAnio() {
        return numeroAnio= getFechaActual().getYear();
    }
    public void setNumeroAnio(Integer numeroAnio) {
        this.numeroAnio = numeroAnio;
    }
    public LocalDate getFechaActual() {
        return fechaActual=LocalDate.now();
    }
    public void setFechaActual(LocalDate fechaActual) {
        this.fechaActual = fechaActual;
    }
    public LocalTime getHoraActual() {
        return horaActual;
    }
    public void setHoraActual(LocalTime horaActual) {
        this.horaActual = horaActual;
    }
    public void setEstadoEntrada(String estadoEntrada) {
        this.estadoEntrada = estadoEntrada;
    }
    
    public void setEstadoSalida(String estadoSalida) {
        this.estadoSalida = estadoSalida;
    }
    public void setDiaDeLaSemana(DayOfWeek diaDeLaSemana) {
        this.diaDeLaSemana = diaDeLaSemana;
    }
    
    public void setNumeroDiaDeLaSemana(int numeroDiaDeLaSemana) {
        this.numeroDiaDeLaSemana = numeroDiaDeLaSemana;
    }
    public String[] getDiasDeLaSemana() {
        return diasDeLaSemana;
    }
    public void setDiasDeLaSemana(String[] diasDeLaSemana) {
        this.diasDeLaSemana = diasDeLaSemana;
    }
    public String[] getMeses() {
        return meses;
    }
    public void setMeses(String[] meses) {
        this.meses = meses;
    }
    
    public String getEstadoEntrada() {
        return estadoEntrada;
    }
    public String getEstadoSalida() {
        return estadoSalida;
    }
    public Integer getHoraAlMomento() {
        return horaAlMomento=getHoraActual().getHour();
    }
    public void setHoraAlMomento(Integer horaAlMomento) {
        this.horaAlMomento = horaAlMomento;
    }
    public Integer getMinutoAlMomento() {
        return minutoAlMomento=getHoraActual().getMinute();
    }
    public void setMinutoAlMomento(Integer minutoAlMomento) {
        this.minutoAlMomento = minutoAlMomento;
    }
    public Integer getHoraEntrada() {
        return horaEntrada;
    }
    public void setHoraEntrada(Integer horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
    public Integer getMinutoEntrada() {
        return minutoEntrada;
    }
    public void setMinutoEntrada(Integer minutoEntrada) {
        this.minutoEntrada = minutoEntrada;
    }
    public Integer getHoraSalida() {
        return horaSalida;
    }
    public void setHoraSalida(Integer horaSalida) {
        this.horaSalida = horaSalida;
    }
    public Integer getMinutoSalida() {
        return minutoSalida;
    }
    public void setMinutoSalida(Integer minutoSalida) {
        this.minutoSalida = minutoSalida;
    }
}

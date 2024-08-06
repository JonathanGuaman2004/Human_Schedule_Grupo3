package FrameWork;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 *
 * @author jonat
 */
public class Fecha {
    private LocalDate fechaActual;
    private int numeroDia ;
    private int numeroMes ;
    private int numeroAno ;
    private int numeroDiaDeLaSemana ;
    private DayOfWeek diaDeLaSemana ;
    
    private String [] diasDeLaSemana={"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
    private String [] meses={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    
    
    public LocalDate getFechaActual() {
        return fechaActual = LocalDate.now();
    }

    public int getNumeroDia() {
        return numeroDia = getFechaActual().getDayOfMonth();
    }

    public int getNumeroMes() {
        return numeroMes = getFechaActual().getMonthValue();
    }

    public int getNumeroAno() {
        return numeroAno = getFechaActual().getYear();
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
    public String getNombreMes() {
        return meses[getNumeroMes()-1];
    }
}

package DataAccess.DTO;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class SistemaControlAcceso_DTO {
    private LocalDate fechaActual=LocalDate.now();
    private LocalTime horaActual = LocalTime.now();
    private Integer iDPersonas;
    private Integer numeroMes;
    private Integer numeroAnio;
    private Integer  numeroAtrasos;
    private Integer  numeroSalidaAntes;
    private Integer horasFaltantes;
    private Integer horasExtra;
    private Integer horasExtraOrdinariasNull=0;
    private Integer horasExtraOrdinarias;
    private String  decimoTercerS;
    private String  decimoCuartoS;
    private Integer numeroDiasLaborables;
    private int [] horasTrabajadas;
    
    public SistemaControlAcceso_DTO() {
    }
    
    public SistemaControlAcceso_DTO(Integer numeroAtrasos, Integer numeroSalidaAntes, Integer horasFaltantes,
            Integer horasExtra, Integer horasExtraOrdinarias, Integer numeroDiasLaborables) {
        this.numeroAtrasos = numeroAtrasos;
        this.numeroSalidaAntes = numeroSalidaAntes;
        this.horasFaltantes = horasFaltantes;
        this.horasExtra = horasExtra;
        this.horasExtraOrdinarias = horasExtraOrdinarias;
        this.numeroDiasLaborables = numeroDiasLaborables;
    }

    public Integer getHorasExtraOrdinarias(SistemaSeguimientoYAsistencia_DTO entidad,int horario) {
        horasTrabajadas=calcularHorasTrabajadas(entidad.getHoraEntrada(), entidad.getMinutoEntrada(), entidad.getHoraSalida(), entidad.getMinutoSalida(), horario);
        return horasTrabajadas[0]+horasTrabajadas[1];
    }
    public void setHorasExtraOrdinarias(Integer horasExtraOrdinarias) {
        this.horasExtraOrdinarias = horasExtraOrdinarias;
    }
    public Integer getHorasExtraOrdinariasNull() {
        return horasExtraOrdinariasNull;
    }
    public void setHorasExtraOrdinariasNull(Integer horasExtraOrdinariasNull) {
        this.horasExtraOrdinariasNull = horasExtraOrdinariasNull;
    }
    
    public SistemaControlAcceso_DTO(Integer iDPersonas, Integer numeroAtrasos,
    Integer numeroSalidaAntes, Integer horasFaltantes, Integer horasExtra,
            String decimoTercerS, String decimoCuartoS) {
        this.iDPersonas = iDPersonas;
        this.numeroMes = getNumeroMes();
        this.numeroAnio = getNumeroAnio();
        this.numeroAtrasos = numeroAtrasos;
        this.numeroSalidaAntes = numeroSalidaAntes;
        this.horasFaltantes = horasFaltantes;
        this.horasExtra = horasExtra;
        this.decimoTercerS = decimoTercerS;
        this.decimoCuartoS = decimoCuartoS;
        this.numeroDiasLaborables = contarDiasLaborables(getNumeroAnio(),getNumeroMes());
    }
    public static int contarDiasLaborables(int year, int month) {
        int totalLaborables = 0;
        LocalDate inicio = LocalDate.of(year, month, 1);
        LocalDate fin = inicio.withDayOfMonth(inicio.lengthOfMonth());
        LocalDate fechaActual = inicio;
        while (!fechaActual.isAfter(fin)) {
            if (fechaActual.getDayOfWeek() != DayOfWeek.SATURDAY && fechaActual.getDayOfWeek() != DayOfWeek.SUNDAY) {
                totalLaborables++;
            }
            fechaActual = fechaActual.plusDays(1);
        }
        return totalLaborables;
    }
    public static int[] calcularHorasTrabajadas(int horaEntrada, int minutosEntrada, int horaSalida, int minutosSalida,
            int horario) {
        int horaInicio;
        int minutoInicio;
        int horaFin;
        int minutoFin;

        // Definir los horarios de entrada y salida
        if (horario ==9) { // Horario de la mañana
            horaInicio = 7;
            minutoInicio = 0;
            horaFin = 16;
            minutoFin = 0;
        } else if (horario == 10) { // Horario de la tarde
            horaInicio = 11;
            minutoInicio = 0;
            horaFin = 20;
            minutoFin = 0;
        } else {
            throw new IllegalArgumentException("Horario no válido");
        }

        // Convertir todo a minutos desde medianoche
        int entradaTotalMinutos = horaEntrada * 60 + minutosEntrada;
        int salidaTotalMinutos = horaSalida * 60 + minutosSalida;
        int inicioTotalMinutos = horaInicio * 60 + minutoInicio;
        int finTotalMinutos = horaFin * 60 + minutoFin;

        // Ajustar la hora de entrada si llega hasta 20 minutos antes
        int entradaPermitida = inicioTotalMinutos - 20;
        if (entradaTotalMinutos < entradaPermitida) {
            entradaTotalMinutos = entradaPermitida;
        }

        // Calcular el tiempo trabajado en minutos
        int tiempoTrabajado = salidaTotalMinutos - entradaTotalMinutos;

        // Calcular las horas trabajadas restando 1 hora para el almuerzo
        int horasTrabajadas = tiempoTrabajado / 60 - 1;
        if (horasTrabajadas < 0)
            horasTrabajadas = 0;

        // Calcular las horas extras
        int horasExtras = 0;
        if (horasTrabajadas > 9) {
            horasExtras = horasTrabajadas - 9;
            horasTrabajadas = 9;
        }

        // Verificar si llegó 20 minutos tarde
        int llegoTarde = (entradaTotalMinutos > inicioTotalMinutos + 20) ? 1 : 0;

        return new int[] { horasTrabajadas, horasExtras, llegoTarde };
    }
    public Integer getiDPersonas() {
        return iDPersonas;
    }
    public void setiDPersonas(Integer iDPersonas) {
        this.iDPersonas = iDPersonas;
    }
    public Integer getNumeroMes() {
        return numeroMes = fechaActual.getMonthValue();
    }
    public void setNumeroMes(Integer numeroMes) {
        this.numeroMes = numeroMes;
    }
    public Integer getNumeroAnio() {
        return numeroAnio= fechaActual.getYear();
    }
    public void setNumeroAnio(Integer numeroAnio) {
        this.numeroAnio = numeroAnio;
    }
    public Integer getHorasFaltantes(SistemaSeguimientoYAsistencia_DTO entidad,int horario) {
        horasTrabajadas=calcularHorasTrabajadas(entidad.getHoraEntrada(), entidad.getMinutoEntrada(), entidad.getHoraSalida(), entidad.getMinutoSalida(), horario);
        return 9-horasTrabajadas[0];
    }
    public void setHorasFaltantes(Integer horasFaltantes){
        
        this.horasFaltantes = horasFaltantes;
    }
    public Integer getHorasExtra(SistemaSeguimientoYAsistencia_DTO entidad,int horario) {
        horasTrabajadas=calcularHorasTrabajadas(entidad.getHoraEntrada(), entidad.getMinutoEntrada(), entidad.getHoraSalida(), entidad.getMinutoSalida(), horario);
        return horasTrabajadas[1];
    }
    
    public void setHorasExtra(Integer horasExtra) {
        this.horasExtra = horasExtra;
    }
    public String getDecimoTercerS() {
        return decimoTercerS;
    }
    public void setDecimoTercerS(String decimoTercerS) {
        this.decimoTercerS = decimoTercerS;
    }
    public String getDecimoCuartoS() {
        return decimoCuartoS;
    }
    public void setDecimoCuartoS(String decimoCuartoS) {
        this.decimoCuartoS = decimoCuartoS;
    }
    public Integer getNumeroHorasLaborables(int year, int month) {
        int totalLaborables = 0;
        LocalDate inicio = LocalDate.of(year, month, 1);
        LocalDate fin = inicio.withDayOfMonth(inicio.lengthOfMonth());

        LocalDate fechaActual = inicio;
        while (!fechaActual.isAfter(fin)) {
            if (fechaActual.getDayOfWeek() != DayOfWeek.SATURDAY && fechaActual.getDayOfWeek() != DayOfWeek.SUNDAY) {
                totalLaborables++;
            }
            fechaActual = fechaActual.plusDays(1);
        }
        return totalLaborables*9;
    }
    public void setNumeroDiasLaborables(Integer numeroDiasLaborables) {
        this.numeroDiasLaborables = numeroDiasLaborables;
    }
    public LocalDate getFechaActual() {
        return fechaActual;
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
    public Integer getNumeroAtrasos(SistemaSeguimientoYAsistencia_DTO entidad,int horario) {
        horasTrabajadas=calcularHorasTrabajadas(entidad.getHoraEntrada(), entidad.getMinutoEntrada(), entidad.getHoraSalida(), entidad.getMinutoSalida(), horario);
        return horasTrabajadas[2];
    }
    public void setNumeroAtrasos(Integer numeroAtrasos) {
        this.numeroAtrasos = numeroAtrasos;
    }
    public Integer getNumeroSalidaAntes(SistemaSeguimientoYAsistencia_DTO entidad,int horario) {
        if(horario==9){
            if(entidad.getHoraSalida()<16){
                return 1;
            }
        }else{
            if(entidad.getHoraSalida()<20){
                return 1;
            }
        }
        return 0;
    }
    public void setNumeroSalidaAntes(Integer numeroSalidaAntes) {
        this.numeroSalidaAntes = numeroSalidaAntes;
    }

    public Integer getNumeroAtrasos() {
        return numeroAtrasos;
    }

    public Integer getNumeroSalidaAntes() {
        return numeroSalidaAntes;
    }

    public Integer getHorasFaltantes() {
        return horasFaltantes;
    }

    public Integer getHorasExtra() {
        return horasExtra;
    }

    public Integer getHorasExtraOrdinarias() {
        return horasExtraOrdinarias;
    }

    public Integer getNumeroDiasLaborables() {
        return numeroDiasLaborables;
    }

    public int[] getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int[] horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
}

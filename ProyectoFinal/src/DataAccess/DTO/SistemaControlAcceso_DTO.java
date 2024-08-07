package DataAccess.DTO;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase para guardar los registros mensuales
 */
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
    
    /**
     * Constructor Vacio
     */
    public SistemaControlAcceso_DTO() {
    }
    
    /**
     * ConstructorUno
     * @param numeroAtrasos: numeroAtrasos
     * @param numeroSalidaAntes: numeroSalidaAntes
     * @param horasFaltantes: horasFaltantes
     * @param horasExtra: horasExtra
     * @param horasExtraOrdinarias: horasExtraOrdinarias
     * @param numeroDiasLaborables: numeroDiasLaborables
     */
    public SistemaControlAcceso_DTO(Integer numeroAtrasos, Integer numeroSalidaAntes, Integer horasFaltantes,
    Integer horasExtra, Integer horasExtraOrdinarias, Integer numeroDiasLaborables) {
        this.numeroAtrasos = numeroAtrasos;
        this.numeroSalidaAntes = numeroSalidaAntes;
        this.horasFaltantes = horasFaltantes;
        this.horasExtra = horasExtra;
        this.horasExtraOrdinarias = horasExtraOrdinarias;
        this.numeroDiasLaborables = numeroDiasLaborables;
    }
    
    /**
     * ConstructorDos
     * @param iDPersonas: iDPersonas
     * @param numeroAtrasos: numeroAtrasos
     * @param numeroSalidaAntes: numeroSalidaAntes
     * @param horasFaltantes: horasFaltantes
     * @param horasExtra: horasExtra
     * @param decimoTercerS: decimoTercerS
     * @param decimoCuartoS: decimoCuartoS
     */
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

    /**
     * Este metodo cuento al numero de dias laborables
     * @param year: anio
     * @param month: mes
     * @return: retorna el numero de dias laborables
     */
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
    
    /**
     * Metodo que devuelve el numero de horas que trabajo una persona en un dia
     * @param horaEntrada: horaEntrada
     * @param minutosEntrada: minutosEntrada
     * @param horaSalida: horaSalida
     * @param minutosSalida: minutosSalida
     * @param horario: horario
     * @return retorna un arreglo con las horas trabajadas, horas extra y si llego tarde
     */
    public static int[] calcularHorasTrabajadas(int horaEntrada, int minutosEntrada, int horaSalida, int minutosSalida,
    int horario) {
        int horaInicio;
        int minutoInicio;
        int horaFin;
        int minutoFin;
        
        if (horario ==9) {
            horaInicio = 7;
            minutoInicio = 0;
            horaFin = 16;
            minutoFin = 0;
        } else if (horario == 10) {
            horaInicio = 11;
            minutoInicio = 0;
            horaFin = 20;
            minutoFin = 0;
        } else {
            throw new IllegalArgumentException("Horario no válido");
        }
        
        int entradaTotalMinutos = horaEntrada * 60 + minutosEntrada;
        int salidaTotalMinutos = horaSalida * 60 + minutosSalida;
        int inicioTotalMinutos = horaInicio * 60 + minutoInicio;
        int finTotalMinutos = horaFin * 60 + minutoFin;
        
        int entradaPermitida = inicioTotalMinutos - 20;
        if (entradaTotalMinutos < entradaPermitida) {
            entradaTotalMinutos = entradaPermitida;
        }
        
        int tiempoTrabajado = salidaTotalMinutos - entradaTotalMinutos;
        
        int horasTrabajadas = tiempoTrabajado / 60 - 1;
        if (horasTrabajadas < 0)
        horasTrabajadas = 0;
        
        int horasExtras = 0;
        if (horasTrabajadas > 9) {
            horasExtras = horasTrabajadas - 9;
            horasTrabajadas = 9;
        }
        
        int llegoTarde = (entradaTotalMinutos > inicioTotalMinutos + 20) ? 1 : 0;
        
        return new int[] { horasTrabajadas, horasExtras, llegoTarde };
    }
    
    /**
     * calcual el numero de horas laborables en un mes
     * @param year: anio
     * @param month; mes
     * @return: numero de horas que se debe trabajar ese mes
     */
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
    
    /**
     * metodo para calcular las horas extraordinarias
     * @param entidad: entidad
     * @param horario: horario
     * @return retorn el nuemro de horas extraordinarias trabajadas
     */
    public Integer getHorasExtraOrdinarias(SistemaSeguimientoYAsistencia_DTO entidad,int horario) {
        horasTrabajadas=calcularHorasTrabajadas(entidad.getHoraEntrada(), entidad.getMinutoEntrada(), entidad.getHoraSalida(), entidad.getMinutoSalida(), horario);
        return horasTrabajadas[0]+horasTrabajadas[1];
    }
    
    /**
     * metodo para calcular las horas faltantes
     * @param entidad: entidad
     * @param horario: horario
     * @return retorn el nuemro de horas faltantes por ser trabajadas
     */
    public Integer getHorasFaltantes(SistemaSeguimientoYAsistencia_DTO entidad,int horario) {
        horasTrabajadas=calcularHorasTrabajadas(entidad.getHoraEntrada(), entidad.getMinutoEntrada(), entidad.getHoraSalida(), entidad.getMinutoSalida(), horario);
        return 9-horasTrabajadas[0];
    }
    
    /**
     * metodo para calcular las horas extra
     * @param entidad: entidad
     * @param horario: horario
     * @return retorn el nuemro de horas extra trabajadas
     */
    public Integer getHorasExtra(SistemaSeguimientoYAsistencia_DTO entidad,int horario) {
        horasTrabajadas=calcularHorasTrabajadas(entidad.getHoraEntrada(), entidad.getMinutoEntrada(), entidad.getHoraSalida(), entidad.getMinutoSalida(), horario);
        return horasTrabajadas[1];
    }

    /**
     * metodo para calcular el nuemro de atrasos de un individuo
     * @param entidad: entidad
     * @param horario: horario
     * @return retorn el nuemro de atrasos
     */
    public Integer getNumeroAtrasos(SistemaSeguimientoYAsistencia_DTO entidad,int horario) {
        horasTrabajadas=calcularHorasTrabajadas(entidad.getHoraEntrada(), entidad.getMinutoEntrada(), entidad.getHoraSalida(), entidad.getMinutoSalida(), horario);
        return horasTrabajadas[2];
    }

    /**
     * metodo para calcular el nuemro de salidas antes de tiempo
     * @param entidad: entidad
     * @param horario: horario
     * @return retorn el nuemro de salidas antes de tiempo
     */
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

    /**
     * Obtiene el valor de la horas Horas ExtraOrdinarias
     * @return: numero Horas ExtraOrdinarias
     */
    public Integer getHorasExtraOrdinariasNull() {
        return horasExtraOrdinariasNull;
    }
    
    /**
     * Obtiene el valor de la iDPersonas
     * @return: numero iDPersonas
     */
    public Integer getiDPersonas() {
        return iDPersonas;
    }
    
    /**
     * Obtiene el valor de la numeroMes
     * @return: numero numeroMes
     */
    public Integer getNumeroMes() {
        return numeroMes = fechaActual.getMonthValue();
    }
    
    /**
     * Obtiene el valor de la numeroAnio
     * @return: numero numeroAnio
     */
    public Integer getNumeroAnio() {
        return numeroAnio= fechaActual.getYear();
    }
    
    /**
     * Obtiene el valor de la decimoTercerS
     * @return: numero decimoTercerS
     */
    public String getDecimoTercerS() {
        return decimoTercerS;
    }
    
    /**
     * Obtiene el valor de la decimoCuartoS
     * @return: numero decimoCuartoS
     */
    public String getDecimoCuartoS() {
        return decimoCuartoS;
    }
    
    /**
     * Obtiene el valor de la fechaActual
     * @return: numero fechaActual
     */
    public LocalDate getFechaActual() {
        return fechaActual;
    }
    
    /**
     * Obtiene el valor de la horaActual
     * @return: numero horaActual
     */
    public LocalTime getHoraActual() {
        return horaActual;
    }
    
    /**
     * Obtiene el valor de la numeroAtrasos
     * @return: numero numeroAtrasos
     */
    public Integer getNumeroAtrasos() {
        return numeroAtrasos;
    }
    
    /**
     * Obtiene el valor de la numeroSalidaAntes
     * @return: numero numeroSalidaAntes
     */
    public Integer getNumeroSalidaAntes() {
        return numeroSalidaAntes;
    }
    
    /**
     * Obtiene el valor de la horasFaltantes
     * @return: numero horasFaltantes
     */
    public Integer getHorasFaltantes() {
        return horasFaltantes;
    }
    
    /**
     * Obtiene el valor de la horasExtra
     * @return: numero horasExtra
     */
    public Integer getHorasExtra() {
        return horasExtra;
    }
    
    /**
     * Obtiene el valor de la horasExtraOrdinarias
     * @return: numero horasExtraOrdinarias
     */
    public Integer getHorasExtraOrdinarias() {
        return horasExtraOrdinarias;
    }
    
    /**
     * Obtiene el valor de la numeroDiasLaborables
     * @return: numero numeroDiasLaborables
     */
    public Integer getNumeroDiasLaborables() {
        return numeroDiasLaborables;
    }
    
    /**
     * Obtiene el valor de la horasTrabajadas
     * @return: numero horasTrabajadas
     */
    public int[] getHorasTrabajadas() {
        return horasTrabajadas;
    }
    
    /**
     * este metodo settea el valor de idpersonas
     * @param iDPersonas: iDPersonas
     */
    public void setiDPersonas(Integer iDPersonas) {
        this.iDPersonas = iDPersonas;
    }
}

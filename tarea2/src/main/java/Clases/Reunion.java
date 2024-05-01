package Clases;

import java.time.Instant;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase que representa una reunion de una empresa.
 * @autor Valeria Quiroga
 * @autor Amtonio Benavides
 */
abstract public class Reunion{

    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horarioInicio;
    private Instant horarioFIn;
    private List<Invitacion> invitacion;
    private List<Asistencia> asistencias;
    private List<Nota> notas;
    private Empleado organizador;
    private tipoReunion tipo;

    /**
     * Funcion que retorna la lista de las asistencias de la reunion.
     * @return Lista de asistencias de la reunion.
     */
    public List<Asistencia> obtenerAsistencias(){
        return asistencias;
    }

    /**
     * Funcion que retorna la lista de las ausencias de la reunion.
     * @return  Lista de ausencias de la reunion.
     */
    public List<Empleado> obtenerAusencias(){           //!!!!FALTA IMPLEMENTAR!!!!//
        return null;
    }

    /**
     * Funcion que retorna la lista de los retrasos de la reunion.
     * @return Lista de retrasos de la reunion.
     */
    public List<Asistencia> obtenerRetrasos(){
        List<Asistencia> retrasos = new ArrayList<Asistencia>();
        for(Asistencia asistencia : asistencias){
            if(asistencia instanceof Retraso){
                retrasos.add(asistencia);
            }
        }
        return retrasos;
    }

    /**
     * Constructor de la clase Reunion.
     * @param organizador Empleado organizador de la reunion.
     * @param tipo Tipo de reunion.
     * @param fecha Fecha de la reunion.
     * @param horaPrevista Hora prevista de la reunion.
     * @param duracionPrevista Duracion prevista de la reunion.
     * @param nota Nota de la reunion.
     * @param invitacion Lista de invitaciones a la reunion.
     */
    public Reunion(Empleado organizador,tipoReunion tipo,Date fecha, Instant horaPrevista, Duration duracionPrevista, Nota nota, List<Invitacion> invitacion){
        this.organizador = organizador;
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.notas.add(nota);
        this.invitacion = invitacion;
        this.tipo = tipo;
    }

    /**
     * Funcion que retorna la fecha de la reunion.
     * @return Fecha de la reunion.
     */
    public Date getFecha(){
        return fecha;
    }

    /**
     * Funcion que retorna la hora prevista de la reunion.
     * @return Hora prevista de la reunion.
     */
    public Instant getHoraPrevista(){
        return horaPrevista;
    }

    /**
     * Funcion que retorna la duracion prevista de la reunion.
     * @return Duracion prevista de la reunion.
     */
    public Duration getDuracionPrevista(){
        return duracionPrevista;
    }
    
    /**
     * Funcion que retorna la cantidad de asistencias de la reunion.
     * @return Cantidad de asistencias de la reunion.
     */
    public int obtenerTotalAsistencia(){
        return obtenerAsistencias().size();
    }

    /**
     * Funcion que retorna el porcentaje de asistencia de la reunion.
     * @return Porcentaje de asistencia de la reunion.
     */
    public float obtenerPorcentajeAsistencia(){
        return (obtenerTotalAsistencia()/(obtenerTotalAsistencia() + obtenerAusencias().size()))*100;
    }

    /**
     * Funcion que retorna el tiempo de duracion real de la reunion.
     * @return Tiempo de duracion real de la reunion.
     */
    public float calcularTiempoReal(){
        return Duration.between(this.horarioInicio, this.horarioFIn).toMinutes();
    }

    /**
     * Funcion que inicia la reunion marcando la hora de inicio y la lista de asistencias.
     * @param asistencia Lista de asistencias de la reunion.
     */
    public void iniciar(List<Asistencia> asistencia){
        this.horarioInicio = Instant.now();
        this.asistencias = asistencia;
    }
    
    /**
     * Funcion que finaliza la reunion marcando la hora de finalizacion.
     */
    public void finalizar(){
        this.horarioFIn = Instant.now();
    }

    /**
     * Funcion que agrega una nota a la reunion.
     * @param nota Nota a agregar.
     */
    public void agregarNota(Nota nota){
        notas.add(nota);
    }

    /**
     * Funcion que retorna al Empleado organizador de la reunion.
     * @return Empleado organizador de la reunion.
     */
    public Empleado getOrganizador(){
        return organizador;
    }

    /**
     * Funcion que retorna el tipo de reunion.
     * @return Tipo de reunion.
     */
    public tipoReunion getTipo(){
        return tipo;
    }
    
}

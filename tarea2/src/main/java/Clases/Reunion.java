package Clases;

import java.time.Instant;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public List<Asistencia> obtenerAsistencias(){
        return asistencias;
    }

    public List<Empleado> obtenerAusencias(){           //FALTA COMPLETAR
        return null;
    }

    public List<Asistencia> obtenerRetrasos(){
        List<Asistencia> retrasos = new ArrayList<Asistencia>();
        for(Asistencia asistencia : asistencias){
            if(asistencia instanceof Retraso){
                retrasos.add(asistencia);
            }
        }
        return retrasos;
    }

    public Reunion(Empleado organizador,tipoReunion tipo,Date fecha, Instant horaPrevista, Duration duracionPrevista, Nota nota, List<Invitacion> invitacion){
        this.organizador = organizador;
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.notas.add(nota);
        this.invitacion = invitacion;
        this.tipo = tipo;
    }

    public Date getFecha(){
        return fecha;
    }

    public Instant getHoraPrevista(){
        return horaPrevista;
    }

    public Duration getDuracionPrevista(){
        return duracionPrevista;
    }
    
    public int obtenerTotalAsistencia(){
        return obtenerAsistencias().size();
    }

    public float obtenerPorcentajeAsistencia(){
        return (obtenerTotalAsistencia()/(obtenerTotalAsistencia() + obtenerAusencias().size()))*100;
    }

    public float calcularTiempoReal(){
        return Duration.between(this.horarioInicio, this.horarioFIn).toMinutes();
    }

    public void iniciar(List<Asistencia> asistencia){
        this.fecha = new Date();
        this.horarioInicio = Instant.now();
        this.asistencias = asistencia;
    }
    
    public void finalizar(){
        this.horarioFIn = Instant.now();
    }

    public void agregarNota(Nota nota){
        notas.add(nota);
    }

    public Empleado getOrganizador(){
        return organizador;
    }

    public tipoReunion getTipo(){
        return tipo;
    }
    
}

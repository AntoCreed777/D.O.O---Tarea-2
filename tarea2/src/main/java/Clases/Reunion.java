package Clases;

import java.time.Instant;
import java.time.Duration;
import java.util.Date;
import java.util.List;

abstract public class Reunion <T>{

    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horarioInicio;
    private Instant horarioFIn;

    public List<T> obtenerAsistencias();
    public List<T> obtenerAusencias();
    public List<T> obtenerRetrasos();

    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista){
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
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

    public void iniciar(){
        this.fecha = new Date();
        this.horarioInicio = Instant.now();
    }
    
    public void finalizar(){
        this.horarioFIn = Instant.now();
    }



}

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

    abstract public List<T> obtenerAsistencias();
    abstract public List<T> obtenerAusencias();
    abstract public List<T> obtenerRetrasos();

    public Reunion(){};

    abstract public int obtenerTotalAsistencia();
    abstract public float obtenerPorcentajeAsistencia();

    abstract public float calcularTiempo();

    abstract public void iniciar();
    abstract public void finalizar();



}

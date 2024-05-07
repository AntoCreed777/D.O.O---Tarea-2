package Clases;

import java.time.Instant;
import java.time.Duration;
import java.util.Date;
import java.util.List;

abstract public class Reunion{

    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horarioInicio;
    private Instant horarioFin;

    public List<Asistencia> obtenerAsistencias(){};
    public List<Asistencia> obtenerAusencias(){};
    public List<Asistencia> obtenerRetrasos(){};

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
        return Duration.between(this.horarioInicio, this.horarioFin).toMinutes();
    }

    public void iniciar(){
        this.fecha = new Date();
        this.horarioInicio = Instant.now();
    }
    
    public void finalizar(){
        this.horarioFin = Instant.now();
    }
    
    
    // getters para obtener hora, fecha, horarioInicio, horarioFin, etc para informe

    public Instant getHora(){
        return horaPrevista;
    }

    public Date getFecha(){
        return fecha;
    }
    public Instant getHorarioInicio(){
        return horarioInicio;
    }
    public Instant getHorarioFin(){
        return horarioFin;
    }
    

}

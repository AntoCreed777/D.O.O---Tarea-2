package Clases;

import java.time.Instant;
import java.time.Duration;
import java.util.Date;
import java.util.List;

/**
 * Clase que representa una reunion virtual de una empresa.
 * @author  Valeria Quiroga
 * @author Antonio Benavides
 */
public class ReunionVirtual extends Reunion{

    private final String enlace;

    /**
     * Constructor en que se inicializan los atributos de la clase.
     * @param organizador Empleado organizador de la reunion.
     * @param tipo Tipo de reunion.
     * @param fecha Fecha de la reunion.
     * @param horaPrevista Hora prevista de la reunion.
     * @param duracionPrevista Duracion prevista de la reunion.
     * @param enlace Enlace de la reunion.
     */
    public ReunionVirtual(Empleado organizador,tipoReunion tipo,Date fecha, Instant horaPrevista, Duration duracionPrevista, String enlace){
        super(organizador,tipo,fecha, horaPrevista, duracionPrevista);
        this.enlace = enlace;
    }

    /**
     * Funcion que retorna el enlace de la 'Reunion'
     * @return enlace de la 'Reunion'
     */
    public String getEnlace(){
        return enlace;
    }

    /**
     * Funcion que devuelve una descripcion de la clase
     * @return Descripcion de la clase
     */
    @Override
    public String toString() {
        return super.toString() + " de forma virtual";
    }
}

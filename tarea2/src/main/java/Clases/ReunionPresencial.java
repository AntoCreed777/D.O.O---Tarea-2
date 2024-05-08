package Clases;

import java.time.Instant;
import java.time.Duration;
import java.util.Date;
import java.util.List;

/**
 * Clase que representa una reunion presencial de una empresa.
 * @author Valeria Quiroga
 * @author Antonio Benavides
 */
public class ReunionPresencial extends Reunion{
    
    private final String sala;
    
    /**
     * Constructor en que se inicializan los atributos de la clase.
     * @param organizador Empleado organizador de la reunion.
     * @param tipo Tipo de reunion.
     * @param fecha Fecha de la reunion.
     * @param horaPrevista Hora prevista de la reunion.
     * @param duracionPrevista Duracion prevista de la reunion.
     * @param sala Sala de la reunion.
     */
    public ReunionPresencial(Empleado organizador,tipoReunion tipo,Date fecha, Instant horaPrevista, Duration duracionPrevista, String sala){
        super(organizador, tipo, fecha, horaPrevista, duracionPrevista);
        this.sala = sala;
    }


    /**
     * Funcion que retorna la sala en que se realiza la reunion
     * @return  Sala en que se realiza la reunion
     */
    public String getSala(){
        return sala;
    }

    /**
     * Funcion que devuelve una descripcion de la clase
     * @return Descripcion de la clase
     */
    @Override
    public String toString() {
        return super.toString() + "en una sala";
    }
}

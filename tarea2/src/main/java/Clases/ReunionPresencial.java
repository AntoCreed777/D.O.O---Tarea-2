package Clases;

import java.time.Instant;
import java.time.Duration;
import java.util.Date;
import java.util.List;

/**
 * Clase que representa una reunion presencial de una empresa.
 * @autor Valeria Quiroga
 * @autor Amtonio Benavides
 */
public class ReunionPresencial extends Reunion{
    
    private String sala;
    
    /**
     * Constructor de la clase ReunionPresencial.
     * @param organizador Empleado organizador de la reunion.
     * @param tipo Tipo de reunion.
     * @param fecha Fecha de la reunion.
     * @param horaPrevista Hora prevista de la reunion.
     * @param duracionPrevista Duracion prevista de la reunion.
     * @param nota Nota de la reunion.
     * @param invitacion Lista de invitaciones de la reunion.
     * @param sala Sala de la reunion.
     */
    public ReunionPresencial(Empleado organizador,tipoReunion tipo,Date fecha, Instant horaPrevista, Duration duracionPrevista, List<Invitacion> invitacion, String sala){
        super(organizador, tipo, fecha, horaPrevista, duracionPrevista, invitacion);
        this.sala = sala;
    }


    // getter para 
    public String getSala(){
        return sala;
    }
}

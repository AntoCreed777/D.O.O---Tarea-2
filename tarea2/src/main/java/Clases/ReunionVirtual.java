package Clases;

import java.time.Instant;
import java.time.Duration;
import java.util.Date;
import java.util.List;

/**
 * Clase que representa una reunion virtual de una empresa.
 * @autor Valeria Quiroga
 * @autor Amtonio Benavides
 */
public class ReunionVirtual extends Reunion{

    private String enlace;

    /**
     * Constructor de la clase ReunionVirtual.
     * @param organizador Empleado organizador de la reunion.
     * @param tipo Tipo de reunion.
     * @param fecha Fecha de la reunion.
     * @param horaPrevista Hora prevista de la reunion.
     * @param duracionPrevista Duracion prevista de la reunion.
     * @param nota Nota de la reunion.
     * @param invitacion Lista de invitaciones de la reunion.
     * @param enlace Enlace de la reunion.
     */
    ReunionVirtual(Empleado organizador,tipoReunion tipo,Date fecha, Instant horaPrevista, Duration duracionPrevista, Nota nota, List<Invitacion> invitacion, String enlace){
        super(organizador,tipo,fecha, horaPrevista, duracionPrevista, invitacion);
        this.enlace = enlace;
    }

    public String getEnlace(){
        return enlace;
    }
}

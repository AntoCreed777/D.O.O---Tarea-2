package Clases;

import java.time.Instant;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class ReunionPresencial extends Reunion{
    private String sala;
    
    ReunionPresencial(Empleado organizador,tipoReunion tipo,Date fecha, Instant horaPrevista, Duration duracionPrevista, Nota nota, List<Invitacion> invitacion, String sala){
        super(organizador,tipo,fecha, horaPrevista, duracionPrevista, nota, invitacion);
        this.sala = sala;
    }
}

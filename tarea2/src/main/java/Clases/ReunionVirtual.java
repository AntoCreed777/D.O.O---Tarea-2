package Clases;

import java.time.Instant;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class ReunionVirtual extends Reunion{

    private String enlace;

    ReunionVirtual(Empleado organizador,tipoReunion tipo,Date fecha, Instant horaPrevista, Duration duracionPrevista, Nota nota, List<Invitacion> invitacion, String enlace){
        super(organizador,tipo,fecha, horaPrevista, duracionPrevista, nota, invitacion);
        this.enlace = enlace;
    }
}

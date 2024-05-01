package Clases;

import java.time.Instant;
import java.time.Duration;
import java.util.Date;

public class ReunionVirtual extends Reunion{

    private String enlace;

    ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, String enlace){
        super(fecha, horaPrevista, duracionPrevista);
        this.enlace = enlace;
    }
}

package Clases;

import java.time.Instant;
import java.time.Duration;
import java.util.Date;

public class ReunionPresencial extends Reunion{
    private String sala;
    
    ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, String sala){
        super(fecha, horaPrevista, duracionPrevista);
        this.sala = sala;
    }
}

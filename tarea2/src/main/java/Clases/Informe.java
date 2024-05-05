package Clases;

import java.time.Instant;
import java.util.Date;

public class Informe {
    private Date fecha;
    private Instant horaPrevista;

    private Instant horarioInicio;
    private Instant horarioFin;

    private String enlace;
    private String sala;

    public Informe(Reunion reunion){
        this.fecha = reunion.getFecha();
        this.horaPrevista = reunion.getHora();
        this.horarioInicio = reunion.getHorarioInicio();
        this.horarioFin = reunion.getHorarioFin();


        }
    }


}

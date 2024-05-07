package Clases;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class Informe {
    private Date fecha;
    private Instant horaPrevista;

    private Instant horarioInicio;
    private Instant horarioFin;

    private String tipoReunion;
    private String enlace = null;
    private String sala = null;

    private List<Invitacion> listaParticipantes;

    public Informe(Reunion reunion){
        this.fecha = reunion.getFecha();
        this.horaPrevista = reunion.getHora();
        this.horarioInicio = reunion.getHorarioInicio();
        this.horarioFin = reunion.getHorarioFin();


        
        if(reunion instanceof ReunionPresencial){
            this.sala = ((ReunionPresencial) reunion).getSala();

        } else if (reunion instanceof ReunionVirtual){
            this.enlace = ((ReunionVirtual) reunion).getEnlace();
        }

        
    }

    public void exportarInformeTXT(){};
}

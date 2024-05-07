package Clases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Clase que representa una reunion de una empresa.
 * @autor Valeria Quiroga
 */

public class Informe {

    private Date fecha;
    private Instant horaPrevista;

    private Instant horarioInicio;
    private Instant horarioFin;

    private tipoReunion tipo;
    private String enlace = null;
    private String sala = null;
    private List<Nota> notas;

    private List<Invitacion> listaParticipantes; // presentes o invitados?

    public Informe(Reunion reunion){
        this.fecha = reunion.getFecha();
        this.horaPrevista = reunion.getHora();
        this.horarioInicio = reunion.getHorarioInicio();
        this.horarioFin = reunion.getHorarioFin();
        this.notas = reunion.getNotas();
        this.tipo = reunion.getTipo();
        
        if(reunion instanceof ReunionPresencial){
            this.sala = ((ReunionPresencial) reunion).getSala();

        } else if (reunion instanceof ReunionVirtual){
            this.enlace = ((ReunionVirtual) reunion).getEnlace();
        }        
    }

    public void exportarInformeTXT(String nombre){

        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombre));
            writer.write("string");
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    };
}

// git commit -m "desarrollo de metodo exportarInformeTXT"

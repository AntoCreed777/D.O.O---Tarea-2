package Clases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Clase que genera un Informe de una 'Reunion'.
 * @autor Valeria Quiroga
 */

public class Informe {

    private Date fecha;
    private Instant horaPrevista;
    private Instant horarioInicio;
    private Instant horarioFin;
    private float duracionTotal;

    private tipoReunion tipo;
    private String enlace = null;
    private String sala = null;
    private List<Nota> notas;
    private List<Asistencia> asistentes;

    /**
     * Funcion que inicializa los atributos de la clase con los detalles de la reunion que fue pasada como argumento.
     * @param reunion Reunion de la cual se quiere generar el informe.
     */
    public Informe(Reunion reunion){
        // guardar los detalles de la reunion en variables
        this.fecha = reunion.getFecha();
        this.duracionTotal = reunion.calcularTiempoReal();
        this.horaPrevista = reunion.getHora();
        this.horarioInicio = reunion.getHorarioInicio();
        this.horarioFin = reunion.getHorarioFin();
        this.notas = reunion.getNotas();
        this.asistentes = reunion.obtenerAsistencias();
        this.tipo = reunion.getTipo();
        

        //dependiendo de si la reunion es virtual o presencial se usa la variable enlace o sala 
        if(reunion instanceof ReunionPresencial){
            this.sala = ((ReunionPresencial) reunion).getSala();
        } 
        else if (reunion instanceof ReunionVirtual){
            this.enlace = ((ReunionVirtual) reunion).getEnlace();
        }        
    }

    /**
     * Funcion que escribe el informe en un archivo .txt
     * @param nombre Nombre de la ruta del archivo en que se quiere escribir el informe
     */
    public void exportarInformeTXT(String nombre){
        
        try {

            // escribir detalles de la reunion
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombre));
            writer.write("Reunion tipo " + tipo.tipo);
            writer.write("\n\nFecha: " + fecha);
            writer.write("\nHora prevista: " + horaPrevista);
            writer.write("\nHora de inicio: " + horarioInicio);
            writer.write(", Hora de fin: " + horarioFin);
            writer.write("\nDuracion total: " + duracionTotal + " segundos.");

            // imprimir el enlace o sala dependiendo del tipo de reunion
            if(enlace != null){ writer.write("\n\nEnlace: " + enlace);}
            else if(sala != null){ writer.write("\n\nSala: " + sala);}

            // escribir empleados asistentes.
            writer.write("\nAsistentes: \n    ");
            for(Asistencia a: asistentes){
                String empleado = a.getEmpleado().getNombre() + " " + a.getEmpleado().getApellidos();
                writer.write(empleado + ", ");
            }
            writer.write("\n\n");


            //Escirbir las notas tomadas.
            writer.write("\nNotas: \n\n");

            int i = 1;
            for(Nota n: notas){

                writer.write("Nota " + i + ":\n");
                writer.write(n.getContenido() + "\n\n");
                i++;
            }
           
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    /**
     * Funcion que devuelve una descripcion de la clase
     * @return Descripcion de la clase
     */
    @Override
    public String toString() {
        return "'Informe' representa a un Empleado de un 'Departamento' una Empresa ";
    }
}


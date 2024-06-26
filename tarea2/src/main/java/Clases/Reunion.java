package Clases;

import java.time.Instant;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase que representa una reunion de una empresa.
 * @author Valeria Quiroga
 * @author Antonio Benavides
 */
abstract public class Reunion{

    private final Date fecha;
    private final Instant horaPrevista;
    private final Duration duracionPrevista;
    private Instant horarioInicio;
    private Instant horarioFin;
    private List<Invitacion> invitaciones;
    private List<Asistencia> asistencias;
    private List<Nota> notas = null;
    private final Empleado organizador;
    private final tipoReunion tipo;


     /**
     * Constructor en que se inicializan los atributos de la clase.
     * @param organizador Empleado organizador de la reunion.
     * @param tipo Tipo de reunion.
     * @param fecha Fecha de la reunion.
     * @param horaPrevista Hora prevista de la reunion.
     * @param duracionPrevista Duracion prevista de la reunion.
     */
    public Reunion(Empleado organizador,tipoReunion tipo,Date fecha, Instant horaPrevista, Duration duracionPrevista){
        this.organizador = organizador;
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.tipo = tipo;

        this.invitaciones = new ArrayList<Invitacion>(); //Crear lista para luego guardar las invitaciones.
        this.asistencias = new ArrayList<Asistencia>();
        this.notas = new ArrayList<Nota>(); // Crear lista para luego guardar las notas.

    }

    /**
     * Funcion que agrega un invitado a la Reunion
     * @param invitacion La Invitacion de Un 'Departamento' o 'Empleado'
     */
    public void agregarInvitado(Invitacion invitacion){invitaciones.add(invitacion);}

    /**
     * Funcion que inicia la reunion marcando la hora de inicio
     */
    public void iniciar(){
        this.horarioInicio = Instant.now();
    }
    
    /**
     * Funcion que finaliza la reunion marcando la hora de finalizacion.
     */
    public void finalizar(){
        this.horarioFin = Instant.now();
    }
    
    //#region CALCULOS Y SETTERS

    /**
     * Funcion que dependiendo de si la reunion ya comenzo o termino marca la asistencia del empleado
     * @param empleado Quien llega a la reunion
     */
    public void marcarAsistencia(Empleado empleado){
         if(horarioInicio == null){ //Si aun no comienza la reunion
             asistencias.add(new Asistencia(empleado));
         }
         else if(horarioFin == null){ //Si ya comenzo la reunion pero aun no termina
             asistencias.add(new Retraso(empleado,Instant.now()));
         }
    }

     /**
     * Funcion que retorna la lista de las asistencias de la reunion.
     * @return Lista de asistencias de la reunion.
     */
    
    public List<Asistencia> obtenerAsistencias(){
        return asistencias;
    }

    /**
     * Funcion que retorna la lista de las ausencias de la reunion.
     * @return  Lista de ausencias de la reunion.
     */
    public List<Empleado> obtenerAusencias(){
        List<Empleado> ausencias = new ArrayList<Empleado>();       //Lista de ausentes a la reunion
        List<Empleado> auxinvitacion = new ArrayList<Empleado>();   //Lista de invitados a la reunion (Solo Empleados, ningun Departamento)

        for(Invitacion invitacion : invitaciones){                  //Se recorren las invitaciones
            if(invitacion.getInvitado() instanceof Departamento){   //Si el invitado es un Departamento
                auxinvitacion.addAll(((Departamento) invitacion.getInvitado()).getEmpleados()); //Agrego a todos los Empleados del Departamento a la lista de invitados
            }
            else{
                auxinvitacion.add((Empleado)invitacion.getInvitado());  //Si el invitado es un Empleado, se agrega a la lista de invitados
            }
        }


        List<Empleado> auxAsistencias = new ArrayList<Empleado>(); //Lista de asistentes a la reunion

        if(asistencias==null){return null;}

        for(Asistencia a : asistencias){                         //Se recorren las asistencias
            auxAsistencias.add(a.getEmpleado());                //Se agregan los empleados a la lista de auxiliar de empleados asistentes
        }

        for(Empleado empleado : auxinvitacion){                 //Se recorren los invitados

            if(!auxAsistencias.contains((Empleado)empleado)){        //Si el empleado no esta en la lista de asistencias

                ausencias.add(empleado);                        //Se agrega a la lista de ausentes
            }
        }
        return ausencias;                                    //Se retorna la lista de ausentes
    }

    /**
     * Funcion que retorna la lista de los retrasos de la reunion.
     * @return Lista de retrasos de la reunion.
     */ 
    public List<Asistencia> obtenerRetrasos(){
        List<Asistencia> retrasos = new ArrayList<Asistencia>();
        for(Asistencia asistencia : asistencias){
            if(asistencia instanceof Retraso){
                retrasos.add(asistencia);
            }
        }
        return retrasos;
    }
    
    /**
     * Funcion que retorna la cantidad de asistencias de la reunion.
     * @return Cantidad de asistencias de la reunion.
     */
    public int obtenerTotalAsistencia(){
        if(obtenerAsistencias()==null){return 0;}
        return obtenerAsistencias().size();
    }

    /**
     * Funcion que retorna el porcentaje de asistencia de la reunion.
     * @return Porcentaje de asistencia de la reunion.
     */
    public float obtenerPorcentajeAsistencia(){
        return ((float)obtenerTotalAsistencia()/(float)getInvitados().size())*100;
    }

    
    /**
     * Funcion que retorna el tiempo de duracion real de la reunion.
     * @return Tiempo de duracion real de la reunion.
     */
    public float calcularTiempoReal(){
        return Duration.between(this.horarioInicio, this.horarioFin).toSeconds();
    }

    /**
     * Funcion que agrega una nota a la reunion.
     * @param nota Nota a agregar.
     */
    public void agregarNota(Nota nota){
        notas.add(nota);
    }

    /**
     * Funcion que devuelve una descripcion de la clase
     * @return Descripcion de la clase
     */
    @Override
    public String toString() {
        return "Representa una reunion de una empresa";
    }

    //#region GETTER

    /**
     * Funcion que retorna la fecha de la reunion.
     * @return Fecha de la reunion.
     */
    public Date getFecha(){
        return fecha;
    }

    /**
     * Funcion que retorna la hora prevista de la reunion.
     * @return Hora prevista de la reunion.
     */
    public Instant getHoraPrevista(){
        return horaPrevista;
    }

    /**
     * Funcion que retorna la duracion prevista de la reunion.
     * @return Duracion prevista de la reunion.
     */
    public Duration getDuracionPrevista(){
        return duracionPrevista;
    }

    /**
     * Funcion que retorna el horario de inicio de la reunion.
     * @return Horario de inicio.
     */
    public Instant getHorarioInicio(){
        return horarioInicio;
    }

    /**
     * Funcion que retorna el horario del fin de reunion.
     * @return Horario de fin.
     */

    public Instant getHorarioFin(){
        return horarioFin;
    }
    
    /**
     * Funcion que retorna la lista de notas.
     * @return Lista notas.
     */
    public List<Nota> getNotas(){
        return notas;
    }

    /**
     * Funcion que retorna al Empleado organizador de la reunion.
     * @return Empleado organizador de la reunion.
     */
    public Empleado getOrganizador(){
        return organizador;
    }

    /**
     * Funcion que retorna el tipo de reunion.
     * @return Tipo de reunion.
     */
    public tipoReunion getTipo(){
        return tipo;
    }

    /**
     * Funcion que retorna la lista de Invitaciones
     * @return Lista de Invitaciones
     */
    public List <Invitacion> getInvitados(){
        return invitaciones;
    }
}

package Clases;

import java.time.Instant;

/**
 * Clase que representa un empleado de una empresa.
 * @author Valeria Quiroga
 * @author Antonio Benavides
 */
public class Empleado implements Invitable{

    private final String id;
    private final String apellidos;
    private final String nombre;
    private final String correo;

    /**
     * Constructor que inicializa los atributos de la clase.
     * @param id Id del empleado.
     * @param apellidos Apellidos del empleado.
     * @param nombre Nombre del empleado.
     * @param correo Correo del empleado.
     */
    public Empleado(String id, String apellidos, String nombre, String correo){
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
    }

    /**
     * Funcion que invita al empleado.
     * @param reunion Reunion a la que se invita al 'Empleado'
     * @return Invitacion del 'Empleado'
     */
    public Invitacion invitar(Reunion reunion){
        return new Invitacion(reunion,this);
    }

    /**
     * Funcion que retorna el id del empleado.
     * @return Id del empleado.
     */
    public String getId(){
        return id;
    }

    /**
     * Funcion que retorna el nombre del empleado.
     * @return Nombre del empleado.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Funcion que retorna los apellidos del empleado.
     * @return Apellidos del empleado.
     */
    public String getApellidos(){
        return apellidos;
    }

    /**
     * Funcion que retorna el correo del empleado.
     * @return Correo del empleado.
     */
    public String getCorreo(){
        return correo;
    }

    /**
     * Funcion que devuelve una descripcion de la clase
     * @return Descripcion de la clase
     */
    @Override
    public String toString() {
        return "'Empleado' representa a un Empleado de un 'Departamento' una Empresa ";
    }

}

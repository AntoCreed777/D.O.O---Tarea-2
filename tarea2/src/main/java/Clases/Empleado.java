package Clases;

/**
 * Clase que representa un empleado de una empresa.
 * @author Valeria Quiroga
 * @author Amtonio Benavides
 */
public class Empleado implements Invitable{

    private String id;
    private String apellidos;
    private String nombre;
    private String correo;

    /**
     * Constructor que establece el id, apellidos, nombre y correo del empleado.
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
     */
    public void invitar(){};  //!!!!FALTA IMPLEMENTAR!!!!//

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

}

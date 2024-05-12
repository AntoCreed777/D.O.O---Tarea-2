package Clases;

/**
 * Clase que representa la asistencia de un Empleado a una reunion
 * @author Antonio Benavides
 */
public class Asistencia {
    private final Empleado empleado;

    /**
     * Constructor que inicializa al Empleado que asiste a la reunion
     * @param empleado Empleado que asiste a la reunion
     */
    public Asistencia(Empleado empleado){
        this.empleado = empleado;
    }

    /**
     * Getter que retorna al Empleado que asistio a la reunion
     * @return  Empleado  que asistio a la reunion
     */
    public Empleado getEmpleado(){
        return empleado;
    }

    /**
     * Funcion que devuelve una descripcion de la clase
     * @return Descripcion de la clase
     */
    @Override
    public String toString() {
        return "Representa la asistencia de un Empleado a una reunion";
    }
}

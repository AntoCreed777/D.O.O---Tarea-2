package Clases;

import java.time.Instant;

/**
 * Clase que representa un retraso de un empleado en una asistencia.
 * @author  Valeria Quiroga
 * @author Antonio Benavides
 */
public class Retraso extends Asistencia {
    private final Instant hora;

    /**
     * Constructor que inicializa los atributos de la clase
     * @param empleado El 'Empleado' que llego tarded a la 'Reunion'
     * @param hora  La hora a la que llego el 'Empleado'
     */

    public Retraso(Empleado empleado, Instant hora) {
        super(empleado);
        this.hora = hora;
    }

    /**
     * Funcion que retorna la hora del retraso.
     * @return Hora del retraso.
     */
    public Instant getHora() {
        return hora;
    }

    /**
     * Funcion que devuelve una descripcion de la clase
     * @return Descripcion de la clase
     */
    @Override
    public String toString() {
        return super.toString() + "si es que llego atrasado";
    }
}

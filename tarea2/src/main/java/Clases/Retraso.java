package Clases;

import java.time.Instant;

/**
 * Clase que representa un retraso de un empleado en una asistencia.
 * @autor Valeria Quiroga
 * @autor Amtonio Benavides
 */
public class Retraso extends Asistencia {
    private Instant hora;

    /**
     * Constructor de la clase Retraso.
     * @param empleado
     * @param hora
     */

    public Retraso(Empleado empleado, Instant hora) {
        super(empleado);
        this.hora = hora;
    }
    
    /**
     * Funcion que establece la hora del retraso.
     * @param hora
     */
    public void setHora(Instant hora) {
        this.hora = hora;
    }

    /**
     * Funcion que retorna la hora del retraso.
     * @return Hora del retraso.
     */
    public Instant getHora() {
        return hora;
    }
}

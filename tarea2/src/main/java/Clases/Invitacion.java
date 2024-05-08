package Clases;

import java.time.Instant;

/**
 * Funcion que representa la invitacion que se le hace a un 'Departamento' o a un 'Empleado'
 * @author Antonio Benavides
 */
public class Invitacion {
    private final Instant hora;
    private final Invitable invitado;

    /**
     * Constructor que inicializa los atributos: a quien se invita y a que hora
     * @param invitado  'Departamento' o 'Empleado' que se invita
     */
    public Invitacion(Invitable invitado){
        this.invitado = invitado;
        this.hora = Instant.now();
    }

    /**
     * Funcion que retorna a quien esta invitado
     * @return Quien este invitado, 'Departamento' o 'Empleado'
     */
    public Invitable getInvitado(){
        return invitado;
    }

    /**
     * Funcion que retorna a que hora fue invitado
     * @return Hora a la que fue invitado
     */
    public Instant getHora(){
        return hora;
    }

    /**
     * Funcion que devuelve una descripcion de la clase
     * @return Descripcion de la clase
     */
    @Override
    public String toString() {
        return "'Invitacion' representa la invitacion que se le hace a un 'Departamento' o a un 'Empleado'";
    }
}

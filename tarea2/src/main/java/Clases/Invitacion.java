package Clases;

import java.time.Instant;

/**
 * Funcion que representa la invitacion que se le hace a un 'Departamento' o a un 'Empleado'
 * @author Antonio Benavides
 */
public class Invitacion {
    private final Instant hora;
    private final Invitable invitado;
    private final Reunion reunion;

    /**
     * Constructor que inicializa los atributos: a que reunion, a quien se invita y a que hora
     * @param reunion 'Reunion' a la que se invita
     * @param invitado  'Departamento' o 'Empleado' que se invita
     */
    public Invitacion(Reunion reunion, Invitable invitado){
        this.reunion = reunion;
        this.invitado = invitado;
        this.hora = reunion.getHoraPrevista();
    }

    /**
     * Funcion que retorna a quien esta invitado
     * @return Quien este invitado, 'Departamento' o 'Empleado'
     */
    public Invitable getInvitado(){return invitado;}

    /**
     * Funcion que retorna a que hora fue invitado
     * @return Hora a la que fue invitado
     */
    public Instant getHora(){
        return hora;
    }

    /**
     * Funcion que retorna la reunion a la que se invito
     * @return Reunion a la que se invito
     */
    public Reunion getReunion(){
        return reunion;
    }

    /**
     * Funcion que devuelve una descripcion de la clase
     * @return Descripcion de la clase
     */
    @Override
    public String toString() {return "Representa la invitacion que se le hace a un 'Departamento' o a un 'Empleado'";}
}

package Clases;

import java.time.Instant;

/**
 * Interface para indicar que una clase se puede invitar
 * @author Valeria Quiroga
 * @author Antonio Benavides
 */
public interface Invitable {
    /**
     * Funcion que permite invitar a la clase que la implemente
     */
    public void invitar(Reunion reunion);
}

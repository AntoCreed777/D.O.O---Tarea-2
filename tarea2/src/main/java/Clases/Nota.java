package Clases;

/**
 * Clase que representa una nota de texto.
 * @author Valeria Quiroga
 * @author Amtonio Benavides
 */
public class Nota {
    private String contenido;

    /**
     * Constructor de la clase Nota Vacio.
     */
    public Nota(){}

    /**
     * Funcion que retorna el contenido de la nota.
     * @return Contenido de la nota.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Funcion que establece el contenido de la nota.
     * @param contenido Contenido de la nota.
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}

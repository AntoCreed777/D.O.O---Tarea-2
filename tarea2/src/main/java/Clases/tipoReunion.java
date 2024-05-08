package Clases;

/**
 * Enumerado que contiene los tipos de reuniones que se pueden realizar.
 * @author Valeria Quiroga
 */
public enum tipoReunion {
    TECNICA("TECNICA"),
    MARKETING("MARKETING"),
    OTRO("OTRO");

    public final String tipo;

    /**
     * Funcion que inicializa el enum
     * @param tipo dato
     */
    tipoReunion(String tipo) {
        this.tipo = tipo;
    }
    /**
     * Funcion que devuelve una descripcion de la Enumeracion
     * @return Descripcion de la Enumeracion
     */
    @Override
    public String toString() {
        return "'Enumeracion' representa a todas las tipos de reuniones que se pueden realizar";
    }
}

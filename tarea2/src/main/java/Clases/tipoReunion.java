package Clases;

/**
 * Enumerado que contiene los tipos de reuniones que se pueden realizar.
 * @author Valeria Quiroga
 */
public enum tipoReunion {
    TECNICA,
    MARKETING,
    OTRO;

    /**
     * Funcion que devuelve una descripcion de la Enumeracion
     * @return Descripcion de la Enumeracion
     */
    @Override
    public String toString() {
        return "'Enumeracion' representa a todas las tipos de reuniones que se pueden realizar";
    }
}

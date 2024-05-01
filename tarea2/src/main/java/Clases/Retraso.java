package Clases;

import java.time.Instant;

public class Retraso extends Asistencia {
    private Instant hora;

    public void setHora(Instant hora) {
        this.hora = hora;
    }

    public Instant getHora() {
        return hora;
    }
}

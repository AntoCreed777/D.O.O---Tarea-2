package Clases;

import java.time.Instant;

public class Invitacion {
    private Instant hora;
    private Invitable invitado;

    public Invitacion(Invitable invitado){
        this.invitado = invitado;
        this.hora = Instant.now();
    }

    public Invitable getInvitado(){
        return invitado;
    }

    public Instant getHora(){
        return hora;
    }
}

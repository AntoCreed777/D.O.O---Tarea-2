import Clases.*;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvitacionTest {

    @Test
    void testGetInvitado() {
        Reunion reunion = new ReunionPresencial("Taller de desarrollo", Instant.now().plus(1, ChronoUnit.HOURS),
                Duration.ofHours(1), "Sala de conferencias");
        Departamento invitado = new Departamento("IT");
        Invitacion invitacion = new Invitacion(reunion, invitado);

        assertEquals(invitado, invitacion.getInvitado());
    }

    @Test
    void testGetHora() {
        Reunion reunion = new Reunion("Taller de desarrollo", Instant.now().plus(1, ChronoUnit.HOURS));
        Departamento invitado = new Departamento("IT");
        Invitacion invitacion = new Invitacion(reunion, invitado);

        assertEquals(reunion.getHoraPrevista(), invitacion.getHora());
    }

    @Test
    void testGetReunion() {
        Reunion reunion = new Reunion("Taller de desarrollo", Instant.now().plus(1, ChronoUnit.HOURS));
        Departamento invitado = new Departamento("IT");
        Invitacion invitacion = new Invitacion(reunion, invitado);

        assertEquals(reunion, invitacion.getReunion());
    }
}
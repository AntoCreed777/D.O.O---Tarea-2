import Clases.*;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvitacionTest {

    @Test
    void testGetInvitado() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);
        String sala = "sala 2";

        Reunion reunion = new ReunionPresencial(empleado, tipoReunion.OTRO, fecha, horaPrevista, duracionPrevista,
                sala);

        Departamento invitado = new Departamento("IT");

        Invitacion invitacion = new Invitacion(reunion, invitado);

        assertEquals(invitado, invitacion.getInvitado());
    }

    @Test
    void testGetHora() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);
        String sala = "sala 2";

        Reunion reunion = new ReunionPresencial(empleado, tipoReunion.OTRO, fecha, horaPrevista, duracionPrevista,
                sala);

        Departamento invitado = new Departamento("IT");
        Invitacion invitacion = new Invitacion(reunion, invitado);

        assertEquals(reunion.getHoraPrevista(), invitacion.getHora());
    }

    @Test
    void testGetReunion() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);
        String sala = "sala 2";

        Reunion reunion = new ReunionPresencial(empleado, tipoReunion.OTRO, fecha, horaPrevista, duracionPrevista,
                sala);

        Departamento invitado = new Departamento("IT");
        Invitacion invitacion = new Invitacion(reunion, invitado);

        assertEquals(reunion, invitacion.getReunion());
    }
}
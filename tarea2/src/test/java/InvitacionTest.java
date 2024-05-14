/**
 * Clase que representa un departamento de una empresa.
 * @author Maria Jose San Martin
 */ 

import Clases.*;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Test unitario que verifica el funcionamiento de la clase Invitacion este correcto.
 */
class InvitacionTest {

    @Test
    void testGetInvitado() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);
        String sala = "sala 2";

        Reunion reunion = new ReunionPresencial(empleado, tipoReunion.OTRO, fecha, horaPrevista, duracionPrevista, sala);

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

        assertEquals(reunion.getHoraPrevista(), invitacion.getHora());    // revisar que la hora prevista de la reunion sea la misma que la hora de la invitacion.
    }

    @Test
    void testGetReunion() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);
        String sala = "sala 2";

        Reunion reunion = new ReunionPresencial(empleado, tipoReunion.OTRO, fecha, horaPrevista, duracionPrevista, sala);

        Departamento invitado = new Departamento("IT");
        Invitacion invitacion = new Invitacion(reunion, invitado);

        assertEquals(reunion, invitacion.getReunion());
    }
}
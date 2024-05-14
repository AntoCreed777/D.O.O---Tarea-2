/**
 * Clase que representa un departamento de una empresa.
 * @author Maria Jose San Martin
 */

import Clases.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/*
 * Test unitario que verifica el funcionamiento de la clase Empleado este correcto.
 */

class EmpleadoTest {

    @Test
    void TestObtenerNombre() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        assertEquals("Valeria", empleado.getNombre());
    }

    @Test
    void TestObtenerApellidos() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        assertEquals("Quiroga", empleado.getApellidos());
    }

    @Test
    void TestObtenerCorreo() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        assertEquals("valeria@example.com", empleado.getCorreo());
    }

    @Test
    void TestInvitarYAdministrarInvitaciones() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");

        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);
        String sala = "sala 2";

        Reunion reunion = new ReunionPresencial(empleado, tipoReunion.OTRO, fecha, horaPrevista, duracionPrevista, sala);

        empleado.invitar(reunion);

        assertEquals(empleado, reunion.getInvitados().get(0).getInvitado());
    }
}
/**
 * Clase que representa un departamento de una empresa.
 * @author Maria Jose San Martin
 */

import Clases.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/*
 * Test unitario que verifica el funcionamiento de la clase Empleado este correcto.
 */

class EmpleadoTest {
    Empleado empleado;

    @BeforeEach
    void setUp() {
        empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");

    }
    @Test
    void TestObtenerNombre() {assertEquals("Valeria", empleado.getNombre());}

    @Test
    void TestObtenerApellidos() {assertEquals("Quiroga", empleado.getApellidos());}

    @Test
    void TestObtenerCorreo() {assertEquals("valeria@example.com", empleado.getCorreo());}

    @Test
    void TestInvitarYAdministrarInvitaciones() {
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);
        String sala = "sala 2";

        Reunion reunion = new ReunionPresencial(empleado, tipoReunion.OTRO, fecha, horaPrevista, duracionPrevista, sala);

        empleado.invitar(reunion);

        assertEquals(empleado, reunion.getInvitados().get(0).getInvitado());
    }

    @Test
    void TestId(){assertEquals("1", empleado.getId());}
}
/**
 * Clase que representa un departamento de una empresa.
 * @author Maria Jose San Martin
 */ 

import Clases.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/*
 * Test unitario que verifica el funcionamiento de la clase Retraso este correcto.
 */
public class RetrasoTest {
    Empleado empleado;
    Instant hora;
    Retraso retraso;

    @BeforeEach
    void setUp() {
        empleado = new Empleado("1", "Apellido", "Nombre", "correo@example.com");
        hora = Instant.now();
        retraso = new Retraso(empleado, hora);
    }
    @Test
    public void testRetrasoConstructor() {
        Assertions.assertNotNull(retraso);
        Assertions.assertEquals(empleado, retraso.getEmpleado());
        Assertions.assertEquals(hora, retraso.getHora());
    }

    @Test
    public void testRetrasoToString() {
        Assertions.assertEquals("Representa la asistencia de un Empleado a una reunion si es que llego atrasado",retraso.toString());
    }
}
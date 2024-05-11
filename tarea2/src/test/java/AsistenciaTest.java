package Clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AsistenciaTest {

    @Test
    void testGetEmpleado() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Asistencia asistencia = new Asistencia(empleado);
        assertEquals(empleado, asistencia.getEmpleado());
    }
}
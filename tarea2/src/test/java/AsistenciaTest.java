import Clases.*;

import org.junit.jupiter.api.Test;
import Clases.Asistencia;
import Clases.Empleado;

import static org.junit.jupiter.api.Assertions.assertSame;

class AsistenciaTest {

    @Test
    void testGetEmpleado() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Asistencia asistencia = new Asistencia(empleado);

        assertSame(empleado, asistencia.getEmpleado());
    }
}
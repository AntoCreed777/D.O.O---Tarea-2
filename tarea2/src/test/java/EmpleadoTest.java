import Clases.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        Reunion reunion = new Reunion("IT", "Taller de desarrollo");
        empleado.invitar(reunion);
        List<Invitacion> invitaciones = empleado.getInvitaciones();
        assertNotNull(invitaciones);
        assertEquals(1, invitaciones.size());
        Invitacion invitacion = invitaciones.get(0);
        assertEquals(reunion, invitacion.getReunion());
        assertEquals(empleado, invitacion.getEmpleado());

        empleado.quitarInvitacion(invitacion);
        assertEquals(0, empleado.getInvitaciones().size());
    }
}
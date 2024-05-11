package Clases;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EmpleadoTest {

    @Test
    void testGetNombre() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        assertEquals("Valeria", empleado.getNombre());
    }

    @Test
    void testGetApellidos() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        assertEquals("Quiroga", empleado.getApellidos());
    }

    @Test
    void testGetEmail() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        assertEquals("valeria@example.com", empleado.getEmail());
    }

    @Test
    void testGetInvitaciones() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Invitacion invitacion = new Invitacion("IT", "Taller de desarrollo");
        empleado.agregarInvitacion(invitacion);
        List<Invitacion> invitaciones = empleado.getInvitaciones();
        assertNotNull(invitaciones);
        assertEquals(1, invitaciones.size());
        assertEquals(invitacion, invitaciones.get(0));
    }

    @Test
    void testAgregarInvitacion() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Invitacion invitacion = new Invitacion("IT", "Taller de desarrollo");
        empleado.agregarInvitacion(invitacion);
        assertNotNull(empleado.getInvitaciones());
        assertEquals(1, empleado.getInvitaciones().size());
    }

    @Test
    void testQuitarInvitacion() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Invitacion invitacion = new Invitacion("IT", "Taller de desarrollo");
        empleado.agregarInvitacion(invitacion);
        empleado.quitarInvitacion(invitacion);
        assertEquals(0, empleado.getInvitaciones().size());
    }
}
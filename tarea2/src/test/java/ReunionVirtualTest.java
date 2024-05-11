package Clases;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReunionVirtualTest {

    @Test
    void testIsInvitable() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado);
        ReunionVirtual reunionVirtual = new ReunionVirtual("Enlace 1", empleados, LocalDateTime.of(2022, 1, 1, 10, 0));
        Invitable invitable = reunionVirtual::isInvitable;
        assertTrue(invitable.isInvitable(empleado));

        empleado = new Empleado("2", "Quiroga", "Juan", "juan@example.com");
        empleados.add(empleado);
        reunionVirtual = new ReunionVirtual("Enlace 1", empleados, LocalDateTime.of(2022, 1, 1, 10, 0));
        invitable = reunionVirtual::isInvitable;
        assertFalse(invitable.isInvitable(empleado));
    }

    @Test
    void testGetFecha() {
        LocalDateTime fecha = LocalDateTime.of(2022, 1, 1, 10, 0);
        ReunionVirtual reunionVirtual = new ReunionVirtual("Enlace 1", new ArrayList<>(), fecha);
        assertEquals(fecha, reunionVirtual.getFecha());
    }

    @Test
    void testSetFecha() {
        LocalDateTime fecha = LocalDateTime.of(2022, 1, 1, 10, 0);
        ReunionVirtual reunionVirtual = new ReunionVirtual();
        reunionVirtual.setFecha(fecha);
        assertEquals(fecha, reunionVirtual.getFecha());
    }

    @Test
    void testGetEnlace() {
        String enlace = "Enlace 1";
        ReunionVirtual reunionVirtual = new ReunionVirtual(enlace, new ArrayList<>(), LocalDateTime.of(2022, 1, 1, 10, 0));
        assertEquals(enlace, reunionVirtual.getEnlace());
    }

    @Test
    void testSetEnlace() {
        String enlace = "Enlace 1";
        ReunionVirtual reunionVirtual = new ReunionVirtual();
        reunionVirtual.setEnlace(enlace);
        assertEquals(enlace, reunionVirtual.getEnlace());
    }

    @Test
    void testGetEmpleados() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado);
        ReunionVirtual reunionVirtual = new ReunionVirtual("Enlace 1", empleados, LocalDateTime.of(2022, 1, 1, 10, 0));
        assertEquals(empleados, reunionVirtual.getEmpleados());
    }

    @Test
    void testSetEmpleados() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado);
        ReunionVirtual reunionVirtual = new ReunionVirtual();
        reunionVirtual.setEmpleados(empleados);
        assertEquals(empleados, reunionVirtual.getEmpleados());
    }
}
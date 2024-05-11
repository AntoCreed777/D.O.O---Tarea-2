package Clases;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReunionPresencialTest {

    @Test
    void testIsInvitable() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado);
        ReunionPresencial reunionPresencial = new ReunionPresencial("Sala 1", empleados, LocalDateTime.of(2022, 1, 1, 10, 0));
        Invitable invitable = reunionPresencial::isInvitable;
        assertTrue(invitable.isInvitable(empleado));

        empleado = new Empleado("2", "Quiroga", "Juan", "juan@example.com");
        empleados.add(empleado);
        reunionPresencial = new ReunionPresencial("Sala 1", empleados, LocalDateTime.of(2022, 1, 1, 10, 0));
        invitable = reunionPresencial::isInvitable;
        assertFalse(invitable.isInvitable(empleado));
    }

    @Test
    void testGetFecha() {
        LocalDateTime fecha = LocalDateTime.of(2022, 1, 1, 10, 0);
        ReunionPresencial reunionPresencial = new ReunionPresencial("Sala 1", new ArrayList<>(), fecha);
        assertEquals(fecha, reunionPresencial.getFecha());
    }

    @Test
    void testSetFecha() {
        LocalDateTime fecha = LocalDateTime.of(2022, 1, 1, 10, 0);
        ReunionPresencial reunionPresencial = new ReunionPresencial();
        reunionPresencial.setFecha(fecha);
        assertEquals(fecha, reunionPresencial.getFecha());
    }

    @Test
    void testGetSala() {
        String sala = "Sala 1";
        ReunionPresencial reunionPresencial = new ReunionPresencial(sala, new ArrayList<>(), LocalDateTime.of(2022, 1, 1, 10, 0));
        assertEquals(sala, reunionPresencial.getSala());
    }

    @Test
    void testSetSala() {
        String sala = "Sala 1";
        ReunionPresencial reunionPresencial = new ReunionPresencial();
        reunionPresencial.setSala(sala);
        assertEquals(sala, reunionPresencial.getSala());
    }

    @Test
    void testGetEmpleados() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado);
        ReunionPresencial reunionPresencial = new ReunionPresencial("Sala 1", empleados, LocalDateTime.of(2022, 1, 1, 10, 0));
        assertEquals(empleados, reunionPresencial.getEmpleados());
    }

    @Test
    void testSetEmpleados() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado);
        ReunionPresencial reunionPresencial = new ReunionPresencial();
        reunionPresencial.setEmpleados(empleados);
        assertEquals(empleados, reunionPresencial.getEmpleados());
    }
}
import Clases.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReunionPresencialTest {

    @Test
    void testInvitadoAReunion() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado);
        ReunionPresencial reunionPresencial = new ReunionPresencial("Sala 1", empleados,
                LocalDateTime.of(2022, 1, 1, 10, 0));
        Invitable invitable = (Invitable) reunionPresencial::isInvitable;
        assertTrue(invitable.isInvitable(empleado));

        Empleado otroEmpleado = new Empleado("2", "Quiroga", "Juan", "juan@example.com");
        empleados.add(otroEmpleado);
        reunionPresencial = new ReunionPresencial("Sala 1", empleados, LocalDateTime.of(2022, 1, 1, 10, 0));
        invitable = (Invitable) reunionPresencial::isInvitable;
        assertFalse(invitable.isInvitable(otroEmpleado));
    }

    @Test
    void testObtenerFecha() {
        LocalDateTime fecha = LocalDateTime.of(2022, 1, 1, 10, 0);
        ReunionPresencial reunionPresencial = new ReunionPresencial("Sala 1", new ArrayList<>(), fecha);
        assertEquals(fecha, reunionPresencial.getFecha());
    }

    @Test
    void testEstablecerFecha() {
        LocalDateTime fecha = LocalDateTime.of(2022, 1, 1, 10, 0);
        ReunionPresencial reunionPresencial = new ReunionPresencial();
        reunionPresencial.setFecha(fecha);
        assertEquals(fecha, reunionPresencial.getFecha());
    }

    @Test
    void testObtenerSala() {
        String sala = "Sala 1";
        ReunionPresencial reunionPresencial = new ReunionPresencial(sala, new ArrayList<>(),
                LocalDateTime.of(2022, 1, 1, 10, 0));
        assertEquals(sala, reunionPresencial.getSala());
    }

    @Test
    void testEstablecerSala() {
        String sala = "Sala 1";
        ReunionPresencial reunionPresencial = new ReunionPresencial();
        reunionPresencial.setSala(sala);
        assertEquals(sala, reunionPresencial.getSala());
    }

    @Test
    void testObtenerEmpleados() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado);
        ReunionPresencial reunionPresencial = new ReunionPresencial("Sala 1", empleados,
                LocalDateTime.of(2022, 1, 1, 10, 0));
        assertEquals(empleados, reunionPresencial.getEmpleados());
    }

    @Test
    void testEstablecerEmpleados() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado);
        ReunionPresencial reunionPresencial = new ReunionPresencial();
        reunionPresencial.setEmpleados(empleados);
        assertEquals(empleados, reunionPresencial.getEmpleados());
    }
}
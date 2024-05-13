import Clases.*;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReunionVirtualTest {

    @Test
    void testEsInvitable() {
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(1);
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado);
        ReunionVirtual reunionVirtual = new ReunionVirtual(empleado, ReunionVirtual.tipoReunion.REUNION_ORDINARIA,
                "Enlace 1", empleados, LocalDateTime.of(2022, 1, 1, 10, 0));
        Invitable invitable = reunionVirtual::isInvitable;
        assertTrue(invitable.isInvitable(empleado));

        empleado = new Empleado("2", "Quiroga", "Juan", "juan@example.com");
        empleados.add(empleado);
        reunionVirtual = new ReunionVirtual(empleado, ReunionVirtual.tipoReunion.REUNION_ORDINARIA, "Enlace 1",
                empleados, LocalDateTime.of(2022, 1, 1, 10, 0));
        invitable = reunionVirtual::isInvitable;
        assertFalse(invitable.isInvitable(empleado));
    }

    @Test
    void testGetFechaCorrecta() {
        LocalDateTime fecha = LocalDateTime.of(2022, 1, 1, 10, 0);
        ReunionVirtual reunionVirtual = new ReunionVirtual("Enlace 1", new ArrayList<>(), fecha);
        assertEquals(fecha, reunionVirtual.getFecha());
    }

    @Test
    void testGetEnlaceCorrecto() {
        String enlace = "Enlace 1";
        ReunionVirtual reunionVirtual = new ReunionVirtual(
                new Empleado("1", "Quiroga", "Valeria", "valeria@example.com"),
                ReunionVirtual.tipoReunion.REUNION_ORDINARIA, enlace, new ArrayList<>(),
                LocalDateTime.of(2022, 1, 1, 10, 0));
        assertEquals(enlace, reunionVirtual.getEnlace());
    }

    @Test
    void testSetEnlaceCorrecto() {
        String enlace = "Enlace 1";
        ReunionVirtual reunionVirtual = new ReunionVirtual();
        reunionVirtual.setEnlace(enlace);
        assertEquals(enlace, reunionVirtual.getEnlace());
    }

    @Test
    void testGetEmpleadosCorrectos() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado);
        ReunionVirtual reunionVirtual = new ReunionVirtual("Enlace 1", empleados, LocalDateTime.of(2022, 1, 1, 10, 0));
        assertEquals(empleados, reunionVirtual.getEmpleados());
    }

    @Test
    void testSetEmpleadosCorrectos() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado);
        ReunionVirtual reunionVirtual = new ReunionVirtual();
        reunionVirtual.setEmpleados(empleados);
        assertEquals(empleados, reunionVirtual.getEmpleados());
    }
}
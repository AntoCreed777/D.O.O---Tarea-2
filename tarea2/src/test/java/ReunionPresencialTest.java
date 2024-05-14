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

class ReunionPresencialTest {

    @Test
    void testInvitadoAReunion() {
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(1);
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado);
        String sala = "sala 2";
        Reunion reunion = new ReunionPresencial(empleado, tipoReunion.OTRO, fecha, horaPrevista, duracionPrevista,sala);
         List<Empleado> empleadosReunion = new ArrayList<>();
         empleadosReunion.add(empleado);
         assertTrue(empleadosReunion.contains(empleado));
         Empleado otroEmpleado = new Empleado("2", "Quiroga", "Juan", "juan@example.com");
         assertFalse(empleadosReunion.contains(otroEmpleado));
    }

    @Test
    void testObtenerFecha() {
        Date fecha = new Date();
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);
        String sala = "sala 2";
        Reunion reunionPresencial = new ReunionPresencial(empleado, tipoReunion.OTRO, fecha, horaPrevista, duracionPrevista, sala);
        assertEquals(fecha, reunionPresencial.getFecha());
    }

    @Test
    void testObtenerSala() {
        String sala = "Sala 1";
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);
        ReunionPresencial reunionPresencial = new ReunionPresencial(empleado, tipoReunion.OTRO, fecha, horaPrevista,
                duracionPrevista, sala);
        assertEquals(sala, reunionPresencial.getSala());
    }

    @Test
    void testObtenerEmpleados() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        List<Empleado> empleados = new ArrayList<>();
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);
        String sala = "sala 2";
        Reunion reunionPresencial = new ReunionPresencial(empleado, tipoReunion.OTRO, fecha, horaPrevista,duracionPrevista, sala);
        assertTrue(reunionPresencial.getAsistentes().contains(empleado));
    }

}
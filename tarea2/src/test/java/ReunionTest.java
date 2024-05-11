package Clases;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReunionTest {

    @Test
    void testGetOrganizador() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Reunion reunion = new Reunion(organizador, tipoReunion.TECNICA, new Date(), Instant.now(), Duration.ofMinutes(60));
        assertEquals(organizador, reunion.getOrganizador());
    }

    @Test
    void testGetTipo() {
        Reunion reunion = new Reunion(new Empleado("1", "Quiroga", "Valeria", "valeria@example.com"), tipoReunion.TECNICA, new Date(), Instant.now(), Duration.ofMinutes(60));
        assertEquals(tipoReunion.TECNICA, reunion.getTipo());
    }

    @Test
    void testGetFecha() {
        Reunion reunion = new Reunion(new Empleado("1", "Quiroga", "Valeria", "valeria@example.com"), tipoReunion.TECNICA, new Date(), Instant.now(), Duration.ofMinutes(60));
        assertEquals(new Date(), reunion.getFecha());
    }

    @Test
    void testGetHoraInicio() {
        Instant horaInicio = Instant.now();
        Reunion reunion = new Reunion(new Empleado("1", "Quiroga", "Valeria", "valeria@example.com"), tipoReunion.TECNICA, new Date(), horaInicio, Duration.ofMinutes(60));
        assertEquals(horaInicio, reunion.getHoraInicio());
    }

    @Test
    void testGetDuracion() {
        Duration duracion = Duration.ofMinutes(60);
        Reunion reunion = new Reunion(new Empleado("1", "Quiroga", "Valeria", "valeria@example.com"), tipoReunion.TECNICA, new Date(), Instant.now(), duracion);
        assertEquals(duracion, reunion.getDuracion());
    }

    @Test
    void testGetAsistencias() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Reunion reunion = new Reunion(organizador, tipoReunion.TECNICA, new Date(), Instant.now(), Duration.ofMinutes(60));
        Empleado empleado1 = new Empleado("2", "Benavides", "Antonio", "antonio@example.com");
        Empleado empleado2 = new Empleado("3", "Gomez", "Juan", "juan@example.com");
        reunion.agregarAsistencia(new Asistencia(empleado1));
        reunion.agregarAsistencia(new Asistencia(empleado2));
        List<Asistencia> asistencias = reunion.getAsistencias();
        assertEquals(2, asistencias.size());
        assertEquals(empleado1, asistencias.get(0).getEmpleado());
        assertEquals(empleado2, asistencias.get(1).getEmpleado());
    }

    @Test
    void testAgregarAsistencia() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Reunion reunion = new Reunion(organizador, tipoReunion.TECNICA, new Date(), Instant.now(), Duration.ofMinutes(60));
        Empleado empleado = new Empleado("2", "Benavides", "Antonio", "antonio@example.com");
        reunion.agregarAsistencia(new Asistencia(empleado));
        assertNotNull(reunion.getAsistencias());
        assertEquals(1, reunion.getAsistencias().size());
    }

    @Test
    void testQuitarAsistencia() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Reunion reunion = new Reunion(organizador, tipoReunion.TECNICA, new Date(), Instant.now(), Duration.ofMinutes(60));
        Empleado empleado = new Empleado("2", "Benavides", "Antonio", "antonio@example.com");
        reunion.agregarAsistencia(new Asistencia(empleado));
        reunion.quitarAsistencia(new Asistencia(empleado));
        assertEquals(0, reunion.getAsistencias().size());
    }

    @Test
    void testObtenerAsistencias() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Reunion reunion = new Reunion(organizador, tipoReunion.TECNICA, new Date(), Instant.now(), Duration.ofMinutes(60));
        Empleado empleado1 = new Empleado("2", "Benavides", "Antonio", "antonio@example.com");
        Empleado empleado2 = new Empleado("3", "Gomez", "Juan", "juan@example.com");
        reunion.agregarAsistencia(new Asistencia(empleado1));
        reunion.agregarAsistencia(new Asistencia(empleado2));
        List<Asistencia> asistencias = reunion.obtenerAsistencias();
        assertEquals(2, asistencias.size());
        assertEquals(empleado1, asistencias.get(0).getEmpleado());
        assertEquals(empleado2, asistencias.get(1).getEmpleado());
    }

    @Test
    void testObtenerAusencias() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Reunion reunion = new Reunion(organizador, tipoReunion.TECNICA, new Date(), Instant.now(), Duration.ofMinutes(60));
        Empleado empleado1 = new Empleado("2", "Benavides", "Antonio", "antonio@example.com");
        Empleado empleado2 = new Empleado("3", "Gomez", "Juan", "juan@example.com");
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado1);
        empleados.add(empleado2);
        reunion.setEmpleados(empleados);
        List<Empleado> ausencias = reunion.obtenerAusencias();
        assertEquals(0, ausencias.size());
    }

    @Test
    void testObtenerRetrasos() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Reunion reunion = new Reunion(organizador, tipoReunion.TECNICA, new Date(), Instant.now(), Duration.ofMinutes(60));
        Empleado empleado1 = new Empleado("2", "Benavides", "Antonio", "antonio@example.com");
        Empleado empleado2 = new Empleado("3", "Gomez", "Juan", "juan@example.com");
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado1);
        empleados.add(empleado2);
        reunion.setEmpleados(empleados);
        List<Empleado> retrasos = reunion.obtenerRetrasos();
        assertEquals(0, retrasos.size());
    }
}
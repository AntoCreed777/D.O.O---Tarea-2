import Clases.*;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReunionTest {

    @Test
    void testGetOrganizador() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Departamento departamento = new Departamento("IT");
        departamento.agregarEmpleado(organizador);
        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";
        Reunion reunion = new ReunionPresencial(organizador, tipoReunion.TECNICA, fecha, Instant.now(),
                duracionPrevista, sala);
        assertEquals(organizador, reunion.getOrganizador());
    }

    @Test
    void testGetTipo() {
        Departamento departamento = new Departamento("IT");
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        departamento.agregarEmpleado(empleado);
        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";
        Reunion reunion = new ReunionPresencial(empleado, tipoReunion.TECNICA, fecha, Instant.now(), duracionPrevista,
                sala);
        assertEquals(tipoReunion.TECNICA, reunion.getTipo());
    }

    @Test
    void testGetFecha() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Departamento departamento = new Departamento("IT");
        departamento.agregarEmpleado(organizador);
        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";
        Reunion reunion = new ReunionPresencial(organizador, tipoReunion.TECNICA, fecha, Instant.now(),
                duracionPrevista, sala);
        assertEquals(new Date(), reunion.getFecha());
    }

    @Test
    void testGetHoraInicio() {
        Instant horaInicio = Instant.now();
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Departamento departamento = new Departamento("IT");
        departamento.agregarEmpleado(organizador);
        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";
        Reunion reunion = new ReunionPresencial(organizador, tipoReunion.TECNICA, fecha, Instant.now(),
                duracionPrevista, sala);
        Instant horaActual = Instant.now();
        long diferenciaSegundos = Math.abs(horaInicio.getEpochSecond() - horaActual.getEpochSecond());
        assertTrue(diferenciaSegundos < 60);
    }

    @Test
    void testGetDuracion() {
        Duration duracion = Duration.ofMinutes(60);
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Departamento departamento = new Departamento("IT");
        departamento.agregarEmpleado(organizador);
        Date fecha = new Date();
        String sala = "sala 2";
        Reunion reunion = new ReunionPresencial(organizador, tipoReunion.TECNICA, fecha, Instant.now(), duracion, sala);
        assertEquals(duracion, reunion.getDuracionPrevista());
    }

    @Test
    void testAgregarInvitado() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Departamento departamento = new Departamento("IT");
        departamento.agregarEmpleado(organizador);
        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";
        Reunion reunion = new ReunionPresencial(organizador, tipoReunion.TECNICA, fecha, Instant.now(),
                duracionPrevista, sala);
        Empleado empleado = new Empleado("2", "Benavides", "Antonio", "antonio@example.com");
        Invitacion invitacionOrganizador = new Invitacion(organizador);

        assertNotNull(invitacionOrganizador);
    }

    @Test
    void testObtenerAsistencias() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";
        Reunion reunion = new ReunionPresencial(organizador, tipoReunion.TECNICA, fecha, Instant.now(),
                duracionPrevista, sala);
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
        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";
        Reunion reunion = new ReunionPresencial(organizador, tipoReunion.TECNICA, fecha, Instant.now(),
                duracionPrevista, sala);
        Empleado empleado1 = new Empleado("2", "Benavides", "Antonio", "antonio@example.com");
        Empleado empleado2 = new Empleado("3", "Gomez", "Juan", "juan@example.com");
        List<Invitacion> invitaciones = new ArrayList<>();
        invitaciones.add(new Invitacion(empleado1));
        invitaciones.add(new Invitacion(empleado2));
        reunion.setInvitaciones(invitaciones);
        List<Empleado> ausencias = reunion.obtenerAusencias();
        assertEquals(0, ausencias.size());
    }

    @Test
    void testObtenerRetrasos() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";
        Reunion reunion = new ReunionPresencial(organizador, tipoReunion.TECNICA, fecha, Instant.now(),
                duracionPrevista, sala);
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
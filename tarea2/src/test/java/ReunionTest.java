/**
 * Clase que representa un departamento de una empresa.
 * @author Maria Jose San Martin
 */ 

import Clases.*;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * Test unitario que verifica el funcionamiento de la clase Reunion este correcto.
 */
class ReunionTest {

    @Test
    void testGetOrganizador() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");

        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";

        Reunion reunion = new ReunionPresencial(organizador, tipoReunion.TECNICA, fecha, Instant.now(), duracionPrevista, sala);

        assertEquals(organizador, reunion.getOrganizador());
    }

    @Test
    void testGetTipo() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");

        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";

        Reunion reunion = new ReunionPresencial(empleado, tipoReunion.TECNICA, fecha, Instant.now(), duracionPrevista, sala);

        assertEquals(tipoReunion.TECNICA, reunion.getTipo());
    }

    @Test
    void testGetFecha() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");

        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";

        Reunion reunion = new ReunionPresencial(organizador, tipoReunion.TECNICA, fecha, Instant.now(), duracionPrevista, sala);

        assertEquals(fecha, reunion.getFecha());
    }

    @Test
    void testGetHoraInicio() {
        Instant horaPrevista = Instant.now();
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");

        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";

        Reunion reunion = new ReunionPresencial(organizador, tipoReunion.TECNICA, fecha, horaPrevista, duracionPrevista, sala);

        assertEquals(horaPrevista, reunion.getHoraPrevista());

        reunion.iniciar(null);

        long diferenciaSegundos = Math.abs(reunion.getHorarioInicio().getEpochSecond() - Instant.now().getEpochSecond());
        assertTrue(diferenciaSegundos < 1);
    }

    @Test
    void testGetDuracion() {
        Duration duracion = Duration.ofMinutes(60);
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");

        Date fecha = new Date();
        String sala = "sala 2";
        Reunion reunion = new ReunionPresencial(organizador, tipoReunion.TECNICA, fecha, Instant.now(), duracion, sala);
        assertEquals(duracion, reunion.getDuracionPrevista());
    }

    @Test
    void testObtenerAsistencias() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";

        Reunion reunion = new ReunionPresencial(organizador, tipoReunion.TECNICA, fecha, Instant.now(), duracionPrevista, sala);

        Empleado empleado1 = new Empleado("2", "Benavides", "Antonio", "antonio@example.com");
        Empleado empleado2 = new Empleado("3", "Gomez", "Juan", "juan@example.com");

        List<Asistencia> asistencias = new ArrayList<>();

        asistencias.add(new Asistencia(empleado1));
        asistencias.add(new Asistencia(empleado2));

        reunion.iniciar(asistencias);

        List<Asistencia> asistenciasObtenidas = reunion.obtenerAsistencias();

        assertEquals(2, asistenciasObtenidas.size());
        assertEquals(empleado1, asistenciasObtenidas.get(0).getEmpleado());
        assertEquals(empleado2, asistenciasObtenidas.get(1).getEmpleado());
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

        empleado1.invitar(reunion);
        empleado2.invitar(reunion);

        List<Asistencia> asistencias = new ArrayList<>();
        asistencias.add(new Asistencia(empleado1));

        reunion.iniciar(asistencias);

        List<Empleado> ausencias = reunion.obtenerAusencias();

        assertEquals(1, ausencias.size());
        assertEquals(empleado2, ausencias.get(0));
    }

    @Test
    void testObtenerRetrasos() { //FALTA CONFIRMAR CUANDO SE AGREGA AL RETRASO
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";

        Reunion reunion = new ReunionPresencial(organizador, tipoReunion.TECNICA, fecha, Instant.now(),
                duracionPrevista, sala);

        Empleado empleado1 = new Empleado("2", "Benavides", "Antonio", "antonio@example.com");
        Empleado empleado2 = new Empleado("3", "Gomez", "Juan", "juan@example.com");

        List<Asistencia> asistencias = new ArrayList<>();

        asistencias.add(new Asistencia(empleado1));

        reunion.iniciar(asistencias);

        List<Asistencia> retrasos = reunion.obtenerRetrasos();
        assertEquals(0, retrasos.size());

        reunion.agregarRetrasado(empleado2);

        retrasos = reunion.obtenerRetrasos();
        assertEquals(1, retrasos.size());
        assertEquals(empleado2, retrasos.get(0).getEmpleado());
    }

    @Test
    void testObtenerTotalAsistencia() { //FALTA CONFIRMAR CUANDO SE AGREGA AL RETRASO
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";

        Reunion reunion = new ReunionPresencial(organizador, tipoReunion.TECNICA, fecha, Instant.now(), duracionPrevista, sala);

        Empleado empleado1 = new Empleado("2", "Benavides", "Antonio", "antonio@example.com");
        Empleado empleado2 = new Empleado("3", "Gomez", "Juan", "juan@example.com");

        List<Asistencia> asistencias = new ArrayList<>();

        asistencias.add(new Asistencia(empleado1));
        asistencias.add(new Asistencia(empleado2));

        reunion.iniciar(asistencias);

        List<Asistencia> asistenciasObtenidas = reunion.obtenerAsistencias();

        assertEquals(asistenciasObtenidas.size(), reunion.obtenerTotalAsistencia());
    }

}
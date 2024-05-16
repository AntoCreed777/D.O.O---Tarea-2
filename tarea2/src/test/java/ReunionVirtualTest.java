/**
 * Clase que representa un departamento de una empresa.
 * @author Maria Jose San Martin
 */


import Clases.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * Test unitario que verifica el funcionamiento de la clase ReunionVirtual este correcto.
 */
class ReunionVirtualTest {
    Date fecha;
    Instant horaPrevista;
    Duration duracionPrevista;
    Empleado organizador;
    String sala;
    ReunionVirtual reunion;

    @BeforeEach
    void setUp() {
        fecha = new Date();
        horaPrevista = Instant.now();
        duracionPrevista = Duration.ofHours(1);
        organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        sala = "sala 2";

        reunion = new ReunionVirtual(organizador, tipoReunion.OTRO, fecha, horaPrevista, duracionPrevista,
                sala);
    }

    @Test
    void testInvitadoAReunion() {
        organizador.invitar(reunion);

        boolean aux = false;
        for (Invitacion invitado : reunion.getInvitados()) {
            if (invitado.getInvitado().equals(organizador)) {
                aux = true;
                break;
            }
        }

        Assertions.assertTrue(aux); //Se comprueba que el empleado este en la lista ded Invitados

        Empleado otroEmpleado = new Empleado("2", "Quiroga", "Juan", "juan@example.com");

        aux = false;
        for (Invitacion invitado : reunion.getInvitados()) {
            if (invitado.getInvitado().equals(otroEmpleado)) {
                aux = true;
                break;
            }
        }

        Assertions.assertFalse(aux); //Se comprueba que el empleado este en la lista ded Invitados
    }

    @Test
    void testObtenerEnlace() {Assertions.assertEquals(sala, reunion.getEnlace());}

    @Test
    void testGetOrganizador() {assertEquals(organizador, reunion.getOrganizador());}

    @Test
    void testGetTipo() {assertEquals(tipoReunion.OTRO, reunion.getTipo());}

    @Test
    void testGetFecha() {assertEquals(fecha, reunion.getFecha());}

    @Test
    void testGetHorarios() {
        assertEquals(horaPrevista, reunion.getHoraPrevista());

        reunion.iniciar();

        long diferenciaSegundos = Math.abs(reunion.getHorarioInicio().getEpochSecond() - Instant.now().getEpochSecond());
        assertTrue(diferenciaSegundos < 1);

        reunion.finalizar();

        diferenciaSegundos = Math.abs(reunion.getHorarioFin().getEpochSecond() - Instant.now().getEpochSecond());
        assertTrue(diferenciaSegundos < 1);
    }

    @Test
    void testGetDuracion() {assertEquals(duracionPrevista, reunion.getDuracionPrevista());}

    @Test
    void testAsistencias() {
        Empleado empleado1 = new Empleado("2", "Benavides", "Antonio", "antonio@example.com");
        Empleado empleado2 = new Empleado("3", "Gomez", "Juan", "juan@example.com");

        reunion.marcarAsistencia(empleado1);
        reunion.marcarAsistencia(empleado2);

        reunion.iniciar();

        List<Asistencia> asistenciasObtenidas = reunion.obtenerAsistencias();

        assertEquals(2, asistenciasObtenidas.size());
        assertEquals(asistenciasObtenidas.size(), reunion.obtenerTotalAsistencia());
        assertEquals(empleado1, asistenciasObtenidas.get(0).getEmpleado());
        assertEquals(empleado2, asistenciasObtenidas.get(1).getEmpleado());
    }

    @Test
    void testObtenerAusencias() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";

        Reunion reunion = new ReunionVirtual(organizador, tipoReunion.TECNICA, fecha, Instant.now(),
                duracionPrevista, sala);

        Empleado empleado1 = new Empleado("2", "Benavides", "Antonio", "antonio@example.com");
        Empleado empleado2 = new Empleado("3", "Gomez", "Juan", "juan@example.com");

        empleado1.invitar(reunion);
        empleado2.invitar(reunion);

        reunion.marcarAsistencia(empleado1);

        reunion.iniciar();

        List<Empleado> ausencias = reunion.obtenerAusencias();

        assertEquals(1, ausencias.size());
        assertEquals(empleado2, ausencias.get(0));
    }

    @Test
    void testRetrasos() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";

        Reunion reunion = new ReunionVirtual(organizador, tipoReunion.TECNICA, fecha, Instant.now(),
                duracionPrevista, sala);

        Empleado empleado1 = new Empleado("2", "Benavides", "Antonio", "antonio@example.com");
        Empleado empleado2 = new Empleado("3", "Gomez", "Juan", "juan@example.com");

        reunion.marcarAsistencia(empleado1);

        reunion.iniciar();

        List<Asistencia> retrasos = reunion.obtenerRetrasos();
        assertEquals(0, retrasos.size());

        reunion.marcarAsistencia(empleado2);

        retrasos = reunion.obtenerRetrasos();
        assertEquals(1, retrasos.size());
        assertEquals(empleado2, retrasos.get(0).getEmpleado());
    }

    @Test
    void testToString() {assertEquals("Representa una reunion de una empresa de forma virtual", reunion.toString());}

    @Test
    void testAgregarNota() {
        Nota nota1 = new Nota("Nota numero 1");
        reunion.agregarNota(nota1);
        assertEquals(1, reunion.getNotas().size());
    }

    @Test
    void testGetNotas() {
        Nota nota1 = new Nota("Nota numero 1");
        reunion.agregarNota(nota1);
        assertEquals(nota1, reunion.getNotas().get(0));
    }

    @Test
    void testCalcularTiempoReal() {
        reunion.iniciar();
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        reunion.finalizar();
        assertEquals(2, reunion.calcularTiempoReal());
    }

    @Test
    void testObtenerPorcentajeAsistencia() {
        Empleado empleado1 = new Empleado("2", "Juan", "Antonio", "antonio@example.com");
        Empleado empleado2 = new Empleado("3", "Gomez", "Juan", "juan@example.com");
        Empleado empleado3 = new Empleado("4", "Juan", "Antonio", "antonio@example.com");

        empleado1.invitar(reunion);
        empleado2.invitar(reunion);
        empleado3.invitar(reunion);

        reunion.marcarAsistencia(empleado1);

        reunion.iniciar();

        assertEquals(33, (int) reunion.obtenerPorcentajeAsistencia()); //PORCENTAJE

        reunion.marcarAsistencia(empleado2);

        assertEquals(66, (int) reunion.obtenerPorcentajeAsistencia()); //PORCENTAJE
    }
}
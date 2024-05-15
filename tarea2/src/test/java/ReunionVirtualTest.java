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

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * Test unitario que verifica el funcionamiento de la clase ReunionVirtual este correcto.
 */

class ReunionVirtualTest {

    @Test
    void testInvitadoAReunion() {  //ESTA MUY RARO
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(1);
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        String enlace = "enlace 2";

        Reunion reunion = new ReunionVirtual(empleado, tipoReunion.OTRO, fecha, horaPrevista, duracionPrevista,
                enlace);

        empleado.invitar(reunion);

        boolean aux = false;
        for (Invitacion invitado: reunion.getInvitados()){
            if(invitado.getInvitado().equals(empleado)){
                aux = true;
                break;
            }
        }

        assertTrue(aux); //Se comprueba que el empleado este en la lista ded Invitados

        Empleado otroEmpleado = new Empleado("2", "Quiroga", "Juan", "juan@example.com");

        aux = false;
        for (Invitacion invitado: reunion.getInvitados()){
            if(invitado.getInvitado().equals(otroEmpleado)){
                aux = true;break;
            }
        }

        Assertions.assertFalse(aux); //Se comprueba que el empleado este en la lista ded Invitados
    }

    @Test
    void testObtenerEnlace() {
        String enlace = "Enlace 1";
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);

        ReunionVirtual reunionVirtual = new ReunionVirtual(empleado, tipoReunion.OTRO, fecha, horaPrevista,
                duracionPrevista, enlace);

        Assertions.assertEquals(enlace, reunionVirtual.getEnlace());
    }

    @Test
    void testGetOrganizador() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");

        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";

        Reunion reunion = new ReunionVirtual(organizador, tipoReunion.TECNICA, fecha, Instant.now(),
                duracionPrevista, sala);

        assertEquals(organizador, reunion.getOrganizador());
    }

    @Test
    void testGetTipo() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");

        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";

        Reunion reunion = new ReunionVirtual(empleado, tipoReunion.TECNICA, fecha, Instant.now(), duracionPrevista,
                sala);

        assertEquals(tipoReunion.TECNICA, reunion.getTipo());
    }

    @Test
    void testGetFecha() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");

        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";

        Reunion reunion = new ReunionVirtual(organizador, tipoReunion.TECNICA, fecha, Instant.now(),
                duracionPrevista, sala);

        assertEquals(fecha, reunion.getFecha());
    }

    @Test
    void testGetHorarios() {
        Instant horaPrevista = Instant.now();
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");

        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";

        Reunion reunion = new ReunionVirtual(organizador, tipoReunion.TECNICA, fecha, Instant.now(),
                duracionPrevista, sala);

        assertEquals(horaPrevista, reunion.getHoraPrevista());

        reunion.iniciar(null);

        long diferenciaSegundos = Math.abs(reunion.getHorarioInicio().getEpochSecond() - Instant.now().getEpochSecond());
        assertTrue(diferenciaSegundos < 1);

        reunion.finalizar();

        diferenciaSegundos = Math.abs(reunion.getHorarioFin().getEpochSecond() - Instant.now().getEpochSecond());
        assertTrue(diferenciaSegundos < 1);
    }

    @Test
    void testGetDuracion() {
        Duration duracion = Duration.ofMinutes(60);
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");

        Date fecha = new Date();
        String sala = "sala 2";
        Reunion reunion = new ReunionVirtual(organizador, tipoReunion.TECNICA, fecha, Instant.now(), duracion, sala);
        assertEquals(duracion, reunion.getDuracionPrevista());
    }

    @Test
    void testAsistencias() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";

        Reunion reunion = new ReunionVirtual(organizador, tipoReunion.TECNICA, fecha, Instant.now(),
                duracionPrevista, sala);

        Empleado empleado1 = new Empleado("2", "Benavides", "Antonio", "antonio@example.com");
        Empleado empleado2 = new Empleado("3", "Gomez", "Juan", "juan@example.com");

        List<Asistencia> asistencias = new ArrayList<>();
        asistencias.add(new Asistencia(empleado1));
        asistencias.add(new Asistencia(empleado2));

        reunion.iniciar(asistencias);

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

        List<Asistencia> asistencias = new ArrayList<>();
        asistencias.add(new Asistencia(empleado1));

        reunion.iniciar(asistencias);

        List<Empleado> ausencias = reunion.obtenerAusencias();

        assertEquals(1, ausencias.size());
        assertEquals(empleado2, ausencias.get(0));
    }

    @Test
    void testObtenerRetrasos() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";

        Reunion reunion = new ReunionVirtual(organizador, tipoReunion.TECNICA, fecha, Instant.now(),
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
    void testToString(){
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";

        ReunionVirtual reunion = new ReunionVirtual(organizador, tipoReunion.TECNICA, fecha, Instant.now(),
                duracionPrevista, sala);

        assertEquals("Representa una reunion de una empresa de forma virtual",reunion.toString());
    }

    @Test
    void testAgregarNota() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";

        Reunion reunion = new ReunionVirtual(organizador, tipoReunion.TECNICA, fecha, Instant.now(),
                duracionPrevista, sala);

        Nota nota1 = new Nota("Nota numero 1");

        reunion.agregarNota(nota1);
        assertEquals(1, reunion.getNotas().size());
    }

    @Test
    void testGetNotas() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";

        Reunion reunion = new ReunionVirtual(organizador, tipoReunion.TECNICA, fecha, Instant.now(),
                duracionPrevista, sala);

        Nota nota1 = new Nota("Nota numero 1");

        reunion.agregarNota(nota1);

        assertEquals(nota1, reunion.getNotas().get(0));
    }

    @Test
    void testCalcularTiempoReal() {
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";

        Reunion reunion = new ReunionVirtual(organizador, tipoReunion.TECNICA, fecha, Instant.now(),
                duracionPrevista, sala);

        reunion.iniciar(null);

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
        Empleado organizador = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Duration duracionPrevista = Duration.ofMinutes(60);
        String sala = "sala 2";

        Reunion reunion = new ReunionVirtual(organizador, tipoReunion.TECNICA, fecha, Instant.now(),
                duracionPrevista, sala);

        Empleado empleado1 = new Empleado("2", "Juan", "Antonio", "antonio@example.com");
        Empleado empleado2 = new Empleado("3", "Gomez", "Juan", "juan@example.com");
        Empleado empleado3 = new Empleado("4", "Juan", "Antonio", "antonio@example.com");

        empleado1.invitar(reunion);
        empleado2.invitar(reunion);
        empleado3.invitar(reunion);

        List<Asistencia> asistencias = new ArrayList<Asistencia>();
        asistencias.add(new Asistencia(empleado1));

        reunion.iniciar(asistencias);

        assertEquals(33, (int) reunion.obtenerPorcentajeAsistencia()); //PORCENTAJE

        reunion.agregarRetrasado(empleado2);

        assertEquals(66, (int) reunion.obtenerPorcentajeAsistencia()); //PORCENTAJE
    }
}
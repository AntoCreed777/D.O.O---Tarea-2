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

        Assertions.assertEquals(true,aux); //Se comprueba que el empleado este en la lista ded Invitados

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
    void testObtenerFecha() {
        Date fecha = new Date();
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);
        String enlace = "enlace 2";

        Reunion reunionVirtual = new ReunionVirtual(empleado, tipoReunion.OTRO, fecha, horaPrevista,
                duracionPrevista, enlace);

        Assertions.assertEquals(fecha, reunionVirtual.getFecha());
    }

    @Test
    void testObtenerenlace() {
        String enlace = "enlace 1";
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);

        ReunionVirtual reunionVirtual = new ReunionVirtual(empleado, tipoReunion.OTRO, fecha, horaPrevista,
                duracionPrevista, enlace);

        Assertions.assertEquals(enlace, reunionVirtual.getEnlace());
    }

    @Test
    void testObtenerAsistencias() { //QUE TIPO DE EMPLEADOS, ASISTENCIA, RETRASOS o AUSENCIAS
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);
        String enlace = "enlace 2";

        Reunion reunionVirtual = new ReunionVirtual(empleado, tipoReunion.OTRO, fecha, horaPrevista,
                duracionPrevista, enlace);

        Empleado empleado1 = new Empleado("2", "Quiroga", "Valeria", "valeria@example.com");

        List<Asistencia> asistencias= new ArrayList<Asistencia>();
        asistencias.add(new Asistencia(empleado1));

        reunionVirtual.iniciar(asistencias);

        boolean empleadoEncontrado = false;

        for (Asistencia asistencia : reunionVirtual.obtenerAsistencias()) {
            if (asistencia.getEmpleado().equals(empleado1)) {
                empleadoEncontrado = true;
                break;
            }
        }

        Assertions.assertTrue(empleadoEncontrado);
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

}
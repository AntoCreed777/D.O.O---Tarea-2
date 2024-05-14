import Clases.*;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;


class ReunionPresencialTest {

    @Test
    void testInvitadoAReunion() {  //ESTA MUY RARO
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(1);
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado);
        String sala = "sala 2";

        Reunion reunion = new ReunionPresencial(empleado, tipoReunion.OTRO, fecha, horaPrevista, duracionPrevista,
                sala);

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
        for (Invitacion invitado: reunion.getInvitados()){if(invitado.getInvitado().equals((Invitable) otroEmpleado)){aux = true;break;}}
        Assertions.assertFalse(aux); //Se comprueba que el empleado este en la lista ded Invitados
    }

    @Test
    void testObtenerFecha() {
        Date fecha = new Date();
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);
        String sala = "sala 2";

        Reunion reunionPresencial = new ReunionPresencial(empleado, tipoReunion.OTRO, fecha, horaPrevista,
                duracionPrevista, sala);

        Assertions.assertEquals(fecha, reunionPresencial.getFecha());
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

        Assertions.assertEquals(sala, reunionPresencial.getSala());
    }

    @Test
    void testObtenerAsistencias() { //QUE TIPO DE EMPLEADOS, ASISTENCIA, RETRASOS o AUSENCIAS
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);
        String sala = "sala 2";

        Reunion reunionPresencial = new ReunionPresencial(empleado, tipoReunion.OTRO, fecha, horaPrevista,
                duracionPrevista, sala);

        Empleado empleado1 = new Empleado("2", "Quiroga", "Valeria", "valeria@example.com");

        List<Asistencia> asistencias= new ArrayList<Asistencia>();
        asistencias.add(new Asistencia(empleado1));

        reunionPresencial.iniciar(asistencias);

        boolean empleadoEncontrado = false;

        for (Asistencia asistencia : reunionPresencial.obtenerAsistencias()) {
            if (asistencia.getEmpleado().equals(empleado1)) {
                empleadoEncontrado = true;
                break;
            }
        }

        Assertions.assertTrue(empleadoEncontrado);
    }

}
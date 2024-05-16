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

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Test unitario que verifica el funcionamiento de la clase Invitacion este correcto.
 */
class InvitacionTest {
    Empleado empleado;
    Date fecha;
    Instant horaPrevista;
    Duration duracionPrevista;
    String sala;
    Reunion reunion;
    Departamento invitado;
    Invitacion invitacion;

    @BeforeEach
    void setup(){
        empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        fecha = new Date();
        horaPrevista = Instant.now();
        duracionPrevista = Duration.ofHours(2);
        sala = "sala 2";

        reunion = new ReunionPresencial(empleado, tipoReunion.OTRO, fecha, horaPrevista, duracionPrevista, sala);

        invitado = new Departamento("IT");
        invitacion = new Invitacion(reunion, invitado);
    }

    @Test
    void testGetInvitado() {assertEquals(invitado, invitacion.getInvitado());}

    @Test
    void testGetHora() {assertEquals(reunion.getHoraPrevista(), invitacion.getHora());}

    @Test
    void testGetReunion() {assertEquals(reunion, invitacion.getReunion());}

    @Test
    void testToString(){
        assertEquals("Representa la invitacion que se le hace a un 'Departamento' o a un 'Empleado'",invitacion.toString());
    }
}
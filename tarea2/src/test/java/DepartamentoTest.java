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

import static org.junit.jupiter.api.Assertions.assertEquals;


/*
 * Test unitario que verifica el funcionamiento de la clase Departamento este correcto.
 */
class DepartamentoTest {
    Departamento departamento;
    Empleado empleado1;
    Empleado empleado2;
    @BeforeEach
    void setUp() {
        departamento = new Departamento("IT");
        empleado1 = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        empleado2 = new Empleado("2", "Benavides", "Antonio", "antonio@example.com");
        departamento.agregarEmpleado(empleado1);
        departamento.agregarEmpleado(empleado2);
    }

    @Test
    void testGetNombre() {assertEquals("IT", departamento.getNombre());}

    @Test
    void testAgregarEmpleado() {
        assertEquals(empleado1, departamento.getEmpleados().get(0));
        assertEquals(empleado2, departamento.getEmpleados().get(1));
    }

    @Test
    void testObtenerCantidadEmpleados() {assertEquals(2, departamento.obtenerCantidadEmpleados());}

    @Test
    void testQuitarEmpleado() {
        departamento.quitarEmpleado(empleado1);
        assertEquals(empleado2, departamento.getEmpleados().get(0));
    }

    @Test
    void testInvitar() {
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);
        String sala = "sala 2";

        Reunion reunion = new ReunionPresencial(empleado1, tipoReunion.OTRO, fecha, horaPrevista, duracionPrevista, sala);

        departamento.invitar(reunion);

        assertEquals(departamento,reunion.getInvitados().get(0).getInvitado());
    }

    @Test
    void testGetEmpleados() {
        List<Empleado> empleados = departamento.getEmpleados();

        assertEquals(2, empleados.size());
        assertEquals(empleado1, empleados.get(0));
        assertEquals(empleado2, empleados.get(1));
    }

    @Test
    void testToString() {assertEquals("'Departamento' representa a un departamento de una Empresa ", departamento.toString());}
}
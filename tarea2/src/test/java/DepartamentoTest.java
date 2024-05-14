/**
 * Clase que representa un departamento de una empresa.
 * @author Maria Jose San Martin
 */

import Clases.*;

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

    @Test
    void testGetNombre() {
        Departamento departamento = new Departamento("IT");
        assertEquals("IT", departamento.getNombre());
    }

    @Test
    void testAgregarEmpleado() {
        Departamento departamento = new Departamento("IT");
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        departamento.agregarEmpleado(empleado);
        assertEquals(1, departamento.getEmpleados().size());
        assertEquals(empleado, departamento.getEmpleados().get(0));
    }

    @Test
    void testObtenerCantidadEmpleados() {
        Departamento departamento = new Departamento("IT");

        Empleado empleado1 = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Empleado empleado2 = new Empleado("2", "Benavides", "Antonio", "antonio@example.com");

        departamento.agregarEmpleado(empleado1);
        departamento.agregarEmpleado(empleado2);

        assertEquals(2, departamento.obtenerCantidadEmpleados());
    }

    @Test
    void testQuitarEmpleado() {
        Departamento departamento = new Departamento("IT");

        Empleado empleado1 = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Empleado empleado2 = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");

        departamento.agregarEmpleado(empleado1);
        departamento.agregarEmpleado(empleado2);

        departamento.quitarEmpleado(empleado1);

        assertEquals(empleado2, departamento.getEmpleados().get(0));
    }

    @Test
    void testInvitar() {
        Departamento departamento = new Departamento("IT");

        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");

        departamento.agregarEmpleado(empleado);

        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);
        String sala = "sala 2";

        Reunion reunion = new ReunionPresencial(empleado, tipoReunion.OTRO, fecha, horaPrevista, duracionPrevista, sala);

        departamento.invitar(reunion);

        assertEquals(departamento,reunion.getInvitados().get(0).getInvitado());
    }

    @Test
    void testGetEmpleados() {
        Departamento departamento = new Departamento("IT");
        Empleado empleado1 = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Empleado empleado2 = new Empleado("2", "Benavides", "Antonio", "antonio@example.com");

        departamento.agregarEmpleado(empleado1);
        departamento.agregarEmpleado(empleado2);

        List<Empleado> empleados = departamento.getEmpleados();

        assertEquals(2, empleados.size());
        assertEquals(empleado1, empleados.get(0));
        assertEquals(empleado2, empleados.get(1));
    }

    @Test
    void testToString() {
        Departamento departamento = new Departamento("IT");
        assertEquals("'Departamento' representa a un departamento de una Empresa ", departamento.toString());
    }
}
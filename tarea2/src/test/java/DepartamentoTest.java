import Clases.*;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DepartamentoTest {

    @Test
    void testGetNombre() {
        Departamento departamento = new Departamento("IT");
        assertEquals("IT", departamento.getNombre());
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
    void testAgregarEmpleado() {
        Departamento departamento = new Departamento("IT");
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        departamento.agregarEmpleado(empleado);
        assertEquals(1, departamento.getEmpleados().size());
    }

    @Test
    void testQuitarEmpleado() {
        Departamento departamento = new Departamento("IT");
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        departamento.agregarEmpleado(empleado);
        departamento.quitarEmpleado(empleado);
        assertEquals(0, departamento.getEmpleados().size());
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
        Reunion reunion = new ReunionPresencial(empleado, tipoReunion.OTRO, fecha, horaPrevista, duracionPrevista,
                sala);
        departamento.invitar(reunion);
        assertEquals(1, reunion.getInvitaciones().size());
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
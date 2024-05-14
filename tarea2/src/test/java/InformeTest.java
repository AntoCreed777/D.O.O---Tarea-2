import Clases.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class InformeTest {

    @Test
    public void testConstructor() {
        Reunion reunion = new ReunionPresencial();
        Informe informe = new Informe(reunion);
        assertNotNull(informe.getfecha());
        assertNotNull(informe.horaPrevista);
        assertNotNull(informe.horarioInicio);
        assertNotNull(informe.horarioFin);
        assertNotNull(informe.duracionTotal);
        assertNotNull(informe.tipo);
        assertNotNull(informe.notas);
        assertNotNull(informe.asistentes);
        assertNotNull(informe.ausentes);
    }

    @Test
    public void testExportarInformeTXT() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);
        String sala = "sala 2";
        Reunion reunion = new ReunionPresencial(empleado, tipoReunion.OTRO, fecha, horaPrevista, duracionPrevista,
                sala);
        Informe informe = new Informe(reunion);
        String fileName = "informe.txt";
        try {
            informe.exportarInformeTXT(fileName);
            assertTrue(new File(fileName).exists());
        } catch (IOException e) {
            fail("IOException no debe ser lanzada en este caso");
        }

    }

    @Test(expected = IOException.class)
    public void testExportarInformeTXTIOException() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(2);
        String sala = "sala 2";
        Reunion reunion = new ReunionPresencial(empleado, tipoReunion.OTRO, fecha, horaPrevista, duracionPrevista,
                sala);
        Informe informe = new Informe(reunion);
        String fileName = "informe.txt";
        informe.exportarInformeTXT(fileName);
    }
}
import Clases.*;
import org.junit.jupiter.api.Test;

import Clases.Informe;
import Clases.Reunion;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class InformeTest {

    @Test
    public void testConstructor() {
        Reunion reunion = new Reunion();
        Informe informe = new Informe(reunion);
        assertNotNull(informe.fecha);
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
        Reunion reunion = new Reunion();
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
        Reunion reunion = new Reunion();
        Informe informe = new Informe(reunion);
        String fileName = "informe.txt";
        informe.exportarInformeTXT(fileName);
    }
}
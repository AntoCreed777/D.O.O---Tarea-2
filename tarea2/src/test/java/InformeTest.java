import org.junit.Test;

import Clases.Informe;
import Clases.Reunion;

import static org.junit.Assert.*;

public class InformeTest {

    @Test
    public void testConstructor() {
        Reunion reunion = new Reunion(); // create a sample Reunion object
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
        Reunion reunion = new Reunion(); // create a sample Reunion object
        Informe informe = new Informe(reunion);
        String fileName = "informe.txt";
        informe.exportarInformeTXT(fileName);
        assertTrue(new File(fileName).exists());
        // verify the contents of the file
    }

    @Test(expected = IOException.class)
    public void testExportarInformeTXTIOException() {
        Reunion reunion = new Reunion(); // create a sample Reunion object
        Informe informe = new Informe(reunion);
        String fileName = "informe.txt";
        // simulate an IOException
        informe.exportarInformeTXT(fileName);
    }
}
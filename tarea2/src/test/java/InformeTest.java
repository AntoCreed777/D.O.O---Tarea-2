import Clases.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class InformeTest {
    public Empleado empleado;
    Date fecha;
    Instant horaPrevista;
    Duration duracionPrevista;
    String sala;
    Reunion reunion;

    @BeforeEach
    void setUpBeforeClass() throws InterruptedException {
        empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        fecha = new Date();
        horaPrevista = Instant.now();
        duracionPrevista = Duration.ofHours(2);
        sala = "sala 2";

        reunion = new ReunionPresencial(empleado, tipoReunion.OTRO, fecha, horaPrevista, duracionPrevista,
                sala);

        empleado.invitar(reunion);

        reunion.iniciar();
        Thread.sleep(2000);
        reunion.finalizar();
    }

    @Test
    public void testExportarInformeTXT() throws InterruptedException {
        Informe informe = new Informe(reunion);
        String fileName = "informe.txt";

        informe.exportarInformeTXT(fileName);

        assertTrue(new File(fileName).exists());
    }

    @Test
    public void testExportarInformeTXTIOException() {
        Informe informe = new Informe(reunion);
        String fileName = "informe.txt";

        informe.exportarInformeTXT(fileName);
    }
}
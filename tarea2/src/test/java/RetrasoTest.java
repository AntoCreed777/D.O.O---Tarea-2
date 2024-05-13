
import Clases.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class RetrasoTest {

    @Test
    public void testRetrasoConstructor() {

        Empleado empleadoMock = Mockito.mock(Empleado.class);
        Instant hora = Instant.now().minus(10, ChronoUnit.MINUTES);

        Retraso retraso = new Retraso(empleadoMock, hora);

        Assertions.assertNotNull(retraso);
        Assertions.assertEquals(empleadoMock, retraso.getEmpleado());
        Assertions.assertEquals(hora, retraso.getHora());
    }

    @Test
    public void testRetrasoToString() {

        Empleado empleadoMock = Mockito.mock(Empleado.class);
        Instant hora = Instant.now().minus(10, ChronoUnit.MINUTES);
        Retraso retraso = new Retraso(empleadoMock, hora);

        String result = retraso.toString();

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.contains("Retraso"));
        Assertions.assertTrue(result.contains("si es que llego atrasado"));
    }
}

import Clases.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class RetrasoTest {

    @Test
    public void testRetrasoConstructor() {
        Empleado empleado = new Empleado("1", "Apellido", "Nombre", "correo@example.com");
        Instant hora = Instant.now().minus(10, ChronoUnit.MINUTES);

        Retraso retraso = new Retraso(empleado, hora);

        Assertions.assertNotNull(retraso);
        Assertions.assertEquals(empleado, retraso.getEmpleado());
        Assertions.assertEquals(hora, retraso.getHora());
    }

    @Test
    public void testRetrasoToString() {
        Empleado empleado = new Empleado("1", "Apellido", "Nombre", "correo@example.com");
        Instant hora = Instant.now().minus(10, ChronoUnit.MINUTES);
        Retraso retraso = new Retraso(empleado, hora);

        String result = retraso.toString();

        Assertions.assertNotNull(result);

        //Assertions.assertTrue(result.contains("Retraso"));  //NO SIRVE, NUNCA SE MENSIONA 'Retraso'

        Assertions.assertTrue(result.contains("si es que llego atrasado"));
    }
}
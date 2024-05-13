
Editar
Pantalla completa
Copiar código
package Clases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class RetrasoTest {

    @Test
    public void testRetrasoConstructor() {
        // Arrange
        Empleado empleadoMock = Mockito.mock(Empleado.class);
        Instant hora = Instant.now().minus(10, ChronoUnit.MINUTES);

        // Act
        Retraso retraso = new Retraso(empleadoMock, hora);

        // Assert
        Assertions.assertNotNull(retraso);
        Assertions.assertEquals(empleadoMock, retraso.getEmpleado());
        Assertions.assertEquals(hora, retraso.getHora());
    }

    @Test
    public void testRetrasoToString() {
        // Arrange
        Empleado empleadoMock = Mockito.mock(Empleado.class);
        Instant hora = Instant.now().minus(10, ChronoUnit.MINUTES);
        Retraso retraso = new Retraso(empleadoMock, hora);

        // Act
        String result = retraso.toString();

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.contains("Retraso"));
        Assertions.assertTrue(result.contains("si es que llego atrasado"));
    }
}
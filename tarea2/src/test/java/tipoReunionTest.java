/**
 * Clase que representa un departamento de una empresa.
 * @author Maria Jose San Martin
 */ 

import Clases.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Test unitario que verifica el funcionamiento de la clase tipo Enum tipoReunion
 *  este correcto.
 */

class tipoReunionTest {

    @Test
    public void testTipoReunionEnum() {

        assertEquals(tipoReunion.TECNICA.tipo, "TECNICA");
        assertEquals(tipoReunion.MARKETING.tipo, "MARKETING");
        assertEquals(tipoReunion.OTRO.tipo, "OTRO");

        String expectedDescription = "Representa al tipo de reunion que se puede realizar";
        assertEquals(expectedDescription, tipoReunion.TECNICA.toString());
        assertEquals(expectedDescription, tipoReunion.MARKETING.toString());
        assertEquals(expectedDescription, tipoReunion.OTRO.toString());
    }
}
import Clases.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class tipoReunionTest {

    @Test
    public void testTipoReunionEnum() {

        assertEquals(tipoReunion.TECNICA.tipo, "TECNICA");
        assertEquals(tipoReunion.MARKETING.tipo, "MARKETING");
        assertEquals(tipoReunion.OTRO.tipo, "OTRO");

        String expectedDescription = "'Enumeracion' representa a todas las tipos de reuniones que se pueden realizar";
        assertEquals(expectedDescription, tipoReunion.TECNICA.toString());
        assertEquals(expectedDescription, tipoReunion.MARKETING.toString());
        assertEquals(expectedDescription, tipoReunion.OTRO.toString());
    }
}
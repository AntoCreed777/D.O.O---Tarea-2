package Clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TipoReunionTest {

    @Test
    void testGetValue() {
        TipoReunion tipoReunion = tipoReunion.TECNICA;
        assertEquals("TECNICA", tipoReunion.getValue());
    }

    @Test
    void testGetDisplayName() {
        TipoReunion tipoReunion = tipoReunion.TECNICA;
        assertEquals("Técnica", tipoReunion.getDisplayName());
    }
}
package Clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NotaTest {

    @Test
    void testGetContenido() {
        Nota nota = new Nota("Este es un ejemplo de nota");
        assertEquals("Este es un ejemplo de nota", nota.getContenido());
    }

    @Test
    void testSetContenido() {
        Nota nota = new Nota();
        nota.setContenido("Este es un ejemplo de nota");
        assertEquals("Este es un ejemplo de nota", nota.getContenido());
    }
}
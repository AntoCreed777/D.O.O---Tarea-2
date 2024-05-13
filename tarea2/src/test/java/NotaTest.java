package Clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NotaTest {

    @Test
    void testGetContenido() {
        String contenido = "Este es un ejemplo de nota";
        Nota nota = new Nota(contenido);
        assertEquals(contenido, nota.getContenido());
    }

    @Test
    void testToString() {
        Nota nota = new Nota("Este es un ejemplo de nota");
        String expectedToString = "'Nota' representa a una nota de texto que indique algo con respecto a la reunion";
        assertEquals(expectedToString, nota.toString());
    }
}
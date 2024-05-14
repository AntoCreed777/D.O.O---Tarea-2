/**
 * Clase que representa un departamento de una empresa.
 * @author Maria Jose San Martin
 */ 

import Clases.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Test unitario que verifica el funcionamiento de la clase Nota este correcto.
 */
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
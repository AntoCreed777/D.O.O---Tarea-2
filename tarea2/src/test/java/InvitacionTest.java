package Clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvitacionTest {

    @Test
    void testGetNombreDepartamento() {
        Invitacion invitacion = new Invitacion("IT", "Taller de desarrollo");
        assertEquals("IT", invitacion.getNombreDepartamento());
    }

    @Test
    void testGetNombreEvento() {
        Invitacion invitacion = new Invitacion("IT", "Taller de desarrollo");
        assertEquals("Taller de desarrollo", invitacion.getNombreEvento());
    }
}
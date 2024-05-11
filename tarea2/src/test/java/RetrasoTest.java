package Clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InvitableTest {

    @Test
    void testIsInvitable() {
        Empleado empleado = new Empleado("1", "Quiroga", "Valeria", "valeria@example.com");
        Invitable invitable = new Invitable() {
            @Override
            public boolean isInvitable(Empleado empleado) {
                return empleado.getNombre().equals("Valeria");
            }
        };
        assertTrue(invitable.isInvitable(empleado));

        invitable = new Invitable() {
            @Override
            public boolean isInvitable(Empleado empleado) {
                return empleado.getNombre().equals("Juan");
            }
        };
        assertFalse(invitable.isInvitable(empleado));
    }
}
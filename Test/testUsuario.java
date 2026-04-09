import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testUsuario {

    @Test
    void testValidarCredencialesCorrectas() {
        Usuario user = new Usuario("Ying01", "112233", "Ying");
        boolean resultado = user.validarCredenciales("Ying01", "112233");
        assertTrue(resultado, "El login debería ser exitoso con los datos son correctas.");
    }

    @Test
    void testValidarCredencialesIncorrectas() {
        Usuario user = new Usuario("Ying01", "112233", "Ying");
        boolean resultado = user.validarCredenciales("Ying01", "clave_falsa");
        assertFalse(resultado, "El login debería fallar si la clave es incorrecta.");
    }
}

import Modelo.RepositorioEnMemoria;
import Modelo.Ruleta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class pruebasRuleta {
    @Test
    void rechazarSaldoInicialNegativo() {

    }

    @Test
    void depositarCorrectamente(){
        Ruleta ruleta = new Ruleta(100,new RepositorioEnMemoria());
        ruleta.depositar(150);
        assertEquals(250,ruleta.getSaldo());
    }
}

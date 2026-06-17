import Modelo.RepositorioEnMemoria;
import Modelo.Ruleta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class pruebasRuleta {
    @Test
    void rechazarSaldoInicialNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {new Ruleta(-1000, new RepositorioEnMemoria());
        });

    }

    @Test
    void depositarCorrectamente(){
        Ruleta ruleta = new Ruleta(100,new RepositorioEnMemoria());
        ruleta.depositar(150);
        assertEquals(250,ruleta.getSaldo());
    }

    @Test
    void rechazarApuestaNula(){

    }

    @Test
    void apuestaMayorQueSaldo(){

    }
}

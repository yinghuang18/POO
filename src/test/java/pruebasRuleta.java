import Controlador.SessionController;
import Modelo.Apuestas.ApuestaImpar;
import Modelo.Apuestas.ApuestaNegro;
import Modelo.Estadisticas;
import Modelo.RepositorioEnMemoria;
import Modelo.Resultado;
import Modelo.Ruleta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class pruebasRuleta {
    @Test
    void rechazarSaldoInicialNegativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {new Ruleta(-1000, new RepositorioEnMemoria());
        });
        assertEquals("Saldo inicial invalido", exception.getMessage());

    }

    @Test
    void depositarCorrectamente(){
        Ruleta ruleta = new Ruleta(100,new RepositorioEnMemoria());
        ruleta.depositar(150);
        assertEquals(250,ruleta.getSaldo());
    }

    @Test
    void rechazarApuestaNula(){
        Ruleta ruleta = new Ruleta(1340,new RepositorioEnMemoria());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {ruleta.jugar(null);
        });

        assertEquals("Apuesta requerida", exception.getMessage());


    }

    @Test
    void apuestaMayorQueSaldo(){
        Ruleta ruleta = new Ruleta(2000,new RepositorioEnMemoria());
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {ruleta.jugar(new ApuestaImpar(3000));
        });
        assertEquals("Saldo insuficiente", exception.getMessage());

    }
    @Test
    void rachaYtipoMasJugado(){
        RepositorioEnMemoria repositorioEnMemoria = new RepositorioEnMemoria();
        Estadisticas estadisticas= new Estadisticas(repositorioEnMemoria);

        repositorioEnMemoria.guardar(new Resultado(23,"ROJO",false,4000,new ApuestaNegro(2000)));
        repositorioEnMemoria.guardar(new Resultado(4,"PAR",false,2000,new ApuestaImpar(1000)));
        repositorioEnMemoria.guardar(new Resultado(5,"IMPAR",true,1000,new ApuestaImpar(2000)));
        repositorioEnMemoria.guardar(new Resultado(7,"IMPAR",true,3000,new ApuestaImpar(3000)));
        repositorioEnMemoria.guardar(new Resultado(6,"PAR",false,6000,null ));
        assertEquals(2, estadisticas.getVictorias());
        assertEquals(2, estadisticas.getRachaMaxima());
        assertEquals(50.0, estadisticas.getPorcentajeVictorias());
        assertEquals("IMPAR", estadisticas.getTipoMasJugado());

    }

    @Test
    void inicioSesionUsuarioNoRegistrado(){
        SessionController sessionController = new SessionController();
        boolean IntentoInicioSesion = sessionController.iniciarSesion("yingNoRegistrado", "contraseñaNoRegistrado");
        assertFalse(IntentoInicioSesion);

    }

    @Test
    void inicioSesionUsuarioNULO(){
        SessionController sessionController = new SessionController();
        sessionController.registrarUsuario("Ying01","Contraseña", "Ying");
        boolean IntentoInicioSesion = sessionController.iniciarSesion(null, "Contraseña");
        assertFalse(IntentoInicioSesion);
    }
}

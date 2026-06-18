package Controlador;

import Modelo.IRepositorioResultados;
import Modelo.Ruleta;
import Modelo.Resultado;
import Modelo.Apuestas.ApuestaBase;

public class RuletaController {

    private final Ruleta ruleta;
    private final SessionController session;

    public RuletaController(Ruleta ruleta, SessionController session) {
        this.ruleta     = ruleta;
        this.session    = session;
    }

    public int getSaldo() { return ruleta.getSaldo(); }

    public void depositar(int monto) {
        ruleta.depositar(monto);
    }

    public boolean puedeApostar(ApuestaBase apuesta) {
        if (apuesta == null) return false;
        int monto = apuesta.getMonto();
        return monto > 0 && monto <= ruleta.getSaldo();
    }

    public Resultado jugar(ApuestaBase apuesta) {
        if (!puedeApostar(apuesta)) {
            throw new IllegalArgumentException("Monto invalido o saldo insuficiente");
        }
        return ruleta.jugar(apuesta);
    }

    public IRepositorioResultados getRepositorio() {
        return ruleta.getRepositorio();
    }
}

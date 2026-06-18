package Modelo;
import java.util.*;

public class RepositorioEnMemoria implements IRepositorioResultados {

    public List<Resultado> historial = new ArrayList<>();

    @Override
    public void guardar(Resultado resultado) {
        historial.add(resultado);
    }

    @Override
    public List<Resultado> listarResultados() {
        return historial;
    }

    @Override
    public Resultado ultimaPartida() {
        if (historial.size() == 0) {
            return null;
        }

        int ultimaPosicion = historial.size() - 1;
        Resultado ultimo = historial.get(ultimaPosicion);
        return ultimo;
    }
}
package Modelo;
import Modelo.Apuestas.ApuestaBase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estadisticas {

    private int    totalJugadas        = 0;
    private int    victorias           = 0;
    private double porcentajeVictorias = 0.0;
    private int    rachaMaxima         = 0;
    private String tipoMasJugado       = null;

    public Estadisticas(IRepositorioResultados repositorio) {
        List<Resultado> historial;
        if (repositorio == null) {
            return;
        }
        historial = repositorio.listarResultados();

        // Filtrar resultados que tengan apuesta != null: solo esas se consideran jugadas válidas
        List<Resultado> jugadasValidas = new java.util.ArrayList<>();
        for (Resultado r : historial) {
            if (r.getApuesta() != null) {
                jugadasValidas.add(r);
            }
        }

        totalJugadas = jugadasValidas.size();

        for (Resultado r : jugadasValidas) {
            if (r.getAcierto()) {
                victorias++;
            }
        }

        if (totalJugadas > 0) {
            porcentajeVictorias = (victorias * 100.0) / totalJugadas;
        }

        int rachaActual = 0;
        // Calcular racha sobre jugadas válidas (ignorando resultados sin apuesta)
        for (Resultado r : jugadasValidas) {
            if (r.getAcierto()) {
                rachaActual++;
                if (rachaActual > rachaMaxima) {
                    rachaMaxima = rachaActual;
                }
            } else {
                rachaActual = 0;
            }
        }

        Map<String, Integer> contador = new HashMap<>();
        for (Resultado r : jugadasValidas) {
            ApuestaBase apuesta = r.getApuesta();
            String etiqueta = apuesta.getEtiqueta();
            if (contador.containsKey(etiqueta)) {
                contador.put(etiqueta, contador.get(etiqueta) + 1);
            } else {
                contador.put(etiqueta, 1);
            }
        }

        int mejorConteo = 0;
        for (Map.Entry<String, Integer> entry : contador.entrySet()) {
            if (entry.getValue() > mejorConteo) {
                tipoMasJugado = entry.getKey();
                mejorConteo   = entry.getValue();
            }
        }
    }

    public int    getTotalJugadas()        { return totalJugadas; }
    public int    getVictorias()           { return victorias; }
    public double getPorcentajeVictorias() { return porcentajeVictorias; }
    public int    getRachaMaxima()         { return rachaMaxima; }
    public String getTipoMasJugado()       { return tipoMasJugado; }
}
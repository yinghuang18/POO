package Modelo;
import java.util.Random;

public class Ruleta {
    public static final int MAX_HISTORIAL = 100;
    private int[] historialNumeros = new int[MAX_HISTORIAL];
    private int[] historialApuestas = new int[MAX_HISTORIAL];
    private boolean[] historialAciertos = new boolean[MAX_HISTORIAL];
    private int[] historialGananciasPerdidas = new int[MAX_HISTORIAL];
    private int historialSize = 0;

    private Random random = new Random();
    private int[] numerosRojos = {1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};

    public int girarRuleta() {
        return random.nextInt(37);
    }

    public boolean evaluarResultado(int numeroRandom, String opcionApuesta) {
        if (opcionApuesta.equals("Par")) {
            return numeroRandom != 0 && numeroRandom % 2 == 0;
        } else if (opcionApuesta.equals("Impar")) {
            return numeroRandom % 2 != 0;
        } else if (opcionApuesta.equals("Rojo")) {
            return esRojo(numeroRandom);
        } else if (opcionApuesta.equals("Negro")) {
            return numeroRandom != 0 && !esRojo(numeroRandom);
        }
        return false;
    }

    private boolean esRojo(int numero) {
        for (int recorrer : numerosRojos) {
            if (recorrer == numero) return true;
        }
        return false;
    }

    public void registrarHistorial(int numero, int monto, boolean acierto) {
        if (historialSize < MAX_HISTORIAL) {
            historialNumeros[historialSize] = numero;
            historialApuestas[historialSize] = monto;
            historialAciertos[historialSize] = acierto;
            int montoRonda;
            if (acierto == true) {
                montoRonda = monto;
            } else {
                montoRonda = -monto;
            }
            historialGananciasPerdidas[historialSize] = montoRonda;
            historialSize++;
        }
    }

    public String obtenerTextoHistorial() {
        if (historialSize == 0) {
            return "Aún no has jugado ninguna ronda.";
        }

        String texto = "--- HISTORIAL DE JUEGO ---\n";

        for (int i = 0; i < historialSize; i++) {
            String resultado;
            if (historialAciertos[i] == true) {
                resultado = "GANASTE";
            } else {
                resultado = "PERDISTE";
            }
            texto += "Ronda " + (i+1) + ": Número=" + historialNumeros[i] +
                    ", Apostado=$" + historialApuestas[i] +
                    ", " + resultado + " ($" + historialGananciasPerdidas[i] + ")\n";
        }

        return texto;
    }
}
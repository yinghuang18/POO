package Modelo;

import Modelo.Apuestas.ApuestaBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class Ruleta {

    private static final int[] NUMEROS_ROJOS = {
            1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36
    };

    private int saldo;
    private final Random            rng         = new Random();
    private final List<Resultado>   resultados  = new ArrayList<>();

    public Ruleta() {
        this(0);
    }

    public Ruleta(int saldoInicial) {
        if (saldoInicial < 0) throw new IllegalArgumentException("Saldo inicial inválido");
        this.saldo = saldoInicial;
    }

    public int getSaldo() { return saldo; }

    public void depositar(int monto) {
        if (monto <= 0) throw new IllegalArgumentException("Monto inválido");
        saldo += monto;
    }

    public int girar() {
        return rng.nextInt(37);
    }

    public String colorDe(int numero) {
        if (numero == 0) return "VERDE";
        return esRojo(numero) ? "ROJO" : "NEGRO";
    }

    public Resultado jugar(ApuestaBase apuesta) {
        if (apuesta == null) throw new IllegalArgumentException("Apuesta requerida");

        int monto = apuesta.getMonto();
        if (monto <= 0) throw new IllegalArgumentException("Monto inválido");
        if (monto > saldo) throw new IllegalArgumentException("Saldo insuficiente");

        int numero      = girar();
        String color    = colorDe(numero);
        boolean acierto = apuesta.acierta(numero, color);

        saldo += acierto ? monto : -monto;

        Resultado resultado = new Resultado(numero, color, acierto, saldo, apuesta);
        resultados.add(resultado);
        return resultado;
    }

    public List<Resultado> getResultados() {
        return Collections.unmodifiableList(resultados);
    }

    private boolean esRojo(int n) {
        for (int r : NUMEROS_ROJOS) if (r == n) return true;
        return false;
    }
}
package Modelo;
import Modelo.Apuestas.ApuestaBase;
import java.util.Random;

public class Ruleta {

	private static final int[] NUMEROS_ROJOS = {
			1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36
	};
	private int saldo;
	private final Random rng = new Random();
	private IRepositorioResultados repositorio;

	public Ruleta(int saldoInicial, IRepositorioResultados repositorio) {
		if (saldoInicial < 0) throw new IllegalArgumentException("Saldo inicial invalido");
		this.saldo = saldoInicial;
		this.repositorio = repositorio;
	}

	public Ruleta(int saldoInicial) {
		this(saldoInicial, new RepositorioEnMemoria());
	}

	public Ruleta() {
		this(0, new RepositorioEnMemoria());
	}

	public int getSaldo() {
		return saldo;
	}

	public void depositar(int monto) {
		if (monto <= 0) throw new IllegalArgumentException("Monto invalido");
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
		if (monto <= 0) throw new IllegalArgumentException("Monto invalido");
		if (monto > saldo) throw new IllegalArgumentException("Saldo insuficiente");

		int numero     = girar();
		String color   = colorDe(numero);
		boolean acierto = apuesta.acierta(numero, color);

		if (acierto) {
			saldo = saldo + monto;
		} else {
			saldo = saldo - monto;
		}

		Resultado resultado = new Resultado(numero, color, acierto, saldo, apuesta);
		repositorio.guardar(resultado);
		return resultado;
	}

	public IRepositorioResultados getRepositorio() {
		return repositorio;
	}

	private boolean esRojo(int n) {
		for (int r : NUMEROS_ROJOS) {
			if (r == n) return true;
		}
		return false;
	}
}
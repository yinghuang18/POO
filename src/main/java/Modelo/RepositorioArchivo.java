package Modelo;

import Modelo.Apuestas.ApuestaBase;
import Modelo.Apuestas.ApuestaRojo;
import Modelo.Apuestas.ApuestaNegro;
import Modelo.Apuestas.ApuestaPar;
import Modelo.Apuestas.ApuestaImpar;
import java.io.*;
import java.util.*;

public class RepositorioArchivo implements IRepositorioResultados {

	private String nombreArchivo;
	private final List<Resultado> historial = new ArrayList<>();

	public RepositorioArchivo(String username) {
		this.nombreArchivo = "historial_" + username + ".csv";

		cargarDatos();
	}

	/**
	 * 
	 * @param resultado
	 */
	@Override
	public void guardar(Resultado resultado) {
		// TODO - implement RepositorioArchivo.guardar
		historial.add(resultado);

		try {
			PrintWriter printWriter= new PrintWriter(new FileWriter(nombreArchivo, true));
			printWriter.println(resultado.getNumero() + "," + resultado.getColor() + "," + resultado.getApuesta().getMonto() + "," + resultado.getAcierto() + "," + resultado.getApuesta().getEtiqueta() + "," + resultado.getSaldoPosterior());
			printWriter.close();
		} catch (Exception e) {
			System.out.println("Error al guardar resultado: " + e.getMessage());
		}


	}
	@Override
	public List<Resultado> listarResultados() {
		// TODO - implement RepositorioArchivo.obtenerTodos
			return historial;
	}
	@Override
	public Resultado ultimaPartida() {
		// TODO - implement RepositorioArchivo.obtenerUltimo
		if (historial.isEmpty()) {
			return null;
		}
		return historial.get(historial.size()-1);

	}
	private void cargarDatos(){
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(nombreArchivo));
			String linea = bufferedReader.readLine();
			while (linea != null) {
				String[] partes = linea.split(",");

				if (partes.length == 6) {
					int numero = Integer.parseInt(partes[0]);
					String color = partes[1];
					String etiqueta = partes[2];
					int monto = Integer.parseInt(partes[3]);
					boolean acierto = Boolean.parseBoolean(partes[4]);
					int saldo = Integer.parseInt(partes[5]);

					ApuestaBase apuesta = null;

					if (etiqueta.equals("ROJO")) {
						apuesta = new ApuestaRojo(monto);
					} else if (etiqueta.equals("NEGRO")) {
						apuesta = new ApuestaNegro(monto);
					} else if (etiqueta.equals("PAR")) {
						apuesta = new ApuestaPar(monto);
					} else if (etiqueta.equals("IMPAR")) {
						apuesta = new ApuestaImpar(monto);
					}

					if (apuesta != null) {
						historial.add(new Resultado(numero, color, acierto, saldo, apuesta));
					}
				}
				linea = bufferedReader.readLine();

			}
			bufferedReader.close();
		} catch (Exception e){
			System.out.println("No se encontró el historial");
		}
	}

}
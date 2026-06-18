package Controlador;

import Modelo.Resultado;
import java.util.List;
import Modelo.IRepositorioResultados;

public class ResultadoController {

    private final IRepositorioResultados repositorio;

    public ResultadoController(IRepositorioResultados repositorio) {

        this.repositorio = repositorio;
    }

    public List<Resultado> getHistorial() {
        return repositorio.listarResultados();
    }

    public Resultado getUltimoResultado() {
       return repositorio.ultimaPartida();
    }
    public IRepositorioResultados getRepositorio() {
        return repositorio;
    }
}
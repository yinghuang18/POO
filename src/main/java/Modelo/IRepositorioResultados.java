package Modelo;

import java.util.*;
public interface IRepositorioResultados {

    /**
     *
     * @param resultado
     */
    void guardar(Resultado resultado);

    List <Resultado> listarResultados();

    Resultado ultimaPartida();

}

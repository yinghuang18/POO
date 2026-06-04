public interface IRepositorioResultados {

    /**
     *
     * @param resultado
     */
    void guardad(Resultado resultado);

    Resultado obtenerUltimo();

    List obtenerTodos();

}
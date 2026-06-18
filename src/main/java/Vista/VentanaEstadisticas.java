package Vista;

import Controlador.ResultadoController;
import Modelo.Estadisticas;

import javax.swing.*;
import java.awt.*;

public class VentanaEstadisticas {
    private final ResultadoController resultadoController;
    private final JFrame    frame           = new JFrame("Estadísticas");
    private final JTextArea txtEstadisticas = new JTextArea(12, 50);
    private final JButton   btnActualizar   = new JButton("Actualizar");

    public VentanaEstadisticas(ResultadoController resultadoController) {
        this.resultadoController = resultadoController;
        construirUI();
        cablearEventos();
        cargar();
    }

    public void mostrar() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void construirUI() {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 340);
        frame.setLayout(new BorderLayout(8, 8));

        txtEstadisticas.setEditable(false);
        txtEstadisticas.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        JPanel norte = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        norte.add(btnActualizar);

        frame.add(norte, BorderLayout.NORTH);
        frame.add(new JScrollPane(txtEstadisticas), BorderLayout.CENTER);
    }

    private void cablearEventos() {
        btnActualizar.addActionListener(e -> cargar());
    }

    private void cargar() {
        Estadisticas est = new Estadisticas(resultadoController.getRepositorio());

        txtEstadisticas.setText("");

        if (est.getTotalJugadas() == 0) {
            txtEstadisticas.append("No hay jugadas registradas.\n");
            return;
        }

        String tipoMas = est.getTipoMasJugado();
        if (tipoMas == null) {
            tipoMas = "-";
        }

        txtEstadisticas.append("Total jugadas         : " + est.getTotalJugadas() + "\n");
        txtEstadisticas.append("Victorias             : " + est.getVictorias() + "\n");
        txtEstadisticas.append("Porcentaje victorias  : " + est.getPorcentajeVictorias() + "%\n");
        txtEstadisticas.append("Racha maxima          : " + est.getRachaMaxima() + "\n");
        txtEstadisticas.append("Tipo mas jugado       : " + tipoMas + "\n");
    }
}
import javax.swing.*;
public class VentanaSaludo {
    private final JFrame frame = new JFrame("Juego de la ruleta");
    private final JLabel lblSaludo = new JLabel();

    public VentanaSaludo(String nombreUsuario) {
        lblSaludo.setText("Hola, " + nombreUsuario + "!");
        frame.add(lblSaludo);
    }
    public void mostrarVentana() {
        frame.setVisible(true);
    }
}

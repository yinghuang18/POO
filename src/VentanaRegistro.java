import javax.swing.*;

public class VentanaRegistro {
    private final JFrame frame = new JFrame("Registro - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblNombre = new JLabel("Usuario:");
    private final JTextField txtNombre = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnRegistrar = new JButton("Registrar");

    public VentanaRegistro() {
        frame.add(lblUsuario);
        frame.add(txtUsuario);
        frame.add(lblNombre);
        frame.add(txtNombre);
        frame.add(lblClave);
        frame.add(txtClave);
        frame.add(btnRegistrar);

    }
    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}

import javax.swing.*;
import java.awt.*;

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
        frame.setSize(400, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
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
    private void registrarUsuario() {
        String nombreIngresado = txtNombre.getText();
        String usuarioIngresado = txtUsuario.getText();
        String claveIngresado = new String(txtClave.getPassword());
        if (!nombreIngresado.isEmpty() && !usuarioIngresado.isEmpty() && !claveIngresado.isEmpty()) {
            Usuario nuevoUsuario = new Usuario(usuarioIngresado, claveIngresado, nombreIngresado);
            VentanaLogin.USUARIOS.add(nuevoUsuario);
            JOptionPane.showMessageDialog(frame, "Usuario registrado exitosamente");
            frame.dispose();
        } else {
            JOptionPane.showMessageDialog(frame, "Complete toda la infromación solicitada");
    }
}

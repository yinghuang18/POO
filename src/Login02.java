import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Login02 {
    public static final List<Usuario> USUARIOS = new ArrayList<>();
    private final JFrame frame = new JFrame("Registro - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblNombre = new JLabel("Usuario:");
    private final JTextField txtNombre = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnRegistrar = new JButton("Registrar");

    public Login02() {

        txtUsuario.setColumns(20);
        txtNombre.setColumns(20);
        txtClave.setColumns(20);
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
    
}

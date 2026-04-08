import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Clase que representa la ventana de Login del Casino Black Cat.
 * Permite ingresar credenciales para acceder al sistema.
 */
public class VentanaLogin {
    // --- Lista dinámica de usuarios ---
    public static final List<Usuario> USUARIOS = new ArrayList<>();
    // --- UI ---
    private final JFrame frame = new JFrame("Login - Casino Black Cat");
    private final JLabel lblUsuario = new JLabel("Usuario:");
    private final JTextField txtUsuario = new JTextField();
    private final JLabel lblClave = new JLabel("Clave:");
    private final JPasswordField txtClave = new JPasswordField();
    private final JButton btnIngresar = new JButton("Ingresar");
    /**
     * Constructor que inicializa la ventana de login.
     * Configura el tamaño, los componentes y los eventos.
     */
    public VentanaLogin() {
// TODO: inicializar usuarios hardcodeados
// TODO: inicializar y configurar la ventana
    USUARIOS.add(new Usuario("Ying01", "112233", "Ying"));

    frame.add(lblUsuario);
    frame.add(txtUsuario);
    frame.add(lblClave);
    frame.add(txtClave);
    frame.add(btnIngresar);

    }

    /**
     * Muestra la ventana en pantalla.
     * Debe centrarla y hacerla visible.
     */
    public void mostrarVentana() {
// TODO: mostrar ventana
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    }
    /**
     * Maneja el evento de login al presionar el botón.
     * Debe validar credenciales y abrir la siguiente ventana o mostrar error.
     */
    private void login() {

// TODO: implementar lógica de login
       String usuario = txtUsuario.getText();
       String contraseña = new String(txtClave.getPassword());
       String nombreUsuario = validarCredenciales(usuario, contraseña);
       if (!nombreUsuario.isEmpty()) {
           VentanaSaludo saludo = new VentanaSaludo(nombreUsuario);
           saludo.mostrarVentana();

       } else {
           JOptionPane.showMessageDialog(frame, "Los datos no coinciden");
       }




    }
    /**
     * Valida las credenciales del usuario contra el arreglo hardcoded.
     *
     * @param u nombre de usuario ingresado
     * @param p clave ingresada
     * @return el nombre del usuario si es válido, o cadena vacía si no coincide
     */
    private String validarCredenciales(String u, String p) {
// TODO: recorrer arreglo y validar credenciales
        for (Usuario recorrer : USUARIOS) {
            if (recorrer.validarCredenciales(u, p)) {
                return recorrer.getNombre();
            }
        }
        /**esta forma lo que hace es recorrer la lista USUARIOS e ir preguntando
         * si es que tienen el mimso u y p, si es asi se llama al metodo .getNombre
         * creada en Usuario.java

        * */
        return "";
        /**
         private String validarCredenciales(String u, String p) {
         for (int i = 0; i < USUARIOS.size(); i++) {
         Usuario usu = USUARIOS.get(i);
         if (usu.validarCredenciales(u, p)) {
         return usu.getNombre();
         }
         }
         return "";
         }

         de esta forma hace lo mismo pero en el for se alarga mas
         * **/

    }
/**
 * Abre la ventana de registro para crear un nuevo usuario.
 * Debe cerrar la ventana actual e invocar a VentanaRegistro.
 */
 void abrirRegistro() {
// TODO: abrir ventana de registro y cerrar login
    }
}

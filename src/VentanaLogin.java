import javax.swing.*;
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



    }

    /**
     * Muestra la ventana en pantalla.
     * Debe centrarla y hacerla visible.
     */
    public void mostrarVentana() {
// TODO: mostrar ventana
        JOptionPane.showMessageDialog(null, new VentanaLogin());
    }
    /**
     * Maneja el evento de login al presionar el botón.
     * Debe validar credenciales y abrir la siguiente ventana o mostrar error.
     */
    private void login() {

// TODO: implementar lógica de login
        String nombreIngresado = JOptionPane.showInputDialog(null,"Ingrese su nombre:");
        String usuarioIngresado = JOptionPane.showInputDialog(null,"Ingrese su nombre de usuario:");
        String contraseñaIngresado = JOptionPane.showInputDialog(null,"Ingrese su contraseña:");

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
        for (int recorrer = 0; recorrer < USUARIOS.length(); recorrer++ ) {

            if (validarCredenciales(u, p)) {
                return USUARIOS.get(recorrer).getNombre();
            } else {
                return
            }
        }
        return "";
    }
/**
 * Abre la ventana de registro para crear un nuevo usuario.
 * Debe cerrar la ventana actual e invocar a VentanaRegistro.
 */
| void abrirRegistro() {
// TODO: abrir ventana de registro y cerrar login
    }
}

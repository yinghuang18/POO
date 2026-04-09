import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
public class Menu {
    private final JFrame frame = new JFrame("Bienvenid@ - Casino Black Cat");
    private final JButton btnInicio = new JButton("Inicio");
    private final JButton btnJugar = new JButton("Jugar");
    private final JButton btnHistorial = new JButton("Historial");
    private final JButton btnSalir = new JButton("Salir");


    public Menu() {
        Scanner scanner = new Scanner(System.in);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(btnInicio);
        frame.add(btnJugar);
        frame.add(btnHistorial);
        frame.add(btnSalir);
        btnInicio.addActionListener(e -> leerTipoApuesta());
        btnJugar.addActionListener(e -> login());
        btnHistorial.addActionListener(e -> login());
        btnSalir.addActionListener(e -> login());


    }
    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void leerTipoApuesta (){
        frame.setVisible(false);
        VentanaApuesta apuesta = new VentanaApuesta();
        apuesta.mostrarVentana();


    }
}

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class VentanaApuesta {
    private final JFrame frame = new JFrame("Seleccione tipo de apuesta");
    private final JButton btnPar = new JButton("Par");
    private final JButton btnImpar = new JButton("Impar");
    private final JButton btnRojo = new JButton("Rojo");
    private final JButton btnNegro = new JButton("Negro");
    private final JButton btnVolver = new JButton("Volver");


    public VentanaApuesta() {
        Scanner scanner = new Scanner(System.in);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(btnPar);
        frame.add(btnImpar);
        frame.add(btnRojo);
        frame.add(btnNegro);
        frame.add(btnVolver);
        btnPar.addActionListener(e -> leerTipoApuesta());
        btnImpar.addActionListener(e -> login());
        btnRojo.addActionListener(e -> login());
        btnNegro.addActionListener(e -> login());
        btnVolver.addActionListener(e -> cerrarVentana());
    }

    public void mostrarVentana() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void cerrarVentana() {
        frame.dispose();
        Menu menu = new Menu();
        menu.mostrarVentana();

    }



}

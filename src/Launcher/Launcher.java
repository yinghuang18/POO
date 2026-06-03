package Launcher;

import Controlador.SessionController;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {
        // ----- APARIENCIA -----
        try {
            UIManager.setLookAndFeel(new FlatDarkPurpleIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        SessionController session = new SessionController();
        VentanaLogin login = new VentanaLogin(session);
        login.mostrarVentana();
    }
}
package Launcher;

import Controlador.SessionController;
import Vista.VentanaLogin;

import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SessionController session = new SessionController();
        VentanaLogin login = new VentanaLogin(session);
        login.mostrarVentana();
    }
}

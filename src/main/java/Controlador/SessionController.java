package Controlador;

import Modelo.Usuario;

public class SessionController {
    private Usuario usuario;

    public void registrarUsuario(String username, String password, String nombre) {
        this.usuario = new Usuario(username, password, nombre);
    }

    public boolean iniciarSesion(String username, String password) {
        if (usuario == null) return false;
        return usuario.validarCredenciales(username, password);
    }

    public boolean hayUsuarioRegistrado() { return usuario != null; }
    public String getNombreUsuario() { return (usuario != null) ? usuario.getNombre() : null; }
    public Usuario getUsuarioActual() { return usuario; }
    public void cerrarSesion() { this.usuario = null; }
}
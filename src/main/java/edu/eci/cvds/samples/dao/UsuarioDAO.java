package edu.eci.cvds.samples.dao;

import java.util.List;

public interface UsuarioDAO {
    public List<UsuarioDAO> consultarUsuarios() throws PersistenceException;

    public UsuarioDAO consultarUsuario(String correo)  throws PersistenceException;

    public void registrarUsuario(String correo, String contraseña,String username, String nombre, String rol) throws PersistenceException;

    public boolean iniciarSesion(String correo, String contraseña) throws PersistenceException;
}

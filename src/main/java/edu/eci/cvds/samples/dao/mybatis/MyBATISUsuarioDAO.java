package edu.eci.cvds.samples.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.samples.Exceptions.PersistenceException;
import edu.eci.cvds.samples.dao.UsuarioDAO;
import edu.eci.cvds.samples.dao.mybatis.mappers.UsuarioMapper;
import edu.eci.cvds.samples.entities.Usuario;

import java.util.List;

public class MyBATISUsuarioDAO implements UsuarioDAO {

    @Inject
    private UsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioDAO> consultarUsuarios() throws PersistenceException {
        try{
            return usuarioMapper.consultarUsuarios();
        }catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("error al consultar usuarios", e);
        }
    }

    @Override
    public UsuarioDAO consultarUsuario(String correo) throws PersistenceException {
        try{
            return usuarioMapper.consultarUsuario(correo);
        }catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("error al consultar usuario " + correo, e);
        }
    }

    @Override
    public void registrarUsuario(String correo, String contraseña, String username, String nombre, String rol) throws PersistenceException {
        try{
            usuarioMapper.registrarUsuario(correo, contraseña, username, nombre, rol);
        }catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("error al registrar usuario", e);
        }

    }

    @Override
    public boolean iniciarSesion(String correo, String contraseña) throws PersistenceException {
        try{
            return usuarioMapper.iniciarUsuario(correo, contraseña);
        }catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("error al registrar usuari", e);
        }

    }

    @Override
    public Usuario getUserName(String userName) {
        return usuarioMapper.getUserName(userName);
    }

    public boolean validateLogin(String correo, String contraseña) throws PersistenceException {
		try{
			System.out.println("LLEGOOOO AL LOGIN");
            return usuarioMapper.iniciarUsuario(correo, contraseña);
        }catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("error al logear usuario", e);
        }
		
	}
}

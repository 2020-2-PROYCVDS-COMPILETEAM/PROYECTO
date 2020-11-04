package edu.eci.cvds.samples.dao.mybatis.mappers;

import edu.eci.cvds.samples.dao.UsuarioDAO;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Usuario;

import java.util.List;

public interface UsuarioMapper {

    /**
     * consultar todos los usuarios registrados
     * @return
     */
    List<UsuarioDAO> consultarUsuarios();

    /**
     * consultar un usuario especifico con su correo
     * @param correo
     * @return
     */
    UsuarioDAO consultarUsuario(@Param("correoUsuario") String correo);

    /**
     * registrar un usuario en la base de datos
     * @param correo
     * @param contraseña
     * @param username
     * @param nombre
     * @param rol
     */
    void registrarUsuario(@Param("correoUsuario") String correo,
                          @Param("contraseñaUsuario") String contraseña,
                          @Param("usernameUsuario") String username,
                          @Param("nombreUsuario") String nombre,
                          @Param("rolUsuario") String rol);

    /**
     * retorna si un usuario puede iniciar sesion
     * @param correo
     * @param contraseña
     * @return
     */
    boolean iniciarUsuario(@Param("correoUsuario") String correo,
                           @Param("contraseñaUsuario") String contraseña);
}

package edu.eci.cvds.samples.entities;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String correo;
    private String contrasena;
    private String username;
    private String nombre;
    private String rol;

    public Usuario(){
        super();
    }

    public Usuario(String correo, String contrasena,String username, String nombre, String rol){
        this.correo = correo;
        this.contrasena = contrasena;
        this.username = username;
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getCorreo() {return correo;  }

    public String getContraseña() { return contrasena;    }

    public String getNombre() {        return nombre;    }

    public String getRol() {        return rol;    }

    public String getUsername() {        return username;    }

    public void setCorreo(String correo) {        this.correo = correo;    }

    public void setContraseña(String contrasena) {        this.contrasena = contrasena;    }

    public void setNombre(String nombre) {        this.nombre = nombre;    }

    public void setRol(String rol) {        this.rol = rol;    }

    public void setUsername(String username) {        this.username = username;    }

}

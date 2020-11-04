package edu.eci.cvds.samples.entities;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String correo;
    private String contraseña;
    private String username;
    private String nombre;
    private String rol;

    public Usuario(){

    }

    public Usuario(String correo, String contraseña,String username, String nombre, String rol){
        this.correo = correo;
        this.contraseña = contraseña;
        this.username = username;
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getCorreo() {return correo;  }

    public String getContraseña() { return contraseña;    }

    public String getNombre() {        return nombre;    }

    public String getRol() {        return rol;    }

    public String getUsername() {        return username;    }

    public void setCorreo(String correo) {        this.correo = correo;    }

    public void setContraseña(String contraseña) {        this.contraseña = contraseña;    }

    public void setNombre(String nombre) {        this.nombre = nombre;    }

    public void setRol(String rol) {        this.rol = rol;    }

    public void setUsername(String username) {        this.username = username;    }

}

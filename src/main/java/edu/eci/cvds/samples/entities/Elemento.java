package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Elemento implements Serializable {

    private int id;
    private String tipo;
    private String equipo;
    private boolean activo;
    private String marca;
    private String nombre;

    //Novedades
    private List<Novedad> novedades;

    public List<Novedad> getNovedades() {
        return novedades;
    }

    public void setNovedades(List<Novedad> novedades) {
        this.novedades = novedades;
    }

    public Elemento(){
        super();
    }

    public Elemento(int id, String tipo, String equipo) {
        this.setId(id);
        this.setTipo(tipo);
        this.setEquipo(equipo);
    }

    public int getId() {
        return id;
    }

    public boolean isActivo() {
        return activo;
    }

    public String getEquipo() {
        return equipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

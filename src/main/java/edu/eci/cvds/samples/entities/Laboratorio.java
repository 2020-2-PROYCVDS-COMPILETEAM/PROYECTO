package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Laboratorio implements Serializable{
    private String id;
    private String nombre;
    private String descripcion;
    private int capacidadDeEquipos;
    private boolean activo;
    private ArrayList<Equipo> equipos;

    public Laboratorio() {
        super();
    }

    public Laboratorio(String id, String nombre, String descripcion, int capacidadDeEquipos,boolean activo,ArrayList<Equipo> equipo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.capacidadDeEquipos = capacidadDeEquipos;
        this.activo= activo;
        this.setEquipos(equipo);
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCapacidadDeEquipos() {
        return capacidadDeEquipos;
    }
    public void setCapacidadDeEquipos(int capacidadDeEquipos) {
        this.capacidadDeEquipos = capacidadDeEquipos;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipo) {
        this.equipos = equipo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}

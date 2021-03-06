package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Laboratorio implements Serializable{
    private Date fechadecierre;
    private Date fechadecreacion;
    private int id;
    private String nombre;
    private String descripcion;
    private boolean activo;
    private ArrayList<Equipo> equipos;

    public Laboratorio() {
        super();
    }

    public Laboratorio(int id, String nombre, String descripcion,boolean activo,Date fechadecreacion,Date fechadecierre,ArrayList<Equipo> equipo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo= activo;
        this.fechadecreacion = fechadecreacion;
        this.fechadecierre = fechadecierre;
        this.setEquipos(equipo);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
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


    public Date getFechadecreacion() { return fechadecreacion; }
    public void setFechadecreacion(Date fechadecreacion) {        this.fechadecreacion = fechadecreacion;   }

    public Date getFechadecierre() { return fechadecierre; }
    public void setFechadecierre(Date fechadecierre) {     this.fechadecierre = fechadecierre;  }

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

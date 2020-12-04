package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Laboratorio implements Serializable{
    private String fechadecierre;
    private  String fechadecreacion;
    private int id;
    private String nombre;
    private String descripcion;
    private int capacidadequipos;
    private boolean activo;
    private ArrayList<Equipo> equipos;

    public Laboratorio() {
        super();
    }

    public Laboratorio(int id, String nombre, String descripcion, int capacidadequipos,boolean activo,String fechadecreacion,String fechadecierre,ArrayList<Equipo> equipo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.capacidadequipos = capacidadequipos;
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

    public int getCapacidadequipos(){return capacidadequipos;}

    public void setCapacidadequipos(int capacidadequipos) { this.capacidadequipos = capacidadequipos;    }

    public String getFechadecreacion() { return fechadecreacion; }
    public void setFechadecreacion(String fechadecreacion) {        this.fechadecreacion = fechadecreacion;   }

    public String getFechadecierre() { return fechadecierre; }
    public void setFechadecierre(String fechadecierre) {     this.fechadecierre = fechadecierre;  }

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

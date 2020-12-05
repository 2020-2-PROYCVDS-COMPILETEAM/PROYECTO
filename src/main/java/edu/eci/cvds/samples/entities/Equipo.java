package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Equipo implements Serializable{
    private int id;
    private int laboratorioId;
    private boolean activo;
    private String nombre;
    private ArrayList<Elemento> elementos;
    private String descripcion;

    public Equipo() {
        super();
    }

    public Equipo(int id, int laboratorioId,boolean activo, ArrayList<Elemento> elementos, String descripcion) {
        this.setId(id);
        this.setLaboratorioId(laboratorioId);
        this.setActivo(activo);
        this.setElementos(elementos);
        this.setDescripcion(descripcion);

    }

    public String getDescripcion() {
        return descripcion;
    }

    private void setDescripcion(String descripcion) {
        this.descripcion=descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(int laboratorioId) {
        this.laboratorioId = laboratorioId;
    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }


    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

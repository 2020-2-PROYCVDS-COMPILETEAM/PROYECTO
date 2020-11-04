package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Equipo implements Serializable{
    private int id;
    private String laboratorioId;
    private boolean activo;
    private String nombre;
    private String descripcion;
    private ArrayList<Elemento> elementos;


    public Equipo() {
        super();
    }

    public Equipo(int id, String laboratorioId,boolean activo, ArrayList<Elemento> elementos, String descripcion) {
        this.setId(id);
        this.setLaboratorioId(laboratorioId);
        this.setActivo(activo);
        this.setElementos(elementos);
        this.setDescripcion(descripcion);

    }

    private void setDescripcion(String descripcion) {
        this.descripcion=descripcion;
    }

    private String getDescripcion(){
        return descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(String laboratorioId) {
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

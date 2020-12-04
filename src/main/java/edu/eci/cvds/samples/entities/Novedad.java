package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.util.Date;

public class Novedad implements Serializable{

    private int id;
    private int elementoId;
    private int equipoId;
    private String usuarioId;
    private Date fecha;
    private String detalle;
    private String nombre;

    public Novedad() {
        super();
    }

    public Novedad(int id, int elementoId, int equipoId, String usuarioId,Date fecha,String detalle,String nombre) {
        this.setId(id);
        this.setElementoId(elementoId);
        this.setEquipoId(equipoId);
        this.setUsuarioId(usuarioId);
        this.setFecha(fecha);
        this.setDetalle(detalle);
        this.setNombre(nombre);
    }

    public int getId() {
        return id;
    }

    public int getElementoId() {
        return elementoId;
    }

    public int getEquipoId() {
        return equipoId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setElementoId(int elementoId) {
        this.elementoId = elementoId;
    }

    public void setEquipoId(int equipoId) {
        this.equipoId = equipoId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

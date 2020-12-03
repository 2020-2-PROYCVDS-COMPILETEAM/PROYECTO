package edu.eci.cvds.managedBeans;


import edu.eci.cvds.samples.services.serviciosHistorialEquipos;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Date;

@ManagedBean(name = "novedadBean")
@ApplicationScoped
public class NovedadBean {

    @Inject
    private serviciosHistorialEquipos serviciosHistorialEquipos;

    /*private Injector injector;*/
    private int id;
    private int id_elemento;
    private int id_equipo;
    private String usuario;
    private Date fecha;
    private String detalle;
    private String nombre;
    private String tipo;


    public void registrar() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            //usuarioId = serviciosHistorialEquipos.getUsuario(SecurityUtils.getSubject().getPrincipal().toString()).getUserName();
            if (tipo.equals("Equipo")) {
                System.out.println("entre equipo");
                serviciosHistorialEquipos.registrarNovedadEquipo(id_elemento, fecha, nombre, usuario, detalle);
            }
            else{
                System.out.println("entre elemento");
                id_equipo = serviciosHistorialEquipos.getEquipoID(id_elemento);
                if (id_equipo != 0){
                    System.out.println("si");
                }
                serviciosHistorialEquipos.registrarNovedadElemento(id_elemento, id_equipo, fecha, nombre, usuario, detalle);
            }
        }
        catch(Exception e) {

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error", "Imposible registrar"));
        }


    }

    public int getId() {
        return id;
    }

    public int getId_elemento() {
        return id_elemento;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public String getUsuario() {
        return usuario;
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

    public String getTipo() {
        return tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_elemento(int id_elemento) {
        this.id_elemento = id_elemento;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

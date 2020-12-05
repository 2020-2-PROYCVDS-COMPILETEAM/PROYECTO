package edu.eci.cvds.managedBeans;


import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Novedad;
import edu.eci.cvds.samples.services.serviciosHistorialEquipos;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import java.util.ArrayList;
import java.util.Date;

@ManagedBean(name = "novedadBean")
@ApplicationScoped
public class NovedadBean extends BasePageBean{

    @Inject
    private serviciosHistorialEquipos serviciosHistorialEquipos;

    /*private Injector injector;*/
    private int id;
    private int id_elemento = 0;
    private int id_equipo = 0;
    private String usuario;
    private Date fecha;
    private String detalle;
    private String nombre;
    private String tipo;


    public void registrar() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            fecha = new Date();
            if (id_equipo != 0){
                serviciosHistorialEquipos.registrarNovedadEquipo(id_equipo,fecha,usuario,detalle,nombre);
            }else{
                try {
                    this.id_equipo = serviciosHistorialEquipos.getEquipoID(this.id_elemento);
                    serviciosHistorialEquipos.registrarNovedadElemento(id_elemento, id_equipo, usuario, fecha, detalle, nombre);
                }catch (Exception e){
                    serviciosHistorialEquipos.registrarNovedadElemento2(id_elemento, usuario, fecha, detalle, nombre);
                }
            }
            id_equipo = 0;
            id_elemento = 0;

        }catch (Exception e){
            System.out.println(e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error", "Es posible que este "));
        }

    }

    public ArrayList<Novedad> getNovedades(){
        FacesContext context = FacesContext.getCurrentInstance();
        return serviciosHistorialEquipos.reporteNovedades();
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

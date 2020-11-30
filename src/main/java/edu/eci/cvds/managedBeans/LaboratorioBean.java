package edu.eci.cvds.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.entities.Laboratorio;
import edu.eci.cvds.samples.services.serviciosHistorialEquipos;


@ManagedBean(name = "laboratorioBean")
@SessionScoped
public class LaboratorioBean extends BasePageBean {

    @Inject
    private serviciosHistorialEquipos serviciosHistorialEquipos;

    private String id;
    private String nombre;
    private String descripcion;
    private int capacidadEquipos;
    private boolean activo;
    private List <Equipo> equipos = new ArrayList<Equipo>();


    public void registrar() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            serviciosHistorialEquipos.crearLaboratorio(id,nombre,descripcion,capacidadEquipos);
            for (Equipo e:equipos) {
                serviciosHistorialEquipos.asociarLaboratorio(id,e.getId());
            }
        }
        catch(Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error", "No fue posible el registro"));
        }


    }

    public List<Equipo> getEquipos(){
        return equipos;
    }

    public List<Equipo> getEquiposDisponibles(){
        return serviciosHistorialEquipos.listarEquiposDisponibles();
    }

    public List<Laboratorio> getLaboratorios() {
        return serviciosHistorialEquipos.listarLaboratorios();
    }



    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getCapacidadEquipos() {
        return capacidadEquipos;
    }
    public void setCapacidadEquipos(int capacidadEquipos) {
        this.capacidadEquipos = capacidadEquipos;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void asociar(Equipo eq) {
        serviciosHistorialEquipos.asociarLaboratorio("",eq.getId());
        equipos.add(eq);

    }

    public void desasociar(Equipo eq) {
        serviciosHistorialEquipos.desasociarLaboratorio(eq.getId());
        equipos.remove(eq);

    }

}

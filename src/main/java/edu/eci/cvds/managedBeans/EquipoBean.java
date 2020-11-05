package edu.eci.cvds.managedBeans;

import com.google.inject.Inject;
import edu.eci.cvds.samples.services.serviciosHistorialEquipos;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
/**
 *
 */

@ManagedBean(name = "equipoBean")
@SessionScoped

public class EquipoBean extends BasePageBean {
    @Inject
    private serviciosHistorialEquipos laboratorioServices;



    /*private Injector injector;*/
    private int id;
    private String nombre;
    private String laboratorioId;
    private boolean activo;
    private int pantallaID;
    private int mouseID;
    private int torreID;
    private int tecladoID;



    public void registrar() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            laboratorioServices.registrarEquipo(nombre,laboratorioId);
        }
        catch(Exception e) {

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("registrarEquipo.xhtml", new FacesMessage("Error", "No fue posible el registro"));
        }

    }

    /**
     *
     */
    public void getEquipos() {
        return;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     */
    public void equiposActivos() {
        return ;
    }



    public String getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(String laboratorioId) {
        this.laboratorioId = laboratorioId;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getPantallaID() {
        return pantallaID;
    }

    public void setPantallaID(int pantallaID) {
        this.pantallaID = pantallaID;
    }

    public int getMouseID() {
        return mouseID;
    }

    public void setMouseID(int mouseID) {
        this.mouseID = mouseID;
    }

    public int getTorreID() {
        return torreID;
    }

    public void setTorreID(int torreID) {
        this.torreID = torreID;
    }

    public int getTecladoID() {
        return tecladoID;
    }

    public void setTecladoID(int tecladoID) {
        this.tecladoID = tecladoID;
    }

    /**
     *
     */
    public void equiposDisponibles(){
        return ;
    }

    /**
     *
     * @param equipo
     */
    public void darDeBaja(int equipo) {
        try {

        }
        catch(Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
        }

    }

    /**
     *
     */
    public void equipo() {
       return ;
    }

}

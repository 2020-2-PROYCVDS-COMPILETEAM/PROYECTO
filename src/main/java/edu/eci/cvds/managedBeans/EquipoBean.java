package edu.eci.cvds.managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;
import com.google.inject.Injector;
import edu.eci.cvds.samples.services.serviciosHistorialEquipos;

@ManagedBean(name = "equipoBean")
@SessionScoped
public class EquipoBean extends BasePageBean {

    @Inject
    private serviciosHistorialEquipos serviciosHistorialEquipos;


    /*private Injector injector;*/
    private int id;
    private String nombre;
    private String laboratorioId;
    private boolean activo;
    private int pantallaID;
    private int mouseID;
    private int torreID;
    private int tecladoID;

	/*public EquipoBean() {
		injector = super.getInjector();
		laboratorioServices = injector.getInstance(LaboratorioServices.class);
	}*/

    public void registrar() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            serviciosHistorialEquipos.registrarEquipo(nombre, laboratorioId);

        } catch (Exception e) {

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("registrarEquipo.xhtml", new FacesMessage("Error", "No fue posible el registro"));
        }

    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }

    public int getId() {
        return id;
    }

    @Override
    public Injector getInjector() {
        return super.getInjector();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void setInjector(Injector injector) {
        super.setInjector(injector);
    }

    public int getMouseID() {
        return mouseID;
    }

    public int getPantallaID() {
        return pantallaID;
    }

    public int getTecladoID() {
        return tecladoID;
    }

    public int getTorreID() {
        return torreID;
    }

    public String getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(String laboratorioId) {
        this.laboratorioId = laboratorioId;
    }

    public void setMouseID(int mouseID) {
        this.mouseID = mouseID;
    }

    public void setPantallaID(int pantallaID) {
        this.pantallaID = pantallaID;
    }

    public void setTecladoID(int tecladoID) {
        this.tecladoID = tecladoID;
    }

    public void setTorreID(int torreID) {
        this.torreID = torreID;
    }

}
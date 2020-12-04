package edu.eci.cvds.managedBeans;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


import com.google.inject.Inject;
import com.google.inject.Injector;
import edu.eci.cvds.samples.services.serviciosHistorialEquipos;

import java.util.Date;

@ManagedBean(name = "equipoBean")
@SessionScoped
public class EquipoBean extends BasePageBean {

    @Inject
    private serviciosHistorialEquipos serviciosHistorialEquipos;

    private int id;
    private String nombre;
    private String laboratorioId;
    private boolean activo;
    private int pantallaID;
    private int mouseID = 0;
    private int torreID = 0;
    private int tecladoID = 0;


    public void registrar() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            serviciosHistorialEquipos.registrarEquipo(nombre,laboratorioId);
            int ma=serviciosHistorialEquipos.mayorEquipo();
            if(mouseID !=0){
                serviciosHistorialEquipos.asociarElemento(mouseID, ma,"Mouse");
            }if(pantallaID !=0){
                serviciosHistorialEquipos.asociarElemento(pantallaID, ma,"Pantalla");
            }if(torreID !=0){
                serviciosHistorialEquipos.asociarElemento(torreID, ma,"Torre");
            }if(tecladoID !=0){
                serviciosHistorialEquipos.asociarElemento(tecladoID, ma, "Teclado");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
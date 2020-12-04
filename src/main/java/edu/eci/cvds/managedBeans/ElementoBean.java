package edu.eci.cvds.managedBeans;

import org.apache.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import edu.eci.cvds.samples.entities.Elemento;

import com.google.inject.Inject;
import edu.eci.cvds.samples.services.serviciosHistorialEquipos;

import java.util.ArrayList;
import java.util.Date;

@ManagedBean(name = "elementoBean")
@ApplicationScoped
public class ElementoBean extends BasePageBean {

    @Inject
    private serviciosHistorialEquipos serviciosHistorialEquipos;

    //private Injector injector;
    private int id;
    private String marca;
    private String tipo;
    private String nombre;
    private int idElem;
    private int idEqui;
    private boolean activo;
    private Elemento selectedElemento;

    public Elemento getSelectedElemento() {
        return selectedElemento;
    }

    public void setSelectedElemento(Elemento selectedElemento) {
        this.selectedElemento = selectedElemento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdEqui() {
        return idEqui;
    }

    public int getIdElem() {
        return idElem;
    }

    public void setIdElem(int idElem) {
        this.idElem = idElem;
    }

    public void setIdEqui(int idEqui) {
        this.idEqui = idEqui;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void registrarElemento() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            System.out.println("entre");
            serviciosHistorialEquipos.registrarElemento(tipo, marca, nombre, idEqui);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error", "Es posible que este tratando de ingresar una ID ya registrada"));
        }
    }

    public ArrayList<Elemento> getElementos(){
        FacesContext context = FacesContext.getCurrentInstance();
        return serviciosHistorialEquipos.reporteElementos();
    }

    public void asociarElemento() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            serviciosHistorialEquipos.asociarElemento(idElem, idEqui);
            java.util.Date fecha = new Date();
            //serviciosHistorialEquipos.registrarNovedadElemento(idElem, idEqui, fecha, "Cambio de asociación", laboratorioServices.getUsuario(SecurityUtils.getSubject().getPrincipal().toString()).getUserName(), "Se asocio el elemento registrado con la ID:"+idElem+" al equipo registrado con la ID:"+idEqui);
        }
        catch(Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error", "Es posible que este tratando de ingresar una ID ya registrada"));
        }
    }

    public void darDeBaja(int elemento) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            serviciosHistorialEquipos.darDeBajaElemento(elemento);
        }
        catch(Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("registrarEquipo.xhtml", new FacesMessage("Error", "No fue posible Desasociar"));
        }

    }

}

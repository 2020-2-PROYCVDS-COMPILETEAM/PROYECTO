package edu.eci.cvds.managedBeans;

import org.apache.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import edu.eci.cvds.samples.entities.Elemento;

import com.google.inject.Inject;
import edu.eci.cvds.samples.services.serviciosHistorialEquipos;

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
    private int idEqui = -1;
    private boolean activo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void registrarElemento() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            serviciosHistorialEquipos.registrarElemento(tipo, marca, nombre, idEqui);
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error", "Es posible que este tratando de ingresar una ID ya registrada"));
        }
    }

}

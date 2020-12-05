package edu.eci.cvds.managedBeans;

import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.entities.Novedad;
import org.apache.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import edu.eci.cvds.samples.entities.Elemento;

import com.google.inject.Inject;
import edu.eci.cvds.samples.services.serviciosHistorialEquipos;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.export.Exporter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private Equipo equipo;

    //modificar
    private String modificarNombre;
    private Boolean modificarActivo;
    private String modificarEquipo;

    //borrar
    private List<Elemento> selectedElementos;

    public ArrayList<Novedad> getNovedadesElemento() {
        return (ArrayList<Novedad>) serviciosHistorialEquipos.getNovedadesElemento(selectedElemento.getId());
    }

    public List<String> getNombreTeclado(){
        List<String> nombres= new ArrayList<String>();
        for(Elemento e:serviciosHistorialEquipos.reporteElementos()){
            if(e.getTipo().equals("teclado")){
                nombres.add(e.getNombre());
            }
        }
        return nombres;
    }
    public List<String> getNombreMouse(){
        List<String> nombres= new ArrayList<String>();
        for(Elemento e:serviciosHistorialEquipos.reporteElementos()){
            if(e.getTipo().equals("mouse")){
                nombres.add(e.getNombre());
            }
        }
        return nombres;
    }
    public List<String> getNombrePantalla(){
        List<String> nombres= new ArrayList<String>();
        for(Elemento e:serviciosHistorialEquipos.reporteElementos()){
            if(e.getTipo().equals("pantalla")){
                nombres.add(e.getNombre());
            }
        }
        return nombres;
    }
    public List<String> getNombreTorre(){
        List<String> nombres= new ArrayList<String>();
        for(Elemento e:serviciosHistorialEquipos.reporteElementos()){
            if(e.getTipo().equals("torre")){
                nombres.add(e.getNombre());
            }
        }
        return nombres;
    }

    public void darDeBaja(){
        serviciosHistorialEquipos.darDeBaja(selectedElementos);
        selectedElementos.clear();
    }

    public void modificarElemento(){
        serviciosHistorialEquipos.modificarElemento(selectedElemento.getId(),modificarNombre,modificarActivo,modificarEquipo);
    }

    public List<Elemento> getSelectedElementos() {
        return selectedElementos;
    }

    public void setSelectedElementos(List<Elemento> selectedElementos) {
        this.selectedElementos = selectedElementos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getModificarNombre() {
        return modificarNombre;
    }

    public void setModificarNombre(String modificarNombre) {
        this.modificarNombre = modificarNombre;
    }

    public Boolean getModificarActivo() {
        return modificarActivo;
    }

    public void setModificarActivo(Boolean modificarActivo) {
        this.modificarActivo = modificarActivo;
    }

    public String getModificarEquipo() {
        return modificarEquipo;
    }

    public void setModificarEquipo(String modificarEquipo) {
        this.modificarEquipo = modificarEquipo;
    }

    public List<String> nombreElementos(){
        List<String> nombres = new ArrayList<String>();
        for(Elemento e: getElementos()){
            nombres.add(e.getNombre());
        }
        return nombres;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

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

package edu.eci.cvds.managedBeans;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


import com.google.inject.Inject;
import com.google.inject.Injector;
import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.entities.Laboratorio;
import edu.eci.cvds.samples.services.serviciosHistorialEquipos;
import org.apache.shiro.SecurityUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "equipoBean")
@ApplicationScoped
public class EquipoBean extends BasePageBean {

    @Inject
    private serviciosHistorialEquipos serviciosHistorialEquipos;

    //registro
    private String rPantalla;
    private String rTeclado;
    private String rMouse;
    private String rTorre;
    private String rLaboratorio = null;

    private int id;
    private String nombre;
    private int laboratorioId;
    private boolean activo;
    private int pantallaID;
    private int mouseID;
    private int torreID;

    public int getElementoID() {
        return elementoID;
    }


    public void setElementoID(int elementoID) {
        this.elementoID = elementoID;
    }

    public List<Elemento> getElementos() {
        return serviciosHistorialEquipos.listarElementos();
    }

    public List<Equipo> getEquiposs() {
        return serviciosHistorialEquipos.listarEquipos();
    }


    public int getEquipoID() {
        return equipoID;
    }

    public void setEquipoID(int equipoID) {
        this.equipoID = equipoID;
    }

    private int tecladoID;
    private String descripcion;

    private Equipo  selectedEquipo;
    private Equipo equipo;

    private int elementoID;
    private int equipoID;

    //modificar
    private String modificarNombre;
    private String modificaLaboratorio;
    private Boolean modificarActivo;


    //borrar
    private List<Equipo> selectedEquipos;


    public void darDeBaja(){
        serviciosHistorialEquipos.darDeBajaEquipos(selectedEquipos);
        selectedEquipos.clear();
    }

    public void modificarEquipo(){
        for(Laboratorio l: serviciosHistorialEquipos.reporteLaboratorios()){
            if (l.getNombre().equals(modificaLaboratorio)){
                laboratorioId = l.getId();
            }
        }
        serviciosHistorialEquipos.modificarEquipo(modificarNombre,laboratorioId,modificarActivo,selectedEquipo.getId());
    }

    public String getModificarNombre() {
        return modificarNombre;
    }

    public void setModificarNombre(String modificarNombre) {
        this.modificarNombre = modificarNombre;
    }

    public String getModificaLaboratorio() {
        return modificaLaboratorio;
    }

    public void setModificaLaboratorio(String modificaLaboratorio) {
        this.modificaLaboratorio = modificaLaboratorio;
    }

    public Boolean getModificarActivo() {
        return modificarActivo;
    }

    public void setModificarActivo(Boolean modificarActivo) {
        this.modificarActivo = modificarActivo;
    }

    public Equipo getSelectedEquipo() {
        return selectedEquipo;
    }

    public void setSelectedEquipo(Equipo selectedEquipo) {
        this.selectedEquipo = selectedEquipo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<Equipo> getSelectedEquipos() {
        return selectedEquipos;
    }

    public void setSelectedEquipos(List<Equipo> selectedEquipos) {
        this.selectedEquipos = selectedEquipos;
    }

    public ArrayList<Equipo> getEquipos(){
        FacesContext context = FacesContext.getCurrentInstance();
        return serviciosHistorialEquipos.reporteEquipos();
    }

    public String getrLaboratorio() {
        return rLaboratorio;
    }

    public void setrLaboratorio(String rLaboratorio) {
        this.rLaboratorio = rLaboratorio;
    }

    public String getrPantalla() {
        return rPantalla;
    }

    public void setrPantalla(String rPantalla) {
        this.rPantalla = rPantalla;
    }

    public String getrTeclado() {
        return rTeclado;
    }

    public void setrTeclado(String rTeclado) {
        this.rTeclado = rTeclado;
    }

    public String getrMouse() {
        return rMouse;
    }

    public void setrMouse(String rMouse) {
        this.rMouse = rMouse;
    }

    public String getrTorre() {
        return rTorre;
    }

    public void setrTorre(String rTorre) {
        this.rTorre = rTorre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void registrar() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            for(Laboratorio l: serviciosHistorialEquipos.reporteLaboratorios()){
                if (l.getNombre().equals(rLaboratorio)){
                    laboratorioId = l.getId();
                }
            }
            serviciosHistorialEquipos.registrarEquipo(nombre,laboratorioId,descripcion);

            int ma=serviciosHistorialEquipos.mayorEquipo();
            System.out.println(ma);
            for(Elemento e: serviciosHistorialEquipos.reporteElementos()){
                if (e.getNombre().equals(rPantalla) && e.getTipo().equals("pantalla")){
                    pantallaID = e.getId();
                }else if (e.getNombre().equals(rMouse) && e.getTipo().equals("mouse")){
                    mouseID = e.getId();
                }else if (e.getNombre().equals(rTeclado) && e.getTipo().equals("teclado")){
                    tecladoID = e.getId();
                }else if (e.getNombre().equals(rTorre) && e.getTipo().equals("torre")){
                    torreID = e.getId();
                }
            }
            serviciosHistorialEquipos.asociarElemento(mouseID, ma);
            serviciosHistorialEquipos.asociarElemento(pantallaID, ma);
            serviciosHistorialEquipos.asociarElemento(torreID, ma);
            serviciosHistorialEquipos.asociarElemento(tecladoID, ma);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void asociarElemento() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            serviciosHistorialEquipos.asociarElemento(elementoID, equipoID);
            java.util.Date fecha = new Date();
            //         serviciosHistorialEquipos.registrarNovedadElemento(elementoID, equipoID, fecha, "Cambio de asociación", serviciosHistorialEquipos.getUsuario(SecurityUtils.getSubject().getPrincipal().toString()).getUserName(), "Se asocio el elemento registrado con la ID:"+elementoID+" al equipo registrado con la ID:"+equipoID);
        }
        catch(Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error", "Es posible que este tratando de ingresar una ID ya registrada"));
        }
    }

    public List<String> getNombreEquipos(){
        List<String> nombres= new ArrayList<String>();
        for(Equipo e:reporteEquipos()){
            nombres.add(e.getNombre());
        }
        return nombres;
    }

    public ArrayList<Equipo> reporteEquipos(){
        return serviciosHistorialEquipos.reporteEquipos();
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

    public int getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(int laboratorioId) {
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
package edu.eci.cvds.managedBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.entities.Laboratorio;
import edu.eci.cvds.samples.services.serviciosHistorialEquipos;


@ManagedBean(name = "laboratorioBean")
@SessionScoped
public class LaboratorioBean extends BasePageBean {

    @Inject
    private serviciosHistorialEquipos serviciosHistorialEquipos;


    private int id;
    private String nombre;
    private String descripcion;
    private Date fechadecreacion;
    private Date fechadecierre;
    private boolean activo;
    private List<Equipo> equipos = new ArrayList<Equipo>();
    private List<Laboratorio> laboratorios;
    private Laboratorio laboratorio;

    public Date getFechadecierre() {
        return fechadecierre;
    }

    public void setFechadecierre(Date fechadecierre) {
        this.fechadecierre = fechadecierre;
    }

    public void setLaboratorios(List<Laboratorio> laboratorios) {
        this.laboratorios = laboratorios;
    }

    //seleccion
    private List<Laboratorio> selectedLaboratorios;

    public void cerrar(){
        fechadecierre = new Date();
        serviciosHistorialEquipos.cerrarLaboratorios(selectedLaboratorios,fechadecierre);
    }

    public Date getFechadecreacion() {
        return fechadecreacion;
    }

    public void setFechadecreacion(Date fechadecreacion) {
        this.fechadecreacion = fechadecreacion;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public List<Laboratorio> getSelectedLaboratorios() {
        return selectedLaboratorios;
    }

    public void setSelectedLaboratorios(List<Laboratorio> selectedLaboratorios) {
        this.selectedLaboratorios = selectedLaboratorios;
    }

    public void setLaboratorios(ArrayList<Laboratorio> laboratorios) {
        this.laboratorios = laboratorios;
    }

    public void registrar() {
        try {
            fechadecreacion = new Date();
            serviciosHistorialEquipos.crearLaboratorio(nombre,descripcion,fechadecreacion);
            for (Equipo e:equipos) {
                serviciosHistorialEquipos.asociarLaboratorio(nombre ,e.getId());
            }
        }
        catch(Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error", "No fue posible el registro"));
        }

    }
    public ArrayList<Laboratorio> reporteLaboratorios() {
        return serviciosHistorialEquipos.reporteLaboratorios();
    }

    public List<String> getNombreLaboratorios(){
        ArrayList<String> nombres = new ArrayList<String>();
        for(Laboratorio l: reporteLaboratorios()){
            nombres.add(l.getNombre());
        }
        return nombres;
    }


    public List<Equipo> getEquipos(){
        return equipos;
    }

    public List<Equipo> getEquiposDisponibles(){
        return serviciosHistorialEquipos.listarEquiposDisponibles();
    }

    public List<Laboratorio> getLaboratorios() {
        return serviciosHistorialEquipos.reporteLaboratorios();
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
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void asociar(Equipo eq) {
        equipos.add(eq);
    }

    public void asociar(){
        for (Equipo e:equipos) {
            System.out.println(4);
            serviciosHistorialEquipos.asociarLaboratorio(nombre, e.getId());
            Date fecha = new Date();
            serviciosHistorialEquipos.registrarNovedadEquipo(e.getId(),"asociar",fecha,"se realizo una asociacion",nombre);
            System.out.println(5);
        }
    }

    public void desasociar(Equipo eq) {
        serviciosHistorialEquipos.desasociarLaboratorio(eq.getId());
        equipos.remove(eq);
    }

}

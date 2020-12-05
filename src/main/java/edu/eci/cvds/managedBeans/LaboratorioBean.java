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
    private boolean activo;
    private List<Equipo> equipos = new ArrayList<Equipo>();
    private ArrayList<Laboratorio> laboratorios = new ArrayList<Laboratorio>();
    private Laboratorio laboratorio;

    public void setLaboratorios(ArrayList<Laboratorio> laboratorios) {
        this.laboratorios = laboratorios;
    }

    public void registrar() {
        try {
            System.out.println(1);
            fechadecreacion = new Date();
            System.out.println(2);
            serviciosHistorialEquipos.crearLaboratorio(nombre,descripcion,fechadecreacion);
            System.out.println(3);
            for (Equipo e:equipos) {
                System.out.println(4);
                serviciosHistorialEquipos.asociarLaboratorio(nombre ,e.getId());
                System.out.println(5);
            }
            System.out.println(6);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            FacesContext context = FacesContext.getCurrentInstance();
            System.out.println(8);
            context.addMessage(null, new FacesMessage("Error", "No fue posible el registro"));
            System.out.println(9);
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

    public ArrayList<Laboratorio> getLaboratorios() {
        FacesContext context = FacesContext.getCurrentInstance();
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

    public void desasociar(Equipo eq) {
        serviciosHistorialEquipos.desasociarLaboratorio(eq.getId());
        equipos.remove(eq);
    }

}

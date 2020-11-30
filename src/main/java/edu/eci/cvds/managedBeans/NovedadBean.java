package edu.eci.cvds.managedBeans;


import edu.eci.cvds.samples.services.serviciosHistorialEquipos;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Date;

@ManagedBean(name = "novedadBean")
@ApplicationScoped
public class NovedadBean {

    @Inject
    private serviciosHistorialEquipos serviciosHistorialEquipos;

    /*private Injector injector;*/
    private int id;
    private int id_elemento;
    private int id_equipo;
    private String usuario;
    private Date fecha;
    private String detalle;
    private String nombre;
    private String tipo;

    public void registrar() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            //usuarioId = serviciosHistorialEquipos.getUsuario(SecurityUtils.getSubject().getPrincipal().toString()).getUserName();
            if (tipo.equals("Equipo")) {
                serviciosHistorialEquipos.registrarNovedadEquipo(id_elemento, fecha, nombre, usuario, detalle);
            }
            else{
                id_equipo = serviciosHistorialEquipos.getEquipoID(id_elemento);
                serviciosHistorialEquipos.registrarNovedadElemento(id_elemento, id_equipo, fecha, nombre, usuario, detalle);
            }
        }
        catch(Exception e) {

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error", "Imposible registrar"));
        }


    }

}

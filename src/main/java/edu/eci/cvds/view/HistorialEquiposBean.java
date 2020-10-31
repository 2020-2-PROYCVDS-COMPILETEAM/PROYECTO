package edu.eci.cvds.view;


import com.google.inject.Inject;
import edu.eci.cvds.samples.services.serviciosHistorialEquipos;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "HistorialEquiposBean")
@ApplicationScoped
public class HistorialEquiposBean extends BasePageBean {

    @Inject
    private serviciosHistorialEquipos servicioHistorialEquipos;

}
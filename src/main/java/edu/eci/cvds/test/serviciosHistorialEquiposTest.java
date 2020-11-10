package edu.eci.cvds.test;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Equipo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.Assert;

import edu.eci.cvds.samples.services.serviciosHistorialEquipos;
import edu.eci.cvds.samples.services.excepcionServiciosHistorialEquipos;
import edu.eci.cvds.samples.services.serviciosHistorialEquiposFactory;

import java.util.ArrayList;

public class serviciosHistorialEquiposTest {

    @Inject
    private SqlSession sqlSession;

    serviciosHistorialEquipos serviciosHistorialEquipos;
    private boolean True;


    public serviciosHistorialEquiposTest() {
        serviciosHistorialEquipos = serviciosHistorialEquiposFactory.getInstance().getServiciosHistorialEquiposTesting();
    }

    @Test
    public void pruebaInsertarEquipo(){
        ArrayList<Elemento> lista = new ArrayList<Elemento>();
        Equipo equipo = new Equipo(5, "como fua",True, lista, "como fua");
       // Assert.assertEquals(equipo,serviciosHistorialEquipos.registrarEquipo("como fua","como fua"));

    }
}
package edu.eci.cvds.test;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Equipo;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import edu.eci.cvds.samples.services.serviciosHistorialEquipos;

import java.util.ArrayList;

public class serviciosHistorialEquiposTest {

    @Inject
    private SqlSession sqlSession;

    serviciosHistorialEquipos serviciosHistorialEquipos;
    private boolean True;


    @Test
    public void pruebaInsertarEquipo(){
        ArrayList<Elemento> lista = new ArrayList<Elemento>();
        Equipo equipo = new Equipo(5, 3,True, lista, "como fua");
       // Assert.assertEquals(equipo,serviciosHistorialEquipos.registrarEquipo("como fua","como fua"));

    }
}
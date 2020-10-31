package edu.eci.cvds.test;

import com.google.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.Assert;

import edu.eci.cvds.samples.services.serviciosHistorialEquipos;
import edu.eci.cvds.samples.services.excepcionServiciosHistorialEquipos;
import edu.eci.cvds.samples.services.serviciosHistorialEquiposFactory;

public class serviciosHistorialEquiposTest {

    @Inject
    private SqlSession sqlSession;

    serviciosHistorialEquipos serviciosHistorialEquipos;


    public serviciosHistorialEquiposTest() {
        serviciosHistorialEquipos = serviciosHistorialEquiposFactory.getInstance().getServiciosHistorialEquiposTesting();
    }

    @Test
    public void prueba(){
        Assert.assertTrue(true);
    }
}
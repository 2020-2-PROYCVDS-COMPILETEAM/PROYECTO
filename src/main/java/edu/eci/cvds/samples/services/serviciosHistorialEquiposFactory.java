package edu.eci.cvds.samples.services;

import com.google.inject.Injector;
import edu.eci.cvds.samples.dao.ElementoDAO;
import edu.eci.cvds.samples.dao.EquipoDAO;
import edu.eci.cvds.samples.dao.UsuarioDAO;
import edu.eci.cvds.samples.dao.mybatis.MyBATISElementoDAO;
import edu.eci.cvds.samples.dao.mybatis.MyBATISUsuarioDAO;
import edu.eci.cvds.samples.dao.mybatis.MyBatisEquipoDAO;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;

public class serviciosHistorialEquiposFactory {
    private static serviciosHistorialEquiposFactory instance = new serviciosHistorialEquiposFactory();
    private static Injector injector;
    private static Injector testInjector;

    public serviciosHistorialEquiposFactory(){
        injector = createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize(){
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config.xml");
                bind(ElementoDAO.class).to(MyBATISElementoDAO.class);
                bind(EquipoDAO.class).to(MyBatisEquipoDAO.class);
                bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
            }
        });

        testInjector = createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize(){
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config-h2.xml");
            }
        });
    }

    public serviciosHistorialEquipos getServiciosHistorialEquipos(){
        return injector.getInstance(serviciosHistorialEquipos.class);
    }

    public serviciosHistorialEquipos getServiciosHistorialEquiposTesting(){
        return testInjector.getInstance(serviciosHistorialEquipos.class);
    }

    public static serviciosHistorialEquiposFactory getInstance(){
        return instance;
    }
}

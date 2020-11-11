package edu.eci.cvds.samples.services;

import com.google.inject.Injector;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;

public class ServiciosHistorialFactory {

    private static final ServiciosHistorialFactory instance= new ServiciosHistorialFactory();
    private static Injector injector;
    private static Injector testInjector;

    public ServiciosHistorialFactory(){
        injector = createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config.xml");
            }
        });

        testInjector = createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config-h2.xml");
            }
        });

    }

    public ServiciosHistorialFactory getServiciosHistorialEquipos(){
        return injector.getInstance(ServiciosHistorialFactory.class);
    }

    public ServiciosHistorialFactory getServiciosHistorialEquiposTesting(){
        return testInjector.getInstance(ServiciosHistorialFactory.class);
    }

    public ServiciosHistorialFactory getInstance(){
        return instance;
    }

}

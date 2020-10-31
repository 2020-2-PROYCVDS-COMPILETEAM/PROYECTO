package edu.eci.cvds.samples.services;

import com.google.inject.Injector;
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

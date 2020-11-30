package edu.eci.cvds.samples.services;

import com.google.inject.Injector;
import edu.eci.cvds.authc.SessionLogger;
import edu.eci.cvds.authc.ShiroSession;
import edu.eci.cvds.samples.dao.*;
import edu.eci.cvds.samples.dao.mybatis.*;
import edu.eci.cvds.samples.services.impl.serviciosHistorialEquiposImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class ServiciosHistorialFactory {

    private static ServiciosHistorialFactory instance= new ServiciosHistorialFactory();

    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);

                bind(ElementoDAO.class).to(MyBATISElementoDAO.class);
                bind(EquipoDAO.class).to(MyBatisEquipoDAO.class);
                bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
                bind(NovedadDAO.class).to(MyBATISNovedadDAO.class);
                bind(serviciosHistorialEquipos.class).to(serviciosHistorialEquiposImpl.class);
                bind(SessionLogger.class).to(ShiroSession.class);
                bind(LaboratorioDAO.class).to(MyBatisLaboratorioDAO.class);

            }
        });
    }

    public ServiciosHistorialFactory getServiciosHistorialEquipos(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }
        return optInjector.get().getInstance(ServiciosHistorialFactory.class);

    }

    public ServiciosHistorialFactory getServiciosHistorialEquiposTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config-h2.xml"));
        }
        return optInjector.get().getInstance(ServiciosHistorialFactory.class);
    }

    public static ServiciosHistorialFactory getInstance(){
        return instance;
    }

    public SessionLogger getLogServices(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }
        return optInjector.get().getInstance(SessionLogger.class);
    }

}

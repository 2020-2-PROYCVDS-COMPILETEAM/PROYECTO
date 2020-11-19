package edu.eci.cvds.samples.services;

import com.google.inject.Injector;
import edu.eci.cvds.authc.SessionLogger;
import edu.eci.cvds.authc.ShiroSession;
import edu.eci.cvds.samples.dao.ElementoDAO;
import edu.eci.cvds.samples.dao.EquipoDAO;
import edu.eci.cvds.samples.dao.UsuarioDAO;
import edu.eci.cvds.samples.dao.mybatis.MyBATISElementoDAO;
import edu.eci.cvds.samples.dao.mybatis.MyBATISUsuarioDAO;
import edu.eci.cvds.samples.dao.mybatis.MyBatisEquipoDAO;
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
                bind(serviciosHistorialEquipos.class).to(serviciosHistorialEquiposImpl.class);
                bind(SessionLogger.class).to(ShiroSession.class);

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

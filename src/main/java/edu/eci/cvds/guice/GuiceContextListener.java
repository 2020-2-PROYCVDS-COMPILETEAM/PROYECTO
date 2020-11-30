package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import edu.eci.cvds.authc.SessionLogger;
import edu.eci.cvds.authc.ShiroSession;
import edu.eci.cvds.samples.dao.*;
import edu.eci.cvds.samples.dao.mybatis.*;
import edu.eci.cvds.samples.services.ServiciosHistorialFactory;
import edu.eci.cvds.samples.services.impl.serviciosHistorialEquiposImpl;
import edu.eci.cvds.samples.services.serviciosHistorialEquipos;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Guice;
import com.google.inject.Injector;


public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");

                // TODO Add service class associated to Stub implementation
                bind(ElementoDAO.class).to(MyBATISElementoDAO.class);
                bind(EquipoDAO.class).to(MyBatisEquipoDAO.class);
                bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
                bind(NovedadDAO.class).to(MyBATISNovedadDAO.class);
                bind(serviciosHistorialEquipos.class).to(serviciosHistorialEquiposImpl.class);
                bind(SessionLogger.class).to(ShiroSession.class);
                bind(LaboratorioDAO.class).to(MyBatisLaboratorioDAO.class);
            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}
package edu.eci.cvds.managedBeans;



import com.google.inject.Inject;
import edu.eci.cvds.authc.SessionLogger;
import edu.eci.cvds.authc.ShiroSession;
import edu.eci.cvds.samples.Exceptions.PersistenceException;
import edu.eci.cvds.samples.services.ServiciosHistorialFactory;
import edu.eci.cvds.samples.services.serviciosHistorialEquipos;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

@SuppressWarnings("deprecation")
@ManagedBean(name="LoginBean")
@ApplicationScoped
public class LoginBean extends BasePageBean{

    @Inject
    private serviciosHistorialEquipos serviciosHistorialEquipos;

    private String username;
    private String contraseña;

    private SessionLogger logger = new ShiroSession();

    public String getUsername() {        return username;    }
    public String getContraseña() {        return contraseña;    }
    public void setUsername(String username) {        this.username = username;    }
    public void setContraseña(String contraseña) {        this.contraseña = contraseña;    }

    public Subject getCurrentUser() {
        Subject currentUser = SecurityUtils.getSubject();
        return currentUser;
    }

    public void login() throws PersistenceException{
        try{
            logger.login(username,contraseña);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/RegistrarEquipo.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

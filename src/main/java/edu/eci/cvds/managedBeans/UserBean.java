/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.managedBeans;

import java.io.IOException;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.google.inject.Inject;
import com.google.inject.Injector;
import edu.eci.cvds.samples.Exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.serviciosHistorialEquipos;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;

/**
 *
 * @author AsusPC
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean extends BasePageBean {

	@Inject
	private serviciosHistorialEquipos serviciosHistorialEquipos;

	// @Inject
	// private UserServices userServices;
	private Injector injector;
	private String username;
	private String password;
	private Usuario selectedUser;

	// private String usernameToUpdate;
	// private String typeToUpdate;

	public UserBean() {
		injector = super.getInjector();
		serviciosHistorialEquipos = injector.getInstance(serviciosHistorialEquipos.class);
	}

	/**
	 * Realiza la validación del usuario y le da ingreso a la pagina correspondiente
	 *
	 * @throws PersistenceException
	 */
	public void logIn() throws PersistenceException {
		System.out.println("LOGIN!!!!!!!!!!!!!!!!!!!!!");
		try {
			Subject currentUser = SecurityUtils.getSubject();
			String encript = new Sha256Hash(password).toHex();
			System.out.println(encript+" contraseña");
			UsernamePasswordToken token = new UsernamePasswordToken(username, encript);
			token.setRememberMe(true);
			currentUser.login(token);

			FacesContext.getCurrentInstance().getExternalContext().redirect("../admin/InicioAdmin.xhtml");
		} catch (UnknownAccountException uae) {
			System.out.println("1.LOGIN!!!!!!!!!!!!!!!!!!!!!");
			//username wasn't in the system, show them an error message?
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Error", "Usuario no encontrado"));
		} catch (IncorrectCredentialsException ice) {
			System.out.println("2.LOGIN!!!!!!!!!!!!!!!!!!!!!");
			//password didn't match, try again?
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Error", "Contraseña incorrecta"));
		} catch (IOException e) {
			System.out.println("3.LOGIN!!!!!!!!!!!!!!!!!!!!!");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Error", "Error de entrada"));
		} catch (Exception e) {
			System.out.println("4.LOGIN!!!!!!!!!!!!!!!!!!!!!");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Error", e.getMessage()));
		}

	}

	public void logout() {
		try {
			SecurityUtils.getSubject().logout();
			FacesContext.getCurrentInstance().getExternalContext().redirect("index.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario getUsuario(){
		try {
			if(SecurityUtils.getSubject().getPrincipal()==null) FacesContext.getCurrentInstance().getExternalContext().redirect("../../login/login.xhtml");

		}catch(Exception e) {
		}
		if(selectedUser==null && SecurityUtils.getSubject().getPrincipal()!=null) {
			selectedUser = serviciosHistorialEquipos.getUsuario(SecurityUtils.getSubject().getPrincipal().toString());
		}
		return selectedUser;
	}


	public String getUsername() {
		try {
			if(SecurityUtils.getSubject().getPrincipal()!=null) FacesContext.getCurrentInstance().getExternalContext().redirect("../admin/InicioAdmin.xhtml");
		} catch (Exception e) {
		}
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public void setSelectedUser(Usuario selectedUser) {
		this.selectedUser = selectedUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Usuario getSelectedUser() {
		return selectedUser;
	}
	/**
	 * public void setSelectedUser(User selectedUser) { this.selectedUser =
	 * selectedUser; }
	 **/
}


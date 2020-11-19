package edu.eci.cvds.authc;

import edu.eci.cvds.samples.Exceptions.PersistenceException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;

public class ShiroSession implements SessionLogger{

    @Override
    public void login(String username, String contraseña) throws PersistenceException {
        try{
            Subject currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, new Sha256Hash(contraseña).toHex());
            currentUser.getSession().setAttribute("username",username);
            currentUser.login( token );

        } catch ( UnknownAccountException e ) {
            throw new PersistenceException("Usuario incorrecto",e);
        } catch ( IncorrectCredentialsException b ) {
            throw new PersistenceException("Contraseña incorrecto",b);
        }

    }

    @Override
    public boolean isLogged() {
        return false;
    }

    @Override
    public void logout() {

    }
}

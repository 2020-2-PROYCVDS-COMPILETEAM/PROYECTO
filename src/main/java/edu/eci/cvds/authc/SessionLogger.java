package edu.eci.cvds.authc;

import edu.eci.cvds.samples.Exceptions.PersistenceException;

public interface SessionLogger {
    public void login(String username, String contraseña) throws PersistenceException;

    public boolean isLogged();

    public void logout();
}

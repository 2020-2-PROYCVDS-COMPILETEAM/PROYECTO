package edu.eci.cvds.samples.Exceptions;

public class PersistenceException extends Exception{
    public PersistenceException (String m,Exception e){
        super(m+e.toString());
    }
}
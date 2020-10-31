package edu.eci.cvds.samples.services;

public class excepcionServiciosHistorialEquipos extends Exception {
    public excepcionServiciosHistorialEquipos(String message){
        super(message);
    }
    public excepcionServiciosHistorialEquipos(String message, Exception e){
        super(message+e.toString());
    }
}


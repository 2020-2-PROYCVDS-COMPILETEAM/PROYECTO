package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Equipo;

import java.util.List;

public interface serviciosHistorialEquipos {

    public List<Equipo> listarEquipos();

    public void registrarEquipo(String nombre, String laboratorioId);

    public List<Equipo> equiposActivos();

    public int mayorEquipo();

    public int getEquipoID(int elementoId);

    public void darDeBajaEquipo(int equipo);

    public List<Equipo> listarEquiposDisponibles();

}

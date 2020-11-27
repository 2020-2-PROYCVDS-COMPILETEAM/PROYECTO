package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.entities.Elemento;

import java.util.ArrayList;
import java.util.List;

public interface serviciosHistorialEquipos {

    public List<Equipo> listarEquipos();

    public void registrarEquipo(String nombre, String laboratorioId);

    public List<Equipo> equiposActivos();

    public int mayorEquipo();

    public int getEquipoID(int elementoId);

    public void darDeBajaEquipo(int equipo);

    public List<Equipo> listarEquiposDisponibles();

    void registrarElemento(String tipo, String marca, String nombre, int id);

    void asociarElemento(int elementoID,int equipoID );

    public void darDeBajaElemento(int elemento);

    ArrayList<Elemento> reporteElementos();

}

package edu.eci.cvds.samples.dao;

import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Equipo;

import java.util.ArrayList;
import java.util.List;

public interface EquipoDAO {

    public List<Equipo> listarTodas();

    public  void registrar(String nombre,int laboratorioId,String descripcion) ;

    public List<Equipo> equiposActivos();

    public int mayor();


    public List<Equipo> listarLibres();

    public void asociar(String nombrelab, int equipoid);

    public void desasociar(int id);

    public void darDeBajaEquipo(int equipo);

    public List<Elemento> equipo(int id);


    ArrayList<Equipo> reporteEquipos();

    void modificarEquipo(String modificarNombre, int modificaLaboratorio, Boolean modificarActivo,int equipoId);
}

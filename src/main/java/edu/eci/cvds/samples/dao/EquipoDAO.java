package edu.eci.cvds.samples.dao;

import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Equipo;

import java.util.List;

public interface EquipoDAO {

    public List<Equipo> listarTodas();

    public  void registrar(String nombre, String laboratorioId) ;

    public List<Equipo> equiposActivos();

    public int mayor();


    public List<Equipo> listarLibres();

    public void asociar(String laboratorioid, int equipoid);

    public void desasociar(int id);

    public void darDeBajaEquipo(int equipo);

    public List<Elemento> equipo(int id);


}

package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Laboratorio;
import edu.eci.cvds.samples.entities.Novedad;

import java.util.ArrayList;
import java.util.Date;
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

    void crearLaboratorio(int id, String nombre, String descripcion, int capacidadDeEquipos);

    void asociarLaboratorio(int laboratorioid, int equipoid);

    List<Laboratorio> listarLaboratorios();

    void registrarNovedadElemento(int id_elemento, int id_equipo, String fecha, Date nombre, String usuario, String detalle);

    void registrarNovedadEquipo(int id_Equipo,Date fecha,String nombre,String usuario,String detalle);

    void desasociarLaboratorio(int id);

    ArrayList<Laboratorio> reporteLaboratorios();

    void modificarElemento(int id,String nombre, boolean activo, String equipo);

    void darDeBaja(List<Elemento> selectedElementos);

    ArrayList<Novedad> reporteNovedades();

}

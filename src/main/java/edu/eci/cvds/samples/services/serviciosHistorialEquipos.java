package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface serviciosHistorialEquipos {

    public List<Equipo> listarEquipos();

    public void registrarEquipo(String nombre,int laboratorioId,String descripcion);

    public List<Equipo> equiposActivos();

    public int mayorEquipo();

    public int getEquipoID(int elementoId);

    public void darDeBajaEquipo(int equipo);

    public List<Equipo> listarEquiposDisponibles();

    void registrarElemento(String tipo, String marca, String nombre, int id);

    void asociarElemento(int elementoID,int equipoID );

    public void darDeBajaElemento(int elemento);

    ArrayList<Elemento> reporteElementos();

    void crearLaboratorio( String nombre, String descripcion, Date fechadecreacioon);

    void asociarLaboratorio(String nombrelab, int equipoid);

    List<Laboratorio> listarLaboratorios();

    void registrarNovedadElemento(int id_elemento, int id_equipo, String fecha, Date nombre, String usuario, String detalle);

    void registrarNovedadEquipo(int id_Equipo,Date fecha,String nombre,String usuario,String detalle);

    void desasociarLaboratorio(int id);

    ArrayList<Laboratorio> reporteLaboratorios();

    void modificarElemento(int id,String nombre, boolean activo, String equipo);

    void darDeBaja(List<Elemento> selectedElementos);

    ArrayList<Novedad> reporteNovedades();

    List<String> getNombreElemento(String tipo);

    ArrayList<Equipo> reporteEquipos();

    void modificarEquipo(String modificarNombre,int modificaLaboratorio, Boolean modificarActivo, int equipoId);

    Usuario getUsuario(String userName);

    List<Novedad> getNovedadesElemento(int idelemento);

    void darDeBajaEquipos(List<Equipo> selectedEquipos);

    void registrarNovedadElemento2(int id_elemento, String usuario, Date fecha, String detalle, String nombre);
}

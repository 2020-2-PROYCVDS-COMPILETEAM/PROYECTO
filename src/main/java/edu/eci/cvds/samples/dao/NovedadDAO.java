package edu.eci.cvds.samples.dao;

import edu.eci.cvds.samples.entities.Novedad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface NovedadDAO {
    public void registrarNovedadEquipo(int id_equipo, Date fecha, String nombre, String usuario, String detalle);

    public void registrarNovedadElemento(int id_elemento, int id_equipo,String usuario, Date fecha,  String detalle, String nombre);

    ArrayList<Novedad> reporteNovedades();

    List<Novedad> getNovedadesElemento(int idelemento);

    void registrarNovedadElemento2(int id_elemento, String usuario, Date fecha, String detalle, String nombre);
}

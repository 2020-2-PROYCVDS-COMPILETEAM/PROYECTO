package edu.eci.cvds.samples.dao;

import java.util.Date;

public interface NovedadDAO {
    public void registrarNovedadEquipo(int id_equipo, Date fecha, String nombre, String usuario, String detalle);

    public void registrarNovedadElemento(int id_elemento, int id_equipo, Date fecha, String nombre, String usuario, String detalle);

}

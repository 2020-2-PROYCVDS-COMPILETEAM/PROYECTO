package edu.eci.cvds.samples.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.samples.dao.NovedadDAO;
import edu.eci.cvds.samples.dao.mybatis.mappers.NovedadMapper;
import edu.eci.cvds.samples.entities.Novedad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyBATISNovedadDAO implements NovedadDAO {

    @Inject
    private NovedadMapper novedadMapper;


    @Override
    public void registrarNovedadEquipo(int id_equipo, Date fecha, String nombre, String usuario, String detalle) {
        java.sql.Date fecha2 = new java.sql.Date(fecha.getTime());
        novedadMapper.registrarNovedadEquipo(id_equipo, fecha2, nombre, usuario, detalle);
    }

    @Override
    public void registrarNovedadElemento(int id_elemento, int id_equipo,String usuario, Date fecha,  String detalle, String nombre) {
        java.sql.Date fecha2 = new java.sql.Date(fecha.getTime());
        novedadMapper.registrarNovedadElemento( id_elemento, id_equipo, usuario, fecha2, detalle, nombre);
    }

    @Override
    public ArrayList<Novedad> reporteNovedades() {
        return novedadMapper.reporteNovedades();
    }

    @Override
    public List<Novedad> getNovedadesElemento(int idelemento) {
        return novedadMapper.getNovedadesElemento(idelemento);
    }

    @Override
    public void registrarNovedadElemento2(int id_elemento, String usuario, Date fecha, String detalle, String nombre) {
        java.sql.Date fecha2 = new java.sql.Date(fecha.getTime());
        novedadMapper.registrarNovedadElemento2( id_elemento, usuario, fecha2, detalle, nombre);
    }

}
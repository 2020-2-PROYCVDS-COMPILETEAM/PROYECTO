package edu.eci.cvds.samples.dao.mybatis.mappers;

import edu.eci.cvds.samples.entities.Novedad;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface NovedadMapper {

    void registrarNovedadEquipo(@Param("id_equipo") int id_equipo, @Param("fecha") Date fecha, @Param("nombre")String nombre, @Param("usuario") String usuario, @Param("detalle")String detalle);
    void registrarNovedadElemento( @Param("id_elemento")int id_elemento,@Param("id_equipo") int id_equipo,@Param("usuario") String usuario,@Param("fecha") Date fecha,
                                   @Param("detalle")String detalle,@Param("nombre")String nombre);

    ArrayList<Novedad> reporteNovedades();

    ArrayList<Novedad> getNovedadesElemento(@Param("idelemento") int idelemento);
}

package edu.eci.cvds.samples.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface NovedadMapper {

    void registrarNovedadEquipo(@Param("id_equipo") int id_equipo, @Param("fecha") Date fecha, @Param("nombre")String nombre, @Param("usuario") String usuario, @Param("detalle")String detalle);

    void registrarNovedadElemento(@Param("id_elemento")int id_elemento, @Param("id_equipo") int id_equipo, @Param("usuario") java.sql.Date usuario, @Param("fecha") String fecha,
                                  @Param("detalle")String detalle, @Param("nombre")String nombre);
}

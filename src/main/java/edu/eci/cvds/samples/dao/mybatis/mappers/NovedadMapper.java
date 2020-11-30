package edu.eci.cvds.samples.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface NovedadMapper {

    public void registrarNovedadEquipo(@Param("id_equipo") int id_equipo, @Param("fecha") Date fecha, @Param("nombre")String nombre, @Param("usuario") String usuario, @Param("detalle")String detalle);

    public void registrarNovedadElemento( @Param("id_elemento")int id_elemento,@Param("id_equipo") int id_equipo,@Param("fecha") Date fecha, @Param("nombre")String nombre,@Param("usuario") String usuario,
                                         @Param("detalle")String detalle);
}

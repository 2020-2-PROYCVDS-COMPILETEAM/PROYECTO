package edu.eci.cvds.samples.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

public interface ElementoMapper {

    void registrarElemento(@Param("tipo") String tipo, @Param("marca") String marca, @Param("nombre") String nombre);
}

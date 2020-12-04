package edu.eci.cvds.samples.dao.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Laboratorio;

public interface LaboratorioMapper {

    public List<Laboratorio> buscarLaboratorios();

    public void crear(@Param("id") String id,@Param("nombre") String nombre,@Param("descripcion") String descripcion,@Param("capacidadEquipos") int capacidadEquipos);




}

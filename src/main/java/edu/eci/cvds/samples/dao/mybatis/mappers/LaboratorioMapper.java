package edu.eci.cvds.samples.dao.mybatis.mappers;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Laboratorio;

public interface LaboratorioMapper {

    List<Laboratorio> buscarLaboratorios();

    void crear(@Param("id") int id, @Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("capacidadEquipos") int capacidadEquipos);

    ArrayList<Laboratorio> reporteLaboratorios();
}

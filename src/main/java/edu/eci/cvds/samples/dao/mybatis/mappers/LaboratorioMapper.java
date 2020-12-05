package edu.eci.cvds.samples.dao.mybatis.mappers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

import edu.eci.cvds.samples.entities.Elemento;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Laboratorio;

public interface LaboratorioMapper {

    List<Laboratorio> buscarLaboratorios();

    void crear( @Param("nombre") String nombre, @Param("descripcion") String descripcion,@Param("fechadecreacion") Date fechadecreacion);

    ArrayList<Laboratorio> reporteLaboratorios();

    void cerrarLaboratorio(@Param("id") int id,@Param("fechacierre") Date fechacierre);

}


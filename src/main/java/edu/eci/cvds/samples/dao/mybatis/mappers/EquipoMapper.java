package edu.eci.cvds.samples.dao.mybatis.mappers;

import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Equipo;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface EquipoMapper {

    public List<Equipo> buscarEquipos();

    public  void registrarEquipo(@Param("nombre") String nombre, @Param("laboratorioId") int laboratorioId,@Param("descripcion") String descripcion);

    public List<Equipo> equiposActivos();

    public Equipo mayor();

    public List<Equipo> equiposLibres();

    public void asociar(@Param("laboratorioid") int laboratorioid, @Param("equipoid") int equipoid);

    public void desasociar( @Param("id") int id);

    public void darDeBajaEquipo(@Param("equipo")int equipo);

    public List<Elemento> equipo(@Param("id")int id);

    ArrayList<Equipo> reporteEquipos();

    void modificarEquipo(@Param("nombre") String modificarNombre,@Param("laboratorio") int modificaLaboratorio,@Param("activo") Boolean modificarActivo,@Param("id") int equipoId );
}

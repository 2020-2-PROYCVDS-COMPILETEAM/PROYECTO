package edu.eci.cvds.samples.dao.mybatis.mappers;

import edu.eci.cvds.samples.entities.Elemento;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface ElementoMapper {

    void registrarElemento(@Param("tipo") String tipo, @Param("marca") String marca, @Param("nombre") String nombre);

    void asociarElemento(@Param("idElem") int elementoID,@Param("idEqui") int equipoID);

    void desasociarElemento(@Param("idElem")int idElem, @Param("idEqui")int idEqui);

    void darDeBajaElemento(@Param("elementoId")int elemento);

    Elemento getEquipoID(@Param("id") int elementoId);

    ArrayList<Elemento> reporteElementos();

    void modificarElemento(@Param("id") int id,@Param("nombre") String nombre,@Param("activo") boolean activo,@Param("equipo") String equipo);

    ArrayList<Elemento> getNombrePorTipo(@Param("tipo") String tipo);

    List<Elemento> listar();
}

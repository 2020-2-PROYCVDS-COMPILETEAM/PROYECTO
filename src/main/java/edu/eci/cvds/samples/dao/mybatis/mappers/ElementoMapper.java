package edu.eci.cvds.samples.dao.mybatis.mappers;

import edu.eci.cvds.samples.entities.Elemento;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface ElementoMapper {

    void registrarElemento(@Param("tipo") String tipo, @Param("marca") String marca, @Param("nombre") String nombre);

    void asociarElemento(@Param("idElem") int elementoID,@Param("idEqui") int equipoID);

    void desasociarElemento(@Param("idElem")int idElem, @Param("idEqui")int idEqui);

    void darDeBajaElemento(@Param("elementoId")int elemento);

    Elemento getEquipoID(@Param("id") int id);

    ArrayList<Elemento> reporteElementos();

}

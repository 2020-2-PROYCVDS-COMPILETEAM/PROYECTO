package edu.eci.cvds.samples.dao.mybatis;
import edu.eci.cvds.samples.dao.ElementoDAO;
import edu.eci.cvds.samples.dao.mybatis.mappers.ElementoMapper;
import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Elemento;

import java.util.ArrayList;
import java.util.List;


public class MyBATISElementoDAO implements ElementoDAO {

    @Inject
    private ElementoMapper elementoMapper;

    @Override
    public void registrarElemento(String tipo, String marca, String nombre, int id) {
        if (id == -1) {
            System.out.println("entre a my batis ellemento");
            elementoMapper.registrarElemento(tipo, marca, nombre);
        }
    }

    @Override
    public void asociarElemento(int elementoID, int equipoID) {
        try {
            elementoMapper.desasociarElemento(elementoID, elementoID);
            elementoMapper.asociarElemento(elementoID, equipoID);
        }catch (Exception e){
            System.out.println("No asocie");
        }
    }

    @Override
    public void darDeBajaElemento(int elemento) {
        elementoMapper.darDeBajaElemento(elemento);
    }

    @Override
    public int getElementoID(int elementoID) {
        return Integer.parseInt(elementoMapper.getEquipoID(elementoID).getEquipo());
    }

    @Override
    public ArrayList<Elemento> reporteElementos() {
        return elementoMapper.reporteElementos();
    }

    @Override
    public void modificarElemento(int id, String nombre, boolean activo, String equipo) {
        elementoMapper.modificarElemento(id, nombre,activo,equipo);
    }

    @Override
    public void darDeBaja(List<Elemento> selectedElementos) {
        for(Elemento e:selectedElementos){
            elementoMapper.darDeBajaElemento(e.getId());
        }
    }

    @Override
    public List<String> getNombreElemento(String tipo) {
        List<String> nombres = new ArrayList<String>();
        ArrayList<Elemento> elementosTipo = elementoMapper.getNombrePorTipo(tipo);
        for(Elemento e: elementosTipo){
            nombres.add(e.getNombre());
        }
        return nombres;
    }
}

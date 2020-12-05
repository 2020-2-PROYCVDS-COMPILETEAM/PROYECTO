package edu.eci.cvds.samples.dao;

import edu.eci.cvds.samples.entities.Elemento;

import java.util.ArrayList;
import java.util.List;

public interface ElementoDAO {

    void registrarElemento(String tipo, String marca, String nombre, int id);

    void asociarElemento(int elementoID, int equipoID);

    void darDeBajaElemento(int elemento);

    int getElementoID(int elementoID);

    ArrayList<Elemento> reporteElementos();

    void modificarElemento(int id, String nombre, boolean activo, String equipo);

    void darDeBaja(List<Elemento> selectedElementos);

    List<String> getNombreElemento(String tipo);

}

package edu.eci.cvds.samples.dao;

import edu.eci.cvds.samples.entities.Elemento;

import java.util.ArrayList;

public interface ElementoDAO {

    void registrarElemento(String tipo, String marca, String nombre, int id);

    void asociarElemento(int elementoID, int equipoID);

    void darDeBajaElemento(int elemento);

    ArrayList<Elemento> reporteElementos();
}

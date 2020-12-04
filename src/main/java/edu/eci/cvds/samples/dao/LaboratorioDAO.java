package edu.eci.cvds.samples.dao;

import java.util.ArrayList;
import java.util.List;

import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Laboratorio;

public interface LaboratorioDAO {

    List<Laboratorio> listar();

    void crear(int id,String nombre, String descripcion, int capacidadEquipos);

    public ArrayList<Laboratorio> reporteLaboratorios();





}

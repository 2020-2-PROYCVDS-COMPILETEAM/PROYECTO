package edu.eci.cvds.samples.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Laboratorio;

public interface LaboratorioDAO {

    public List<Laboratorio> listar();

    public void crear(String id, String nombre, String descripcion, int capacidadEquipos);





}
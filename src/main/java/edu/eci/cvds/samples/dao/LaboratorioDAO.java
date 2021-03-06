package edu.eci.cvds.samples.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Laboratorio;

public interface LaboratorioDAO {

    public List<Laboratorio> listar();

    public void crear( String nombre, String descripcion, Date fechadecreacion);

    public ArrayList<Laboratorio> reporteLaboratorios();

    void cerrarLaboratorio(int id,Date fechadecierre);
}

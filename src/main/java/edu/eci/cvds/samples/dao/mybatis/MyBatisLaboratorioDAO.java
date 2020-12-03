package edu.eci.cvds.samples.dao.mybatis;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Laboratorio;
import edu.eci.cvds.samples.dao.LaboratorioDAO;
import edu.eci.cvds.samples.dao.mybatis.mappers.LaboratorioMapper;

public class MyBatisLaboratorioDAO implements LaboratorioDAO {


    @Inject
    private LaboratorioMapper laboratorioMapper;

    @Override
    public List<Laboratorio> listar() {
        return laboratorioMapper.buscarLaboratorios();
    }

    @Override
    public void crear(String id, String nombre, String descripcion, int capacidadEquipos) {
        laboratorioMapper.crear(id,nombre,descripcion,capacidadEquipos);

    }
    @Override
    public ArrayList<Laboratorio> reporteLaboratorios() {
        return laboratorioMapper.reporteLaboratorios();
    }


}

package edu.eci.cvds.samples.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.samples.dao.EquipoDAO;
import edu.eci.cvds.samples.dao.mybatis.mappers.EquipoMapper;
import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Equipo;

import java.util.ArrayList;
import java.util.List;

public class MyBatisEquipoDAO implements EquipoDAO {

    @Inject
    private EquipoMapper equipoMapper;

    @Override
    public List<Equipo> listarTodas() {
        return equipoMapper.buscarEquipos();
    }

    @Override
    public void registrar(String nombre,int laboratorioId,String descripcion) {
        equipoMapper.registrarEquipo( nombre, laboratorioId, descripcion);
    }

    @Override
    public List<Equipo> equiposActivos() {
        return equipoMapper.equiposActivos();
    }

    @Override
    public int mayor() {
        return equipoMapper.mayor().getId();
    }

    @Override

    public List<Equipo> listarLibres() {
        return equipoMapper.equiposLibres();
    }


    @Override
    public void asociar(String nombrelab, int equipoid) {
        System.out.println(nombrelab+" "+equipoid);
        equipoMapper.asociar(nombrelab, equipoid);

    }

    @Override
    public void desasociar(int id) {
        equipoMapper.desasociar(id);

    }

    @Override
    public void darDeBajaEquipo(int equipo) {
        equipoMapper.darDeBajaEquipo(equipo);
    }

    @Override
    public List<Elemento> equipo(int id) {
        return equipoMapper.equipo(id);
    }

    @Override
    public ArrayList<Equipo> reporteEquipos() {
        return equipoMapper.reporteEquipos();
    }

    @Override
    public void modificarEquipo(String modificarNombre, int modificaLaboratorio, Boolean modificarActivo,int equipoId) {
        equipoMapper.modificarEquipo(modificarNombre,modificaLaboratorio,modificarActivo,equipoId);
    }


}

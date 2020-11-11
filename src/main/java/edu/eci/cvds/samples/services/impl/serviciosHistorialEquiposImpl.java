package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.samples.dao.ElementoDAO;
import edu.eci.cvds.samples.dao.EquipoDAO;
import edu.eci.cvds.samples.dao.UsuarioDAO;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.services.serviciosHistorialEquipos;

import java.util.List;

public class serviciosHistorialEquiposImpl implements serviciosHistorialEquipos {
    @Inject
    private EquipoDAO equipoDAO;

    @Inject
    private ElementoDAO elementoDAO;

    @Inject
    private UsuarioDAO usuarioDAO;


    @Override
    public List<Equipo> listarEquipos() {
        return null;
    }

    @Override
    public void registrarEquipo(String nombre, String laboratorioId) {
        equipoDAO.registrar(nombre,laboratorioId);
    }

    @Override
    public List<Equipo> equiposActivos() {
        return null;
    }

    @Override
    public int mayorEquipo() {
        return 0;
    }

    @Override
    public int getEquipoID(int elementoId) {
        return 0;
    }

    @Override
    public void darDeBajaEquipo(int equipo) {

    }

    @Override
    public void registrarElemento(String tipo, String marca,String nombre,int idEqui) {
        elementoDAO.registrarElemento(tipo,marca,nombre,idEqui);

    }

    @Override
    public List<Equipo> listarEquiposDisponibles() {
        return null;
    }

}

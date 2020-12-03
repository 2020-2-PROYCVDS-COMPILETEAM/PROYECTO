package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.samples.dao.*;
import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.entities.Laboratorio;
import edu.eci.cvds.samples.entities.Novedad;
import edu.eci.cvds.samples.services.serviciosHistorialEquipos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class serviciosHistorialEquiposImpl implements serviciosHistorialEquipos {
    @Inject
    private EquipoDAO equipoDAO;

    @Inject
    private ElementoDAO elementoDAO;

    @Inject
    private UsuarioDAO usuarioDAO;

    @Inject
    private LaboratorioDAO laboratorioDAO;

    @Inject
    private NovedadDAO novedadDAO;


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
        return equipoDAO.mayor();
    }

    @Override
    public int getEquipoID(int elementoId) {
        return elementoDAO.getElementoID(elementoId);
    }

    @Override
    public void darDeBajaEquipo(int equipo) {

    }

    @Override
    public void registrarElemento(String tipo, String marca,String nombre,int idEqui) {
        elementoDAO.registrarElemento(tipo,marca,nombre,idEqui);

    }

    @Override
    public void asociarElemento(int elementoID, int equipoID) {
        elementoDAO.asociarElemento(elementoID, equipoID);
    }

    @Override
    public void darDeBajaElemento(int elemento) {
        elementoDAO.darDeBajaElemento(elemento);
    }

    @Override
    public ArrayList<Elemento> reporteElementos() {
        return elementoDAO.reporteElementos();
    }

    @Override
    public void crearLaboratorio(String id, String nombre, String descripcion, int capacidadEquipos) {
        laboratorioDAO.crear(id,nombre,descripcion,capacidadEquipos);
    }

    @Override
    public void asociarLaboratorio(String laboratorioid, int equipoid) {
        equipoDAO.asociar(laboratorioid,equipoid);

    }

    @Override
    public List<Laboratorio> listarLaboratorios() {
        return laboratorioDAO.listar();
    }

    @Override
    public void registrarNovedadElemento(int id_elemento, int id_equipo, Date fecha, String nombre, String usuario, String detalle) {
        novedadDAO.registrarNovedadElemento(id_elemento,id_equipo,fecha,nombre,usuario,detalle);
    }

    @Override
    public void registrarNovedadEquipo(int id_equipo, Date fecha, String nombre, String usuario, String detalle) {
        novedadDAO.registrarNovedadEquipo(id_equipo,fecha,nombre,usuario,detalle);
    }

    @Override
    public void desasociarLaboratorio(int id) {
        equipoDAO.desasociar(id);

    }

    @Override
    public  ArrayList<Laboratorio> reporteLaboratorios() {
        return laboratorioDAO.reporteLaboratorios();
    }

    @Override
    public List<Equipo> listarEquiposDisponibles() {
        return equipoDAO.listarTodas();
    }

}

package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.samples.dao.*;
import edu.eci.cvds.samples.entities.*;
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
    public void registrarEquipo(String nombre,int laboratorioId,String descripcion) {
        equipoDAO.registrar( nombre, laboratorioId, descripcion);
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
    public void crearLaboratorio(String nombre, String descripcion, Date fechadecreacion) {
        laboratorioDAO.crear(nombre,descripcion,fechadecreacion);
    }

    @Override
    public void asociarLaboratorio(String nombrelab, int equipoid) {
        equipoDAO.asociar(nombrelab,equipoid);

    }

    @Override
    public List<Laboratorio> listarLaboratorios() {
        return laboratorioDAO.listar();
    }

    @Override
    public void registrarNovedadElemento(int id_elemento, int id_equipo, String fecha, Date nombre, String usuario, String detalle) {
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
    public void modificarElemento(int id, String nombre, boolean activo, String equipo) {
        elementoDAO.modificarElemento(id, nombre,activo,equipo);
    }

    @Override
    public void darDeBaja(List<Elemento> selectedElementos) {
        elementoDAO.darDeBaja(selectedElementos);
    }

    @Override
    public ArrayList<Novedad> reporteNovedades() {
        return novedadDAO.reporteNovedades();
    }

    @Override
    public List<String> getNombreElemento(String tipo) {
        return null;
    }

    @Override
    public ArrayList<Equipo> reporteEquipos() {
        return equipoDAO.reporteEquipos();
    }

    @Override
    public void modificarEquipo(String modificarNombre, int modificaLaboratorio, Boolean modificarActivo,int equipoId) {
        equipoDAO.modificarEquipo(modificarNombre,modificaLaboratorio,modificarActivo,equipoId);
    }

    @Override
    public List<Equipo> listarEquiposDisponibles() {
        return equipoDAO.listarTodas();
    }

    @Override
    public Usuario getUsuario(String userName) {
        return usuarioDAO.getUserName(userName);
    }

    @Override
    public List<Novedad> getNovedadesElemento(int idelemento) {
        return novedadDAO.getNovedadesElemento(idelemento);
    }

    @Override
    public void darDeBajaEquipos(List<Equipo> selectedEquipos) {
        for(Equipo e: selectedEquipos){
            equipoDAO.darDeBajaEquipo(e.getId());
        }

    }

    @Override
    public void registrarNovedadElemento2(int id_elemento, String usuario, Date fecha, String detalle, String nombre) {
        novedadDAO.registrarNovedadElemento2(id_elemento,usuario,fecha,detalle,nombre);
    }

}

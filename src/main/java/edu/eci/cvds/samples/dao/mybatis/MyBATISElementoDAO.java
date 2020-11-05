package edu.eci.cvds.samples.dao.mybatis;
import edu.eci.cvds.samples.dao.ElementoDAO;
import edu.eci.cvds.samples.dao.mybatis.mappers.ElementoMapper;
import com.google.inject.Inject;

public class MyBATISElementoDAO implements ElementoDAO {

    @Inject
    private ElementoMapper elementoMapper;

    @Override
    public void registrarElemento(String tipo, String marca, String nombre, int id) {
        elementoMapper.registrarElemento(tipo,marca,nombre);
    }
}

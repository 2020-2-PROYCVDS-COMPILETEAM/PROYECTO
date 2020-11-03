package edu.eci.cvds.samples.dao.mybatis;
import edu.eci.cvds.samples.dao.mybatis.mappers.ElementoMapper;
import com.google.inject.Inject;

public class MyBATISElementoDAO implements ElementoMapper{

    @Inject
    private ElementoMapper elementoMapper;

    @Override
    public void registrarElemento(String tipo, String marca, String nombre) {
        elementoMapper.registrarElemento(tipo,marca,nombre);
    }
}

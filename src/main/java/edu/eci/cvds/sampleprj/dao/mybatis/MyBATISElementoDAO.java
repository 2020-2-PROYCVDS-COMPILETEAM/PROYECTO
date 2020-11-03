package edu.eci.cvds.sampleprj.dao.mybatis;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ElementoMapper;
import com.google.inject.Inject;
import org.apache.ibatis.annotations.Param;

public class MyBATISElementoDAO implements ElementoMapper{

    @Inject
    private ElementoMapper elementoMapper;

    @Override
    public void registrarElemento(String tipo, String marca, String nombre) {
        elementoMapper.registrarElemento(tipo,marca,nombre);
    }
}

package dev.compaoli.finance.services;

import dev.compaoli.finance.repositorys.GastoRepository;
import dev.compaoli.finance.entitys.Gasto;
import dev.compaoli.finance.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GastoService {

    private final CategoriaService serviceCateg = new CategoriaService() ;

    @Autowired
    GastoRepository repo ;

    public GastoService() {

    }

    public Gasto agregarGasto(Gasto gasto) throws ServiceException {
        try {
            return repo.save(gasto) ;
        } catch (Exception e) {
            throw new ServiceException("Hubo un error en la conexion...") ;
        }
    }

}

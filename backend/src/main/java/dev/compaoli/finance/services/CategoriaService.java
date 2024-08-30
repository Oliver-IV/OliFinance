package dev.compaoli.finance.services;

import dev.compaoli.finance.repositorys.CategoriaRepository;
import dev.compaoli.finance.entitys.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repo ;

    public Categoria buscarCategoria(String nombre_categoria) {
        return repo.findByNombre(nombre_categoria) ;
    }

    public Categoria agregarCategoria(Categoria categoria) {
        return repo.save(categoria) ;
    }

    public List<Categoria> agregarCategorias(List<Categoria> categorias) {
        return repo.saveAll(categorias) ;
    }
}

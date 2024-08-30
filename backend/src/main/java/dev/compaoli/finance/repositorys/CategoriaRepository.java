package dev.compaoli.finance.repositorys;

import dev.compaoli.finance.entitys.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    @Override
    <S extends Categoria> S save(S entity);

    @Override
    <S extends Categoria> List<S> saveAll(Iterable<S> entities);

    Categoria findByNombre(String nombre) ;
}

package dev.compaoli.finance.repositorys;

import dev.compaoli.finance.entitys.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Long> {

    @Override
    <S extends Gasto> S save(S entity);

//    @Query("SELECT g FROM gasto WHERE ")
//    List<Gasto> findAllGastosUsuario() ;
}

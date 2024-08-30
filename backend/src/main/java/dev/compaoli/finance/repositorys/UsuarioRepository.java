package dev.compaoli.finance.repositorys;

import dev.compaoli.finance.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Override
    <S extends Usuario> S save(S entity);

    Usuario findUsuarioByEmail(String email) ;

}

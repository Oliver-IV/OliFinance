package dev.compaoli.finance.services;

import dev.compaoli.finance.repositorys.CategoriaRepository;
import dev.compaoli.finance.dto.GastoDTO;
import dev.compaoli.finance.entitys.Categoria;
import dev.compaoli.finance.entitys.Gasto;
import dev.compaoli.finance.entitys.Usuario;
import dev.compaoli.finance.exceptions.ServiceException;
import dev.compaoli.finance.repositorys.GastoRepository;
import dev.compaoli.finance.repositorys.UsuarioRepository;
import dev.compaoli.finance.utils.Convertor;
import dev.compaoli.finance.utils.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repo ;

    @Autowired
    CategoriaRepository serviceCateg ;

    @Autowired
    GastoRepository serviceGasto ;

    private final Encryption encrypt;

    @Autowired
    public UsuarioService(Encryption encryption) {
        this.encrypt = encryption;
    }

    public void agregarUsuario(Usuario usuario) throws ServiceException {
        try{
            List<Categoria> categorias = serviceCateg.saveAll(usuario.getCategorias()) ;
            usuario.setCategorias(categorias);
            usuario.setPassword(encriptarAES(usuario.getPassword()));
            repo.save(usuario) ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ServiceException("Hubo un error en la conexion...") ;
        }
    }

    public Usuario obtenerUsuarioPorEmail(String email) throws ServiceException {
        try {
            return repo.findUsuarioByEmail(email) ;
        } catch (Exception e) {
            throw new ServiceException("Hubo un error en la conexion...") ;
        }
    }

    public boolean login (String email, String password) throws ServiceException {
        try {
            Usuario usuario = repo.findUsuarioByEmail(email) ;
            return desencriptarAES(usuario.getPassword()).equals(password);
        } catch (Exception e) {
            throw new ServiceException("Hubo un error en la conexion...") ;
        }
    }

    public void agregarCategoria(String email, String categoria) {

        Usuario usuario = repo.findUsuarioByEmail(email) ;
        Categoria categoriaAgregar = serviceCateg.save(new Categoria(categoria)) ;
        usuario.getCategorias().add(categoriaAgregar) ;

        repo.save(usuario) ;
    }

    public void eliminarCategoria(String email, String categoria) {

    }

    public void agregarGastoUsuario(String email, GastoDTO dto) throws ServiceException {
        try {
            Usuario usuario = repo.findUsuarioByEmail(email) ;

            if(usuario != null) {
                Categoria categoria = serviceCateg.findByNombre(dto.getCategoria()) ;
                Gasto gastoAgregar = Convertor.gastoDtoAEntity(dto) ;
                gastoAgregar.setCategoria(categoria) ;
                gastoAgregar.setUsuario(usuario);
                Gasto gastoAgregado = serviceGasto.save(gastoAgregar);
                usuario.getGastos().add(gastoAgregado) ;

                repo.save(usuario) ;
            }
        } catch (Exception e) {
            throw new ServiceException("Hubo un error en la conexion...") ;
        }
    }

    private String encriptarAES(String texto) throws Exception {
        try{
            return encrypt.encriptar(texto) ;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error...") ;
        }
    }

    private String desencriptarAES(String texto) throws Exception {
        try{
            return encrypt.desencriptar(texto) ;
        } catch (Exception e) {
            throw new Exception("Error...") ;
        }
    }

}

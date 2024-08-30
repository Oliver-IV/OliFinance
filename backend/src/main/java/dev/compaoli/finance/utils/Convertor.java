package dev.compaoli.finance.utils;

import dev.compaoli.finance.dto.GastoDTO;
import dev.compaoli.finance.dto.UsuarioDTO;
import dev.compaoli.finance.entitys.Categoria;
import dev.compaoli.finance.entitys.Gasto;
import dev.compaoli.finance.entitys.Usuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Convertor {

    public static UsuarioDTO usuarioEntityADto(Usuario entity) {
        return new UsuarioDTO(
                listaCategoriaEntityADto(entity.getCategorias()),
                entity.getEmail(),
                listaGastoEntityADto(entity.getGastos()),
                entity.getPassword()
        ) ;
    }

    public static Usuario usuarioDtoAEntity(UsuarioDTO dto) {
        return new Usuario(
                dto.getEmail(),
                dto.getPassword(),
                listaCategoriaDtoAEntity(dto.getCategorias())
        ) ;
    }

    public static GastoDTO gastoEntityADto(Gasto entity) {
        return new GastoDTO(
                entity.getCategoria().getNombre(),
                entity.getMonto(),
                entity.getNota(),
                entity.getTitulo(),
                entity.getFecha()
        ) ;
    }

    public static Gasto gastoDtoAEntity(GastoDTO dto) {
        return new Gasto(
                dto.getTitulo(),
                dto.getMonto(),
                dto.getNota(),
                categoriaDtoAEntity(dto.getCategoria()),
                dto.getFecha()) ;
    }

    public static String categoriaEntityADto(Categoria categoria) {
        return categoria.getNombre() ;
    }

    public static Categoria categoriaDtoAEntity(String dto) {
        return new Categoria(dto) ;
    }

    public static List<Categoria> listaCategoriaDtoAEntity(List<String> dtos) {
        List<Categoria> entitys = new ArrayList<>() ;
        dtos.forEach(dto -> {
            entitys.add(categoriaDtoAEntity(dto)) ;
        });
        return entitys ;
    }

    public static List<String> listaCategoriaEntityADto(List<Categoria> entitys) {
        List<String> dtos = new ArrayList<>() ;
        entitys.forEach(entity -> {
            dtos.add(categoriaEntityADto(entity)) ;
        });
        return dtos ;
    }

    public static List<Gasto> listaGastoDtoAEntity(List<GastoDTO> dtos) {
        List<Gasto> entitys = new ArrayList<>() ;
        dtos.forEach(dto -> {
            entitys.add(gastoDtoAEntity(dto)) ;
        });
        return entitys ;
    }

    public static List<GastoDTO> listaGastoEntityADto(List<Gasto> entitys) {
        List<GastoDTO> dtos = new ArrayList<>() ;
        entitys.forEach(entity -> {
            dtos.add(gastoEntityADto(entity)) ;
        });
        return dtos ;
    }

}

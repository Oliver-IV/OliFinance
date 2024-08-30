package dev.compaoli.finance.dto;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {

    private String email ;

    private String password ;

    private List<GastoDTO> gastos = new ArrayList<>();

    private List<String> categorias = new ArrayList<>() ;

    public UsuarioDTO() {

    }

    public UsuarioDTO(List<String> categorias, String email, List<GastoDTO> gastos, String password) {
        this.categorias = categorias;
        this.email = email;
        this.gastos = gastos;
        this.password = password;
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<GastoDTO> getGastos() {
        return gastos;
    }

    public void setGastos(List<GastoDTO> gastos) {
        this.gastos = gastos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

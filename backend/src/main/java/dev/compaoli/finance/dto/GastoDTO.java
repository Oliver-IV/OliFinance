package dev.compaoli.finance.dto;

import java.time.LocalDate;

public class GastoDTO {

    private String titulo ;

    private Float monto ;

    private String nota ;

    private String categoria ;

    private LocalDate fecha ;

    public GastoDTO() {

    }

    public GastoDTO(String categoria, Float monto, String nota, String titulo, LocalDate fecha) {
        this.categoria = categoria;
        this.monto = monto;
        this.nota = nota;
        this.titulo = titulo;
        this.fecha = fecha ;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}

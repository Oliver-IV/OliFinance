package dev.compaoli.finance.entitys;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "gasto")
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gasto", nullable = false, unique = true)
    private Long id ;

    @Column(name = "titulo", nullable = false)
    private String titulo ;

    @Column(name = "monto", nullable = false)
    private Float monto ;

    @Column(name = "nota", nullable = false)
    private String nota ;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = true)
    private Usuario usuario ;

    public Gasto() {

    }

    public Gasto(Long id, String titulo, Float monto, String nota, Categoria categoria, LocalDate fecha, Usuario usuario) {
        this.categoria = categoria;
        this.id = id;
        this.monto = monto;
        this.nota = nota;
        this.titulo = titulo;
        this.usuario = usuario;
        this.fecha = fecha ;
    }

    public Gasto(String titulo, Float monto, String nota, Categoria categoria, LocalDate fecha, Usuario usuario) {
        this.categoria = categoria;
        this.monto = monto;
        this.nota = nota;
        this.titulo = titulo;
        this.usuario = usuario;
        this.fecha = fecha ;
    }

    public Gasto(String titulo, Float monto, String nota, Categoria categoria, LocalDate fecha) {
        this.categoria = categoria;
        this.monto = monto;
        this.nota = nota;
        this.titulo = titulo;
        this.fecha = fecha ;
    }

    public Gasto(String titulo, Float monto, String nota, Categoria categoria) {
        this.categoria = categoria;
        this.monto = monto;
        this.nota = nota;
        this.titulo = titulo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}

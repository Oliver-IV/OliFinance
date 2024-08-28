package dev.compaoli.finance.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "gasto")
public class Gasto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gasto")
    private Long id ;

    @Column(name = "titulo")
    private String titulo ;

    @Column(name = "monto")
    private Float monto ;

    @Column(name = "nota")
    private String nota ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    @Column()
    private Categoria categoria ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario ;

    public Gasto() {

    }

    public Gasto(Long id, String titulo, Float monto, String nota, Categoria categoria, Usuario usuario) {
        this.categoria = categoria;
        this.id = id;
        this.monto = monto;
        this.nota = nota;
        this.titulo = titulo;
        this.usuario = usuario;
    }

    public Gasto(String titulo, Float monto, String nota, Categoria categoria, Usuario usuario) {
        this.categoria = categoria;
        this.monto = monto;
        this.nota = nota;
        this.titulo = titulo;
        this.usuario = usuario;
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
}

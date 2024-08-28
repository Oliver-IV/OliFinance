package dev.compaoli.finance.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;

    @Column(name = "nombre_categoria", nullable = false, unique = true, length = 15)
    private String nombre_categoria ;

    public Categoria() {

    }

    public Categoria(Long id, String nombre_categoria) {
        this.id = id;
        this.nombre_categoria = nombre_categoria;
    }

    public Categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }
}

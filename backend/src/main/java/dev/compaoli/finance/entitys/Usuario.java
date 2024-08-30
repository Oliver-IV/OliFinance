package dev.compaoli.finance.entitys;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", unique = true, nullable = false)
    private Long id ;

    @Column(name = "email", unique = true, nullable = false)
    private String email ;

    @Column(name = "password", nullable = false)
    private String password ;

    @Column(name = "cartera")
    private Float cartera ;

    @OneToMany(mappedBy = "usuario", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Gasto> gastos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Gasto> ingresos = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(
            name = "user_categories",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_categoria")
    )
    private List<Categoria> categorias = new ArrayList<>() ;

    public Usuario() {

    }

    public Usuario(Float cartera, List<Categoria> categorias, String email, List<Gasto> gastos, Long id, List<Gasto> ingresos, String password) {
        this.cartera = cartera;
        this.categorias = categorias;
        this.email = email;
        this.gastos = gastos;
        this.id = id;
        this.ingresos = ingresos;
        this.password = password;
    }

    public Usuario(Long id, String email, String password, List<Gasto> gastos, List<Categoria> categorias) {
        this.categorias = categorias;
        this.email = email;
        this.gastos = gastos;
        this.id = id;
        this.password = password;
    }

    public Usuario(Float cartera, List<Categoria> categorias, String email, List<Gasto> gastos, List<Gasto> ingresos, String password) {
        this.cartera = cartera;
        this.categorias = categorias;
        this.email = email;
        this.gastos = gastos;
        this.ingresos = ingresos;
        this.password = password;
    }

    public Usuario(String email, String password, List<Categoria> categorias) {
        this.categorias = categorias;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Float getCartera() {
        return cartera;
    }

    public void setCartera(Float cartera) {
        this.cartera = cartera;
    }

    public List<Gasto> getIngresos() {
        return ingresos;
    }

    public void setIngresos(List<Gasto> ingresos) {
        this.ingresos = ingresos;
    }
}

package dev.compaoli.finance.entitys;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ingreso")
public class Ingreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingreso", nullable = false, unique = true)
    private Long id ;

    @Column(name = "monto")
    private Float monto ;

    @Column(name = "fecha")
    private LocalDate fecha ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = true)
    private Usuario usuario ;

    public Ingreso(LocalDate fecha, Long id, Float monto, Usuario usuario) {
        this.fecha = fecha;
        this.id = id;
        this.monto = monto;
        this.usuario = usuario;
    }

    public Ingreso(LocalDate fecha, Float monto, Usuario usuario) {
        this.fecha = fecha;
        this.monto = monto;
        this.usuario = usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

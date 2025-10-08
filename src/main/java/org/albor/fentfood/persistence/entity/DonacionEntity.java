package org.albor.fentfood.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "Donaciones")
@Data
public class DonacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDonacion;

    @Column(name = "idDonador", nullable = false)
    private Long idDonador;

    private LocalDateTime fechaDonacion;

    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private TipoEntrega metodoEntrega;

    @Column(length = 64)
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "idDonador", insertable = false, updatable = false)
    private DonadorEntity donador;

    public enum TipoEntrega{
        presencial,
        recoleccion
    }
}
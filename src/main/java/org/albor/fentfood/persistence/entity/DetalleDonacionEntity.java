package org.albor.fentfood.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "DetalleDonaciones")
@Data
public class DetalleDonacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleDonacion;

    @Column(name = "idDonacion", nullable = false)
    private Long idDonacion;

    @Column(name = "idProducto", nullable = false)
    private Long idProducto;

    @Column(name = "cantidad", precision = 10, scale = 2, nullable = false)
    private BigDecimal cantidad;

    @ManyToOne
    @JoinColumn(name = "idDonacion", insertable = false, updatable = false)
    private DonacionEntity donacion;

    @ManyToOne
    @JoinColumn(name = "idProducto", insertable = false, updatable = false)
    private ProductoEntity producto;
}
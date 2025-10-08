package org.albor.fentfood.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "Productos")
@Data
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(length = 64)
    private String nombreProducto;

    @Column(length = 64, nullable = false)
    private String descripcion;

    @Column(length = 20, nullable = false)
    private String unidadMedida;

    private Date fechaVencimiento;

    @Column(length = 20)
    private String estadoProducto;
}

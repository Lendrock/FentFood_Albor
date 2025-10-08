package org.albor.fentfood.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Gestores")
@Data
public class GestorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGestor;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioEntity usuario;

    @Column(length = 64, nullable = false)
    private String nombreGestor;

    @Column(length = 64, nullable = false)
    private String apellidoGestor;

    @Column(length = 20, nullable = false)
    private String telefono;

    @Column(length = 255, nullable = false)
    private String direccion;
}
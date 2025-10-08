package org.albor.fentfood.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Donadores")
@Data
public class DonadorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDonador;

    @Column(name = "idUsuario")
    private Long idUsuario;

    @Column(length = 64)
    private String nombreDonador;

    @Column(length = 64)
    private String apellidoDonador;

    @Column(length = 64)
    private String telefono;

    @Column(length = 255)
    private String direccion;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private TipoDonador tipoDonador;

    @ManyToOne
    @JoinColumn(name = "idUsuario", insertable = false, updatable = false)
    private UsuarioEntity usuario;

    public enum TipoDonador{
        EMPRESA,
        PERSONA
    }
}
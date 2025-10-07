package org.albor.fentfood.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Usuarios")
@Data
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 100, nullable = false)
    private String correo;

    @Column(length = 255, nullable = false)
    private String psw;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Rol rol;

    public enum Rol{
        GESTOR,
        DONADOR,
        SUPERVISOR
    }
}

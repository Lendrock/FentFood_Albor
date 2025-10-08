package org.albor.fentfood.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Beneficiarios")
@Data
public class BeneficiarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBeneficiario;

    @Column(length = 64)
    private String nombreBeneficiario;

    @Column(length = 64)
    private String apellidoBeneficiario;

    @Column(length = 20)
    private String telefono;

    @Column(length = 255)
    private String direccion;

    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private TipoBeneficiario tipoBeneficiario;

    @Column(length = 64)
    private String necesidad;

    public enum TipoBeneficiario{
        FAMILIA,
        INSTITUCION
    }
}

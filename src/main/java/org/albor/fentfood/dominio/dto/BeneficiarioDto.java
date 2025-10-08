package org.albor.fentfood.dominio.dto;

import org.albor.fentfood.persistence.entity.BeneficiarioEntity.TipoBeneficiario;

public record BeneficiarioDto(
        Integer idBeneficiario,
        String name,
        String lastName,
        String phone,
        String address,
        TipoBeneficiario tipoBeneficiario,
        String need
) {
}
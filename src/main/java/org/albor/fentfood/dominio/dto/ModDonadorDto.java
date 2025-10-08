package org.albor.fentfood.dominio.dto;

import org.albor.fentfood.persistence.entity.DonadorEntity.TipoDonador;

public record ModDonadorDto(
        Long idUsuario,
        String name,
        String lastName,
        String phone,
        String address,
        TipoDonador tipoDonador
) {
}
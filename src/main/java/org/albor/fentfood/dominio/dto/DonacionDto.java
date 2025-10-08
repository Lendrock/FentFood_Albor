package org.albor.fentfood.dominio.dto;

import org.albor.fentfood.persistence.entity.DonacionEntity.TipoEntrega;
import java.time.LocalDateTime;

public record DonacionDto(
        Long idDonacion,
        Long idDonador,
        LocalDateTime donationDate,
        TipoEntrega metodoEntrega,
        String observations
) {
}
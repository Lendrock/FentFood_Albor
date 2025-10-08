package org.albor.fentfood.dominio.dto;

import java.math.BigDecimal;

public record ModDetalleDonacionDto(
        Long idDonacion,
        Long idProducto,
        BigDecimal quantity
) {
}
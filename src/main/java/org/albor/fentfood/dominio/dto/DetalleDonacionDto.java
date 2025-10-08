package org.albor.fentfood.dominio.dto;

import java.math.BigDecimal;

public record DetalleDonacionDto(
        Long idDetalleDonacion,
        Long idDonacion,
        Long idProducto,
        BigDecimal quantity
) {
}
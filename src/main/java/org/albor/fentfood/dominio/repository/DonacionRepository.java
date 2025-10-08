package org.albor.fentfood.dominio.repository;

import org.albor.fentfood.dominio.dto.DonacionDto;
import org.albor.fentfood.dominio.dto.ModDonacionDto;

import java.util.List;

public interface DonacionRepository {
    List<DonacionDto> obtenerTodo();
    DonacionDto buscarPorId(Long id);
    DonacionDto guardarDonacion(DonacionDto donacionDto);
    DonacionDto modificarDonacion(Long id, ModDonacionDto modDonacionDto);
    void eliminarDonacion(Long id);
}
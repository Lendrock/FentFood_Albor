package org.albor.fentfood.dominio.repository;

import org.albor.fentfood.dominio.dto.DonadorDto;
import org.albor.fentfood.dominio.dto.ModDonadorDto;

import java.util.List;

public interface DonadorRepository {
    List<DonadorDto> obtenerTodo();
    DonadorDto buscarPorId(Long id);
    DonadorDto guardarDonador(DonadorDto donadorDto);
    DonadorDto modificarDonador(Long id, ModDonadorDto modDonadorDto);
    void eliminarDonador(Long id);
}
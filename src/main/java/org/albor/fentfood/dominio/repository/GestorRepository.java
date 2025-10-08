package org.albor.fentfood.dominio.repository;

import org.albor.fentfood.dominio.dto.GestorDto;
import org.albor.fentfood.dominio.dto.ModGestorDto;

import java.util.List;

public interface GestorRepository {
    List<GestorDto> obtenerTodo();
    GestorDto buscarPorIdGestor(Long idGestor);
    GestorDto guardarGestor(GestorDto gestorDto);
    GestorDto modificarGestor(Long idGestor, ModGestorDto modGestorDto);
    void eliminarGestor(Long idGestor);
}

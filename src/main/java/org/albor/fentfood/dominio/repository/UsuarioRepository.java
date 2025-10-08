package org.albor.fentfood.dominio.repository;

import org.albor.fentfood.dominio.dto.ModUsuarioDto;
import org.albor.fentfood.dominio.dto.RegistroUsuarioDto;
import org.albor.fentfood.dominio.dto.UsuarioDto;

import java.util.List;

public interface UsuarioRepository {
    List<UsuarioDto> obtenerTodo();
    UsuarioDto buscarPorId(Long id);
    UsuarioDto guardarUsuario(RegistroUsuarioDto registroUsuarioDto);
    UsuarioDto modificarUsuario(Long id, ModUsuarioDto modUsuarioDto);
    void eliminarUsuario(Long id);
}

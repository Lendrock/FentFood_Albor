package org.albor.fentfood.dominio.service;

import org.albor.fentfood.dominio.dto.ModUsuarioDto;
import org.albor.fentfood.dominio.dto.UsuarioDto;
import org.albor.fentfood.dominio.repository.UsuarioRepository;

import java.util.List;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {this.usuarioRepository = usuarioRepository;}

    public List<UsuarioDto> obtenerTodo(){ return this.usuarioRepository.obtenerTodo();}

    public UsuarioDto buscarPorId(Long id){return this.usuarioRepository.buscarPorId(id);}

    public UsuarioDto guardarUsuario(UsuarioDto usuarioDto){
        return this.usuarioRepository.guardarUsuario(usuarioDto);
    }

    public UsuarioDto modificarUsuario(Long id, ModUsuarioDto modUsuarioDto){
        return this.usuarioRepository.modificarUsuario(id, modUsuarioDto);
    }

    public void eliminarUsario(Long id){ this.usuarioRepository.eliminarUsuario(id);}
}

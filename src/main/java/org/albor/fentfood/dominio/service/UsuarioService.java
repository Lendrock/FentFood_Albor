package org.albor.fentfood.dominio.service;

import org.albor.fentfood.dominio.dto.ModUsuarioDto;
import org.albor.fentfood.dominio.dto.RegistroUsuarioDto;
import org.albor.fentfood.dominio.dto.UsuarioDto;
import org.albor.fentfood.dominio.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {this.usuarioRepository = usuarioRepository;}

    public List<UsuarioDto> obtenerTodo(){ return this.usuarioRepository.obtenerTodo();}

    public UsuarioDto buscarPorId(Long id){return this.usuarioRepository.buscarPorId(id);}

    public UsuarioDto guardarUsuario(RegistroUsuarioDto registroUsuarioDto){
        return this.usuarioRepository.guardarUsuario(registroUsuarioDto);
    }

    public UsuarioDto modificarUsuario(Long id, ModUsuarioDto modUsuarioDto){
        return this.usuarioRepository.modificarUsuario(id, modUsuarioDto);
    }

    public void eliminarUsario(Long id){ this.usuarioRepository.eliminarUsuario(id);}

    //Login
    public Optional<UsuarioDto> buscarPorCorreo(String correo){ return this.usuarioRepository.buscarPorCorreo(correo);}
}

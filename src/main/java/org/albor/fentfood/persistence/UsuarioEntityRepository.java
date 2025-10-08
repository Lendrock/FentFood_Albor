package org.albor.fentfood.persistence;

import org.albor.fentfood.dominio.dto.ModUsuarioDto;
import org.albor.fentfood.dominio.dto.RegistroUsuarioDto;
import org.albor.fentfood.dominio.dto.UsuarioDto;
import org.albor.fentfood.dominio.repository.UsuarioRepository;
import org.albor.fentfood.exception.UsuarioNoExisteException;
import org.albor.fentfood.exception.UsuarioYaExisteExeption;
import org.albor.fentfood.persistence.crud.CrudUsuarioEntity;
import org.albor.fentfood.persistence.entity.UsuarioEntity;
import org.albor.fentfood.persistence.mapper.UsuarioMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioEntityRepository implements UsuarioRepository {

    private final CrudUsuarioEntity crudUsuarioEntity;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioEntityRepository(CrudUsuarioEntity crudUsuarioEntity, UsuarioMapper usuarioMapper, PasswordEncoder passwordEncoder){
        this.crudUsuarioEntity = crudUsuarioEntity;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UsuarioDto> obtenerTodo(){ return this.usuarioMapper.toDto(this.crudUsuarioEntity.findAll());}

    @Override
    public UsuarioDto buscarPorId(Long id){
        return this.usuarioMapper.toDto(this.crudUsuarioEntity.findById(id).orElse(null));
    }

    @Override
    public UsuarioDto guardarUsuario(RegistroUsuarioDto registroUsuarioDto){
        if (this.crudUsuarioEntity.findFirstByIdUsuario(registroUsuarioDto.idUsuario()) != null){
            throw new UsuarioYaExisteExeption(registroUsuarioDto.idUsuario());
        }
        UsuarioEntity usuario = new UsuarioEntity();
        usuario = this.usuarioMapper.toEntity(registroUsuarioDto);
        String pswCifrada = this.passwordEncoder.encode(registroUsuarioDto.password());
        usuario.setPsw(pswCifrada);
        this.crudUsuarioEntity.save(usuario);
        return this.usuarioMapper.toDto(usuario);
    }

    @Override
    public UsuarioDto modificarUsuario(Long id, ModUsuarioDto modUsuarioDto){
        UsuarioEntity usuario = this.crudUsuarioEntity.findById(id).orElse(null);
        if (usuario == null){
            throw new UsuarioNoExisteException(id);
        }
        this.usuarioMapper.modificarEntityFromDto(modUsuarioDto, usuario);

        return this.usuarioMapper.toDto(this.crudUsuarioEntity.save(usuario));
    }

    @Override
    public void eliminarUsuario(Long id){
        UsuarioEntity usuario = this.crudUsuarioEntity.findById(id).orElse(null);

        if (usuario == null){
            throw new UsuarioNoExisteException(id);
        }else {
            this.crudUsuarioEntity.deleteById(id);
        }
    }

    //Login
    @Override
    public Optional<UsuarioDto> buscarPorCorreo(String correo) {
        return this.crudUsuarioEntity.findByCorreo(correo)
                .map(this.usuarioMapper::toDto);
    }

}

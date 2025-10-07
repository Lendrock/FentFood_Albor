package org.albor.fentfood.persistence;

import org.albor.fentfood.dominio.dto.ModUsuarioDto;
import org.albor.fentfood.dominio.dto.UsuarioDto;
import org.albor.fentfood.dominio.repository.UsuarioRepository;
import org.albor.fentfood.persistence.crud.CrudUsuarioEntity;
import org.albor.fentfood.persistence.entity.UsuarioEntity;
import org.albor.fentfood.persistence.mapper.UsuarioMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioEntityRepository implements UsuarioRepository {

    private final CrudUsuarioEntity crudUsuarioEntity;
    private final UsuarioMapper usuarioMapper;

    public UsuarioEntityRepository(CrudUsuarioEntity crudUsuarioEntity, UsuarioMapper usuarioMapper){
        this.crudUsuarioEntity = crudUsuarioEntity;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public List<UsuarioDto> obtenerTodo(){ return this.usuarioMapper.toDto(this.crudUsuarioEntity.findAll());}

    @Override
    public UsuarioDto buscarPorId(Long id){
        return this.usuarioMapper.toDto(this.crudUsuarioEntity.findById(id).orElse(null));
    }

    @Override
    public UsuarioDto guardarUsuario(UsuarioDto usuarioDto){
        if (this.crudUsuarioEntity.findFirstById(usuarioDto.idUsuario()) != null){
            throw new UsuarioYaExisteExeption(usuarioDto.idUsuario());
        }
        UsuarioEntity usuario = new UsuarioRepository();
        usuario = this.usuarioMapper.toEntity(usuarioDto);
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

}

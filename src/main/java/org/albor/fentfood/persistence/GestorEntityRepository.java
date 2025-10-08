package org.albor.fentfood.persistence;

import org.albor.fentfood.dominio.dto.GestorDto;
import org.albor.fentfood.dominio.dto.ModGestorDto;
import org.albor.fentfood.dominio.repository.GestorRepository;
import org.albor.fentfood.persistence.crud.CrudGestorEntity;
import org.albor.fentfood.persistence.entity.GestorEntity;
import org.albor.fentfood.persistence.mapper.GestorMapper;
import org.albor.fentfood.exception.GestorNoExisteException;
import org.albor.fentfood.exception.GestorYaExisteException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GestorEntityRepository implements GestorRepository {

    private final CrudGestorEntity crudGestorEntity;
    private final GestorMapper gestorMapper;

    public GestorEntityRepository(CrudGestorEntity crudGestorEntity, GestorMapper gestorMapper) {
        this.crudGestorEntity = crudGestorEntity;
        this.gestorMapper = gestorMapper;
    }

    @Override
    public List<GestorDto> obtenerTodo() {
        return this.gestorMapper.toDto(this.crudGestorEntity.findAll());
    }

    @Override
    public GestorDto buscarPorIdGestor(Long idGestor) {
        GestorEntity gestor = this.crudGestorEntity.findById(idGestor).orElseThrow(() -> new GestorNoExisteException(idGestor));
        return this.gestorMapper.toDto(gestor);
    }

    @Override
    public GestorDto guardarGestor(GestorDto gestorDto) {
        if (this.crudGestorEntity.existsById(gestorDto.usuario())) {
            throw new GestorYaExisteException(gestorDto.firstName() + " " + gestorDto.lastName());
        }
        GestorEntity gestor = this.gestorMapper.toEntity(gestorDto);
        this.crudGestorEntity.save(gestor);
        return this.gestorMapper.toDto(gestor);
    }

    @Override
    public GestorDto modificarGestor(Long idGestor, ModGestorDto modGestorDto) {
        GestorEntity gestor = this.crudGestorEntity.findById(idGestor).orElseThrow(() -> new GestorNoExisteException(idGestor));
        this.gestorMapper.modificarEntityFromDto(modGestorDto, gestor);
        return this.gestorMapper.toDto(this.crudGestorEntity.save(gestor));
    }

    @Override
    public void eliminarGestor(Long idGestor) {
        GestorEntity gestor = this.crudGestorEntity.findById(idGestor).orElseThrow(() -> new GestorNoExisteException(idGestor));
        this.crudGestorEntity.deleteById(idGestor);
    }
}

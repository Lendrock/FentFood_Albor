package org.albor.fentfood.persistence;

import org.albor.fentfood.dominio.dto.BeneficiarioDto;
import org.albor.fentfood.dominio.dto.ModBeneficiarioDto;
import org.albor.fentfood.dominio.repository.BeneficiarioRepository;
import org.albor.fentfood.exception.BeneficiarioNoExisteException;
import org.albor.fentfood.exception.BeneficiarioYaExisteExeption;
import org.albor.fentfood.persistence.crud.CrudBeneficiarioEntity;
import org.albor.fentfood.persistence.entity.BeneficiarioEntity;
import org.albor.fentfood.persistence.mapper.BeneficiarioMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BeneficiarioEntityRepository implements BeneficiarioRepository {

    private final CrudBeneficiarioEntity crudBeneficiarioEntity;
    private final BeneficiarioMapper beneficiarioMapper;

    public BeneficiarioEntityRepository(CrudBeneficiarioEntity crudBeneficiarioEntity, BeneficiarioMapper beneficiarioMapper) {
        this.crudBeneficiarioEntity = crudBeneficiarioEntity;
        this.beneficiarioMapper = beneficiarioMapper;
    }

    @Override
    public List<BeneficiarioDto> obtenerTodo(){
        return this.beneficiarioMapper.toDto(this.crudBeneficiarioEntity.findAll());
    }

    @Override
    public BeneficiarioDto buscarPorId(Long id){
        return this.beneficiarioMapper.toDto(this.crudBeneficiarioEntity.findById(id).orElse(null));
    }

    @Override
    public BeneficiarioDto guardarBeneficiario(BeneficiarioDto beneficiarioDto){
        if (this.crudBeneficiarioEntity.findFirstByIdBeneficiario(beneficiarioDto.idBeneficiario()) != null){
            throw new BeneficiarioYaExisteExeption(beneficiarioDto.idBeneficiario());
        }
        BeneficiarioEntity beneficiario = new BeneficiarioEntity();
        beneficiario = this.beneficiarioMapper.toEntity(beneficiarioDto);;
        this.crudBeneficiarioEntity.save(beneficiario);
        return this.beneficiarioMapper.toDto(beneficiario);
    }

    @Override
    public BeneficiarioDto modificarBeneficiario(Long id, ModBeneficiarioDto modBeneficiarioDto){
        BeneficiarioEntity beneficiario = this.crudBeneficiarioEntity.findById(id).orElse(null);
        if (beneficiario == null){
            throw new BeneficiarioNoExisteException(id);
        }
        this.beneficiarioMapper.modificarEntityFromDto(modBeneficiarioDto, beneficiario);

        return this.beneficiarioMapper.toDto(this.crudBeneficiarioEntity.save(beneficiario));
    }

    @Override
    public void eliminarBeneficiario(Long id){
        BeneficiarioEntity beneficiario = this.crudBeneficiarioEntity.findById(id).orElse(null);
        if (beneficiario == null) {
            throw new BeneficiarioNoExisteException(id);
        } else {
            this.crudBeneficiarioEntity.deleteById(id);
        }
    }
}
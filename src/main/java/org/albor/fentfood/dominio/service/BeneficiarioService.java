package org.albor.fentfood.dominio.service;

import org.albor.fentfood.dominio.dto.BeneficiarioDto;
import org.albor.fentfood.dominio.dto.ModBeneficiarioDto;
import org.albor.fentfood.dominio.repository.BeneficiarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiarioService {
    private final BeneficiarioRepository beneficiarioRepository;

    public BeneficiarioService(BeneficiarioRepository beneficiarioRepository) {this.beneficiarioRepository = beneficiarioRepository;}

    public List<BeneficiarioDto> obtenerTodo(){ return this.beneficiarioRepository.obtenerTodo();}

    public BeneficiarioDto buscarPorId(Long id){return this.beneficiarioRepository.buscarPorId(id);}

    public BeneficiarioDto guardarBeneficiario(BeneficiarioDto beneficiarioDto){
        return this.beneficiarioRepository.guardarBeneficiario(beneficiarioDto);
    }

    public BeneficiarioDto modificarBeneficiario(Long id, ModBeneficiarioDto modBeneficiarioDto){
        return this.beneficiarioRepository.modificarBeneficiario(id, modBeneficiarioDto);
    }

    public void eliminarBeneficiario(Long id){ this.beneficiarioRepository.eliminarBeneficiario(id);}
}
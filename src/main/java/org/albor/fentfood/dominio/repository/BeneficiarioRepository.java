package org.albor.fentfood.dominio.repository;

import org.albor.fentfood.dominio.dto.BeneficiarioDto;
import org.albor.fentfood.dominio.dto.ModBeneficiarioDto;

import java.util.List;

public interface BeneficiarioRepository {
    List<BeneficiarioDto> obtenerTodo();
    BeneficiarioDto buscarPorId(Long id);
    BeneficiarioDto guardarBeneficiario(BeneficiarioDto beneficiarioDto);
    BeneficiarioDto modificarBeneficiario(Long id, ModBeneficiarioDto modBeneficiarioDto);
    void eliminarBeneficiario(Long id);
}
package org.albor.fentfood.dominio.service;

import org.albor.fentfood.dominio.dto.DonadorDto;
import org.albor.fentfood.dominio.dto.ModDonadorDto;
import org.albor.fentfood.dominio.repository.DonadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonadorService {
    private final DonadorRepository donadorRepository;

    public DonadorService(DonadorRepository donadorRepository) {this.donadorRepository = donadorRepository;}

    public List<DonadorDto> obtenerTodo(){ return this.donadorRepository.obtenerTodo();}

    public DonadorDto buscarPorId(Long id){return this.donadorRepository.buscarPorId(id);}

    public DonadorDto guardarDonador(DonadorDto donadorDto){
        return this.donadorRepository.guardarDonador(donadorDto);
    }

    public DonadorDto modificarDonador(Long id, ModDonadorDto modDonadorDto){
        return this.donadorRepository.modificarDonador(id, modDonadorDto);
    }

    public void eliminarDonador(Long id){ this.donadorRepository.eliminarDonador(id);}
}
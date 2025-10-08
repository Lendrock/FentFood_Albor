package org.albor.fentfood.dominio.service;

import org.albor.fentfood.dominio.dto.DonacionDto;
import org.albor.fentfood.dominio.dto.ModDonacionDto;
import org.albor.fentfood.dominio.repository.DonacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonacionService {
    private final DonacionRepository donacionRepository;

    public DonacionService(DonacionRepository donacionRepository) {this.donacionRepository = donacionRepository;}

    public List<DonacionDto> obtenerTodo(){ return this.donacionRepository.obtenerTodo();}

    public DonacionDto buscarPorId(Long id){return this.donacionRepository.buscarPorId(id);}

    public DonacionDto guardarDonacion(DonacionDto donacionDto){
        return this.donacionRepository.guardarDonacion(donacionDto);
    }

    public DonacionDto modificarDonacion(Long id, ModDonacionDto modDonacionDto){
        return this.donacionRepository.modificarDonacion(id, modDonacionDto);
    }

    public void eliminarDonacion(Long id){ this.donacionRepository.eliminarDonacion(id);}
}
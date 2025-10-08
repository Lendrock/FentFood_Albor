package org.albor.fentfood.dominio.service;

import org.albor.fentfood.dominio.dto.GestorDto;
import org.albor.fentfood.dominio.dto.ModGestorDto;
import org.albor.fentfood.dominio.repository.GestorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestorService {

    private final GestorRepository gestorRepository;

    public GestorService(GestorRepository gestorRepository){
        this.gestorRepository = gestorRepository;
    }

    public List<GestorDto> obtenerTodo(){
        return this.gestorRepository.obtenerTodo();
    }

    public GestorDto buscarPorIdGestor(Long idGestor){
        return this.gestorRepository.buscarPorIdGestor(idGestor);
    }

    public GestorDto guardarGestor(GestorDto gestorDto){
        return this.gestorRepository.guardarGestor(gestorDto);
    }

    public GestorDto modificarGestor(Long idGestor, ModGestorDto modGestorDto){
        return this.gestorRepository.modificarGestor(idGestor, modGestorDto);
    }

    public void eliminarGestor(Long idGestor){
        this.gestorRepository.eliminarGestor(idGestor);
    }
}

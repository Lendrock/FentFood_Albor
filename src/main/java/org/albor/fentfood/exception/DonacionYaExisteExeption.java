package org.albor.fentfood.exception;

public class DonacionYaExisteExeption extends RuntimeException {
    public DonacionYaExisteExeption(Long id) {
        super("La donación con el Id: " + id + " ya existe en el sistema.");
    }
}
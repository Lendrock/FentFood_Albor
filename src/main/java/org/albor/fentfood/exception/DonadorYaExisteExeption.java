package org.albor.fentfood.exception;

public class DonadorYaExisteExeption extends RuntimeException {
    public DonadorYaExisteExeption(Long id) {
        super("El donador con el Id: " + id + " ya existe en el sistema.");
    }
}
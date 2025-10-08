package org.albor.fentfood.exception;

public class UsuarioYaExisteExeption extends RuntimeException {
    public UsuarioYaExisteExeption(Long id) {
        super("El usuario con el Id: " + id + " ya  existe en el sistema.");
    }
}

package org.albor.fentfood.exception;

public class GestorYaExisteException extends RuntimeException {
    public GestorYaExisteException(String nombreCompleto) {
        super("El Gestor con el nombre: " + nombreCompleto + " ya existe en el sistema.");
    }
}

package org.albor.fentfood.exception;

public class ProductoNoExisteException extends RuntimeException {
    public ProductoNoExisteException(Long id) {
        super("El Producto con el Id: " + id + " no  existe en el sistema.");
    }
}
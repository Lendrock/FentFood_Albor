package org.albor.fentfood.exception;

public class ProductoYaExisteException extends RuntimeException {
    public ProductoYaExisteException(Long id) {
    super("El Producto con el Id: " + id + " ya  existe en el sistema.");
  }
}

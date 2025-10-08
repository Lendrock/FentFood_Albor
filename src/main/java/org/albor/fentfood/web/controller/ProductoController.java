package org.albor.fentfood.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.albor.fentfood.dominio.dto.ProductoDto;
import org.albor.fentfood.dominio.dto.ModProductoDto;
import org.albor.fentfood.dominio.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/productos")
@Tag(name = "Productos", description = "Operaciones CRUD para Productos dentro de Albor FentFood")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping
    @Operation(
            summary = "Obtener todos los productos",
            description = "Retorna la lista completa de productos registrados en el sistema",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Lista de productos obtenida correctamente")
            }
    )
    public ResponseEntity<List<ProductoDto>> obtenerProductos(){
        return ResponseEntity.ok(productoService.obtenerTodo());
    }

    @GetMapping("{idProducto}")
    @Operation(
            summary = "Obtener un Producto por su identificador",
            description = "Retorna el producto que coincide con el identificador enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Producto encontrado"),
                    @ApiResponse(responseCode = "400", description = "Producto no encontrado", content = @Content)
            }
    )
    public ResponseEntity<ProductoDto> buscarPorId(
            @Parameter(description = "Identificador del Producto a recuperar", example = "5")
            @PathVariable Long idProducto){
        return ResponseEntity.ok(this.productoService.buscarPorIdProducto(idProducto));
    }

    @PostMapping
    @Operation(
            summary = "Registrar un nuevo Producto",
            description = "Permite registrar un nuevo producto dentro del sistema",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Producto creado correctamente"),
                    @ApiResponse(responseCode = "400", description = "Error al registrar el producto", content = @Content)
            }
    )
    public ResponseEntity<ProductoDto> guardarProducto(
            @RequestBody @Valid ProductoDto productoDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.productoService.guardarProducto(productoDto));
    }

    @PutMapping("{idProducto}")
    @Operation(
            summary = "Modificar un Producto existente",
            description = "Permite actualizar la información de un producto por su ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Producto modificado correctamente"),
                    @ApiResponse(responseCode = "400", description = "Producto no encontrado", content = @Content)
            }
    )
    public ResponseEntity<ProductoDto> modificarProducto(
            @PathVariable Long idProducto,
            @RequestBody @Valid ModProductoDto modProductoDto){
        return ResponseEntity.ok(this.productoService.modificarProducto(idProducto, modProductoDto));
    }

    @DeleteMapping("{idProducto}")
    @Operation(
            summary = "Eliminar un Producto",
            description = "Permite eliminar un producto del sistema mediante su ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Producto eliminado correctamente"),
                    @ApiResponse(responseCode = "400", description = "Producto no encontrado", content = @Content)
            }
    )
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long idProducto){
        this.productoService.eliminarProducto(idProducto);
        return ResponseEntity.ok().build();
    }
}

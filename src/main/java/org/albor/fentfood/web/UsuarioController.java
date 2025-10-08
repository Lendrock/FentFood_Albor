package org.albor.fentfood.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.albor.fentfood.dominio.dto.ModUsuarioDto;
import org.albor.fentfood.dominio.dto.RegistroUsuarioDto;
import org.albor.fentfood.dominio.dto.UsuarioDto;
import org.albor.fentfood.dominio.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retrofit2.http.Path;

import java.util.List;

@RestController
@RequestMapping("/v1/usuarios")
@Tag(name = "Usuarios", description = "Operaciones CRUD para Usuarios dentro de FentFood Albor")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){ this.usuarioService = usuarioService;}

    //Listar
    @GetMapping
    public ResponseEntity<List<UsuarioDto>> obtenerUsuarios(){
        return ResponseEntity.ok(this.usuarioService.obtenerTodo());
    }

    //Buscar Por id
    @GetMapping("{idUsuario}")
    @Operation(
            summary = "Obtener una parte por su identificador",
            description = "Retorna la parte que coincida con el identificador enviado",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Parte encontrada"),
                    @ApiResponse(responseCode = "404", description = "Parte no encontrada", content = @Content)
            }
    )
    public ResponseEntity<UsuarioDto> buscarPorId
    (@Parameter(description = "Identificar la parte a recuperar", example = "3")
     @PathVariable Long id){
        return ResponseEntity.ok(this.usuarioService.buscarPorId(id));
    }

    //Crear
    @PostMapping
    public ResponseEntity<UsuarioDto> guardarUsuario
    (@RequestBody @Valid RegistroUsuarioDto registroUsuarioDto){
        return ResponseEntity.status(HttpStatus.CREATED).
                body(this.usuarioService.guardarUsuario(registroUsuarioDto));
    }

    //Modificar
    @PutMapping("{idUsuario}")
    public ResponseEntity<UsuarioDto> modificarUsuario
    (@PathVariable("idUsuario") Long idUsuario, @RequestBody ModUsuarioDto modUsuarioDto){
        return ResponseEntity.ok(this.usuarioService.modificarUsuario(idUsuario, modUsuarioDto));
    }

    //Eliminar
    @DeleteMapping("{idUsuario}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long idUsuario){
        this.usuarioService.eliminarUsario(idUsuario);
        return ResponseEntity.ok().build();
    }

}

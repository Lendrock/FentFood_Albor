package org.albor.fentfood.web.controller;

import org.albor.fentfood.dominio.dto.AuthResponseDto;
import org.albor.fentfood.dominio.dto.LoginRequestDto;
import org.albor.fentfood.dominio.dto.UsuarioDto;
import org.albor.fentfood.dominio.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioService usuarioService;

    public LoginController(AuthenticationManager authenticationManager, UsuarioService usuarioService) {
        this.authenticationManager = authenticationManager;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@Valid @RequestBody LoginRequestDto loginRequest) {

        // 1. Autentica al usuario con el AuthenticationManager (usa el CustomUserDetailsService)
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 2. Simulación de generación de Token (aquí iría la lógica JWT)
        // String token = jwtService.generateToken(authentication);

        // 3. Busca los detalles del usuario para la respuesta
        Optional<UsuarioDto> userDetails = usuarioService.buscarPorCorreo(loginRequest.email());

        if (userDetails.isEmpty()) {
            return ResponseEntity.internalServerError().build(); // Error inesperado
        }

        UsuarioDto user = userDetails.get();

        // 4. Retorna la respuesta
        return ResponseEntity.ok(new AuthResponseDto(
                "MOCK_JWT_TOKEN", // Usar un token JWT real en producción
                user.idUsuario(),
                user.name(),
                user.email(),
                user.rol().name()
        ));
    }
}
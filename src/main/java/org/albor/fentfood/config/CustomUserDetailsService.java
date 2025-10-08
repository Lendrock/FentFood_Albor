package org.albor.fentfood.config;

import org.albor.fentfood.persistence.crud.CrudUsuarioEntity;
import org.albor.fentfood.persistence.entity.UsuarioEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final CrudUsuarioEntity crudUsuarioEntity;

    public CustomUserDetailsService(CrudUsuarioEntity crudUsuarioEntity) {
        this.crudUsuarioEntity = crudUsuarioEntity;
    }

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        UsuarioEntity usuario = crudUsuarioEntity.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con correo: " + correo));

        Set<GrantedAuthority> authorities = Collections.singleton(
                new SimpleGrantedAuthority("ROLE_" + usuario.getRol().name())
        );

        return new User(
                usuario.getCorreo(),
                usuario.getPsw(),
                authorities
        );
    }
}
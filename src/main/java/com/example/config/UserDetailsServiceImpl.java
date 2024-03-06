package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.domain.Usuario;
import com.example.repository.UsuarioRepository;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String Nombre) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNombre(Nombre);
        if (usuario == null)
            throw (new UsernameNotFoundException("Usuario no encontrado!"));
        return User
                .withUsername(Nombre)
                .roles(usuario.getRol().toString())
                .password(usuario.getPassword())
                .build();
    }
}

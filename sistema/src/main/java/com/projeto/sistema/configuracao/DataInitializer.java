package com.projeto.sistema.configuracao;

import com.projeto.sistema.modelos.Usuario;
import com.projeto.sistema.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@Configuration
public class DataInitializer {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initData() {
    
        String adminUsername = "admin";
        
        String adminPassword = "senhaSegura"; 

        Usuario admin = usuarioRepositorio.findByUsername(adminUsername).orElse(null);

        if (admin == null) {
            Usuario novoAdmin = new Usuario();
            novoAdmin.setUsername(adminUsername);
            novoAdmin.setPassword(passwordEncoder.encode(adminPassword));
            
            usuarioRepositorio.save(novoAdmin);
        }
    }
}

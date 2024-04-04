package com.projeto.sistema.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.sistema.modelos.Abertura;

@Repository
public interface AberturaRepositorio extends JpaRepository<Abertura, Long> {
    
}

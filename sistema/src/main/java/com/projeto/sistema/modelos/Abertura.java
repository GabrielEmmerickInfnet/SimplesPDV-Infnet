package com.projeto.sistema.modelos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="abertura")
public class Abertura implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BigDecimal valorDeAbertura;
    private LocalDate dataDeAbertura;
    
    // Getters e setters...
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public BigDecimal getValorDeAbertura() {
        return valorDeAbertura;
    }
    
    public void setValorDeAbertura(BigDecimal valorDeAbertura) {
        this.valorDeAbertura = valorDeAbertura;
    }
    
    public LocalDate getDataDeAbertura() {
        return dataDeAbertura;
    }
    
    public void setDataDeAbertura(LocalDate dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }
}

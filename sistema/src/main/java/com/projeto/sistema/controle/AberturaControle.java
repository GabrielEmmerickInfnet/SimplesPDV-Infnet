package com.projeto.sistema.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.sistema.modelos.Abertura;
import com.projeto.sistema.repositorios.AberturaRepositorio;

@Controller
public class AberturaControle {
    
    @Autowired
    private AberturaRepositorio aberturaRepositorio;
    
    @GetMapping("/cadastroabertura")
    public ModelAndView cadastrar(Abertura abertura) {
        ModelAndView mv = new ModelAndView("administrativo/aberturas/cadastro");
        mv.addObject("abertura", abertura);
        return mv;
    }
    
    @GetMapping("/listarabertura")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("administrativo/aberturas/lista");
        mv.addObject("listaAberturas", aberturaRepositorio.findAll()); 
        return mv;
    }
    
    @GetMapping("/editarabertura/{id}")
    public ModelAndView editar(@PathVariable("id") Long id) {
        Optional<Abertura> abertura = aberturaRepositorio.findById(id);
        if(abertura.isPresent()) {
            return cadastrar(abertura.get());
        } else {
            return listar().addObject("message", "Abertura não encontrada.");
        }
    }
    
    @GetMapping("/removerabertura/{id}")
    public ModelAndView remover(@PathVariable("id") Long id) {
        Optional<Abertura> abertura = aberturaRepositorio.findById(id);
        if(abertura.isPresent()) {
            aberturaRepositorio.delete(abertura.get());
        } else {
            return listar().addObject("message", "Não foi possível encontrar a abertura para deletar.");
        }
        return listar();
    }
    
    @PostMapping("/salvarabertura")
    public ModelAndView salvar(Abertura abertura, BindingResult result) {
        if(result.hasErrors()) {
            return cadastrar(abertura);
        }
        aberturaRepositorio.saveAndFlush(abertura);
        return listar().addObject("message", "Abertura salva com sucesso!");
    }
}

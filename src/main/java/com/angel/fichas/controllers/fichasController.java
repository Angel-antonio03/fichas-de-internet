package com.angel.fichas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angel.fichas.model.Fichas;
import com.angel.fichas.repository.FichaRepository;

@RestController
@RequestMapping("/fichas")
public class fichasController {
@Autowired
    private FichaRepository fichaRepository;
    @GetMapping ("/TraerFichas")
    public List <Fichas> TraerFichas() {
        return fichaRepository.findAll();
        
    }
}

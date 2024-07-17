package com.alura.challenguealuralibros.controller;

import com.alura.challenguealuralibros.entity.Autor;
import com.alura.challenguealuralibros.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<Autor> listarAutores() {
        return autorService.listarAutores();
    }

    @GetMapping("/vivos")
    public List<Autor> listarAutoresVivos(@RequestParam int anio) {
        LocalDate fecha = LocalDate.of(anio, 1, 1);
        return autorService.listarAutoresVivosAntesDe(fecha);
    }
}
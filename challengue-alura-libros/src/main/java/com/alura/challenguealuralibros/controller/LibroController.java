package com.alura.challenguealuralibros.controller;

import com.alura.challenguealuralibros.entity.Libro;
import com.alura.challenguealuralibros.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listarLibros() {
        return libroService.listarLibros();
    }

    @GetMapping("/buscar")
    public List<Libro> buscarLibrosPorTitulo(@RequestParam String titulo) {
        return libroService.buscarLibrosPorTitulo(titulo);
    }

    @GetMapping("/idioma")
    public List<Libro> listarLibrosPorIdioma(@RequestParam String idioma) {
        return libroService.listarLibrosPorIdioma(idioma);
    }
}

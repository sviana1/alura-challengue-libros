package com.alura.challenguealuralibros.repository;

import com.alura.challenguealuralibros.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByTituloContaining(String titulo);
    List<Libro> findByIdioma(String idioma);
}

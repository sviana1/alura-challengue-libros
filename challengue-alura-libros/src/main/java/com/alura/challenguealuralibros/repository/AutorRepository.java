package com.alura.challenguealuralibros.repository;

import com.alura.challenguealuralibros.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByVivoAndFechaNacimientoBefore(boolean vivo, LocalDate fechaNacimiento);
}
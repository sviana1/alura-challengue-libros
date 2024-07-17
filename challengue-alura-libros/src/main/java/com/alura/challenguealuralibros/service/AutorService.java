package com.alura.challenguealuralibros.service;

import com.alura.challenguealuralibros.entity.Autor;
import com.alura.challenguealuralibros.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    public List<Autor> listarAutoresVivosAntesDe(LocalDate fecha) {
        return autorRepository.findByVivoAndFechaNacimientoBefore(true, fecha);
    }
}

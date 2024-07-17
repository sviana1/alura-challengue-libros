package com.alura.challenguealuralibros;

import com.alura.challenguealuralibros.service.AutorService;
import com.alura.challenguealuralibros.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Scanner;

@Component
public class ConsoleApplication implements CommandLineRunner {

    @Autowired
    private LibroService libroService;

    @Autowired
    private AutorService autorService;

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) {
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // consumir nueva línea

            switch (opcion) {
                case 1:
                    buscarLibrosPorTitulo();
                    break;
                case 2:
                    listarLibros();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    listarAutoresVivos();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("1. Buscar libros por el título");
        System.out.println("2. Listar libros registrados");
        System.out.println("3. Listar autores registrados");
        System.out.println("4. Listar autores vivos de un determinado año");
        System.out.println("5. Listar libros por idioma");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void buscarLibrosPorTitulo() {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        libroService.buscarLibrosPorTitulo(titulo).forEach(System.out::println);
    }

    private void listarLibros() {
        libroService.listarLibros().forEach(System.out::println);
    }

    private void listarAutores() {
        autorService.listarAutores().forEach(System.out::println);
    }

    private void listarAutoresVivos() {
        System.out.print("Ingrese el año: ");
        int anio = scanner.nextInt();
        autorService.listarAutoresVivosAntesDe(LocalDate.of(anio, 1, 1)).forEach(System.out::println);
    }

    private void listarLibrosPorIdioma() {
        System.out.print("Ingrese el idioma: ");
        String idioma = scanner.nextLine();
        libroService.listarLibrosPorIdioma(idioma).forEach(System.out::println);
    }
}

package com.literatura.literalura.controller;

import com.literatura.literalura.client.GutendexClient;
import com.literatura.literalura.model.Autor;
import com.literatura.literalura.model.Libro;
import com.literatura.literalura.repository.AutorRepository;
import com.literatura.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class MainController implements CommandLineRunner {

    @Autowired
    private GutendexClient gutendexClient;

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {
        boolean exit = false;
        while (!exit) {
            System.out.println("Menú de opciones:");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar todos los libros");
            System.out.println("3. Listar libros por idioma");
            System.out.println("4. Listar autores");
            System.out.println("5. Listar autores vivos en un año determinado");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    listarTodosLosLibros();
                    break;
                case 3:
                    listarLibrosPorIdioma();
                    break;
                case 4:
                    listarAutores();
                    break;
                case 5:
                    listarAutoresVivosEnAnioDeterminado();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void buscarLibroPorTitulo() {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        Libro libro = gutendexClient.buscarLibroPorTitulo(titulo);

        if (libro != null) {
            Autor autor = libro.getAutor();
            if (autor != null) {
                autorRepository.save(autor);
            }
            libroRepository.save(libro);
            System.out.println("Libro guardado en la base de datos:");
            System.out.println(libro);
        } else {
            System.out.println("No se encontró el libro.");
        }
    }

    private void listarTodosLosLibros() {
        List<Libro> libros = libroRepository.findAll();
        if (libros.isEmpty()) {
            System.out.println("No hay libros guardados.");
        } else {
            libros.forEach(System.out::println);
        }
    }

    private void listarLibrosPorIdioma() {
        System.out.print("Ingrese el idioma: ");
        String idioma = scanner.nextLine();
        List<Libro> libros = libroRepository.findByIdioma(idioma);
        if (libros.isEmpty()) {
            System.out.println("No hay libros en ese idioma.");
        } else {
            libros.forEach(System.out::println);
        }
    }

    private void listarAutores() {
        List<Autor> autores = autorRepository.findAll();
        if (autores.isEmpty()) {
            System.out.println("No hay autores guardados.");
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void listarAutoresVivosEnAnioDeterminado() {
        System.out.print("Ingrese el año: ");
        int anio = scanner.nextInt();
        List<Autor> autores = autorRepository.findByAnioNacimientoBeforeAndAnioFallecimientoAfter(anio, anio);
        if (autores.isEmpty()) {
            System.out.println("No hay autores vivos en ese año.");
        } else {
            autores.forEach(System.out::println);
        }
    }
}

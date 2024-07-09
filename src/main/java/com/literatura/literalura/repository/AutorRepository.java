package com.literatura.literalura.repository;

import com.literatura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    List<Autor> findByAnioNacimientoBeforeAndAnioFallecimientoAfter(int anioNacimiento, int anioFallecimiento);
}

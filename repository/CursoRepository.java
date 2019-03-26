package br.com.cursosceuma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursosceuma.domain.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}

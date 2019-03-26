package br.com.cursosceuma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cursosceuma.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}

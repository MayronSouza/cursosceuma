package br.com.cursosceuma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursosceuma.domain.Curso;
import br.com.cursosceuma.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	CursoRepository cursoRepository;// classe repository anotada com @Autowired injeta dependências
	
	public List<Curso> listar() {
		
		return cursoRepository.findAll();// o método findAll retorna todas as Entidades
		
	}
	
	public Curso salvar(Curso curso) {
		
		curso.setId(null);
		
		return cursoRepository.save(curso);
		
	}
	
	public Curso buscar(Long id) {
		
		Curso curso = cursoRepository.findById(id).orElse(null);
		
		return curso;
		
	}
	
	public void deletar(Long id) {
		
		cursoRepository.deleteById(id);
		
	}
	
	public void atualizar(Curso curso) {
		
		verificarExistencia(curso);
		
		cursoRepository.save(curso);
		
	}

	private void verificarExistencia(Curso curso) {
		
		buscar(curso.getId());
		
	}
	
}
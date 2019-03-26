package br.com.cursosceuma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursosceuma.domain.Aluno;
import br.com.cursosceuma.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	public List<Aluno> listar() {
		
		return alunoRepository.findAll();
		
	}
	
	public Aluno salvar(Aluno aluno) {
		
		aluno.setId(null);
		
		return alunoRepository.save(aluno);
		
	}
	
	public Aluno buscar(Long id) {
		
		Aluno aluno = alunoRepository.findById(id).orElse(null);
		
		return aluno;
		
	}
	
	public void deletar(Long id) {
		
		alunoRepository.deleteById(id);
		
	}
	
	public void atualizar(Aluno aluno) {
		
		verificarExistencia(aluno);
		
		alunoRepository.save(aluno);
		
	}

	private void verificarExistencia(Aluno aluno) {
		
		buscar(aluno.getId());
		
	}

}

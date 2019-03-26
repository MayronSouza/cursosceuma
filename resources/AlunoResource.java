package br.com.cursosceuma.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cursosceuma.domain.Aluno;
import br.com.cursosceuma.services.AlunoService;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {
	
	@Autowired
	AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> listar() {
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(alunoService.listar());
		
	}
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Aluno aluno) {
		
		aluno = alunoService.salvar(aluno);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(aluno.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> buscar(@PathVariable Long id) {
		
		alunoService.buscar(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		
		alunoService.deletar(id);
		
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody Aluno aluno, @PathVariable Long id) {
		
		aluno.setId(id);
		
		alunoService.atualizar(aluno);
		
		return ResponseEntity.noContent().build();
		
	}

}

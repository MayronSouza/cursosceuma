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

import br.com.cursosceuma.domain.Curso;
import br.com.cursosceuma.services.CursoService;

@RestController
@RequestMapping(value="/cursos")
public class CursoResource {
	
	@Autowired
	CursoService cursoService;
	
	@GetMapping
	public ResponseEntity<List<Curso>> listar() {
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(cursoService.listar());
		
	}
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Curso curso) {
		
		curso = cursoService.salvar(curso);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(curso.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<?> buscar(@PathVariable Long id) {
		
		Curso curso = cursoService.buscar(id);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(curso);
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		
		cursoService.deletar(id);
		
		return ResponseEntity.noContent()
				.build();
		
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> atualizar(@RequestBody Curso curso, @PathVariable Long id) {
		
		curso.setId(id);
		
		cursoService.atualizar(curso);
		
		return ResponseEntity.noContent()
				.build();
		
	}

}

package br.com.cj.escola.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.cj.escola.model.Professor;
import br.com.cj.escola.service.ProfessorService;

@RestController
@RequestMapping(value = "/professores")
public class ProfessorController {

	@Autowired
	private ProfessorService professorServ;
	
	@RequestMapping
	public ResponseEntity<List<Professor>> todosProfessor(){
		List<Professor> professores=professorServ.findAll();
		return ResponseEntity.ok().body(professores);
	}
	@PostMapping
	public ResponseEntity<Void> salvarProfessor(@RequestBody Professor professor){
		Professor novoProfessor=professorServ.save(professor);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoProfessor.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Professor> procurarProfessor(@PathVariable int id){
		Professor professor=professorServ.findById(id);
		return ResponseEntity.ok().body(professor);
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> atualizarProfessor(@PathVariable int id,@RequestBody Professor professor){
		professor.setId(id);
		professorServ.update(professor);
		return ResponseEntity.noContent().build();
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletarProfessor(@PathVariable int id){
		professorServ.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}

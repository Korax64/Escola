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

import br.com.cj.escola.model.Disciplina;
import br.com.cj.escola.service.DisciplinaService;

@RestController
@RequestMapping(value = "/disciplinas")
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaServ;

	@RequestMapping
	public ResponseEntity<List<Disciplina>> listarDisciplina() {
		return ResponseEntity.ok().body(disciplinaServ.findAll());
	}

	@PostMapping
	public ResponseEntity<Void> salvarDisciplina(@RequestBody Disciplina disciplina) {
		Disciplina novaDisciplina=disciplinaServ.save(disciplina);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novaDisciplina.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Disciplina> procurarDisciplina(@PathVariable int id) {
		return ResponseEntity.ok().body(disciplinaServ.findById(id));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> atualizarDisciplina(@PathVariable int id,@RequestBody Disciplina disciplina){
		disciplina.setId(id);
		disciplinaServ.update(disciplina);
		return ResponseEntity.noContent().build();
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletarDisciplina(@PathVariable int id){
		disciplinaServ.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}

package br.com.cj.escola.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cj.escola.model.Disciplina;
import br.com.cj.escola.repository.DisciplinaRepository;
import br.com.cj.escola.service.exception.ObjectNotFoundException;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository disciplinaRepo;

	public List<Disciplina> findAll() {
		return disciplinaRepo.findAll();
	}

	public Disciplina save(Disciplina disciplina) {
		//disciplina.setId(null);
		return disciplinaRepo.save(disciplina);
	}

	public Disciplina findById(int id) {
		Optional<Disciplina> prof = disciplinaRepo.findById(id);
		return prof.orElseThrow(() -> new ObjectNotFoundException("Disciplina não encontrada"));
	}

	public void update(Disciplina disciplina) {
		findById(disciplina.getId());
		disciplinaRepo.save(disciplina);
	}

	public void deleteById(int id) {
		findById(id);
		disciplinaRepo.deleteById(id);
	}
}

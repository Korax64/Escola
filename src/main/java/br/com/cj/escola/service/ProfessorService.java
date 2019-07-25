package br.com.cj.escola.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cj.escola.model.Professor;
import br.com.cj.escola.repository.ProfessorRepository;
import br.com.cj.escola.service.exception.ObjectNotFoundException;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepo;
	
	public List<Professor> findAll(){
		return professorRepo.findAll();
	}
	
	public Professor save(Professor professor) {
//		if(professor.getId() != null) {
//			Professor novoProfessor=findById(professor.getId());
//			
//			if(novoProfessor != null) {
//				throw new ObjectNotFoundException("O Professor já existe.");
//			}
//		}
		//professor.setId(null);
		return professorRepo.save(professor);
	}
	
	public Professor findById(int id) {
		Optional<Professor> prof=professorRepo.findById(id);
		return prof.orElseThrow(()-> new ObjectNotFoundException("Professor não encontrado"));
	}
	
	public void update(Professor professor) {
		findById(professor.getId());
		professorRepo.save(professor);
	}
	
	public void deleteById(int id) {
		findById(id);
		professorRepo.deleteById(id);
	}
}

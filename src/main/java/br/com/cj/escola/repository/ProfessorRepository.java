package br.com.cj.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cj.escola.model.Professor;

@Repository
public interface ProfessorRepository  extends JpaRepository<Professor, Integer>{

}

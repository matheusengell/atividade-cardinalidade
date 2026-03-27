package com.atividade.atividade4.repository;

import com.atividade.atividade4.model.Curso;
import com.atividade.atividade4.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}

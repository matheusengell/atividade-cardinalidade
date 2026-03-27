package com.atividade.atividade4.repository;

import com.atividade.atividade4.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findByProfessorNome(String nome);

    List<Curso> findByProfessorId(Long id);

    Optional<Curso> findByIdAndNome(Long id, String nome);

}

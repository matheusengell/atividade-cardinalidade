package com.atividade.atividade5.repository;

import com.atividade.atividade5.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByProjetoId(Long id);

    Optional<Tarefa> findByIdAndTitulo(Long id, String titulo);

    List<Tarefa> findByTituloContainingIgnoreCase(String titulo);

 }

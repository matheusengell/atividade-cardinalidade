package com.atividade.atividade1.repository;

import com.atividade.atividade1.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findByDepartamentoId(Long departamentoId);

    List<Funcionario> findByNome(String nome);

    Optional<Funcionario> findByIdAndNome(Long id, String nome);
}

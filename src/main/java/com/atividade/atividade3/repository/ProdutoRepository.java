package com.atividade.atividade3.repository;

import com.atividade.atividade3.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {


    List<Produto> findByCategoriaId(Long id);

    List<Produto> findByNome(String nome);

    List<Produto> findByCategoriaNome(String nome);

    Optional<Produto> findByIdAndNome(Long id, String nome);
}

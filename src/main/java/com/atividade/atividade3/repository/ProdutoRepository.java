package com.atividade.atividade3.repository;

import com.atividade.atividade3.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {



}

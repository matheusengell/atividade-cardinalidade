package com.atividade.atividade2.repository;

import com.atividade.atividade2.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByClienteNome(String nome);

    Optional<Pedido> findByIdAndDescricaoContainingIgnoreCase(Long id, String descricao);

    List<Pedido> findByClienteId(Long id);


}

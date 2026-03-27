package com.atividade.atividade2.dto.pedido;

import jakarta.persistence.Column;

import java.time.LocalDate;

public record PedidoResponseDto(

         Long id,
         Double valor,
         LocalDate dataPedido,
         String descricao,
         Long idCliente,
         String nomeCliente
) {
}

package com.atividade.atividade2.dto.pedido;

import java.time.LocalDate;

public record PedidoRequestDto(

        Double valor,
        LocalDate dataPedido,
        String descricao,
        Long idCliente
) {
}
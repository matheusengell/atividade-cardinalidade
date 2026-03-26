package com.atividade.atividade2.mapper;

import com.atividade.atividade2.dto.pedido.PedidoRequestDto;
import com.atividade.atividade2.dto.pedido.PedidoResponseDto;
import com.atividade.atividade2.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    public Pedido paraEntidade(PedidoRequestDto requestDto){
        return new Pedido(
                requestDto.valor(),
                requestDto.dataPedido(),
                requestDto.descricao()
        );
    }

    public PedidoResponseDto paraDto(Pedido pedido){
        return new PedidoResponseDto(
                pedido.getId(),
                pedido.getValor(),
                pedido.getDataPedido()
        );
    }
}

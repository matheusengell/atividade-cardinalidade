package com.atividade.atividade3.mapper;

import com.atividade.atividade3.dto.pedido.ProdutoRequestDto;
import com.atividade.atividade3.dto.pedido.ProdutoResponseDto;
import com.atividade.atividade3.model.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

public Produto paraEntidade(ProdutoRequestDto requestDto){
    return new Produto(
            requestDto.nome(),
            requestDto.preco()
    );
}

public ProdutoResponseDto paraDto(Produto produto){
    return new ProdutoResponseDto(
            produto.getId(),
            produto.getNome(),
            produto.getPreco(),
            produto.getCategoria().getNome()
    );
}
}

package com.atividade.atividade3.dto.produto;

public record ProdutoRequestDto(

        String nome,
        Double preco,
        Long idCategoria
) {
}
package com.atividade.atividade3.dto.produto;

public record ProdutoResponseDto(

         Long id,
         String nome,
         Double preco,
         String nomeCategoria
) {
}

package com.atividade.atividade3.dto.pedido;

import com.atividade.atividade3.model.Categoria;
import jakarta.persistence.Column;

public record ProdutoResponseDto(

         Long id,
         String nome,
         Double preco,
         String nomeCategoria
) {
}

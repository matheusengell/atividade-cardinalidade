package com.atividade.atividade5.dto.projeto;

import jakarta.persistence.Column;

public record ProjetoResponseDto(

        Long id,
        String nome,
        String descricao
) {
}

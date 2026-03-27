package com.atividade.atividade5.dto.tarefa;

import jakarta.persistence.Column;

public record TarefaResponseDto(
        Long id,
        String titulo,
        String descricao,
        Long projetoId
) {
}

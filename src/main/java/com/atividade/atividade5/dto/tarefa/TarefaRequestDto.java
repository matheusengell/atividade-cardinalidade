package com.atividade.atividade5.dto.tarefa;

public record TarefaRequestDto(

        String titulo,
        String descricao,
        Long projetoId
) {
}
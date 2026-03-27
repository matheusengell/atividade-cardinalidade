package com.atividade.atividade4.dto.professor;

import jakarta.persistence.Column;

public record ProfessorResponseDto(
         Long id,
         String nome,
         String especialidade
) {
}

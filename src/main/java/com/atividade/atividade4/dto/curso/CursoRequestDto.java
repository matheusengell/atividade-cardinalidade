package com.atividade.atividade4.dto.curso;

public record CursoRequestDto(

        String nome,
        Integer cargaHoraria,
        Long idProfessor
) {
}

package com.atividade.atividade4.mapper;

import com.atividade.atividade4.dto.curso.CursoRequestDto;
import com.atividade.atividade4.dto.curso.CursoResponseDto;
import com.atividade.atividade4.model.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {

    public Curso paraEntidade(CursoRequestDto requestDto){
        return new Curso(
                requestDto.nome(),
                requestDto.cargaHoraria()
        );
    }

    public CursoResponseDto paraDto(Curso curso){
        return new CursoResponseDto(
                curso.getId(),
                curso.getNome(),
                curso.getProfessor().getNome()
        );
    }
}

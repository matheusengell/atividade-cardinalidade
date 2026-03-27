package com.atividade.atividade4.mapper;

import com.atividade.atividade4.dto.professor.ProfessorRequestDto;
import com.atividade.atividade4.dto.professor.ProfessorResponseDto;
import com.atividade.atividade4.model.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public Professor paraEntidade(ProfessorRequestDto requestDto){
        return new Professor(
                requestDto.nome(),
                requestDto.especialidade()
        );
    }

    public ProfessorResponseDto paraDto(Professor professor){
        return new ProfessorResponseDto(
                professor.getId(),
                professor.getNome(),
                professor.getEspecialidade()
        );
    }
}

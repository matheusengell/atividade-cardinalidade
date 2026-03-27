package com.atividade.atividade5.mapper;

import com.atividade.atividade4.dto.professor.ProfessorRequestDto;
import com.atividade.atividade4.dto.professor.ProfessorResponseDto;
import com.atividade.atividade4.model.Professor;
import com.atividade.atividade5.dto.tarefa.TarefaRequestDto;
import com.atividade.atividade5.dto.tarefa.TarefaResponseDto;
import com.atividade.atividade5.model.Tarefa;
import org.springframework.stereotype.Component;

@Component
public class TarefaMapper {

    public Tarefa paraEntidade(TarefaRequestDto requestDto){
        return new Tarefa(
                requestDto.titulo(),
                requestDto.descricao()
        );
    }

    public TarefaResponseDto paraDto(Tarefa tarefa){
        return new TarefaResponseDto(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getProjeto().getId()
        );
    }

}

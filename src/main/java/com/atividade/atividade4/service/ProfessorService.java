package com.atividade.atividade4.service;

import com.atividade.atividade4.dto.professor.ProfessorRequestDto;
import com.atividade.atividade4.dto.professor.ProfessorResponseDto;
import com.atividade.atividade4.mapper.ProfessorMapper;
import com.atividade.atividade4.model.Curso;
import com.atividade.atividade4.model.Professor;
import com.atividade.atividade4.repository.CursoRepository;
import com.atividade.atividade4.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProfessorService {

    private final ProfessorRepository repository;
    private ProfessorMapper mapper;

    public ProfessorResponseDto criar(ProfessorRequestDto requestDto){
        Professor professor = mapper.paraEntidade(requestDto);
        repository.save(professor);
        return mapper.paraDto(professor);
    }

    public List<ProfessorResponseDto> listarTodos(){
        List<Professor> professores = repository.findAll();

        return professores.stream()
                .map(mapper::paraDto)
                .toList();
    }

}

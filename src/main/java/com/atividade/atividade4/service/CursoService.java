package com.atividade.atividade4.service;

import com.atividade.atividade4.dto.curso.CursoRequestDto;
import com.atividade.atividade4.dto.curso.CursoResponseDto;
import com.atividade.atividade4.dto.professor.ProfessorResponseDto;
import com.atividade.atividade4.mapper.CursoMapper;
import com.atividade.atividade4.model.Curso;
import com.atividade.atividade4.model.Professor;
import com.atividade.atividade4.repository.CursoRepository;
import com.atividade.atividade4.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CursoService {

    private final CursoRepository repository;
    private final ProfessorRepository professorRepository;
    private final CursoMapper mapper;

    public CursoResponseDto cadastrar(CursoRequestDto requestDto){
        Professor professor = professorRepository.findById(requestDto.idProfessor())
                .orElseThrow(()-> new RuntimeException("Professor não encontrado"));

        Curso curso = mapper.paraEntidade(requestDto);

        curso.setProfessor(professor);
        repository.save(curso);
        return mapper.paraDto(curso);
    }

    public List<CursoResponseDto> listarTodos(){
        List<Curso> cursos = repository.findAll();

        return cursos.stream()
                .map(mapper::paraDto)
                .toList();
    }


    public List<CursoResponseDto> listarPorNomeProfessor(String nome){
        List<Curso> cursos = repository.findByProfessorNome(nome);

        return cursos.stream()
                .map(mapper::paraDto)
                .toList();
    }

    public List<CursoResponseDto> listarPorIdProfessor(Long id){
        List<Curso> cursos = repository.findByProfessorId(id);

        return cursos.stream()
                .map(mapper::paraDto)
                .toList();
    }

    public CursoResponseDto listarPorIdAndNome(Long id,String nome){
        Curso curso = repository.findByIdAndNome(id, nome)
                .orElseThrow(()-> new RuntimeException("Curso não encontrado"));

        return mapper.paraDto(curso);
    }


}

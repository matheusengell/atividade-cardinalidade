package com.atividade.atividade5.service;

import com.atividade.atividade5.dto.tarefa.TarefaRequestDto;
import com.atividade.atividade5.dto.tarefa.TarefaResponseDto;
import com.atividade.atividade5.mapper.ProjetoMapper;
import com.atividade.atividade5.mapper.TarefaMapper;
import com.atividade.atividade5.model.Projeto;
import com.atividade.atividade5.model.Tarefa;
import com.atividade.atividade5.repository.ProjetoRepository;
import com.atividade.atividade5.repository.TarefaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TarefaService {

    private final TarefaRepository repository;
    private final ProjetoRepository projetoRepository;
    private final TarefaMapper mapper;

    public TarefaResponseDto criar(TarefaRequestDto requestDto){
        Projeto projeto = projetoRepository.findById(requestDto.projetoId())
                .orElseThrow(()-> new RuntimeException("Projeto não encontrado"));

        Tarefa tarefa = mapper.paraEntidade(requestDto);
        tarefa.setProjeto(projeto);
        repository.save(tarefa);
        return mapper.paraDto(tarefa);
    }

    public List<TarefaResponseDto> listarTodas(){
        List<Tarefa> tarefas = repository.findAll();
        return tarefas.stream()
                .map(mapper::paraDto)
                .toList();
    }

    public List<TarefaResponseDto> listarPorProjetoId(Long id){
        List<Tarefa> tarefas = repository.findByProjetoId(id);
        return tarefas.stream()
                .map(mapper::paraDto)
                .toList();
    }

    public List<TarefaResponseDto> listarPorTitulo(String titulo){
        List<Tarefa> tarefas = repository.findByTituloContainingIgnoreCase(titulo);
        return tarefas.stream()
                .map(mapper::paraDto)
                .toList();
    }

    public TarefaResponseDto listarPorIdAndTitulo(Long id, String titulo){
        Tarefa tarefa = repository.findByIdAndTitulo(id, titulo)
                .orElseThrow(()-> new RuntimeException("Tarefa não encontrada"));

        return mapper.paraDto(tarefa);
    }

}

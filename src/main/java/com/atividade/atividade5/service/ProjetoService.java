package com.atividade.atividade5.service;

import com.atividade.atividade5.dto.projeto.ProjetoRequestDto;
import com.atividade.atividade5.dto.projeto.ProjetoResponseDto;
import com.atividade.atividade5.mapper.ProjetoMapper;
import com.atividade.atividade5.model.Projeto;
import com.atividade.atividade5.repository.ProjetoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjetoService {


    private final ProjetoRepository repository;
    private final ProjetoMapper mapper;

    public ProjetoResponseDto criar(ProjetoRequestDto requestDto){
        Projeto projeto = mapper.paraEntidade(requestDto);
        repository.save(projeto);
        return mapper.paraDto(projeto);
    }

    public List<ProjetoResponseDto> listarTodos(){
        List<Projeto> projetos = repository.findAll();

        return projetos.stream()
                .map(mapper::paraDto)
                .toList();
    }

}

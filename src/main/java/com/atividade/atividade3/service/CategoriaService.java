package com.atividade.atividade3.service;

import com.atividade.atividade3.dto.cliente.CategoriaRequestDto;
import com.atividade.atividade3.dto.cliente.CategoriaResponseDto;
import com.atividade.atividade3.mapper.CategoriaMapper;
import com.atividade.atividade3.model.Categoria;
import com.atividade.atividade3.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoriaService {


    private final CategoriaRepository repository;
    private final CategoriaMapper mapper;

    public CategoriaResponseDto criar(CategoriaRequestDto requestDto){
        Categoria categoria = mapper.paraEntidade(requestDto);
        repository.save(categoria);
        return mapper.paraDto(categoria);
    }

    public CategoriaResponseDto buscarPorId(Long id){
        Categoria categoria = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Categoria não encontrada"));

        return mapper.paraDto(categoria);
    }



}

package com.atividade.atividade3.mapper;

import com.atividade.atividade3.dto.categoria.CategoriaRequestDto;
import com.atividade.atividade3.dto.categoria.CategoriaResponseDto;
import com.atividade.atividade3.model.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public Categoria paraEntidade(CategoriaRequestDto requestDto){
        return new Categoria(
                requestDto.nome()
        );
    }

    public CategoriaResponseDto paraDto(Categoria categoria){
        return new CategoriaResponseDto(
                categoria.getId(),
                categoria.getNome()
        );
    }
}

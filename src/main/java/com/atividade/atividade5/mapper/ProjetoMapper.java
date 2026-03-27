package com.atividade.atividade5.mapper;

import com.atividade.atividade5.dto.projeto.ProjetoRequestDto;
import com.atividade.atividade5.dto.projeto.ProjetoResponseDto;
import com.atividade.atividade5.model.Projeto;
import org.springframework.stereotype.Component;

@Component
public class ProjetoMapper {


    public Projeto paraEntidade(ProjetoRequestDto requestDto){
        return new Projeto(
                requestDto.nome(),
                requestDto.descricao()
        );
    }

    public ProjetoResponseDto paraDto(Projeto projeto){
        return new ProjetoResponseDto(
                projeto.getId(),
                projeto.getNome(),
                projeto.getDescricao()
        );
    }

}

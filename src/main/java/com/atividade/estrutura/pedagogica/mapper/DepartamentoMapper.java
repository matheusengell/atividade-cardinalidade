package com.atividade.estrutura.pedagogica.mapper;

import com.atividade.estrutura.pedagogica.dto.departamento.DepartamentoRequestDto;
import com.atividade.estrutura.pedagogica.dto.departamento.DepartamentoResponseDto;
import com.atividade.estrutura.pedagogica.model.Departamento;
import org.springframework.stereotype.Component;

@Component
public class DepartamentoMapper {

    public Departamento paraEntidade(DepartamentoRequestDto requestDto){
        return new Departamento(
                requestDto.nome()
        );
    }

    public DepartamentoResponseDto paraDto(Departamento departamento){
        return new DepartamentoResponseDto(
                departamento.getId(),
                departamento.getNome()
        );
    }
}

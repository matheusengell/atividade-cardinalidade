package com.atividade.atividade1.mapper;

import com.atividade.atividade1.dto.departamento.DepartamentoRequestDto;
import com.atividade.atividade1.dto.departamento.DepartamentoResponseDto;
import com.atividade.atividade1.model.Departamento;
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

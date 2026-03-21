package com.atividade.atividade1.mapper;

import com.atividade.atividade1.dto.funcionario.FuncionarioRequestDto;
import com.atividade.atividade1.dto.funcionario.FuncionarioResponseDto;
import com.atividade.atividade1.model.Funcionario;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    public Funcionario paraEntidade(FuncionarioRequestDto requestDto){
        return new Funcionario(
                requestDto.nome()
        );
    }

    public FuncionarioResponseDto paraDto(Funcionario funcionario){
        return new FuncionarioResponseDto(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getDepartamento().getId()
        );
    }
}

package com.atividade.estrutura.pedagogica.mapper;

import com.atividade.estrutura.pedagogica.dto.funcionario.FuncionarioRequestDto;
import com.atividade.estrutura.pedagogica.dto.funcionario.FuncionarioResponseDto;
import com.atividade.estrutura.pedagogica.model.Funcionario;
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

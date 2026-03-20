package com.atividade.estrutura.pedagogica.service;

import com.atividade.estrutura.pedagogica.dto.departamento.DepartamentoRequestDto;
import com.atividade.estrutura.pedagogica.dto.departamento.DepartamentoResponseDto;
import com.atividade.estrutura.pedagogica.mapper.DepartamentoMapper;
import com.atividade.estrutura.pedagogica.model.Departamento;
import com.atividade.estrutura.pedagogica.repository.DepartamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartamentoService {

    private final DepartamentoRepository repository;
    private final DepartamentoMapper mapper;

    public DepartamentoResponseDto criarDepartamento(DepartamentoRequestDto requestDto){
        Departamento departamento = mapper.paraEntidade(requestDto);
        repository.save(departamento);
        return mapper.paraDto(departamento);
    }


    public DepartamentoResponseDto buscarPorId(Long id){
        Departamento departamento = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Não encontrado"));

        return mapper.paraDto(departamento);
    }

    public List<DepartamentoResponseDto> listarDepartamento(){
        List<Departamento> departamentos = repository.findAll();

        return departamentos.stream()
                .map(mapper::paraDto)
                .toList();
    }




}

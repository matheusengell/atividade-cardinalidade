package com.atividade.estrutura.pedagogica.service;

import com.atividade.estrutura.pedagogica.dto.funcionario.FuncionarioRequestDto;
import com.atividade.estrutura.pedagogica.dto.funcionario.FuncionarioResponseDto;
import com.atividade.estrutura.pedagogica.mapper.FuncionarioMapper;
import com.atividade.estrutura.pedagogica.model.Departamento;
import com.atividade.estrutura.pedagogica.model.Funcionario;
import com.atividade.estrutura.pedagogica.repository.DepartamentoRepository;
import com.atividade.estrutura.pedagogica.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FuncionarioService {

    private final DepartamentoRepository departamentoRepository;
    private final FuncionarioRepository repository;
    private final FuncionarioMapper mapper;


    public FuncionarioResponseDto criarFuncionario(FuncionarioRequestDto requestDto){
        Departamento departamento = departamentoRepository.findById(requestDto.idDepartamento())
                .orElseThrow(()-> new RuntimeException("Não encontrado"));

        Funcionario funcionario = mapper.paraEntidade(requestDto);

        funcionario.setDepartamento(departamento);

        return mapper.paraDto(repository.save(funcionario));
    }

    public List<FuncionarioResponseDto> listarFuncionarios(){
        List<Funcionario> funcionarios = repository.findAll();

        return funcionarios.stream()
                .map(mapper::paraDto)
                .toList();
    }

    public List<FuncionarioResponseDto> listarPorNome(String nome){
        List<Funcionario> funcionarios = repository.findByNome(nome);

        return funcionarios.stream()
                .map(mapper::paraDto)
                .toList();
    }

    public List<FuncionarioResponseDto> listarPorDepartamentoId(Long dptoId){
        List<Funcionario> funcionarios = repository.findByDepartamentoId(dptoId);

        return funcionarios.stream()
                .map(mapper::paraDto)
                .toList();
    }

    public FuncionarioResponseDto buscarPorNomeId(Long id,String nome ){
        Funcionario funcionario = repository.findByIdAndNome(id, nome)
                .orElseThrow(()-> new RuntimeException("Não encontrado"));

        return mapper.paraDto(funcionario);
    }


}

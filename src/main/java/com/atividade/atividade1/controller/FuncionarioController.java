package com.atividade.atividade1.controller;

import com.atividade.atividade1.dto.funcionario.FuncionarioRequestDto;
import com.atividade.atividade1.dto.funcionario.FuncionarioResponseDto;
import com.atividade.atividade1.service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
@AllArgsConstructor
public class FuncionarioController {
    
    private final FuncionarioService service;
    
    
    @PostMapping
    public FuncionarioResponseDto criarFuncionario(@RequestBody FuncionarioRequestDto requestDto){
        return service.criarFuncionario(requestDto);
    }
    
    @GetMapping
    public List<FuncionarioResponseDto> listarTodos(){
        return service.listarFuncionarios();
    }
    
    @GetMapping("/departamento/{departamentoId}")
    public List<FuncionarioResponseDto> listarPorDepartamentoId(@PathVariable Long departamentoId){
        return service.listarPorDepartamentoId(departamentoId);
    }

    @GetMapping("/nome/{nome}")
    public List<FuncionarioResponseDto> listarPorNome(@PathVariable String nome) {
        return service.listarPorNome(nome);
    }

    @GetMapping("/filtro/{id}/{nome}")
    public FuncionarioResponseDto listarPorNomeId(@PathVariable  Long id, @PathVariable String nome) {
        return service.buscarPorNomeId(id, nome);
    }




    
}

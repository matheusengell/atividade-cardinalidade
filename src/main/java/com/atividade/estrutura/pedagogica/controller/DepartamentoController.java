package com.atividade.estrutura.pedagogica.controller;

import com.atividade.estrutura.pedagogica.dto.departamento.DepartamentoRequestDto;
import com.atividade.estrutura.pedagogica.dto.departamento.DepartamentoResponseDto;
import com.atividade.estrutura.pedagogica.service.DepartamentoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
@AllArgsConstructor
public class DepartamentoController {

    private final DepartamentoService service;

    @PostMapping
    public DepartamentoResponseDto criarDepartamento(@RequestBody DepartamentoRequestDto requestDto){
        return service.criarDepartamento(requestDto);
    }

    @GetMapping("/{id}")
    public DepartamentoResponseDto buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @GetMapping
    public List<DepartamentoResponseDto> listarTodos(){
        return service.listarDepartamento();
    }

}

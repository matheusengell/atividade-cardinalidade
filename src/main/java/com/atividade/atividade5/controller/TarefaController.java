package com.atividade.atividade5.controller;

import com.atividade.atividade5.dto.tarefa.TarefaRequestDto;
import com.atividade.atividade5.dto.tarefa.TarefaResponseDto;
import com.atividade.atividade5.service.TarefaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
@AllArgsConstructor
public class TarefaController {


    private final TarefaService service;

    @PostMapping
    public TarefaResponseDto criar(@RequestBody TarefaRequestDto requestDto){
        return service.criar(requestDto);
    }

    @GetMapping
    public List<TarefaResponseDto> listarTodas(){
        return service.listarTodas();
    }

    @GetMapping("/projeto/{id}")
    public List<TarefaResponseDto> listarPorProjetoId(@PathVariable Long id){
        return service.listarPorProjetoId(id);
    }

    @GetMapping("/{titulo}")
    public List<TarefaResponseDto> listarPorTitulo(@PathVariable String titulo){
        return service.listarPorTitulo(titulo);
    }

    @GetMapping("/filtro/{id}/{titulo}")
    public TarefaResponseDto  listarPorIdAndTitulo(@PathVariable Long id,@PathVariable String titulo){
        return service.listarPorIdAndTitulo(id, titulo);
    }


}

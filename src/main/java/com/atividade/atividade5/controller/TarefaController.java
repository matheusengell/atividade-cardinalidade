package com.atividade.atividade5.controller;

import com.atividade.atividade5.dto.tarefa.TarefaRequestDto;
import com.atividade.atividade5.dto.tarefa.TarefaResponseDto;
import com.atividade.atividade5.service.TarefaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
@AllArgsConstructor
public class TarefaController {


    private final TarefaService service;

    @PostMapping
    public ResponseEntity<TarefaResponseDto> criar(@RequestBody TarefaRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criar(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponseDto>> listarTodas(){
        List<TarefaResponseDto> tarefas = service.listarTodas();
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/projeto/{id}")
    public ResponseEntity<List<TarefaResponseDto>> listarPorProjetoId(@PathVariable Long id){
        List<TarefaResponseDto> tarefas = service.listarPorProjetoId(id);
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/{titulo}")
    public ResponseEntity<List<TarefaResponseDto>> listarPorTitulo(@PathVariable String titulo){
        List<TarefaResponseDto> tarefas = service.listarPorTitulo(titulo);
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/filtro/{id}/{titulo}")
    public ResponseEntity<TarefaResponseDto> listarPorIdAndTitulo(@PathVariable Long id,@PathVariable String titulo){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.listarPorIdAndTitulo(id, titulo));
    }


}

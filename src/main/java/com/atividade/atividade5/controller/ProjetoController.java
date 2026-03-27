package com.atividade.atividade5.controller;

import com.atividade.atividade5.dto.projeto.ProjetoRequestDto;
import com.atividade.atividade5.dto.projeto.ProjetoResponseDto;
import com.atividade.atividade5.model.Projeto;
import com.atividade.atividade5.service.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projeto")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService service;

    @PostMapping
    public ResponseEntity<ProjetoResponseDto> criar(@RequestBody ProjetoRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criar(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<ProjetoResponseDto>> listarTodos(){
        List<ProjetoResponseDto> projetos = service.listarTodos();
        return ResponseEntity.ok(projetos);

    }


}

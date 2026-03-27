package com.atividade.atividade3.controller;

import com.atividade.atividade3.dto.categoria.CategoriaRequestDto;
import com.atividade.atividade3.dto.categoria.CategoriaResponseDto;
import com.atividade.atividade3.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService service;

    @PostMapping
    public ResponseEntity<CategoriaResponseDto> criar(@RequestBody CategoriaRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criar(requestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDto> listarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.buscarPorId(id));
    }
}

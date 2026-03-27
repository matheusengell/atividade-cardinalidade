package com.atividade.atividade3.controller;

import com.atividade.atividade3.dto.categoria.CategoriaRequestDto;
import com.atividade.atividade3.dto.categoria.CategoriaResponseDto;
import com.atividade.atividade3.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService service;

    @PostMapping
    public CategoriaResponseDto criar(@RequestBody CategoriaRequestDto requestDto){
        return service.criar(requestDto);
    }

    @GetMapping("/{id}")
    public CategoriaResponseDto listarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }
}

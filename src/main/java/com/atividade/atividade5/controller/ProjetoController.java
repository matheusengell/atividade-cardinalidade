package com.atividade.atividade5.controller;

import com.atividade.atividade5.dto.projeto.ProjetoRequestDto;
import com.atividade.atividade5.dto.projeto.ProjetoResponseDto;
import com.atividade.atividade5.service.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
@RequiredArgsConstructor
public class ProjetoController {


    private final ProjetoService service;

    @PostMapping
    public ProjetoResponseDto criar(@RequestBody ProjetoRequestDto requestDto){
        return service.criar(requestDto);
    }

    @GetMapping
    public List<ProjetoResponseDto> listarTodos(){
        return service.listarTodos();
    }


}

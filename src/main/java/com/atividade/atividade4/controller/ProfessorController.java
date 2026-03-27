package com.atividade.atividade4.controller;

import com.atividade.atividade4.dto.professor.ProfessorRequestDto;
import com.atividade.atividade4.dto.professor.ProfessorResponseDto;
import com.atividade.atividade4.service.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@AllArgsConstructor
public class ProfessorController {


    private final ProfessorService service;

    @PostMapping
    public ProfessorResponseDto criar(@RequestBody ProfessorRequestDto requestDto){
        return service.criar(requestDto);
    }

    @GetMapping
    public List<ProfessorResponseDto> listarTodos(){
        return service.listarTodos();
    }

}

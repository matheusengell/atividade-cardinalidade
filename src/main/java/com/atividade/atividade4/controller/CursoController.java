package com.atividade.atividade4.controller;

import com.atividade.atividade4.dto.curso.CursoRequestDto;
import com.atividade.atividade4.dto.curso.CursoResponseDto;
import com.atividade.atividade4.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
@RequiredArgsConstructor
public class CursoController {


    private final CursoService service;

    @PostMapping
    public CursoResponseDto cadastrar(@RequestBody CursoRequestDto requestDto){
        return service.cadastrar(requestDto);
    }

    @GetMapping
    public List<CursoResponseDto> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/professor/nome/{nome}")
    public List<CursoResponseDto> listarPorProfessorNome(@PathVariable String nome){
        return service.listarPorNomeProfessor(nome);
    }

    @GetMapping("/professor/id/{id}")
    public List<CursoResponseDto> listarPorProfessorId(@PathVariable Long id){
        return service.listarPorIdProfessor(id);
    }

    @GetMapping("/{id}/{nome}")
    public CursoResponseDto buscarPorIdAndNome(@PathVariable Long id, @PathVariable String nome){
        return service.listarPorIdAndNome(id, nome);
    }

}

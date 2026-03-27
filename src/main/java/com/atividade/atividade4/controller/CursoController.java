package com.atividade.atividade4.controller;

import com.atividade.atividade4.dto.curso.CursoRequestDto;
import com.atividade.atividade4.dto.curso.CursoResponseDto;
import com.atividade.atividade4.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
@RequiredArgsConstructor
public class CursoController {


    private final CursoService service;

    @PostMapping
    public ResponseEntity<CursoResponseDto> cadastrar(@RequestBody CursoRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.cadastrar(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<CursoResponseDto>> listarTodos(){
        List<CursoResponseDto> curso = service.listarTodos();
        return ResponseEntity.ok(curso);
    }

    @GetMapping("/professor/nome/{nome}")
    public ResponseEntity<List<CursoResponseDto>> listarPorProfessorNome(@PathVariable String nome){
        List<CursoResponseDto> cursoResponseDtos = service.listarPorNomeProfessor(nome);
        return ResponseEntity.ok(cursoResponseDtos);
    }

    @GetMapping("/professor/id/{id}")
    public ResponseEntity<List<CursoResponseDto>> listarPorProfessorId(@PathVariable Long id){
        List<CursoResponseDto> curso = service.listarPorIdProfessor(id);
        return ResponseEntity.ok(curso);
    }

    @GetMapping("/{id}/{nome}")
    public ResponseEntity<CursoResponseDto> buscarPorIdAndNome(@PathVariable Long id, @PathVariable String nome){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.listarPorIdAndNome(id, nome));
    }

}

package com.atividade.atividade4.controller;

import com.atividade.atividade4.dto.professor.ProfessorRequestDto;
import com.atividade.atividade4.dto.professor.ProfessorResponseDto;
import com.atividade.atividade4.model.Professor;
import com.atividade.atividade4.service.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
@AllArgsConstructor
public class ProfessorController {


    private final ProfessorService service;

    @PostMapping
    public ResponseEntity<ProfessorResponseDto> criar(@RequestBody ProfessorRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criar(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDto>> listarTodos(){
        List<ProfessorResponseDto> professor = service.listarTodos();
        return ResponseEntity.ok(professor);
    }

}

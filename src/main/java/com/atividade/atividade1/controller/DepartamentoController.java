package com.atividade.atividade1.controller;

import com.atividade.atividade1.dto.departamento.DepartamentoRequestDto;
import com.atividade.atividade1.dto.departamento.DepartamentoResponseDto;
import com.atividade.atividade1.service.DepartamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
@AllArgsConstructor
public class DepartamentoController {

    private final DepartamentoService service;

    @PostMapping
    public ResponseEntity<DepartamentoResponseDto> criarDepartamento(@RequestBody DepartamentoRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criarDepartamento(requestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoResponseDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoResponseDto>> listarTodos(){
        List<DepartamentoResponseDto> departamento = service.listarDepartamento();
        return ResponseEntity.ok(departamento);
    }

}

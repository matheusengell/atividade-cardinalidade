package com.atividade.atividade1.controller;

import com.atividade.atividade1.dto.funcionario.FuncionarioRequestDto;
import com.atividade.atividade1.dto.funcionario.FuncionarioResponseDto;
import com.atividade.atividade1.service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
@AllArgsConstructor
public class FuncionarioController {
    
    private final FuncionarioService service;
    
    
    @PostMapping
    public ResponseEntity<FuncionarioResponseDto> criarFuncionario(@RequestBody FuncionarioRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criarFuncionario(requestDto));
    }
    
    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDto>> listarTodos(){
        List<FuncionarioResponseDto> funcionarios = service.listarFuncionarios();
        return ResponseEntity.ok(funcionarios);
    }
    
    @GetMapping("/departamento/{departamentoId}")
    public ResponseEntity<List<FuncionarioResponseDto>> listarPorDepartamentoId(@PathVariable Long departamentoId){
        List<FuncionarioResponseDto> funcionarios = service.listarPorDepartamentoId(departamentoId);
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<FuncionarioResponseDto>> listarPorNome(@PathVariable String nome) {
        List<FuncionarioResponseDto> funcionarios = service.listarPorNome(nome);
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/filtro/{id}/{nome}")
    public ResponseEntity<FuncionarioResponseDto> listarPorNomeId(@PathVariable  Long id, @PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.buscarPorNomeId(id, nome));
    }




    
}

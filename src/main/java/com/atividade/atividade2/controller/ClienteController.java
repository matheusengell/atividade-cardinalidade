package com.atividade.atividade2.controller;

import com.atividade.atividade2.dto.cliente.ClienteRequestDto;
import com.atividade.atividade2.dto.cliente.ClienteResponseDto;
import com.atividade.atividade2.service.ClienteService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;


    @PostMapping
    public ResponseEntity<ClienteResponseDto> criar(@RequestBody ClienteRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criarCliente(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> listarTodos(){
        List<ClienteResponseDto> cliente = service.listarClientes();
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.listarPorId(id));
    }

    @GetMapping("/busca/{nome}")
    public ResponseEntity<List<ClienteResponseDto>> buscarPorNome(@PathVariable String nome) {
        List<ClienteResponseDto> cliente = service.listarPorNome(nome);
        return ResponseEntity.ok(cliente);
    }
    }

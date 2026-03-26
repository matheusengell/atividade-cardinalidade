package com.atividade.atividade2.controller;

import com.atividade.atividade2.dto.cliente.ClienteRequestDto;
import com.atividade.atividade2.dto.cliente.ClienteResponseDto;
import com.atividade.atividade2.service.ClienteService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;


    @PostMapping
    public ClienteResponseDto criar(@RequestBody ClienteRequestDto requestDto){
        return service.criarCliente(requestDto);
    }

    @GetMapping
    public List<ClienteResponseDto> listarTodos(){
        return service.listarClientes();
    }

    @GetMapping("/{id}")
    public ClienteResponseDto buscarPorId(@PathVariable Long id){
        return service.listarPorId(id);
    }

    @GetMapping("/busca/{nome}")
    public List<ClienteResponseDto> buscarPorNome(@PathVariable String nome) {
        return  service.listarPorNome(nome);
    }
    }

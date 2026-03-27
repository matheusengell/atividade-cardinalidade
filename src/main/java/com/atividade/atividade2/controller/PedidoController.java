package com.atividade.atividade2.controller;

import com.atividade.atividade2.dto.pedido.PedidoRequestDto;
import com.atividade.atividade2.dto.pedido.PedidoResponseDto;
import com.atividade.atividade2.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@AllArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @PostMapping
    public PedidoResponseDto criar(@RequestBody PedidoRequestDto requestDto){
        return service.criar(requestDto);
    }

    @GetMapping
    public List<PedidoResponseDto> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/cliente/{id}")
    public List<PedidoResponseDto> listarPorClienteId(@PathVariable Long id){
        return service.listarPorClienteId(id);
    }

    @GetMapping("/cliente/nome/{nome}")
    public List<PedidoResponseDto> listarPorClienteNome(@PathVariable String nome){
        return service.listarPorClienteNome(nome);
    }

    @GetMapping("/detalhe/{id}/{descricao}")
    public PedidoResponseDto listarPorClienteIdDescricao(@PathVariable Long id,@PathVariable String descricao){
        return service.listarPorIdEDescricao(id, descricao);
    }

}

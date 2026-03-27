package com.atividade.atividade2.controller;

import com.atividade.atividade2.dto.pedido.PedidoRequestDto;
import com.atividade.atividade2.dto.pedido.PedidoResponseDto;
import com.atividade.atividade2.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@AllArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @PostMapping
    public ResponseEntity<PedidoResponseDto> criar(@RequestBody PedidoRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criar(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDto>> listarTodos(){
        List<PedidoResponseDto> pedido = service.listarTodos();
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<PedidoResponseDto>> listarPorClienteId(@PathVariable Long id){
        List<PedidoResponseDto> pedido = service.listarPorClienteId(id);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/cliente/nome/{nome}")
    public ResponseEntity<List<PedidoResponseDto>> listarPorClienteNome(@PathVariable String nome){
        List<PedidoResponseDto> pedido = service.listarPorClienteNome(nome);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping("/detalhe/{id}/{descricao}")
    public ResponseEntity<PedidoResponseDto> listarPorClienteIdDescricao(@PathVariable Long id,@PathVariable String descricao){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.listarPorIdEDescricao(id, descricao));
    }

}

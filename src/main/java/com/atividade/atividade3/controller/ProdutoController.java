package com.atividade.atividade3.controller;

import com.atividade.atividade3.dto.produto.ProdutoRequestDto;
import com.atividade.atividade3.dto.produto.ProdutoResponseDto;
import com.atividade.atividade3.model.Produto;
import com.atividade.atividade3.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<ProdutoResponseDto> criar(@RequestBody ProdutoRequestDto requestDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criar(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDto>> listarTodos(){
        List<ProdutoResponseDto> produtos = service.listarTodos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/categoria/id/{id}")
    public ResponseEntity<List<ProdutoResponseDto>> buscarCategoriaId(@PathVariable Long id){
        List<ProdutoResponseDto> produtos = service.buscarPorCategoriaId(id);
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<ProdutoResponseDto>> buscarPorNome(@PathVariable String nome){
        List<ProdutoResponseDto> produtos = service.buscarPorNome(nome);
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/categoria/nome/{nome}")
    public ResponseEntity<List<ProdutoResponseDto>> buscarPorNomeCategoria(@PathVariable String nome) {
        List<ProdutoResponseDto> produtos = service.buscarPorNomeCategoria(nome);
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}/{nome}")
    public ResponseEntity<ProdutoResponseDto> buscarPorIdAndNome(@PathVariable Long id ,@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.buscarPorIdENome(id, nome));
    }
}
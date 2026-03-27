package com.atividade.atividade3.controller;

import com.atividade.atividade3.dto.produto.ProdutoRequestDto;
import com.atividade.atividade3.dto.produto.ProdutoResponseDto;
import com.atividade.atividade3.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ProdutoResponseDto criar(@RequestBody ProdutoRequestDto requestDto){
        return service.criar(requestDto);
    }

    @GetMapping
    public List<ProdutoResponseDto> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/categoria/id/{id}")
    public List<ProdutoResponseDto> buscarCategoriaId(@PathVariable Long id){
        return service.buscarPorCategoriaId(id);
    }

    @GetMapping("/nome/{nome}")
    public List<ProdutoResponseDto> buscarPorNome(@PathVariable String nome){
        return service.buscarPorNome(nome);
    }

    @GetMapping("/categoria/nome/{nome}")
    public List<ProdutoResponseDto> buscarPorNomeCategoria(@PathVariable String nome) {
        return service.buscarPorNomeCategoria(nome);
    }

    @GetMapping("/{id}/{nome}")
    public ProdutoResponseDto buscarPorIdAndNome(@PathVariable Long id ,@PathVariable String nome) {
        return service.buscarPorIdENome(id, nome);
    }
}

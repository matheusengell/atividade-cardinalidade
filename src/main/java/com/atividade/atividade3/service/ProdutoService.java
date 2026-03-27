package com.atividade.atividade3.service;

import com.atividade.atividade3.dto.pedido.ProdutoRequestDto;
import com.atividade.atividade3.dto.pedido.ProdutoResponseDto;
import com.atividade.atividade3.mapper.ProdutoMapper;
import com.atividade.atividade3.model.Categoria;
import com.atividade.atividade3.model.Produto;
import com.atividade.atividade3.repository.CategoriaRepository;
import com.atividade.atividade3.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    private final CategoriaRepository categoriaRepository;
    private final ProdutoMapper mapper;

    public ProdutoResponseDto criar(ProdutoRequestDto requestDto){
        Categoria categoria = categoriaRepository.findById(requestDto.idCategoria())
                .orElseThrow(()-> new RuntimeException("Categoria não encontrada"));

        Produto produto = mapper.paraEntidade(requestDto);

        produto.setCategoria(categoria);

        repository.save(produto);
        return mapper.paraDto(produto);
    }

    public List<ProdutoResponseDto> listarTodos(){
        List<Produto> produtos = repository.findAll();

        return produtos.stream()
                .map(mapper::paraDto)
                .toList();
    }

    public List<ProdutoResponseDto> buscarPorCategoriaId(Long id){
        List<Produto> produtos = repository.findByCategoriaId(id);

        return produtos.stream()
                .map(mapper::paraDto)
                .toList();
    }

    public List<ProdutoResponseDto> buscarPorNome(String nome){
        List<Produto> produtos = repository.findByNome(nome);

        return produtos.stream()
                .map(mapper::paraDto)
                .toList();
    }

    public List<ProdutoResponseDto> buscarPorNomeCategoria(String nome){
        List<Produto> produtos = repository.findByCategoriaNome(nome);

        return produtos.stream()
                .map(mapper::paraDto)
                .toList();
    }

    public ProdutoResponseDto buscarPorIdENome(Long id, String nome){
        Produto produto = repository.findByIdAndNome(id, nome)
                .orElseThrow(()-> new RuntimeException("Produto não encontrado"));

        return mapper.paraDto(produto);
    }

}

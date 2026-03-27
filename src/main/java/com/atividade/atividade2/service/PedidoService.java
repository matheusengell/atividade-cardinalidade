package com.atividade.atividade2.service;

import com.atividade.atividade2.dto.pedido.PedidoRequestDto;
import com.atividade.atividade2.dto.pedido.PedidoResponseDto;
import com.atividade.atividade2.mapper.PedidoMapper;
import com.atividade.atividade2.model.Cliente;
import com.atividade.atividade2.model.Pedido;
import com.atividade.atividade2.repository.ClienteRepository;
import com.atividade.atividade2.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;
    private final ClienteRepository clienteRepository;
    private final PedidoMapper mapper;

    public PedidoResponseDto criar(PedidoRequestDto requestDto){
        Cliente cliente = clienteRepository.findById(requestDto.idCliente())
                .orElseThrow(()-> new RuntimeException("Cliente não encontrado"));

        Pedido pedido = mapper.paraEntidade(requestDto, cliente);

        pedido.setCliente(cliente);

        repository.save(pedido);
        return mapper.paraDto(pedido);
    }

    public List<PedidoResponseDto> listarTodos(){
        List<Pedido> pedidos = repository.findAll();

        return pedidos.stream()
                .map(mapper::paraDto)
                .toList();
    }


    public List<PedidoResponseDto> listarPorClienteNome(String nome){
        List<Pedido> pedidos = repository.findByClienteNome(nome);
        return pedidos.stream()
                .map(mapper::paraDto)
                .toList();
    }

    public List<PedidoResponseDto> listarPorClienteId(Long id){
        List<Pedido> pedidos = repository.findByClienteId(id);
        return pedidos.stream()
                .map(mapper::paraDto)
                .toList();
    }

    public PedidoResponseDto listarPorIdEDescricao(Long id, String descricao){
        Pedido pedido = repository.findByIdAndDescricaoContainingIgnoreCase(id, descricao)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        return mapper.paraDto(pedido);
    }







}

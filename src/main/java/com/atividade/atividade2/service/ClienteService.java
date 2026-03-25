package com.atividade.atividade2.service;

import com.atividade.atividade2.dto.cliente.ClienteRequestDto;
import com.atividade.atividade2.dto.cliente.ClienteResponseDto;
import com.atividade.atividade2.mapper.ClienteMapper;
import com.atividade.atividade2.model.Cliente;
import com.atividade.atividade2.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteResponseDto criarCliente(ClienteRequestDto requestDto){
        Cliente cliente = mapper.paraEntidade(requestDto);
        repository.save(cliente);
        return mapper.paraDto(cliente);
    }

    public List<ClienteResponseDto> listarClientes(){
        List<Cliente> clientes = repository.findAll();

        return clientes.stream()
                .map(mapper::paraDto)
                .toList();
    }

}

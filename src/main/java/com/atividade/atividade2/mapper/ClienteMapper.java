package com.atividade.atividade2.mapper;

import com.atividade.atividade2.dto.cliente.ClienteRequestDto;
import com.atividade.atividade2.dto.cliente.ClienteResponseDto;
import com.atividade.atividade2.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente paraEntidade(ClienteRequestDto requestDto){
        return new Cliente(
                requestDto.nome(),
                requestDto.email()
        );
    }

    public ClienteResponseDto paraDto(Cliente cliente){
        return new ClienteResponseDto(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail()
        );
    }
}

package com.atividade.atividade2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private LocalDate dataPedido;

    @Column(nullable = false)
    private String descricao;


    public Pedido(Double valor, LocalDate dataPedido, String descricao) {
        this.valor = valor;
        this.dataPedido = dataPedido;
        this.descricao = descricao;
    }
}

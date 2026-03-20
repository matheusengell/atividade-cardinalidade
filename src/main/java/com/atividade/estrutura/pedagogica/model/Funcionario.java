package com.atividade.estrutura.pedagogica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;


    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;


    public Funcionario(String nome) {
        this.nome=nome;
    }
}

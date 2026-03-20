package com.atividade.estrutura.pedagogica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "departamento")
public class Departamento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;


    @OneToMany(mappedBy = "departamento")
    private List<Funcionario>funcionarios;


    public Departamento(String nome) {
        this.nome=nome;
    }
}

package com.fag.lucasmartins.arquitetura_software.domain.model;

public class Produto {

    private String nome;
    private Double preco;
    private Integer estoque;
    private Double precoFinal;

    public Produto(String nome, Double preco, Integer estoque) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome obrigatório");
        }

        if (preco == null || preco <= 0) {
            throw new IllegalArgumentException("Preço inválido");
        }

        if (estoque == null || estoque < 0) {
            throw new IllegalArgumentException("Estoque inválido");
        }

        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;

        if (estoque >= 50) {
            this.precoFinal = preco - (preco * 0.10);
        } else {
            this.precoFinal = preco;
        }

        if (nome.toLowerCase().contains("premium") && preco < 100) {
            throw new IllegalArgumentException("Produto premium precisa custar 100+");
        }
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public Double getPrecoFinal() {
        return precoFinal;
    }
}
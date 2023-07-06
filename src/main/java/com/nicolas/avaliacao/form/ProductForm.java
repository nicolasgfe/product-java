package com.nicolas.avaliacao.form;

import com.nicolas.avaliacao.model.Product;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class ProductForm {
    @Length(max = 50)
    @NotNull
    @NotEmpty
    private String nome;
    @Length(max = 200)
    @NotNull
    @NotEmpty
    private String descricao;
    @NotNull
    @NotEmpty
    private float valor;
    @NotNull
    @NotEmpty
    private int quantidade;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Product converter() {
        return new Product(nome, descricao, valor, quantidade);
    }
}

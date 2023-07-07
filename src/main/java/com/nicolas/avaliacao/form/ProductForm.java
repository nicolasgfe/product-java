package com.nicolas.avaliacao.form;

import com.nicolas.avaliacao.model.Product;
import com.nicolas.avaliacao.repository.ProductRepository;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

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
    private BigDecimal valor;
    @NotNull
    private Integer quantidade;


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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public Product converter(Long id, ProductRepository productRepository) {
        Product product = productRepository.findById(id).get();
        product.setNome(nome);
        product.setDescricao(descricao);
        product.setValor(valor);
        product.setQuantidade(quantidade);
        return product;
    }

    public Product converter() {
        return new Product(nome, descricao, valor, quantidade);
    }
}

package com.nicolas.avaliacao.dto;


import com.nicolas.avaliacao.model.Product;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

public class ProductDTO {
    private long id;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private Integer quantidade;

    public ProductDTO(Product product) {
        super();
        this.id = product.getId();
        this.nome = product.getNome();
        this.descricao = product.getDescricao();
        this.valor = product.getValor();
        this.quantidade = product.getQuantidade();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public static Page<ProductDTO> converter(Page<Product> products) {
        return products.map(ProductDTO::new);
    }
}

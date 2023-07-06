package com.nicolas.avaliacao.dto;


import com.nicolas.avaliacao.model.Product;
import org.springframework.data.domain.Page;

public class ProductDTO {
    private long id;
    private String nome;
    private String descricao;
    private float valor;
    private int quantidade;

    public ProductDTO(Product product) {
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

    public static Page<ProductDTO> converter(Page<Product> products) {
        return products.map(ProductDTO::new);
    }
}

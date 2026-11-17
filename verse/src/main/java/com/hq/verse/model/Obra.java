package com.hq.verse.model;

import jakarta.persistence.*;

@Entity
public class Obra {
    @Id
    @GeneratedValue
    private Integer id;

    private String titulo;

    private String autor;

    private String imagem;

    private Double preco;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Obra() {
    }

    public Obra(Integer id, String titulo, String autor, Double preco, String imagem, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.categoria = categoria;
        this.imagem = imagem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}

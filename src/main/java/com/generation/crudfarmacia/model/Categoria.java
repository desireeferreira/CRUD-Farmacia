package com.generation.crudfarmacia.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    
    private String nome;
    
    @JsonIgnore
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)    
    private List<Produto> produtos;
   
    public List<Produto> getProdutos() {
        return produtos;
    }
    
	public Categoria(Long id, String nome, List<Produto> produtos) {
		super();
		this.id = id;
		this.nome = nome;
		this.produtos = produtos;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
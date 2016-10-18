package br.edu.utfpr.jsf.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // define a classe como sendo uma tabela do banco de dados
@Table(name="produto") // define detalhes da tabela
public class Produto implements Serializable {
	
	private static final long serialVersionUID = -7242170108753050541L;
	
	@Id // define a propriedade id como primary key
	@GeneratedValue // define a propriedade id como auto incremento
	@Column(name="id") // define detalhes da propriedade
	private Long id;
	@Column(name="nome",nullable=false,length=60) // define detalhes da propriedade
	private String nome;
	@Column(name="descricao",length=255) // define detalhes da propriedade
	private String descricao;
	@Column(name="saldo",nullable=false) // define detalhes da propriedade
	private Integer saldo;
	@Column(name="preco",nullable=false,precision=8,scale=2) // define detalhes da propriedade
	private Double preco;
	
	public Produto() {}

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}

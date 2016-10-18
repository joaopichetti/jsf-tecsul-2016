package br.edu.utfpr.jsf.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // define a classe como sendo uma tabela do banco de dados
@Table(name="cliente") // define detalhes da tabela
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1981323199248445959L;
	
	@Id // define a propriedade id como primary key
	@GeneratedValue // define a propriedade id como auto incremento
	@Column(name="id") // define detalhes da propriedade
	private Long id;
	@Column(name="nome",nullable=false,length=60) // define detalhes da propriedade
	private String nome;
	@Column(name="tipo",nullable=false,length=1) // define detalhes da propriedade
	private String tipo;
	@Column(name="cpf_cnpj",nullable=false,length=14) // define detalhes da propriedade
	private String cpfCnpj;
	@Column(name="email",nullable=false,length=100) // define detalhes da propriedade
	private String email;
	
	public Cliente() {}

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

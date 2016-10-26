package br.edu.utfpr.jsf.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity // define a classe como sendo uma tabela do banco de dados
@Table(name="venda_produto") // define detalhes da tabela
public class VendaProduto implements Serializable {
	
	private static final long serialVersionUID = -1999102608573115262L;
	
	@Id // define a propriedade id como primary key
	@GeneratedValue // define a propriedade id como auto incremento
	@Column(name="id") // define detalhes da propriedade 
	private Long id;
	@Column(name="valor",nullable=false,precision=15,scale=2) // define detalhes da propriedade 
	private BigDecimal valor;
	@Column(name="quantidade",nullable=false) // define detalhes da propriedade 
	private Integer quantidade;
	@ManyToOne(optional=false) // define relacionamento muitos para um
	@JoinColumn(name="produto_id") // define detalhes da propriedade
	private Produto produto = new Produto();
	@ManyToOne(optional=false) // define relacionamento muitos para um
	@JoinColumn(name="venda_id") // define detalhes da propriedade
	private Venda venda;
	
	public VendaProduto() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public BigDecimal getTotal() {
		if (quantidade != null && valor != null) {
			return valor.multiply(new BigDecimal(quantidade));
		} else {
			return BigDecimal.ZERO;
		}
	}

}

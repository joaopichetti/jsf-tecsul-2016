package br.edu.utfpr.jsf.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity // define a classe como sendo uma tabela do banco de dados
@Table(name="venda") // define detalhes da tabela
public class Venda implements Serializable {
	
	private static final long serialVersionUID = 1845289079780297042L;
	
	@Id // define a propriedade id como primary key
	@GeneratedValue // define a propriedade id como auto incremento
	@Column(name="id") // define detalhes da propriedade 
	private Long id;
	@Column(name="numero",nullable=false) // define detalhes da propriedade
	private Integer numero;
	@Temporal(TemporalType.DATE) // define que sera gravada apenas a data sem o horario
	@Column(name="data",nullable=false) // define detalhes da propriedade
	private Calendar data = Calendar.getInstance();
	// define relacionamento inverso um para muitos, esse campo nao sera criado no banco de dados
	@OneToMany(mappedBy="venda",fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	private List<VendaProduto> produtos = new ArrayList<>();
	
	public Venda() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public List<VendaProduto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<VendaProduto> produtos) {
		this.produtos = produtos;
	}
	
	public void addProduto(VendaProduto produto) {
		if (this.produtos == null) {
			this.produtos = new ArrayList<>();
		}
		produto.setVenda(this);
		this.produtos.add(produto);
	}
	
	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		for (VendaProduto vendaProduto : produtos) {
			total = total.add(vendaProduto.getTotal());
		}
		return total;
	}

}
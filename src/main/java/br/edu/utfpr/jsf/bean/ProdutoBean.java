package br.edu.utfpr.jsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.edu.utfpr.jsf.dao.DAO;
import br.edu.utfpr.jsf.modelo.Produto;

@ManagedBean
public class ProdutoBean {
	
	private Produto produto;
	
	public ProdutoBean() {
		produto = new Produto();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public void gravar() {
		System.out.println("Gravando produto... " + this.produto.getNome());
		DAO<Produto> dao = new DAO<>(Produto.class);
		if (this.produto.getId() == null) {
			dao.adiciona(this.produto);
		} else {
			dao.atualiza(this.produto);
		}
		limparCampos();
	}
	
	private void limparCampos() {
		this.produto = new Produto();
	}
	
	public List<Produto> getProdutos() {
		DAO<Produto> dao = new DAO<>(Produto.class);
		List<Produto> produtos = dao.listaTodos();
		return produtos;
	}
	
	public void carregar(Long id) {
		DAO<Produto> dao = new DAO<>(Produto.class);
		this.produto = dao.buscaPorId(id);
	}
	
	public void remover(Long id) {
		DAO<Produto> dao = new DAO<>(Produto.class);
		Produto produto = dao.buscaPorId(id);
		if (produto != null) {
			dao.remove(produto);
		}
	}
	
	public void novo() {
		this.produto = new Produto();
	}

}

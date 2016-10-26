package br.edu.utfpr.jsf.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.utfpr.jsf.dao.DAO;
import br.edu.utfpr.jsf.modelo.Produto;
import br.edu.utfpr.jsf.modelo.Venda;
import br.edu.utfpr.jsf.modelo.VendaProduto;

@ManagedBean
@ViewScoped
public class VendaBean {
	
	private Venda venda;
	private String operacao = "listando";
	private String tituloFormulario;

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public void gravar() {
		System.out.println("Gravando venda...");
		if (this.venda.getProdutos() == null || this.venda.getProdutos().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Venda sem produtos", ""));
		} else {
			DAO<Venda> dao = new DAO<>(Venda.class);
			if (this.venda.getId() == null) {
				dao.adiciona(this.venda);				
			} else {
				dao.atualiza(this.venda);
			}
			this.fecharFormulario();
			FacesMessage message = new FacesMessage("Venda gravada com sucesso!");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, message);			
		}
	}

	public List<Produto> getProdutos() {
		DAO<Produto> dao = new DAO<>(Produto.class);
		List<Produto> produtos = dao.listaTodos();
		return produtos;
	}
	
	public Produto buscaProdutoPorId(Long id) {
		DAO<Produto> dao = new DAO<>(Produto.class);
		Produto produto = dao.buscaPorId(id);
		return produto;
	}
	
	public void excluirProduto(int index) {
		this.venda.getProdutos().remove(index);
	}
	
	public void adicionarProduto() {
		VendaProduto vendaProduto = new VendaProduto();
		this.venda.addProduto(vendaProduto);
	}
	
	public void editar(Long id) {
		this.operacao = "editando";
		this.tituloFormulario = "Editar Venda";
		DAO<Venda> dao = new DAO<>(Venda.class);
		Venda venda = dao.buscaPorId(id);
		if (venda != null) {
			this.venda = venda;
		} else {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Nenhuma venda encontrada"));
		}
	}
	
	public void excluir(Long id) {
		DAO<Venda> dao = new DAO<>(Venda.class);
		Venda venda = dao.buscaPorId(id);
		if (venda != null) {
			dao.remove(venda);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Venda excluída com sucesso!"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Nenhuma venda encontrada"));
		}
	}
	
	public boolean estaListando() {
		return "listando".equalsIgnoreCase(this.operacao);
	}
	
	public void inserir() {
		this.operacao = "inserindo";
		this.tituloFormulario = "Nova Venda";
		this.venda = new Venda();
	}
	
	public List<Venda> getVendas() {
		DAO<Venda> dao = new DAO<>(Venda.class);
		return dao.listaTodos();
	}
	
	public void fecharFormulario() {
		this.venda = new Venda();
		this.operacao = "listando";
	}

	public String getTituloFormulario() {
		return tituloFormulario;
	}

	public void setTituloFormulario(String tituloFormulario) {
		this.tituloFormulario = tituloFormulario;
	}
	
}

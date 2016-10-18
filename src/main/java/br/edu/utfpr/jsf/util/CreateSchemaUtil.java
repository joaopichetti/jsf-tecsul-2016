package br.edu.utfpr.jsf.util;

import java.util.List;

import br.edu.utfpr.jsf.dao.DAO;
import br.edu.utfpr.jsf.modelo.Produto;

public class CreateSchemaUtil {
	
	public static void main(String[] args) {
		DAO<Produto> dao = new DAO<>(Produto.class);
		List<Produto> produtos = dao.listaTodos();
		for (Produto produto : produtos) {
			System.out.println(produto.getNome());
		}
	}

}

package br.com.fiap.producao.dao;

import java.util.List;

import br.com.fiap.producao.entity.Mercadoria;

public interface MercadoriaDAO {
	void inserir(Mercadoria mercadoria);
	
	void atualizar(Mercadoria mercadoria);

	List<Mercadoria> buscarTodos();
	
	Mercadoria buscarPorCodigo(int codigo);
		
	void remover(int codigo);
}

package br.com.fiap.producao.dao;

public abstract class DAOFactory {	
	public static MercadoriaDAO getMercadoriaDAO() {
		return new MercadoriaDAOImpl();
	}
}

package br.com.fiap.producao.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.producao.jdbc.ConnectionManager;
import br.com.fiap.producao.entity.Mercadoria;

public class MercadoriaDAOImpl implements MercadoriaDAO {
	private Connection conexao;
	
	PreparedStatement pstmt = null;
		
	@Override
	public void inserir(Mercadoria mercadoria) {
		try {
			conexao = ConnectionManager.getInstance().getConnection();
	
			CallableStatement cs = conexao.prepareCall("{call SP_INSERT_MERCADORIA(?, ?, ?, ?, ?, ?)}");
			
			cs.setString(1, mercadoria.getNomeProduto());
			cs.setString(2, mercadoria.getOrigem());
			cs.setString(3, mercadoria.getDestino());
			cs.setString(4, mercadoria.getSituacaoAtual());
			cs.setString(5, mercadoria.getTemperaturaIdeal());
			cs.setString(6, mercadoria.getTemperaturaAtual());

			cs.executeUpdate();
					
		} catch (SQLException e) {
			e.printStackTrace();	
		
		} finally {
			try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void atualizar(Mercadoria mercadoria) {
		try {
			conexao = ConnectionManager.getInstance().getConnection();
	
			pstmt = conexao.prepareStatement("UPDATE mercadoria SET nome_produto = ?, origem = ?, destino = ?, situacao_atual = ?, temperatura_ideal = ?, temperatura_atual = ? WHERE codigo = ?");								
			
			pstmt.setString(1, mercadoria.getNomeProduto());
			pstmt.setString(2, mercadoria.getOrigem());
			pstmt.setString(3, mercadoria.getDestino());
			pstmt.setString(4, mercadoria.getSituacaoAtual());
			pstmt.setString(5, mercadoria.getTemperaturaIdeal());
			pstmt.setString(6, mercadoria.getTemperaturaAtual());
			pstmt.setInt(7, mercadoria.getCodigo());

			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				conexao.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Mercadoria> buscarTodos() {
		List<Mercadoria> mercadorias = new ArrayList<Mercadoria>();
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			
			pstmt = conexao.prepareStatement("SELECT * FROM mercadoria");								
						
			rs = pstmt.executeQuery();
			
			while (rs.next()) {	
				Mercadoria mercadoria = new Mercadoria(rs.getInt("codigo"), rs.getString("nome_produto"), rs.getString("origem"), rs.getString("destino"), rs.getString("situacao_atual"), rs.getString("temperatura_ideal"), rs.getString("temperatura_atual"));
		
				mercadorias.add(mercadoria);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				conexao.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return mercadorias;
	}
	
	@Override
	public Mercadoria buscarPorCodigo(int codigo) {
		ResultSet rs = null;
		
		Mercadoria mercadoria = new Mercadoria();

		try {
			conexao = ConnectionManager.getInstance().getConnection();
	
			pstmt = conexao.prepareStatement("SELECT * FROM mercadoria WHERE codigo = ?");								

			pstmt.setInt(1, codigo);
						
			rs = pstmt.executeQuery();
			
			rs.next();
			
			mercadoria.setCodigo(rs.getInt("codigo"));
			mercadoria.setNomeProduto(rs.getString("nome_produto"));
			mercadoria.setOrigem(rs.getString("origem"));
			mercadoria.setDestino(rs.getString("destino"));
			mercadoria.setSituacaoAtual(rs.getString("situacao_atual"));
			mercadoria.setTemperaturaIdeal(rs.getString("temperatura_ideal"));
			mercadoria.setTemperaturaAtual(rs.getString("temperatura_atual"));

		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				conexao.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return mercadoria;
	}
	
	@Override
	public void remover(int codigo) {
		try {
			conexao = ConnectionManager.getInstance().getConnection();
	
			pstmt = conexao.prepareStatement("DELETE FROM mercadoria WHERE codigo = ?");								

			pstmt.setInt(1, codigo);

			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				conexao.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
